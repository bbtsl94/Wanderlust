package com.agenzia.Wanderlust.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Viaggio 
{
	private int id;
	private int idPartenza;
	private int idArrivo;
	private String idTrasporto;
	private LocalDateTime oraP;
	private LocalDateTime oraA;
	private double prezzo;
	private boolean disponibile;
	private boolean cancellato;
	private int classe;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdLuogoPartenza() {
		return idPartenza;
	}
	public void setIdLuogoPartenza(String idPartenza) {
		this.idPartenza = Integer.parseInt(idPartenza);
	}
	public int getIdLuogoArrivo() {
		return idArrivo;
	}
	public void setIdLuogoArrivo(String idArrivo) {
		this.idArrivo = Integer.parseInt(idArrivo);
	}
	public String getIdTrasporto() {
		return idTrasporto;
	}
	public void setIdTrasporto(String idTrasporto) {
		this.idTrasporto = idTrasporto;
	}
	public LocalDateTime getOraPartenza() {
		return oraP;
	}
	public void setOraPartenza(String oraP) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
		this.oraP = LocalDateTime.parse(oraP, dateFormat);
	}
	public LocalDateTime getOraArrivo() {
		return oraA;
	}
	public void setOraArrivo(String oraA) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
		this.oraA = LocalDateTime.parse(oraA, dateFormat);
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(String prezzo) {
		this.prezzo = Double.parseDouble(prezzo);
	}
	public boolean isDisponibile() {
		return disponibile;
	}
	public void setDisponibile(String disponibile) {
		this.disponibile = disponibile.equals("1");
	}
	public boolean isCancellato() {
		return cancellato;
	}
	public void setCancellato(String cancellato) {
		this.cancellato = cancellato.equals("1");
	}
	public int getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = Integer.parseInt(classe);
	}
}