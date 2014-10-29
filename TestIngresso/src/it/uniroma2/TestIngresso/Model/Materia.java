package it.uniroma2.TestIngresso.Model;

/**
 * Classe che rappresenta la materia di riferimento di una domanda
 * @author roberto
 * @version 24-10-14
 */
public class Materia {
	/** id univoco della materia */
	int id;
	/** nome della materia */
	String nome;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
