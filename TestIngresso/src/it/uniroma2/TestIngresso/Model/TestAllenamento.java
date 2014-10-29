package it.uniroma2.TestIngresso.Model;

public class TestAllenamento {
	private String materia;
	private DomandaTest[] domande;
	
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public DomandaTest[] getDomande() {
		return domande;
	}
	public void setDomande(DomandaTest[] domande) {
		this.domande = domande;
	}
	public DomandaTest getDomanda(int i){
		return this.domande[i];
	}
	
}
