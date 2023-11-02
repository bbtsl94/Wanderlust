package com.agenzia.Wanderlust.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.agenzia.Wanderlust.Database.Database;
import com.agenzia.Wanderlust.entities.Persona;

public class DaoPersona 
{
	@Autowired
	private Database db;
	
	@Autowired
	private DaoLog daoLog;
	
	@Autowired
	private ApplicationContext context;
	
	
	public List<Persona> read(String query, String... params)
	{
		List<Map<String,String>> mappe= db.rows(query, params);
		return creaOggetto(mappe);
	}
	
	public List<Persona> readAll()
	{
		return creaOggetto(db.rows("select * from persone"));
	}
	
	public boolean delete(String cf)
	{
		boolean result = db.update("delete from persone where cf=? ", cf);
		Map<String, String> datiLog = DaoLog.createEntryMessage("delete", "persone", result ? cf : "Errore");
		daoLog.create(datiLog);
		return result;
	}
	
	public boolean create(Map<String, String> m)
	{
		String query =	"insert into persone \n"
						+ "(cf,nominativo,dob,username,password,email)\n"
						+ "values(?,?,?,?,?,?);";
		
		boolean result = db.update(query, m.get("cf"),
								m.get("nominativo"),
								m.get("dob"),
								m.get("username"),
								m.get("password"),
								m.get("email"));
		
		Map<String, String> datiLog = DaoLog.createEntryMessage("create", "persone", result ? m.get("cf") : "Errore");
		daoLog.create(datiLog);
		return result;
	}	
	
	public boolean update(Map<String,String> m) 
	{
		String query ="update persone set  nominativo=? ,\n"
					+ "	dob=?, username=?, \n"
					+ " password=? ,email =? \n"
					+ " where  cf=? ";
		
		boolean result = db.update(query, m.get("nominativo"),
								m.get("dob"),
								m.get("username"),
								m.get("password"),
								m.get("email"),
								m.get("cf"));
		
		Map<String, String> datiLog = DaoLog.createEntryMessage("update", "persone", result ? m.get("cf") : "Errore");
		daoLog.create(datiLog);
		return result;
	}
	
	public Persona cercaPersona(String cf)
	{
	
		String query="select * from persone where cf = ?;";
		
		return context.getBean(Persona.class , db.row(query, cf ));
	}
	
	private List<Persona> creaOggetto(List<Map<String,String>> map)
	{
		Persona pers;
		List<Persona> ris= new ArrayList<Persona>();
		
		for(Map<String,String> m : map)
		{
			pers= context.getBean(Persona.class, m);
			ris.add(pers);
		}
		return ris;
		
	}
	//controppo credenziali 
	public Persona cercaPersona(String username, String password)
	{
	
		String query="select * from persone "
					+ "where username = ? and  password = ? ;";
		if(db.row(query, username , password ) != null)
		{
			return context.getBean(Persona.class , db.row(query, username , password ));
		}
		return null;
	}
	
	//controllo username 
	public Persona cercaPersonaUsername(String username)
	{
	
		String query="select * from persone "
					+ "where username = ?";
		if(db.row(query, username ) != null)
		{
			return context.getBean(Persona.class , db.row(query, username));
		}
		return null;
	}
	
	// controllo email
	public Persona cercaPersonaEmail(String email)
	{
	
		String query="select * from persone "
					+ "where email = ? ";
		if(db.row(query, email ) != null)
		{
			context.getBean(Persona.class , db.row(query, email));	
		}
		return null;
		
	}
	
	public boolean controllo(Map<String, String> map)
	{
		Persona p = context.getBean(Persona.class , map);
		boolean ris = false ;
		if(p.getCf().length()== 16 && 
		   p.getNominativo().length() > 0 &&
		   // controllo username 
		   p.getUsername().length() >= 8 &&
		   (cercaPersonaUsername(p.getUsername()) == null ) &&
		   //controllo emial 
		   p.getEmail().length() > 0 &&
		   (cercaPersonaEmail(p.getEmail()) == null) &&
		   //controllo password
		   p.getPassword().length()>= 8 && p.getPassword().length()<= 12)  ris = true ;
	
		//risposta 
		return ris;
	}
	
	
}
