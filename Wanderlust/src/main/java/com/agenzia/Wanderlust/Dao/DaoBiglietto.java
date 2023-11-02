package com.agenzia.Wanderlust.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.agenzia.Wanderlust.Database.Database;
import com.agenzia.Wanderlust.entities.Biglietto;

public class DaoBiglietto 
{
	@Autowired
	private Database db;
	
	@Autowired
	private DaoLog daoLog;
	
	@Autowired
	private ApplicationContext context;
	
	
	public List<Biglietto> read(String query, String... params)
	{
		List<Map<String,String>> mappe= db.rows(query, params);
		
		return creaOggetto(mappe);
	}
	
	public List<Biglietto> readAll()
	{
		return read("select * from biglietti");
	}
	
	
	public boolean delete(int id)
	{
		boolean result = db.update("delete from biglietti where id=?", Integer.toString(id));
		Map<String, String> datiLog = DaoLog.createEntryMessage("delete", "biglietti", result ? Integer.toString(id) : "Errore");
		daoLog.create(datiLog);
		return result;
	}
	
	public boolean create(Map<String,String> m)
	{
		
		String query=	"insert into biglietti \n"
						+ "(cf,idViaggio,prezzo)\n"
						+ "values(?,?,?);";
		
		boolean result = db.update(query, m.get("cf"),
								m.get("idViaggio"),
								m.get("prezzo"));
		
		Map<String, String> datiLog = null;
		if (result)
		{
			String id = db.row("SELECT MAX(id) AS id FROM biglietti").get("id");
			datiLog = DaoLog.createEntryMessage("create", "biglietti", id);
		}
		else
		{
			datiLog = DaoLog.createEntryMessage("create", "biglietti", "Errore");
		}
		daoLog.create(datiLog);
		return result;
	}
	
	public boolean update(Map<String,String> m )
	{
		String query= "update biglietti set cf=?, " + 
									 "idViaggio=?," +
									 "prezzo=? "    +
									 "where id= ?;";
		
		boolean result = db.update(query, m.get("cf"),
								m.get("idViaggio"),
								m.get("prezzo"),
								m.get("id"));
		
		Map<String, String> datiLog = DaoLog.createEntryMessage("update", "biglietti", result ? m.get("id") : "Errore");
		daoLog.create(datiLog);
		return result;
	}
	
	public Biglietto cercaBiglietto(int id)
	{
		String query="select * from biglietti where id=? ;";

		return context.getBean(Biglietto.class , db.row(query, id + ""));
	}
	
//	crea biglietto 
	private List<Biglietto> creaOggetto(List<Map<String , String >> map) 
	{
		List<Biglietto> ris = new ArrayList<>();
		Biglietto b;
		for(Map<String,String> m : map)
		{
			b = context.getBean(Biglietto.class, m);
			ris.add(b);
		}
		
		return ris;
	}

	public Map<String,String> readM(String query, String... params) 
	{
		return db.row(query, params);
	}
	
	public List<Map<String,String>> readMList(String query, String... params) 
	{
		return db.rows(query, params);
	}
	
	
	public List<Biglietto> cercaPerCodiceFiscale(String cf)
	{
		String query = "SELECT * FROM biglietti WHERE cf = ?";
		return creaOggetto(db.rows(query, cf));
	}
}
