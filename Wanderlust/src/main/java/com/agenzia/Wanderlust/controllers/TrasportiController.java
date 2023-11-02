package com.agenzia.Wanderlust.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.agenzia.Wanderlust.Dao.DaoCompagnia;
import com.agenzia.Wanderlust.Dao.DaoMezzo;
import com.agenzia.Wanderlust.Dao.DaoTrasporto;
import com.agenzia.Wanderlust.entities.Trasporto;

@Controller
@RequestMapping("/trasporti")
public class TrasportiController 
{
	private static final String  PREFISSO = "/trasporti/";

	@Autowired
	private DaoTrasporto dt;
	
	@Autowired
	private DaoCompagnia daoCompagnia;
	
	@Autowired
	private DaoMezzo daoMezzo;
	
	//elenco trasporti
	@GetMapping("elenco")
	public String elencoTrasporti(Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}


		model.addAttribute("trasporti",dt.readAll());
	
		return PREFISSO + "elencotrasporti.jsp";
	}
	
	//cancellazione di un trasporto
		@GetMapping("elimina")
		public String elimina(@RequestParam("nome") String nomeTrasporto , HttpSession sessione)
		{
			if(sessione.getAttribute("connesso") == null)
			{
				return "redirect:/sessione/home";
			}
			
			if(dt.delete(nomeTrasporto))
				return "redirect:elenco";
			else
				return "Il trasporto " + dt.cercaTrasporto(nomeTrasporto) + "nu ce sta";
		}
		
	//Form nuovo trasporto
		@GetMapping("formnuovo")
		public String formNuovoTrasporto(Model model, HttpSession sessione)
		{
			if(sessione.getAttribute("connesso") == null)
			{
				return "redirect:/sessione/home";
			}

			//	parametri
			if (sessione.getAttribute("codice").equals("operatore")) 
			{
				model.addAttribute("isOperatore", true);
			}
			else
			{
				model.addAttribute("isOperatore", false);
			}
			model.addAttribute("compagnie" , daoCompagnia.readAll());
			model.addAttribute("mezzi" , daoMezzo.readAll());
			
			return PREFISSO + "formnuovotrasporto.jsp";
		}
		
	//creazione nuovo trasporto
		@PostMapping("aggiungi")
		public String aggiungi(@RequestParam Map<String,String> m, HttpSession session)
		{
			
			if(session.getAttribute("connesso") == null)
			{
				return "redirect:/sessione/home";
			}

			if(dt.create(m))
			{
				if(session.getAttribute("codice").equals("operatore"))
					return "redirect:trasportipercompagnia";
				else
					return "redirect:elenco";
			}
			else
				return m + "non può essere aggiunto";
		}
		
	//form modifica trasporto
		@GetMapping("formmodifica")
		public String formModificaTrasporto(@RequestParam Map<String , String > map , Model model, HttpSession sessione)
		{
			if(sessione.getAttribute("connesso") == null)
			{
				return "redirect:/sessione/home";
			}

			System.err.println(map);
			Map<String, String > b= dt.readM("select t.nome as 'Nome trasporto', \n"
									+ "	   t.nPosti as 'Posti totali',\n"
									+ "       m.tipo as 'Tipo mezzo',\n"
									+ "		m.id as idMezzo , \n "
									+ "       m.prezzoBase as 'Prezzo base mezzo',\n"
									+ "       c.nome as 'Nome compagnia',\n"
									+ "       c.supplemento as 'Supplemento compagnia'\n"
									+ "	from trasporti t inner join compagnie c \n"
									+ "    on t.idCompagnia = c.id\n"
									+ "    inner join mezzi m  \n"
									+ "    on m.id = t.idMezzo \n"
									+ " where t.idMezzo = ?\n"
									+ " and t.nome = ? ; ", map.get("idmezzo") , map.get("nome"));
			if (((String) sessione.getAttribute("codice")).equals("operatore")) 
			{
				model.addAttribute("isOperatore", true);
			}
			else
			{
				model.addAttribute("isOperatore", false);
			}
			model.addAttribute("trasporto" , b );
			model.addAttribute("compagnie" , daoCompagnia.readAll());
			model.addAttribute("mezzi" , daoMezzo.readAll());
			
			return PREFISSO + "formmodificatrasporto.jsp";
			
		}
		
	//modifica trasporto
		@PostMapping("modifica")
		public String change(@RequestParam Map<String,String> m, HttpSession session) 
		{	
			if(session.getAttribute("connesso") == null)
			{
				return "redirect:/sessione/home";
			}

			if(dt.update(m))
			{
				if(session.getAttribute("codice").equals("operatore"))
					return "redirect:trasportipercompagnia";
				else
					return "redirect:elenco";
			}
				
			else
				return m + " non è stato modificato";
		}
		
		@GetMapping("funziono")
		@ResponseBody
		public String prova ()
		{
			return "funziono";
		}
		
		//dettaglio trasporto 2
		@GetMapping("dettaglio")
		public String dettaglio2(@RequestParam Map<String, String> m, Model model, HttpSession sessione)
		{
			
			if(sessione.getAttribute("connesso") == null)
			{
				return "redirect:/sessione/home";
			}

			Map<String, String > b= dt.readM("select t.nome as 'Nome trasporto', \n"
											+ "	   t.nPosti as 'Posti totali',\n"
											+ "       m.tipo as 'Tipo mezzo',\n"
											+ "		m.id as idMezzo , \n "
											+ "       m.prezzoBase as 'Prezzo base mezzo',\n"
											+ "       c.nome as 'Nome compagnia',\n"
											+ "       c.supplemento as 'Supplemento compagnia'\n"
											+ "	from trasporti t inner join compagnie c \n"
											+ "    on t.idCompagnia = c.id\n"
											+ "    inner join mezzi m  \n"
											+ "    on m.id = t.idMezzo \n"
											+ " where t.idMezzo = ?; ", m.get("idMezzo") );
			if (sessione.getAttribute("codice").equals("operatore")) 
			{
				model.addAttribute("isOperatore", true);
			}
			else
			{
				model.addAttribute("isOperatore", false);
			}
			model.addAttribute("trasporto", b);	
			return PREFISSO + "dettaglitrasporti.jsp";
		}
		
		@GetMapping("trasportipercompagnia")
		public String trasportipercompagnia(HttpSession sessione, Model model)
		{
			if(sessione.getAttribute("connesso") == null)
			{
				return "redirect:/sessione/home";
			}

			List<Trasporto> trasporti = dt.trasportiPerCompagnia((int)sessione.getAttribute("idcompagnia"));
			model.addAttribute("trasporti",trasporti);
			return PREFISSO + "elencotrasporti.jsp";
		}
}
