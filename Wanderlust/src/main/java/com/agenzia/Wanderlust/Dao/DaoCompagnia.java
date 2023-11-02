package com.agenzia.Wanderlust.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.agenzia.Wanderlust.Database.Database;
import com.agenzia.Wanderlust.entities.Compagnia;

public class DaoCompagnia 
{
	@Autowired
	private Database db;
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private DaoLog daoLog;
	
	
	public List<Compagnia> read(String query, String... params)
	{
		List<Map<String,String>> mappe= db.rows(query, params);
		return creaOggetto(mappe);
	}
	
	public List<Compagnia> readAll()
	{
		return read("select * from compagnie");
	}
	
	public boolean delete(int id)
	{
		boolean result = db.update("delete from compagnie where id=?", Integer.toString(id));
		Map<String, String> datiLog = DaoLog.createEntryMessage("delete", "compagnie", result ? Integer.toString(id) : "Errore");
		daoLog.create(datiLog);
		return result;
	}
	
	public boolean create(Map<String,String> m)
	{
		
		String query=	"insert into compagnie \n"
						+ "(nome,supplemento)\n"
						+ "values(?,?);";
		
		boolean result = db.update(query, m.get("nome"),
								m.get("supplemento"));
		
		Map<String, String> datiLog = null;
		if (result)
		{
			String id = db.row("SELECT MAX(id) AS id FROM compagnie").get("id");
			datiLog = DaoLog.createEntryMessage("create", "compagnie", id);
		}
		else
		{
			datiLog = DaoLog.createEntryMessage("create", "compagnie", "Errore");
		}
		daoLog.create(datiLog);
		return result;
								
	}
	
	public boolean update(Map<String,String> m )
	{
		
		String query= "update compagnie set nome=?, " + 
									 "supplemento=? " +
									 "where id= ?;";

		boolean result = db.update(query, m.get("nome"),
								m.get("supplemento"),
								m.get("id"));
		
		Map<String, String> datiLog = DaoLog.createEntryMessage("update", "compagnie", result ? m.get("nome") : "Errore");
		daoLog.create(datiLog);
		return result;
	}
	
	public Compagnia cercaCompagnia(int id)
	{
		String query="select * from compagnie where id=? ;";
		
		return context.getBean(Compagnia.class , db.row(query, id + ""));
	}
	
	private List<Compagnia> creaOggetto(List<Map<String,String>> map)
	{
		Compagnia com;
		List<Compagnia> ris= new ArrayList<Compagnia>();
		
		for(Map<String,String> m : map)
		{
			com= context.getBean(Compagnia.class, m);
			ris.add(com);
		}
		return ris;
	}
}
