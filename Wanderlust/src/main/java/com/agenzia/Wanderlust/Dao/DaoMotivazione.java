package com.agenzia.Wanderlust.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.agenzia.Wanderlust.Database.Database;
import com.agenzia.Wanderlust.entities.Motivazione;

public class DaoMotivazione
{
	@Autowired
	private Database db;
	
	@Autowired
	private DaoLog daoLog;
	
	@Autowired
	private ApplicationContext context;
	
	
	public List<Motivazione> read(String query, String... params)
	{
		List<Map<String,String>> mappe= db.rows(query, params);
		return creaOggetto(mappe);
	}
	
	public List<Map<String, String>> read()
	{
		return db.rows("select * from motivazioni");
	}
	
	public boolean delete(int id)
	{
		boolean result = db.update("delete from motivazioni where idViaggio=?", id + "");
		Map<String, String> datiLog = DaoLog.createEntryMessage("delete", "motivazioni", result ? Integer.toString(id) : "Errore");
		daoLog.create(datiLog);
		return result;
	}
	
	public boolean create(Map<String,String> m)
	{
		
		String query=	"insert into motivazioni \n"
						+ "(idViaggio,motivo)\n"
						+ "values(?,?);";
		
		boolean result = db.update(query, m.get("idViaggio"),
								m.get("motivo"));
		
		Map<String, String> datiLog = DaoLog.createEntryMessage("create", "motivazioni", result ? m.get("idViaggio") : "Errore");
		daoLog.create(datiLog);
		return result;
								
	}
	
	public boolean update(Map<String,String> m )
	{
		String query= "update motivazioni set motivo=? " + 
									 	"where idViaggio= ?;";
		
		boolean result = db.update(query, m.get("motivo"),
								m.get("idViaggio"));
		
		Map<String, String> datiLog = DaoLog.createEntryMessage("update", "motivazioni", result ? m.get("idViaggio") : "Errore");
		daoLog.create(datiLog);
		return result;
	}
	
	public Motivazione cercaMotivo(int id)
	{
		String query="select * from motivazioni where idViaggio=? ;";
		
		return context.getBean(Motivazione.class , db.row(query, id + ""));
	}
	
	public List<Motivazione> readAll()
	{

		List<Map<String, String>> rows = db.rows("select * from motivazioni");
		return creaOggetto(rows);
	}
	
	private List<Motivazione> creaOggetto(List<Map<String,String>> map)
	{
		Motivazione motivo;
		List<Motivazione> ris= new ArrayList<Motivazione>();
		
		for(Map<String,String> m : map)
		{
			motivo= context.getBean(Motivazione.class, m);
			ris.add(motivo);
		}
		return ris;
		
	}
}