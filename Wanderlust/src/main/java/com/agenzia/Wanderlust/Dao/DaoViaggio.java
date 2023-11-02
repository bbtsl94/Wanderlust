package com.agenzia.Wanderlust.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.agenzia.Wanderlust.Database.Database;
import com.agenzia.Wanderlust.entities.Trasporto;
import com.agenzia.Wanderlust.entities.Viaggio;

public class DaoViaggio 
{
	@Autowired
	private Database db;
	
	@Autowired
	private DaoLog daoLog;
	
	@Autowired
	private DaoTrasporto dt;
	
	@Autowired
	private ApplicationContext context;
	
	public boolean create(Map<String, String> viaggio)
	{
		String query = "INSERT INTO viaggi (idPartenza, idArrivo, idTrasporto, oraP, oraA, prezzo, disponibile, cancellato, classe)"
					 + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		boolean result = db.update(query, viaggio.get("idPartenza"), viaggio.get("idArrivo"), viaggio.get("idTrasporto"), viaggio.get("oraP"), viaggio.get("oraA"), viaggio.get("prezzo"), viaggio.get("disponibile"), viaggio.get("cancellato"), viaggio.get("classe"));
		
		
		return result;
	}
	
	public List<Viaggio> readAll()
	{
		return read("SELECT * FROM viaggi");
	}
	
	public List<Viaggio> read(String query, String... params)
	{
		List<Map<String,String>> mappe= db.rows(query, params);
		return creaOggetto(mappe);
	}
	
	public boolean update(Map<String, String> viaggio)
	{
		String query = "UPDATE viaggi SET idPartenza = ?, idArrivo = ?, idTrasporto = ?, oraP = ?, oraA = ?, prezzo = ?, disponibile = ?, cancellato = ?, classe = ?" +
					   "WHERE id = ?";
		boolean result = db.update(query, viaggio.get("idPartenza"), viaggio.get("idArrivo"), viaggio.get("idTrasporto"), viaggio.get("oraP"), viaggio.get("oraA"), viaggio.get("prezzo"), viaggio.get("disponibile"), viaggio.get("cancellato"), viaggio.get("classe"), viaggio.get("id"));
		
		Map<String, String> datiLog = DaoLog.createEntryMessage("update", "viaggi", result ? viaggio.get("id") : "Errore");
		daoLog.create(datiLog);
		return result;
	}
	
	
	public boolean delete(int id)
	{
		String query = "DELETE FROM viaggi WHERE id = ?";
		boolean result = db.update(query, Integer.toString(id));
		
		Map<String, String> datiLog = DaoLog.createEntryMessage("delete", "viaggi", result ? Integer.toString(id) : "Errore");
		daoLog.create(datiLog);
		return result;
	}
	
	
	public List<Viaggio> cercaPerDestinazione(int idDestinazione)
	{
		return creaOggetto(db.rows("SELECT * FROM viaggi WHERE idArrivo = ?", Integer.toString(idDestinazione)));
	}
	
	public List<Viaggio> cercaPerPartenza(int idPartenza)
	{
		return creaOggetto(db.rows("SELECT * FROM viaggi WHERE idPartenza = ?", Integer.toString(idPartenza)));
	}
	
	
	public Viaggio cercaPerID(int id)
	{
		Map<String, String> datiViaggio = db.row("SELECT * FROM viaggi WHERE id = ?", Integer.toString(id));
		return (Viaggio)context.getBean(Viaggio.class, datiViaggio);
	}
	
	
	public List<Viaggio> cercaPerPartenzaEArrivo(int idPartenza, int idArrivo)
	{
		return creaOggetto(db.rows("SELECT * FROM viaggi WHERE idPartenza = ? AND idArrivo = ?", Integer.toString(idPartenza), Integer.toString(idArrivo)));
	}
	
	
	public List<Viaggio> cercaPerPartenzaArrivoMezzo(int idPartenza, int idArrivo, int idMezzo)
	{
		List<Trasporto> trasporti = dt.trasportiPerMezzo(idMezzo);
		String listaTrasporti = "";
		for (int i = 0; i < trasporti.size() ; i++)
		{
			listaTrasporti += "'" + trasporti.get(i).getNome() + "'";
			if (i != trasporti.size() - 1) 
			{
				listaTrasporti += ",";
			}
		}
		String query = "SELECT * FROM viaggi WHERE idPartenza = ? AND idArrivo = ? AND idTrasporto IN (" + listaTrasporti + ")";
		return creaOggetto(db.rows(query, Integer.toString(idPartenza), Integer.toString(idArrivo)));
	}
	
	public List<Viaggio> viaggiDiaponibiliPerCompagnia(int idCompagnia)
	{
		List<Trasporto> trasportiPerCompagnia = dt.trasportiPerCompagnia(idCompagnia);
		List<Viaggio> viaggiDisponibiliPerCompagnia = new ArrayList<Viaggio>();
		List<Viaggio> viaggiPerTrasporto;
		for (Trasporto trasporto : trasportiPerCompagnia)
		{
			viaggiPerTrasporto = cercaPerTrasporto(trasporto.getNome());
			for (Viaggio viaggio: viaggiPerTrasporto)
			{
				if (viaggio.isDisponibile())
				{
					viaggiDisponibiliPerCompagnia.add(viaggio);
				}
			}
		}
		return viaggiDisponibiliPerCompagnia;
	}
	
	
	public List<Viaggio> cercaPerTrasporto(String idTrasporto)
	{
		String query = "SELECT * FROM viaggi WHERE idTrasporto = ?";
		return creaOggetto(db.rows(query, idTrasporto));
	}
	
	private List<Viaggio> creaOggetto(List<Map<String, String>> datiViaggi)
	{
		Viaggio v;
		List<Viaggio> ris= new ArrayList<Viaggio>();
		for(Map<String,String> m : datiViaggi)
		{
			v= context.getBean(Viaggio.class, m);
			ris.add(v);
		}
		return ris;
	}
}