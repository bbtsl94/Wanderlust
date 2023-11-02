package com.agenzia.Wanderlust.entities;

public class Admin
{
	private String cf ;
	private String codice ;
	
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	@Override
	public String toString() {
		return "cf : " + cf + "\ncodice : " + codice + "\n";
	}
	
	
}
