package com.agenzia.Wanderlust.entities;

public class Motivazione
{
 
	private int idViaggio;
	private String motivo;
	
	public int getIdViaggio() 
	{
		return idViaggio;
	}
	
	public void setIdViaggio(String idViaggio) 
	{
		this.idViaggio = Integer.parseInt(idViaggio);
	}
	
	public String getMotivo()
	{
		return motivo;
	}
	
	public void setMotivo(String motivo) 
	{
		this.motivo = motivo;
	}

	@Override
	public String toString() {
		return "Id Viaggio :  " + idViaggio + 
				"\nMotivo :   " + motivo    + 
				"\n";
	}
	
	
	
	
}
