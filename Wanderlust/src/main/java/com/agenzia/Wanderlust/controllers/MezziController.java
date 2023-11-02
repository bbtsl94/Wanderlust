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

import com.agenzia.Wanderlust.Dao.*;

@Controller
@RequestMapping("/mezzi")
public class MezziController {
	
	private static final String PREFISSO= "/mezzi/";
	
	@Autowired
	private DaoMezzo dm;

	//elenco mezzi
	@GetMapping("elenco")
	public String elencoMezzi(Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		model.addAttribute("mezzi",dm.readAll());
		return PREFISSO + "elencomezzi.jsp";
	}
	
	@GetMapping("formnuovo")
	public String formnuovoMezzo(HttpSession  sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		return PREFISSO + "formnuovomezzo.jsp";
	}
	
	//aggiungi un mezzo
	@PostMapping("aggiungi")
	public String aggiungi(@RequestParam Map<String,String> m , HttpSession sessione ) 
	{		
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		if(dm.create(m))
			return "redirect:elenco";
		else
			return m + " non è stato aggiunto";
	}
	
	//dettagli di un mezzo
	@GetMapping("dettagli")
	public String dettagliMezzo(@RequestParam("id") int idMezzo, Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		if(dm.cercaMezzo(idMezzo) != null)
		{
			model.addAttribute("mezzo",dm.cercaMezzo(idMezzo));
			return PREFISSO + "dettaglimezzo.jsp";
		}
		else
			return "redirect:elenco";
	}
	
	//modifica di un mezzo
	@PostMapping("modifica")
	public String modifica(@RequestParam Map<String,String> m , HttpSession sessione) 
	{	
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		System.err.println(m);
		if(dm.update(m))
			return "redirect:elenco";
		else
			return m + " non è stato modificato";
	}
	
	@GetMapping("formmodifica")
	public String formModificaMezzo(@RequestParam("id") int idMezzo, Model model, HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}
		
		
		model.addAttribute("mezzo" , dm.cercaMezzo(idMezzo) );
		return PREFISSO + "formmodificamezzo.jsp";
	}
	
	//elimina di un mezzo
	@GetMapping("elimina")
	public String elimina(@RequestParam("id") int idMezzo , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		if(dm.delete(idMezzo))
			return "redirect:elenco";
		else
			return "Questo posto " +  dm.cercaMezzo(idMezzo) + "non esiste" ;
	}

}