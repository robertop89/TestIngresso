package it.uniroma2.TestIngresso.Model;

import it.uniroma2.TestIngresso.DAO.DomandaDAO;
import it.uniroma2.TestIngresso.DAO.MateriaDAO;
import it.uniroma2.TestIngresso.DAO.DAOFactory;

import java.util.ArrayList;
import java.util.List;

public class TestAllenamentoFactory {
	/**
	 * Metodo che carica in un test di allenamento un "numero" di domande scelte in 
	 * modo casuale
	 * @param materia
	 * @param numero
	 * @return oggetto TestAllenamento. Se non ci sono sufficienti domande restituisce l'oggetto con materia "00"
	 */
	public static TestAllenamento caricaTest(int materia, int numero){
		TestAllenamento test = new TestAllenamento();
		List<DomandaTest> domande = new ArrayList<DomandaTest>();
		
		MateriaDAO md = DAOFactory.createMateria();
		DomandaDAO dd = DAOFactory.createDomanda();
		
		// Se non ci sono sufficienti domande restituisce un oggetto TestAllenamento vuoto
		// con materia "00"
		if(numero > dd.countDomandeMateria(materia)){
			test.setMateria("00");
			return test;
		}
		test.setMateria(md.selectById(materia));
		domande = dd.selectRandomByMateria(materia, numero);
		
		DomandaTest[] dom = new DomandaTest[numero];
		for(int i=0;i<domande.size();i++){
			dom[i] = domande.get(i);
		}
		test.setDomande(dom);
		return test;
	}
}
