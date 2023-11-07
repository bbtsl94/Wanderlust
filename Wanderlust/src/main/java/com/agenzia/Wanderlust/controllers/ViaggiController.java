package com.agenzia.Wanderlust.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.agenzia.Wanderlust.Dao.*;
import com.agenzia.Wanderlust.entities.*;

@Controller
@RequestMapping("/viaggi")
public class ViaggiController 
{
	private static final String PREFISSO = "/viaggi/";
	
	@Autowired
	private DaoViaggio daoViaggi;
	
	@Autowired
	private DaoLuogo daoLuoghi;
	
	@Autowired
	private DaoMotivazione daoMotivazione;
	
	@Autowired
	private DaoMezzo daoMezzo;
	
	@Autowired
	private DaoTrasporto daoTrasporto;
	
	@Autowired
	private DaoBiglietto daoBiglietto;
	
	@PostMapping("viaggipermezzi")
	public String viaggiPerMezzi(@RequestParam("idPartenza") int idPartenza, @RequestParam("idArrivo") int idArrivo, @RequestParam("idMezzo") String idMezzo, Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		if (idMezzo.equals("tutto"))
		{
			List<Viaggio> viaggi = daoViaggi.cercaPerPartenzaEArrivo(idPartenza, idArrivo);
			model.addAttribute("viaggio", viaggi);
		}
		else
		{
			List<Viaggio> viaggi = daoViaggi.cercaPerPartenzaArrivoMezzo(idPartenza, idArrivo, Integer.parseInt(idMezzo));
			model.addAttribute("viaggio", viaggi);
		}
		return "/cliente/viaggielenco.jsp";
	}
	
	@GetMapping("cerca")
	public String cerca(Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		model.addAttribute("mezzi", daoMezzo.readAll());
		model.addAttribute("luoghi", daoLuoghi.readAll());
		return "/cliente/cercaviaggi.jsp";
	}
	
	@GetMapping("elenco")
	public String elencoViaggi(Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		List<Viaggio> viaggi = daoViaggi.readAll();
		List<Luogo> luoghi = daoLuoghi.readAll();
		model.addAttribute("viaggi", viaggi);
		model.addAttribute("luoghi", luoghi);
		return  PREFISSO + "elencoviaggi.jsp";
	}
	
	@GetMapping("dettaglio")
	public String dettagliViaggio(@RequestParam("id") int idViaggio, Model model, HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		//	cerco viaggio per id 
		Viaggio datiViaggio = daoViaggi.cercaPerID(idViaggio);
		
		//	cerco luogo partenza 			
		Luogo datiLuogoPartenza = daoLuoghi.cercaLuogo(datiViaggio.getIdLuogoPartenza());
		//	cerco luogo arrivo 
		Luogo datiLuogoArrivo = daoLuoghi.cercaLuogo(datiViaggio.getIdLuogoArrivo());
		
		//	cerco trasporto + tutti i dati	
		Trasporto dati = daoTrasporto.cercaTrasporto(datiViaggio.getIdTrasporto());
		
		//	cerco mezzo per id 	
		Mezzo mezzo = daoMezzo.cercaMezzo(dati.getIdMezzo());
		
		Motivazione datiMotivazione = null;
		if (datiViaggio.isCancellato())
		{
			datiMotivazione = daoMotivazione.cercaMotivo(idViaggio);
			model.addAttribute("motivo", datiMotivazione);
		}
		
		if (sessione.getAttribute("codice").equals("operatore")) 
		{
			model.addAttribute("isOperatore", true);
		}
		else
		{
			model.addAttribute("isOperatore", false);
		}
		//	riempio il model 	
		model.addAttribute("viaggio", datiViaggio);
		model.addAttribute("luogoPartenza", datiLuogoPartenza);
		model.addAttribute("luogoArrivo", datiLuogoArrivo);
		model.addAttribute("mezzo", mezzo);
		model.addAttribute("trasporto", dati);
		return PREFISSO + "dettagliviaggio.jsp";
	}
	
	@GetMapping("formmodifica")
	public String formModifica(@RequestParam("id") int idViaggio, Model model, HttpSession sessione) 
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		Viaggio datiViaggio = daoViaggi.cercaPerID(idViaggio);
		
		List<Luogo> datiLuoghi = daoLuoghi.readAll();
		List<Trasporto> datiTrasporti = null;
		if (sessione.getAttribute("codice").equals("operatore"))
		{
			datiTrasporti = daoTrasporto.trasportiPerCompagnia((int)sessione.getAttribute("idcompagnia"));
		}
		else 
		{
			datiTrasporti = daoTrasporto.readAll();
		}
		Motivazione motivoCancellazione = null;
		if (datiViaggio.isCancellato())
		{
			motivoCancellazione = daoMotivazione.cercaMotivo(idViaggio);
		}
		if (sessione.getAttribute("codice").equals("operatore")) 
		{
			model.addAttribute("isOperatore", true);
		}
		else
		{
			model.addAttribute("isOperatore", false);
		}
		
		model.addAttribute("viaggio", datiViaggio);
		model.addAttribute("luoghi", datiLuoghi);
		model.addAttribute("trasporti", datiTrasporti);
		model.addAttribute("motivazione", motivoCancellazione);
		return PREFISSO + "formmodificaviaggio.jsp";
	}
	
	@PostMapping("modifica")
	public String modificaViaggio(@RequestParam Map<String, String> values, HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		LocalDateTime oraPartenza = LocalDateTime.parse(values.get("oraP"));
		LocalDateTime oraArrivo = LocalDateTime.parse(values.get("oraA"));
		String disponibile = values.get("disponibile");
		String cancellato = values.get("cancellato");
		values.put("oraP", oraPartenza.toString().replace("T", " "));
		values.put("oraA", oraArrivo.toString().replace("T", " "));
		if (disponibile != null)
		{
			values.put("disponibile", "1");
		}
		else
		{
			values.put("disponibile","0");
		}
		if (cancellato != null)
		{
			values.put("cancellato", "1");
		}
		else
		{
			values.put("cancellato","0");
		}
		if (daoViaggi.update(values))
		{
			if (cancellato != null)
			{
				Map<String, String> datiMotivazione = new HashMap<String, String>();
				datiMotivazione.put("idViaggio", values.get("id"));
				datiMotivazione.put("motivo", values.get("motivo"));
				if (!daoMotivazione.create(datiMotivazione))
				{
					if(sessione.getAttribute("codice").equals("operatore"))
						return "redirect:viaggipercompagnia";
					else
						return "redirect:elenco";
				}
			}
			if(sessione.getAttribute("codice").equals("operatore"))
				return "redirect:viaggipercompagnia";
			else
				return "redirect:elenco";
		}
		else
		{
			if(sessione.getAttribute("codice").equals("operatore"))
				return "redirect:viaggipercompagnia";
			else
				return "redirect:elenco";
		}
	}
	
	@GetMapping("elimina")
	public String eliminaViaggio(@RequestParam("id") int idViaggio , HttpSession session )
	{
		if(session.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}
		if (daoViaggi.delete(idViaggio))
		{
			return "redirect:elenco";
		}
		else 
		{
			return "Errore durante l'eliminazione del viaggio.";
		}
	}
	
	@GetMapping("formnuovo")
	public String formnuovo(Model model, HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		model.addAttribute("luoghi" , daoLuoghi.readAll());
		List<Trasporto> datiTrasporti = null;
		if (sessione.getAttribute("codice").equals("operatore"))
		{
			datiTrasporti = daoTrasporto.trasportiPerCompagnia((int)sessione.getAttribute("idcompagnia"));
		}
		else 
		{
			datiTrasporti = daoTrasporto.readAll();
		}
		model.addAttribute("trasporti" , datiTrasporti);
		if (sessione.getAttribute("codice").equals("operatore")) 
		{
			model.addAttribute("isOperatore", true);
		}
		else
		{
			model.addAttribute("isOperatore", false);
		}
		
		return PREFISSO + "formnuovoviaggio.jsp";
	}
	
	@GetMapping("aggiungi")
	public String aggiungi(@RequestParam Map<String,String > map, HttpSession sessione) 
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		LocalDateTime oraPartenza = LocalDateTime.parse(map.get("oraP"));
		LocalDateTime oraArrivo = LocalDateTime.parse(map.get("oraA"));
		map.put("oraP", oraPartenza.toString().replace("T", " "));
		map.put("oraA", oraArrivo.toString().replace("T", " "));
		map.put("disponibile", "1");
		map.put("cancellato", "0");
		if (daoViaggi.create(map)) 
		{
			if(sessione.getAttribute("codice").equals("operatore"))
				return "redirect:viaggipercompagnia";
			else
				return "redirect:elenco";
		}
		else
		{
			return "Errore durante l'aggiunta del viaggio.";
		}
	}
	
	@GetMapping("viaggipercompagnia")
	public String viaggiPerCompagnia(HttpSession sessione, Model model)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}
		
		List<Viaggio> viaggi = daoViaggi.viaggiDiaponibiliPerCompagnia((int)sessione.getAttribute("idcompagnia"));
		List<Luogo> luoghi = daoLuoghi.readAll();
		model.addAttribute("viaggi", viaggi);
		model.addAttribute("luoghi", luoghi);
		return PREFISSO + "elencoviaggi.jsp";
	}
	
	@GetMapping("prenota")
	public String prenota(@RequestParam("id") int idViaggio, HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}
		
		Persona persona = (Persona)sessione.getAttribute("persona");
		Viaggio viaggio = daoViaggi.cercaPerID(idViaggio);
		
		Map<String, String> datiBiglietto = new HashMap<String, String>();
		datiBiglietto.put("cf", persona.getCf());
		datiBiglietto.put("idViaggio", Integer.toString(idViaggio));
		datiBiglietto.put("prezzo", Double.toString(viaggio.getPrezzo()));
		if (daoBiglietto.create(datiBiglietto))
		{
			return "redirect:/biglietti/imieiviaggi";
		}
		else
		{
			return "Errore durante la prenotazione";
		}
	}
}