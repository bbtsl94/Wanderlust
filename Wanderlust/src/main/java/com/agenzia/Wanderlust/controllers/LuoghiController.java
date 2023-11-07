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
import org.springframework.web.bind.annotation.ResponseBody;

import com.agenzia.Wanderlust.Dao.DaoLuogo;


@Controller
@RequestMapping("/luoghi")
public class LuoghiController {
	
	private static final String PREFISSO = "/luoghi/";
	
	@Autowired
	private DaoLuogo dl;
	
	//creazione elencoluoghi.jsp
	@GetMapping("elenco")
	public String elencoLuoghi(Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		model.addAttribute("luoghi",dl.readAll());
		return PREFISSO+"elencoluoghi.jsp";
	}
	
	//cancellazione di un "luogo"
	@GetMapping("elimina")
	public String elimina(@RequestParam("id") int idLuogo , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}
		if(dl.delete(idLuogo))
			return "redirect:elenco";
		else
			return "Questo posto " +  dl.cercaLuogo(idLuogo) + "non esiste" ;

	}
	
	//dettagli del luogo
	@GetMapping("dettaglio")
	public String dettagliLuogo(@RequestParam("id") int idLuogo , Model model, HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		model.addAttribute("luogo", dl.cercaLuogo(idLuogo));
		return PREFISSO + "dettagliluogo.jsp";
		
	}
	
	
	// pagina jsl luogo 	
	@GetMapping("formnuovo")
	public String formNuovoLuogo(HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		return PREFISSO + "formnuovoluogo.html";
	}
	
	//aggiungi "luogo"
	@PostMapping("aggiungi")
	public String aggiungi(@RequestParam Map<String,String> m , HttpSession sessione) 
	{		
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		if(dl.create(m))
			return "redirect:elenco";
		else
			return m + " non è stato aggiunto";
	}
	
	
	@GetMapping("formmodifica")
	public String formModificaLuogo(@RequestParam("id") int idLuogo , Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}
	
		model.addAttribute("luogo" , dl.cercaLuogo(idLuogo) );
		return PREFISSO + "formmodificaluogo.jsp";
		
	}
	
	//modificare luogo
	@PostMapping("modifica")
	public String change(@RequestParam Map<String,String> m , HttpSession sessione ) 
	{	
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		if(dl.update(m))
			return "redirect:elenco";
		else
			return m + " non è stato modificato";
	}
	
	

}