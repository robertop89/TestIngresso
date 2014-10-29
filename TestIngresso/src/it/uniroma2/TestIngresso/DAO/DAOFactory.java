package it.uniroma2.TestIngresso.DAO;

/**
 * Factory dei DAO
 * @author roberto
 * @version 26-10-14
 */

public class DAOFactory{
	public static DomandaDAO createDomanda(){
		return (new DomandaDAOImpl());
	}
	
	public static MateriaDAO createMateria(){
		return (new MateriaDAOImpl());
	}
	
	
}
