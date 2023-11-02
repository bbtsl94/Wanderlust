package com.agenzia.Wanderlust.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.agenzia.Wanderlust.Database.Database;
import com.agenzia.Wanderlust.entities.Luogo;

public class DaoLuogo
{

	@Autowired
	private Database db;
	
	@Autowired
	private DaoLog daoLog;
	
	@Autowired
	private ApplicationContext context;
	
	
	public List<Luogo> read(String query, String... params)
	{
		List<Map<String,String>> mappe= db.rows(query, params);
		return creaOggetto(mappe);
	}
	
	public List<Luogo> readAll()
	{
		return read("select * from luoghi;");
	}
	
	public boolean delete(int id)
	{
		boolean result = db.update("delete from luoghi where id=?", id + "");
		Map<String, String> datiLog = DaoLog.createEntryMessage("delete", "luoghi", result ? Integer.toString(id) : "Errore");
		daoLog.create(datiLog);
		return result;
	}
	
	public boolean create(Map<String,String> m)
	{
		
		String query=	"insert into luoghi \n"
						+ "(nome)\n"
						+ "values(?);";
		
		boolean result = db.update(query, m.get("nome"));
		Map<String, String> datiLog = null;
		if (result)
		{
			String id = db.row("SELECT MAX(id) AS id FROM luoghi").get("id");
			datiLog = DaoLog.createEntryMessage("create", "luoghi", id);
		}
		else
		{
			datiLog = DaoLog.createEntryMessage("create", "luoghi", "Errore");
		}
		daoLog.create(datiLog);
		return result;		
	}
	
	public boolean update(Map<String,String> m )
	{
		String query= "update luoghi set nome= ?  " + 
									 " where id= ? ;";
		System.out.println(m.get("id"));
		boolean result = db.update(query, m.get("nome") , m.get("id"));
		Map<String, String> datiLog = DaoLog.createEntryMessage("update", "luoghi", result ? m.get("id") : "Errore");
		daoLog.create(datiLog);
		return result;
	}
	
	public Luogo cercaLuogo(int id)
	{
		String query="select * from luoghi where id = ?;";
		
		return context.getBean(Luogo.class , db.row(query, id + ""));
	}
	
	private List<Luogo> creaOggetto(List<Map<String,String>> map)
	{
		Luogo l;
		List<Luogo> ris= new ArrayList<Luogo>();
		
		for(Map<String,String> m : map)
		{
			l= context.getBean(Luogo.class, m);
			ris.add(l);
		}
		return ris;
		
	}
}
