package com.agenzia.Wanderlust.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.agenzia.Wanderlust.Database.Database;
import com.agenzia.Wanderlust.entities.Mezzo;

public class DaoMezzo 
{
	
	@Autowired
	private Database db;
	
	@Autowired
	private DaoLog daoLog;
	
	@Autowired
	private ApplicationContext context;
	
	
	public List<Mezzo> read(String query, String... params)
	{
		List<Map<String,String>> mappe= db.rows(query, params);
		return creaOggetto(mappe);
	}
	
	public List<Mezzo> readAll()
	{
		return read("select * from mezzi");
	}
	
	public boolean delete(int id)
	{
		boolean result = db.update("delete from mezzi where id=?", id + "");
		Map<String, String> datiLog = DaoLog.createEntryMessage("delete", "mezzi", result ? Integer.toString(id) : "Errore");
		daoLog.create(datiLog);
		return result;
	}
	
	public boolean create(Map<String,String> m)
	{
		String query=	"insert into mezzi \n"
						+ "(tipo,prezzoBase)\n"
						+ "values(?,?);";
		
		boolean result = db.update(query, m.get("tipo"),
								m.get("prezzoBase"));
		
		Map<String, String> datiLog = null;
		if (result)
		{
			String id = db.row("SELECT MAX(id) AS id FROM mezzi").get("id");
			datiLog = DaoLog.createEntryMessage("create", "mezzi", id);
		}
		else
		{
			datiLog = DaoLog.createEntryMessage("create", "mezzi", "Errore");
		}
		daoLog.create(datiLog);
		return result;
	}
	
	public boolean update(Map<String,String> m )
	{
		String query= "update mezzi set tipo= ?, " + 
								  "prezzoBase= ? " +
									 "where id= ?;";
		
		boolean result = db.update(query, m.get("tipo"),
								m.get("prezzoBase"),
								m.get("id"));
		
		Map<String, String> datiLog = DaoLog.createEntryMessage("update", "mezzi", result ? m.get("id") : "Errore");
		daoLog.create(datiLog);
		return result;
	}
	
	public Mezzo cercaMezzo(int id)
	{
		String query="select * from mezzi where id=? ;";
		
		return context.getBean(Mezzo.class , db.row(query, id + ""));
	}
	
	private List<Mezzo> creaOggetto(List<Map<String,String>> map)
	{
		Mezzo mezzo;
		List<Mezzo> ris= new ArrayList<Mezzo>();
		
		for(Map<String,String> m : map)
		{
			mezzo= context.getBean(Mezzo.class, m);
			ris.add(mezzo);
		}
		return ris;
	}
}