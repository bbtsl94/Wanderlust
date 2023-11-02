package com.agenzia.Wanderlust.Dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.agenzia.Wanderlust.Database.Database;
import com.agenzia.Wanderlust.entities.Admin;


public class DaoAdmin 
{
	@Autowired
	private Database db;
	
	@Autowired
	private ApplicationContext context;
	
	public Admin read (String cf ) 
	{
		String query = "select * from admin where cf = ?";
		if(db.row(query, cf ) != null)
		{
			return context.getBean(Admin.class , db.row(query , cf));	
		}
		return null;
	}
	
}
