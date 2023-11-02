package com.agenzia.Wanderlust.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.agenzia.Wanderlust.Dao.DaoLog;
import com.agenzia.Wanderlust.Database.Database;


@Controller
@RequestMapping("/log")
public class LogController
{
 
	 
	@Autowired
	public Database db;
	
	@Autowired
	private DaoLog daoLog;
	

	
	
	@GetMapping("allLog")
	public String allLog(Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		System.err.println("errore");
		
     	model.addAttribute("log", daoLog.read("select * from log"));
     	System.out.println(daoLog);
     	return "/log.jsp";
		
	}
	
	
	
	
	
	
	
	
}
