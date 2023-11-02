package com.agenzia.Wanderlust.entities;

public class Compagnia 
{
	private int id ;
	private String nome;
	private int supplemento;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = Integer.parseInt(id);
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public int getSupplemento()
	{
		return supplemento;
	}
	
	public void setSupplemento(String supplemento) 
	{
		this.supplemento =Integer.parseInt(supplemento);
	}
	


	@Override
	public String toString() 
	{
		return "id : " + id 
				+ "\nCompagnia : " + nome 
				+ "\nsupplemento : " 
				+ supplemento + "\n";
	}
	
	
	
	
}
