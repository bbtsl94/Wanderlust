package com.agenzia.Wanderlust.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.agenzia.Wanderlust.Dao.DaoCompagnia;
import com.agenzia.Wanderlust.Dao.DaoOperatore;
import com.agenzia.Wanderlust.Dao.DaoPersona;

@Controller
@RequestMapping("/operatori")
public class OperatoriController 
{
	private static final String PREFISSO= "/operatori/";

	
	@Autowired
	private DaoOperatore dop;
	
	@Autowired
	private DaoCompagnia daoCompania;
	
	@Autowired
	private DaoPersona  daoPersona;
	

	
	//creazione elencooperatori.jsp
	@GetMapping("elenco")
	public String elencoOperatori(Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		System.err.println();
		model.addAttribute("operatori",dop.readAll());
		return PREFISSO + "elencooperatori.jsp";
	}
		
	//cancellazione di un "operatore"
	@GetMapping("elimina")
	public String elimina(@RequestParam("cf") String idOperatori , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		if(dop.delete(idOperatori))
			return "redirect:elenco";
		else
			return "Questo posto " +  dop.cercaOperatore(idOperatori) + "non esiste" ;

	}
		
	//dettagli dell'operatore
	@GetMapping("dettagli")
	public String dettagliOperatore(@RequestParam("cf") String idOperatore , Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		if(dop.cercaOperatore(idOperatore) != null)
		{
			model.addAttribute("operatore", dop.cercaOperatore(idOperatore));
			return PREFISSO + "dettaglioperatore.jsp";
		}
		else
			return "redirect:elenco";
	}
		
		
	// pagina operatore	
	@GetMapping("formnuovo")
	public String NuovoOperatore(Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		model.addAttribute("persone" , daoPersona.readAll());
		model.addAttribute("compagnie" , daoCompania.readAll());
		return PREFISSO + "formnuovooperatore.jsp";
	}
		
	//aggiungi "operatore"
	@PostMapping("aggiungi")
	public String aggiungi(@RequestParam Map<String,String> m ,  HttpSession sessione) 
	{		
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		System.err.println(m);
		if(dop.create(m))
			return "redirect:elenco";
		else
			return m + " non è stato aggiunto";
	}
		
		
	@GetMapping("formmodifica")
	public String formModificaOperatore(@RequestParam("cf") String idOperatore , Model model , HttpSession sessione)
	{	
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		model.addAttribute("operatore" , dop.cercaOperatore(idOperatore) );
		model.addAttribute("compagnie" , daoCompania.readAll());
		return PREFISSO + "formmodificaoperatore.jsp";	
	}
		
	//modificare operatore
	@PostMapping("modifica")
	public String modifica(@RequestParam Map<String,String> m , HttpSession sessione) 
	{	
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		if(dop.update(m))
			return "redirect:elenco";
		else
			return m + " non è stato modificato";
	}
}
