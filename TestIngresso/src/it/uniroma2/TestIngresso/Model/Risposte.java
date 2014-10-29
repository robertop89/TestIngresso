package it.uniroma2.TestIngresso.Model;

/**
 * Classe contenente le risposte corrette con la motivazione delle domande contenute
 * @author roberto
 * @version 27-10-14
 */
public class Risposte {
	private int[] idDomanda;
	private int[] indiceCorretta;
	private String[] motivazione;
	
	public int[] getIdDomanda() {
		return idDomanda;
	}
	public int getIdDomanda(int i){
		return idDomanda[i];
	}
	public void setIdDomanda(int[] idDomanda) {
		this.idDomanda = idDomanda;
	}
	public int[] getIndiceCorretta() {
		return indiceCorretta;
	}
	public int getIndiceCorretta(int i){
		return indiceCorretta[i];
	}
	public void setIndiceCorretta(int[] indiceCorretta) {
		this.indiceCorretta = indiceCorretta;
	}
	public String[] getMotivazione() {
		return motivazione;
	}
	public String getMotivazione(int i){
		return motivazione[i];
	}
	public void setMotivazione(String[] motivazione) {
		this.motivazione = motivazione;
	}
	
}
