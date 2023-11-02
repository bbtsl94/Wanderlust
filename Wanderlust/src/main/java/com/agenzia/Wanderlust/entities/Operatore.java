package com.agenzia.Wanderlust.entities;

public class Operatore 
{

	private String cf; 
	private int idCompagnia;
	private int sconto;
	
	
	public String getCf()
	{
		return cf;
	}
	
	public void setCf(String cf)
	{
		this.cf = cf;
	}
	
	public int getIdcompagnia() 
	{
		return idCompagnia;
	}
	
	
	public void setIdcompagnia(String idCompagnia) 
	{
		this.idCompagnia = Integer.parseInt(idCompagnia);
	}
	
	public int getSconto() 
	{
		return sconto;
	}
	
	public void setSconto(String sconto) 
	{
		this.sconto = Integer.parseInt(sconto);
	}

	@Override
	public String toString() {
		return "Codice Fiscale :  "  + cf  		  + 
				"\nId Compagnia :  " + idCompagnia + 
				"\nSconto :  " 		 + sconto      + 
				"\n";
	}
	
	
	
}
