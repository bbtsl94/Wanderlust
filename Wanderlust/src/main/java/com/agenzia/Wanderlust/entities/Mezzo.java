package com.agenzia.Wanderlust.entities;

public class Mezzo 
{
	private int id;
	private String tipo;
	private double prezzoBase;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getTipo() 
	{
		return tipo;
	}
	
	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}
	
	public double getPrezzoBase()
	{
		return prezzoBase;
	}
	
	public void setPrezzoBase(String  prezzoBase) 
	{
		if(prezzoBase == null)
			this.prezzoBase=0.0;
		else
			this.prezzoBase =Double.parseDouble(prezzoBase) ;
	}

	
	@Override
	public String toString() 
	{
		return "id : " + id 
				+ "\nMezzo : " + tipo 
				+ "\nPrezzo base : " + prezzoBase 
				+ "\n";
	}
	
	
	
}
