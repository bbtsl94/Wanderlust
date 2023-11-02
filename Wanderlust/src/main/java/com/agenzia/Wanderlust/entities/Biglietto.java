package com.agenzia.Wanderlust.entities;

public class Biglietto 
{

	private int id;
	private String cf;
	private int idViaggio;
	private double prezzo;
	
	//Get & Set
	public int getId()
	{
		return id;
	}
	
	public void setId(String id) 
	{
		this.id = Integer.parseInt(id);
	}
	public String getCf() 
	{
		return cf;
	}
	
	public void setCf(String cf) 
	{
		this.cf = cf;
	}
	
	public int getIdViaggio() 
	{
		return idViaggio;
	}
	
	public void setIdViaggio(String idViaggio) 
	{
		this.idViaggio = Integer.parseInt(idViaggio);
	}
	
	public double getPrezzo() 
	{
		return prezzo;
	}
	
	public void setPrezzo(String prezzo) 
	{
		this.prezzo = Double.parseDouble(prezzo);
	}

	//ToString 
	@Override
	public String toString() {
		return "Id Biglietto :  " 	   + id 	   + 
				"\nCodice Fiscale :  " + cf	       + 
				"\nId Viaggio :  " 	   + idViaggio + 
				"\nPrezzo :  "  	   + prezzo    +
				"\n";
	}
	
	
	
}
