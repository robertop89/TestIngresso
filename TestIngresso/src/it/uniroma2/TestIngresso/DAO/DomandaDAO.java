package it.uniroma2.TestIngresso.DAO;

import it.uniroma2.TestIngresso.Model.Domanda;
import it.uniroma2.TestIngresso.Model.DomandaTest;
import it.uniroma2.TestIngresso.Model.Risposta;

import java.util.List;

/**
 * Interfaccia di DomandaDAO indicante i metodi implementati
 * @author roberto
 * @version 25-10-14
 */
public interface DomandaDAO{
	public List<Domanda> selectAll();
	public List<Domanda> selectByMateria(int materia);
	public List<DomandaTest> selectRandomByMateria(int materia, int numero);
	public int countDomandeMateria(int materia);
	public Domanda selectById(int id);
	public Risposta selectRispById(int id);
	public boolean insert(Domanda d);
	public boolean update(Domanda d);
	public boolean delete(int id);

}

