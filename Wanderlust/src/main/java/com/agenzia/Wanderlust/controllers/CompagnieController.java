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

@Controller
@RequestMapping("/compagnie")
public class CompagnieController 
{
	private static final String PREFISSO = "/compagnie/";

	@Autowired
	private DaoCompagnia dc;
	

	
	//creazione elencocompagnie.jsp
	@GetMapping("elenco")
	public String elencoCompagnie(Model model, HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}
		model.addAttribute("compagnie", dc.readAll());
		System.err.println(model);
		return PREFISSO + "elencocompagnie.jsp";
	}
	
	//dettagli del luogo
	@GetMapping("dettaglio")
	public String dettagliLuogo(@RequestParam("id") int idCompagnia , Model model , HttpSession sessione  )
	{
		
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		model.addAttribute("compagnia", dc.cercaCompagnia(idCompagnia));
		return PREFISSO + "dettaglicompagnie.jsp";
			
	}
	//cancellazione di una compagnia
	@GetMapping("elimina")
	public String elimina(@RequestParam("id") int idCompagnia , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		if(dc.delete(idCompagnia))
			return "redirect:elenco";
		else
			return "La compagnia " + dc.cercaCompagnia(idCompagnia) + " non esiste";
	}
	
	
	@GetMapping("formnuovo")
	public String formNuovoCompagnia(HttpSession sessione )
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		return PREFISSO + "formnuovacompagnia.html";
	}
	
	//aggiungiamo  "compagnia"
	@PostMapping("aggiungi")
	public String aggiungi(@RequestParam Map<String,String> m , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		if(dc.create(m))
			return "redirect:elenco";
		else
			return m + "non è stato aggiunto";
	}
	
	
	@GetMapping("formmodifica")
	public String formModificaCompagnia(@RequestParam("id") int idCompagnia, Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		
		model.addAttribute("compagnia" , dc.cercaCompagnia(idCompagnia));
		return PREFISSO + "formmodificacompagnia.jsp";
	}
	
	//modificare "compagnia"
		@PostMapping("modifica")
		public String change(@RequestParam Map<String,String> m , HttpSession sessione) 
		{
			if(sessione.getAttribute("connesso") == null)
			{
				return "redirect:/sessione/home";
			}

			if(dc.update(m))
				return "redirect:elenco";
			else
				return m + " non è stato modificato";
		}
		
}
