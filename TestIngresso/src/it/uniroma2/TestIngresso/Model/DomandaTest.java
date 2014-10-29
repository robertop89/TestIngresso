package it.uniroma2.TestIngresso.Model;

/**
 * Classe che rappresenta l'oggetto domanda da sottoporre all'utente
 * @author roberto
 * @version 24-10-14
 */

public class DomandaTest {
	/** id univoco della domanda */
	int id;
	/** testo del quesito da esporre */
	String testo;
	/** testi delle 5 possibili risposte */
	String risp1, risp2, risp3, risp4, risp5;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public String getRisp1() {
		return risp1;
	}
	public void setRisp1(String risp1) {
		this.risp1 = risp1;
	}
	public String getRisp2() {
		return risp2;
	}
	public void setRisp2(String risp2) {
		this.risp2 = risp2;
	}
	public String getRisp3() {
		return risp3;
	}
	public void setRisp3(String risp3) {
		this.risp3 = risp3;
	}
	public String getRisp4() {
		return risp4;
	}
	public void setRisp4(String risp4) {
		this.risp4 = risp4;
	}
	public String getRisp5() {
		return risp5;
	}
	public void setRisp5(String risp5) {
		this.risp5 = risp5;
	}
}
