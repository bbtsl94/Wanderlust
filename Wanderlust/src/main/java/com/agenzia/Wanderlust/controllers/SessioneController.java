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
import com.agenzia.Wanderlust.Dao.DaoAdmin;
import com.agenzia.Wanderlust.Dao.DaoCompagnia;
import com.agenzia.Wanderlust.Dao.DaoOperatore;
import com.agenzia.Wanderlust.Dao.DaoPersona;
import com.agenzia.Wanderlust.entities.Admin;
import com.agenzia.Wanderlust.entities.Compagnia;
import com.agenzia.Wanderlust.entities.Operatore;
import com.agenzia.Wanderlust.entities.Persona;

@Controller
@RequestMapping("/sessione")
public class SessioneController
{
	@Autowired
	private DaoPersona daopersona ;
	
	@Autowired
	private DaoAdmin daoAdmin;
 
	@Autowired
	private DaoOperatore daoOperatore;
	
	@Autowired
	private DaoCompagnia daoCompagnia;
	
	@GetMapping("home")
	public String home() 
	{
		return "/home.html";
	}
	
	//	form login 
	@GetMapping("login")
	public String formlogin() 
	{
		
		return "/login.html";
	}

	
	//form refister 
	@GetMapping("register")
	public String formRegister() 
	{
		
		return "/register.html";
	}
	// form newaccount
	@PostMapping("newaccount")
	public String formNewaccount( @RequestParam Map<String , String >map) 
	{
		System.err.println("coglione");
		if ( daopersona.controllo(map)) 
		{
			// caso in cui il controllo va a buon fine (molto difficile abbiamo cannato)
			daopersona.create(map);
			return "redirect:login";
		}
		else
			return "redirect:register";
	}
	
	
	@GetMapping("accesso")
	public String verificaLogin(@RequestParam Map<String , String > map ,HttpSession session ) 
	{
		Persona p = null;
		System.out.println(map.get("dob") +  "valore di dio stilenca  ");
		System.out.println();
		p = daopersona.cercaPersona(map.get("username") , map.get("password"));
		System.out.println(p);
		if(p != null) 
		{
			session.setAttribute("codice", null);
			session.setAttribute("persona", null);
			session.setAttribute("idcompagnia", null);
			session.setAttribute("connesso", null);

			Admin a = daoAdmin.read(p.getCf());
			if (a != null) 
			{	
				session.setAttribute("codice", a.getCodice());
			}
			else 
			{
				Operatore  o = daoOperatore.cercaOperatore(p.getCf());
				if(o != null)
				{
					session.setAttribute("codice", "operatore");
					session.setAttribute("idcompagnia", o.getIdcompagnia());
				}
				else 
				{
					
					session.setAttribute("codice", "default");
				}
				
			}
			
			session.setAttribute("persona", p);
			session.setAttribute("connesso", "si");
			return "redirect:menu";
		}
		return "redirect:login";
		
	}
	
	
	
	@GetMapping("menu")
	public String page(HttpSession session , Model model ) 
	{	
		if(session.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}
		
		String var = (String) session.getAttribute("codice");
		System.out.println(var);
		switch (var) 
		{
			case "default":
				model.addAttribute("persona" ,(Persona) session.getAttribute("persona"));
				return "/basemenu/menucliente.jsp";

			case "operatore":
				model.addAttribute("persona" , (Persona) session.getAttribute("persona"));
				Compagnia compagnia = daoCompagnia.cercaCompagnia((int) session.getAttribute("idcompagnia"));
				model.addAttribute("compagnia" , compagnia );
				System.out.println("sono operatore");
				return "/basemenu/menuoperatore.jsp";
			case "admin":
				
				model.addAttribute("persona" ,(Persona) session.getAttribute("persona"));
				
				return "/basemenu/menuadmin.html";
				
			default:
				return "redirect:home";
		}
	}
	
	
	@GetMapping("exit")
	public String exit(HttpSession session) 
	{
		session.setAttribute("codice", null);
		session.setAttribute("persona", null);
		session.setAttribute("idcompagnia", null);
		session.setAttribute("connesso", null);
		return "redirect:home" ;	
	}
}
