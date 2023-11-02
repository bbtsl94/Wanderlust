package com.agenzia.Wanderlust.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.agenzia.Wanderlust.Database.Database;
import com.agenzia.Wanderlust.entities.Trasporto;

public class DaoTrasporto
{

	@Autowired
	private Database db;
	
	@Autowired
	private DaoLog daoLog;
	
	@Autowired
	private ApplicationContext context;
	
	
	public List<Trasporto> read(String query, String... params)
	{
		List<Map<String,String>> mappe= db.rows(query, params);
		
		return creaOggetto(mappe);
	}
	
	public List<Trasporto> readAll()
	{
		return read("select * from trasporti;");
	}
	
	public boolean delete(String nome)
	{
		boolean result = db.update("delete from trasporti where nome=?", nome);
		Map<String, String> datiLog = DaoLog.createEntryMessage("delete", "trasporti", result ? nome : "Errore");
		daoLog.create(datiLog);
		return result;
	}
	
	public boolean create(Map<String,String> m)
	{
		
		String query=	"insert into trasporti \n"
						+ "(nome,nPosti,idCompagnia,idMezzo)\n"
						+ "values(?,?,?,?);";
		
		boolean result = db.update(query, m.get("nome"),
								m.get("nPosti"),
								m.get("idCompagnia"),
								m.get("idMezzo"));
		
		Map<String, String> datiLog = DaoLog.createEntryMessage("create", "trasporti", result ? m.get("nome") : "Errore");
		daoLog.create(datiLog);
		return result;		
	}
	
	public boolean update(Map<String,String> m )
	{
		String query= "update trasporti set " + 
									 	"nPosti=?," +
									 	"idCompagnia=?," +
									 	"idMezzo=?" +
									 	"where nome= ?;";
		
		boolean result = db.update(query, m.get("nPosti"),
								m.get("idCompagnia"),
								m.get("idMezzo"),
								m.get("nome"));
		
		Map<String, String> datiLog = DaoLog.createEntryMessage("update", "trasporti", result ? m.get("nome") : "Errore");
		daoLog.create(datiLog);
		return result;
	}
	
	public Trasporto cercaTrasporto(String nome)
	{
		String query="select * from trasporti where nome=? ;";
		
		return context.getBean(Trasporto.class , db.row(query, nome));
	}
	
	public List<Trasporto> trasportiPerMezzo(int idMezzo)
	{
		String query = "SELECT * FROM trasporti WHERE idMezzo = ?";
		return creaOggetto(db.rows(query, idMezzo+ ""));
	}
	
	public List<Trasporto> trasportiPerCompagnia(int idCompagnia)
	{
		String query = "SELECT * FROM trasporti WHERE idCompagnia = ?";
		return creaOggetto(db.rows(query, Integer.toString(idCompagnia)));
	}
	
	private List<Trasporto> creaOggetto(List<Map<String,String>> map)
	{
		Trasporto t;
		List<Trasporto> ris= new ArrayList<Trasporto>();
		
		for(Map<String,String> m : map)
		{
			t= context.getBean(Trasporto.class, m);
			ris.add(t);
		}
		return ris;
		
	}
	
	public Map<String,String> readM(String query, String... params) {
			
		if(params.length==2 )
		{
			return db.row(query, params[0], params[1] );
		}
		else
			return db.row(query, params );
	}
}
