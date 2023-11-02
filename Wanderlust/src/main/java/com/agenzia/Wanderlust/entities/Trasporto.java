package com.agenzia.Wanderlust.entities;

public class Trasporto 
{
	private String nome;
	private int nPosti;
	private int idCompagnia;
	private int idMezzo;
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public int getNPosti() 
	{
		return nPosti;
	}
	
	public void setNPosti(String nPosti)
	{
		this.nPosti = Integer.parseInt(nPosti);
	}
	
	public int getIdCompagnia() 
	{
		return idCompagnia;
	}
	
	public void setIdCompagnia(String idCompagnia)
	{
		this.idCompagnia = Integer.parseInt(idCompagnia);
	}
	
	public int getIdMezzo()
	{
		return idMezzo;
	}
	
	public void setIdMezzo(String idMezzo) 
	{
		this.idMezzo = Integer.parseInt(idMezzo);
	}

	@Override
	public String toString() 
	{
		return "nome : " + nome 
				+ "\nPosti massimi : " + nPosti 
				+ "\nid Compagnia : " + idCompagnia 
				+ "\nid Mezzo : " + idMezzo
				+ "\n";
	}
	
	
	
	

}
