package com.agenzia.Wanderlust.Dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.agenzia.Wanderlust.Database.Database;
import com.agenzia.Wanderlust.entities.Log;


public class DaoLog
{
	@Autowired
	private Database db;
	
	@Autowired
	private ApplicationContext context;
	
	
	public List<Map<String, String>> readAll()
	{
		return db.rows("select * from log");		
	}
	
	public List<Log> read(String query, String... params)
	{
		List<Log> ris= new ArrayList<Log>();
		List<Map<String,String>> mappe= db.rows(query, params);
		Log l;
		
		for(Map<String,String> m : mappe)
		{
			l= context.getBean(Log.class, m);
			ris.add(l);
		}
		return ris;
	}
	
	
	public boolean create(Map<String, String> datiLog)
	{
		StringBuilder messaggio = new StringBuilder();
		messaggio.append(datiLog.get("crud"));
		messaggio.append(':');
		messaggio.append(datiLog.get("tabella"));
		messaggio.append(',');
		messaggio.append(datiLog.get("pk"));
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
		String data = LocalDateTime.now().format(dateFormat);
		return db.update("INSERT INTO log (mex, data) VALUES (?, ?)", messaggio.toString(), data);
	}
	
	// Crea una mappa che contiene i componenti del messaggio di una voce di log.
	public static Map<String, String> createEntryMessage(String crud, String table, String pk)
	{
		Map<String, String> datiLog = new HashMap<String, String>();
		datiLog.put("crud", crud);
		datiLog.put("tabella", table);
		datiLog.put("pk", pk);
		return datiLog;
	}
}