package com.agenzia.Wanderlust.entities;

import java.sql.Date;

//classe persona 
public class Persona
{

	private String cf;
	private String nominativo;
	private Date dob;
	private String username;
	private String password;
	private String email;
		
//Get & Set 	
	public String getCf()
	{
		return cf;
	}


	public void setCf(String cf)
	{
		this.cf = cf;
	}


	public String getNominativo()
	{
		return nominativo;
	}


	public void setNominativo(String nominativo)
	{
		this.nominativo = nominativo;
	}


	public Date getDob()
	{
		return dob;
	}


	public void setDob(String dob) 
	{
		this.dob = Date.valueOf(dob);
	}

	public String getUsername()
	{
		return username;
	}


	public void setUsername(String username) 
	{
		this.username = username;
	}


	public String getPassword() 
	{
		return password;
	}


	public void setPassword(String password) 
	{
		this.password = password;
	}


	public String getEmail() 
	{
		return email;
	}


	public void setEmail(String email) 
	{
		this.email = email;
	}



	@Override
	public String toString()
	{
		return "Codice Fiscale :  " 	+ cf 		 + 
				"\nNominativo :  " 		+ nominativo + 
				"\nData di nascita :  " + dob 		 + 
				"\nUsername :  " 		+ username   + 
				 "\nPassword :  " 		+ password 	 + 
				 "\nEmail :  " 			+ email      +
				 "\n";
	}
	
	
	
	
}
