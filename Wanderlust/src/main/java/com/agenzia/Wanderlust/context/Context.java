package com.agenzia.Wanderlust.context;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.agenzia.Wanderlust.Dao.*;
import com.agenzia.Wanderlust.Database.Database;
import com.agenzia.Wanderlust.entities.Viaggio;
import com.agenzia.Wanderlust.entities.*;

@Configuration
public class Context 
{
	@Bean
	public Database db() 
	{

		return new Database("Wanderlust", "root", "rooter94");
	}

	//	parte dao viaggio 
	@Bean
	public DaoViaggio daoViaggio() 
	{
		return new DaoViaggio();
	}
	

	@Bean
	@Scope("prototype")
	@Primary
	public  Viaggio viaggioMappa (Map<String , String > map)
	{
		Viaggio v = new Viaggio();
		

		v.setId(Integer.parseInt(map.get("id")))			;
		v.setIdLuogoPartenza(map.get("idpartenza"))			;
		v.setIdLuogoArrivo(map.get("idarrivo"))				;
		v.setIdTrasporto(map.get("idtrasporto"))			;
		v.setOraPartenza(map.get("orap"))					;
		v.setOraArrivo(map.get("oraa"))						;
		v.setPrezzo(map.get("prezzo"))						;
		v.setClasse(map.get("classe"))						;
		v.setDisponibile(map.get("disponibile"))			;
		v.setCancellato(map.get("cancellato"))				;
		System.err.println(map.get("id"));

		return v ;

	}
	@Bean
	@Scope("prototype")
	public  Viaggio viaggioMappa (int id , int idLuogoPartenza ,
								  int idLuogoArrivo , int idTrasporto , 
								  LocalDateTime oraPartenza, LocalDateTime oraArrivo ,
								  double prezzo, boolean disponibile ,
								  boolean cancellato , int classe ) 
	{
		Viaggio v = new Viaggio();

		v.setId(id);
		v.setIdLuogoPartenza(idLuogoPartenza + "") ;
		v.setIdLuogoArrivo(idLuogoArrivo + "")     ;
		v.setIdTrasporto(idTrasporto + "")		   ;
		v.setOraPartenza(oraPartenza + "")		   ;
		v.setOraArrivo(oraArrivo + "")			   ;
		v.setPrezzo(prezzo + "")				   ;
		v.setClasse(classe + "")				   ;
		v.setDisponibile(disponibile +"")		   ;
		v.setCancellato(cancellato+"")			   ;
		

		return v ;

	}


	//	parte dao mezzi
	@Bean
	public DaoMezzo daoMezzo() 
	{
		return new DaoMezzo();
	}
	

	@Bean
	@Scope("prototype")
	@Primary
	public Mezzo mezzo(Map<String , String> map )
	{
		Mezzo m = new Mezzo();
		
		m.setId(Integer.parseInt(map.get("id")));
		m.setTipo(map.get("tipo"));
		m.setPrezzoBase(map.get("prezzobase"));
		
		return m ;
	}
	
	

	@Bean
	@Scope("prototype")
	public Mezzo mezzo(int id, String tipo , double prezzoBase) 
	{
		Mezzo m = new Mezzo();
		
		m.setId(id);
		m.setTipo(tipo);
		m.setPrezzoBase(prezzoBase + "");
		
		return m ;
		
	}

	//	parte del biglietto
	@Bean
	public  DaoBiglietto DaoBiglietto() 
	{
		return new DaoBiglietto();
	}
	

	@Bean
	@Scope("prototype")
	@Primary
	public Biglietto biglietto(Map<String , String> map )
	{
		Biglietto b = new Biglietto();
		
		b.setId(map.get("id"));
		b.setCf(map.get("cf"));
		b.setIdViaggio(map.get("idviaggio"));
		b.setPrezzo(map.get("prezzo"));
	
		return b ;
	}
	
	

	@Bean
	@Scope("prototype")
	public Biglietto biglietto(int id, String cf , int idVigaggio , double prezzo) 
	{

		Biglietto b = new Biglietto();
		
		b.setId(id + "");
		b.setCf(cf);
		b.setIdViaggio(idVigaggio + "");
		b.setPrezzo(prezzo + "");
	
		return b ;
		
	}

	//	parte persona 
	
	@Bean
	public DaoPersona daoPersona() 
	{
		return new DaoPersona();
	}
	
	@Bean
	@Scope("prototype")
	@Primary
	public Persona personaMappa(Map<String, String> m)
	{
		Persona p = new Persona();

		p.setCf((m.get("cf")));
		p.setNominativo(m.get("nominativo"));

		if(!m.get("dob").equals(""))
		{
			p.setDob(m.get("dob"));
		}

		p.setUsername(m.get("username"));
		p.setPassword(m.get("password"));
		p.setEmail(m.get("email"));

		return p;
	}

	@Bean
	@Scope("prototype")
	public Persona personaOggetto(String cf, String nominativo, Date dob, String username, String password, String email)
	{
		Persona p = new Persona();

		p.setCf(cf);
		p.setNominativo(nominativo);
		p.setDob(dob + "");
		p.setUsername(username);
		p.setPassword(password);
		p.setEmail(email);

		return p;
	}

	//parte della compagnia
	
	@Bean
	public DaoCompagnia daoCompagnia() 
	{
		return new DaoCompagnia();
	}
	
	@Bean
	@Scope("prototype")
	@Primary
	public Compagnia compagniaMappa(Map<String, String> m)
	{
		Compagnia compa = new Compagnia();
		
		compa.setId((m.get("id")));
		compa.setNome(m.get("nome"));
		compa.setSupplemento(m.get("supplemento"));

		return compa;
	}

	@Bean
	@Scope("prototype")
	public Compagnia compagniaOggetto(int id, String nome, String supplemento)
	{
		Compagnia compa = new Compagnia();
		
		compa.setId(id + "");
		compa.setNome(nome);
		compa.setSupplemento(supplemento + "");

		return compa;
	}
	
	//parte della operatore

	@Bean
	public DaoOperatore daoOperatori() 
	{
		return new DaoOperatore();
	}
	@Bean
	@Scope("prototype")
	@Primary
	public Operatore operatoreMappa(Map<String, String> m)
	{
	    Operatore operat = new Operatore();
	    operat.setCf((m.get("cf")));
	    operat.setIdcompagnia(m.get("idcompagnia"));
	    operat.setSconto(m.get("sconto"));


	    return operat;
	}

	@Bean
	@Scope("prototype")
	public Operatore operatoreOggetto(String cf, int idCompagnia, int sconto)
	{
	    Operatore operat = new Operatore();
	    
	    operat.setCf(cf);
	    operat.setIdcompagnia(idCompagnia + "");
	    operat.setSconto(sconto + "");

	    return operat;
	}
	
	// motivazione 

	@Bean
	public DaoMotivazione daoMotivazione() 
	{
		return new DaoMotivazione();
	}
	
	@Bean
	@Scope("prototype")
	@Primary
	public Motivazione motivazioneMappa(Map<String, String> m)
	{
	    Motivazione motivo = new Motivazione();
	    motivo.setIdViaggio((m.get("idviaggio")));
	    motivo.setMotivo(m.get("motivo"));


	    return motivo;
	}

	@Bean
	@Scope("prototype")
	public Motivazione motivazioneOggetto( int idViaggio, int sconto)
	{
	    Motivazione operat = new Motivazione();
	    operat.setIdViaggio(idViaggio + "");
	    operat.setMotivo(sconto + "");

	return operat;
	}
	
	//parte della trasporto

	@Bean
	public DaoTrasporto daoTrasporto() 
	{
		return new DaoTrasporto();
	}
	
	@Bean
	@Scope("prototype")
	@Primary
	public Trasporto trasportoMappa(Map<String, String> m)
	{
	    Trasporto tra = new Trasporto();
		
	    tra.setNome(m.get("nome"));	    
	    tra.setNPosti(m.get("nposti"));	    
	    tra.setIdCompagnia(m.get("idcompagnia"));	    
	    tra.setIdMezzo(m.get("idmezzo"));

	    return tra;
	}

	@Bean
	@Scope("prototype")
	public Trasporto trasportoOggetto( String nome , int nPosti, int idCompagnia, int idMezzo)
	{
	    Trasporto tra = new Trasporto();
	    tra.setNome(nome);
	    tra.setNPosti(nPosti + "");
	    tra.setIdCompagnia(idCompagnia +" ");
	    tra.setIdMezzo(idMezzo + " ");

	return tra;
	}

	//parte della luogo

	@Bean
	public DaoLuogo daoLuogo() 
	{
		return new DaoLuogo();
	}
	
	
	@Bean
	@Scope("prototype")
	@Primary
	public Luogo luogoMappa(Map<String, String> m)
	{
	    Luogo luogo = new Luogo();
	    luogo.setId((m.get("id")));
	    luogo.setName(m.get("nome"));


	    return luogo;
	}

	@Bean
	@Scope("prototype")
	public Luogo luogoOggetto(int id, String name)
	{
	    Luogo luogo = new Luogo();
	    luogo.setId(id + "");
	    luogo.setName(name);

	return luogo;
	}
	
	//parte della log

	@Bean
	public DaoLog daoLog() 
	{
		return new DaoLog();
	}
	
		@Bean
		@Scope("prototype")
		@Primary
		public Log log(Map<String, String> m)
		{
		    Log log = new Log();
			log.setId(m.get("id")); 
		    log.setData((m.get("data")));
		    log.setMex(m.get("mex"));


		    return log;
		}

		// admin 
		@Bean 
		public DaoAdmin daoAdmin() 
		{
			return new DaoAdmin();
					
		}
		
		@Bean
		@Scope("prototype")
		@Primary
		public Admin adminMappa(Map<String, String> m)
		{
			Admin a = new Admin();
			a.setCf((m.get("cf")));
			a.setCodice(m.get("codice"));
			
			return a;
		}
		
	

}