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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.agenzia.Wanderlust.Dao.DaoPersona;
import com.agenzia.Wanderlust.entities.Persona;

@Controller
@RequestMapping("/persone")
public class PersoneController {
	private static final String PREFISSO = "/persone/";
	@Autowired
	private DaoPersona dp;

	//creazione elencopersone.jsp
	@GetMapping("elenco")
	public String elencoPersone(Model model , HttpSession sessione, RedirectAttributes attributi)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}
		String codice = (String)sessione.getAttribute("codice");
		if (codice.equals("default") || codice.equals("operatore"))
		{
			Persona p = (Persona)sessione.getAttribute("persona");
			attributi.addAttribute("cf", p.getCf());
			return "redirect:dettaglio";
		}
		else
		{
			model.addAttribute("persone",dp.readAll());
			return PREFISSO + "elencopersone.jsp";
		}
	}
	
	//cancellazione di una persona"
	@GetMapping("elimina")
	public String elimina(@RequestParam("cf") String cfPersona , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		if(dp.delete(cfPersona))
			return "redirect:elenco";
		else
			return "Questa persona " +  dp.cercaPersona(cfPersona) + "non esiste" ;
	}
	
	//aggiungi persona
	@PostMapping("aggiungi")
	public String aggiungi(@RequestParam Map<String,String> m , HttpSession sessione ) 
	{	
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		if(dp.create(m))
			return "redirect:elenco";
		else
			return m + " non è stato aggiunto";
	}
	 	
	@GetMapping("formnuovo")
	public String nuovaPersona(HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		return PREFISSO + "formnuovapersona.jsp";
	}
	
	//modificare persona
	@PostMapping("modifica")
	public String modifica(@RequestParam Map<String,String> m , HttpSession sessione, RedirectAttributes attributi) 
	{	
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		if(dp.update(m)) 
		{
			String codice = (String)sessione.getAttribute("codice");
			if (codice.equals("default") || codice.equals("operatore"))
			{
				Persona p = (Persona)sessione.getAttribute("persona");
				attributi.addAttribute("cf", p.getCf());
				return "redirect:dettaglio";
			}
			else 
			{
				return "redirect:elenco";
			}
		}
		else
			return m + " non è stato modificato";
	}
	
	
	@GetMapping("formmodifica")
	public String modificaPersona(@RequestParam("cf") String cfPersona, Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}
		
		model.addAttribute("persona" , dp.cercaPersona(cfPersona) );
		return PREFISSO + "formmodificapersona.jsp";	
	}
			
	
	//dettagli persona
	@GetMapping("dettaglio")
	public String dettagliPersona(@RequestParam ("cf") String cf, Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}
		if(dp.cercaPersona(cf) != null)
		{
			model.addAttribute("persona", dp.cercaPersona(cf));
			return PREFISSO + "dettagliopersona.jsp";
		}
		else
			return "redirect:elenco";
	}
}
