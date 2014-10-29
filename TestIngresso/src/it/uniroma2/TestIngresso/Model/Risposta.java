package it.uniroma2.TestIngresso.Model;

/**
 * Classe che rappresenta l'indice della risposta corretta e la motivazione della
 * domanda con id idDomanda
 * @author roberto
 * @version 26-10-14
 */
public class Risposta {
	private int idDomanda;
	private int indiceCorretta;
	private String motivazione;
	
	public int getIdDomanda() {
		return idDomanda;
	}
	public void setIdDomanda(int idDomanda) {
		this.idDomanda = idDomanda;
	}
	public int getIndiceCorretta() {
		return indiceCorretta;
	}
	public void setIndiceCorretta(int indiceCorretta) {
		this.indiceCorretta = indiceCorretta;
	}
	public String getMotivazione() {
		return motivazione;
	}
	public void setMotivazione(String motivazione) {
		this.motivazione = motivazione;
	}
}
