package com.agenzia.Wanderlust.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/prova")
public class BaseController
{
	@GetMapping("funziono")
	@ResponseBody
	public String funziono ()
	{
		return "funziono";
	}
	
	@GetMapping("import")
	public String prova () 
	{
		return  "/base.html";
		
	}
}
