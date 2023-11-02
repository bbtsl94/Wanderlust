package com.agenzia.Wanderlust.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.agenzia.Wanderlust.Database.Database;
import com.agenzia.Wanderlust.entities.Operatore;

public class DaoOperatore
{
	@Autowired
	private Database db;
	
	@Autowired
	private DaoLog daoLog;
	
	@Autowired
	private ApplicationContext context;
	
	public List<Operatore> read(String query, String... params)
	{
		List<Map<String,String>> mappe= db.rows(query, params);
		return creaOggetto(mappe);
	}
	
	public List<Operatore> readAll()
	{
		return read("select * from operatori");
	}
	
	public boolean delete(String cf)
	{
		boolean result = db.update("delete from operatori where cf=?", cf );
		Map<String, String> datiLog = DaoLog.createEntryMessage("delete", "operatori", result ? cf : "Errore");
		daoLog.create(datiLog);
		return result;
	}
	
	public boolean create(Map<String,String> m)
	{
		
		String query=	"insert into operatori \n"
						+ "(cf,idCompagnia,sconto)\n"
						+ "values(?,?,?);";
		
		boolean result = db.update(query, m.get("cf"),
								m.get("idCompagnia"),
								m.get("sconto"));
		
		Map<String, String> datiLog = DaoLog.createEntryMessage("create", "operatori", result ? m.get("cf") : "Errore");
		daoLog.create(datiLog);
		return result;
	}
	
	public boolean update(Map<String,String> m )
	{
		String query= "update operatori set idCompagnia=?,\n " + 
									 	"sconto=? \n" 		   +
									 	"where cf= ?;";
		
		boolean result = db.update(query, m.get("idCompagnia"),
								m.get("sconto"),
								m.get("cf"));
		
		Map<String, String> datiLog = DaoLog.createEntryMessage("update", "operatori", result ? m.get("cf") : "Errore");
		daoLog.create(datiLog);
		return result;
	}
	
	public Operatore cercaOperatore(String cf)
	{
		String query="select * from operatori where cf=? ;";
		
		if(db.row(query, cf ) != null)
		{
			return context.getBean(Operatore.class , db.row(query, cf + ""));	
		}
		return null;
	}
	
	private List<Operatore> creaOggetto(List<Map<String,String>> map)
	{
		Operatore op;
		List<Operatore> ris= new ArrayList<Operatore>();
		
		for(Map<String,String> m : map)
		{
			op= context.getBean(Operatore.class, m);
			ris.add(op);
		}
		return ris;
		
	}

}
