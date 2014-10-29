package it.uniroma2.TestIngresso.DAO;

import it.uniroma2.TestIngresso.Model.Materia;

import java.util.List;

/**
 * Interfaccia Materia DAO che dichiara i metodi implementati
 * @author roberto
 * @version 26-10-14
 */
public interface MateriaDAO{
	
	public List<Materia> selectAll();
	public String selectById(int id);
	public int selectByNome(String nome);
	public boolean update(Materia m);
}