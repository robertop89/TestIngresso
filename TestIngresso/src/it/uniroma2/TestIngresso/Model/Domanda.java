package it.uniroma2.TestIngresso.Model;

/**
 * Classe che rappresenta l'oggetto domanda completo di materia, risposta corretta
 * e motivazione presente nel DB
 * @author roberto
 * @version 24-10-14
 */
public class Domanda extends DomandaTest{
	/** id della materia della domanda */
	int materia;
	/** indice della risposta corretta. Da 1 a 5 */
	byte indiceCorretta;
	/** motivazione della risposta corretta */
	String motivazione;
	
	public int getMateria() {
		return materia;
	}
	public void setMateria(int materia) {
		this.materia = materia;
	}
	public byte getIndiceCorretta() {
		return indiceCorretta;
	}
	public void setIndiceCorretta(byte indiceCorretta) {
		this.indiceCorretta = indiceCorretta;
	}
	public String getMotivazione() {
		return motivazione;
	}
	public void setMotivazione(String motivazione) {
		this.motivazione = motivazione;
	}
}
