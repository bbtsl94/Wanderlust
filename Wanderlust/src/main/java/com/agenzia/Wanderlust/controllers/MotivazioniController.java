package com.agenzia.Wanderlust.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.agenzia.Wanderlust.Dao.DaoMotivazione;
import com.agenzia.Wanderlust.Dao.DaoViaggio;

@Controller
@RequestMapping("/motivazioni")
public class MotivazioniController 
{
	private static final String PREFISSO = "/motivazioni/";

	@Autowired
	private DaoMotivazione dm;
	
	@Autowired
	private DaoViaggio daoViaggi;
	
	//creazione elencomotivazioni.jsp
	@GetMapping("elenco")
	public String elencoMotivazioni(Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		model.addAttribute("motivazioni",dm.readAll());
		return PREFISSO + "elencomotivazioni.jsp";
	}
	
	// pagina motivazione	
	@GetMapping("formnuovo")
	public String formNuovoMotivo(Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		String query = "select * \n"
						+ "from viaggi\n"
						+ "where cancellato = false;";
		model.addAttribute("viaggi", daoViaggi.read(query));
		
		return PREFISSO + "formnuovomotivo.jsp";
	}
		
	//aggiungi motivazione
	@PostMapping("aggiungi")
	public String aggiungi(@RequestParam Map<String,String> m , HttpSession sessione) 
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
		
		
	@GetMapping("formmodifica")
	public String formModificaMotivo(@RequestParam("idViaggio") int idViaggio , Model model , HttpSession sessione )
	{	
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		model.addAttribute("motivazione" , dm.cercaMotivo(idViaggio) );
		return PREFISSO + "formmodificamotivo.jsp";	
	}
		
	//modificare motivazione
	@PostMapping("modifica")
	public String modifica(@RequestParam Map<String,String> m , HttpSession sessione) 
	{	
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		if(dm.update(m))
			return "redirect:elenco";
		else
			return m + " non è stato modificato";
	}
	
	@GetMapping("elimina")
	public String elimina(@RequestParam("idViaggio") int idViaggio  , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		if(dm.delete(idViaggio))
			return "redirect:elenco";
		else
			return "Errore durante l'eliminazione della motivazione";
	}
}