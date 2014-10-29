package it.uniroma2.TestIngresso.DAO;
import java.util.ArrayList;
import java.util.List;

import it.uniroma2.TestIngresso.Model.*;

public class prova {
	public static void main(String [ ] args){
		/*List<Domanda> d = new ArrayList<Domanda>();
		
		
		DomandaDAOFactory daoD = new DomandaDAOFactory();
		DomandaDAO dao = daoD.create();
		d = dao.selectRandomByMateria(1,1);
		System.out.println(dao.countDomandeMateria(6));
		for(int i=0;i<d.size();i++){
			Domanda dom = new Domanda();
			dom = d.get(i);
			System.out.println(dom.getId()+" "+dom.getTesto()+" "+dom.getMateria()+"\n"+dom.getRisp1()+" "+dom.getRisp2()+" "+dom.getRisp3()+" "+dom.getRisp4()+" "+dom.getRisp5()+"\n"+dom.getIndiceCorretta()+" "+dom.getMotivazione()+"\n\n");
		}
		Domanda dom = new Domanda();
		dom.setId(8);
		dom.setMateria(2);
		dom.setTesto("La radice di 4?");
		dom.setRisp1("1");
		dom.setRisp2("1,41");
		dom.setRisp3("2");
		dom.setRisp4("4");
		dom.setRisp5("meno infinito");
		dom.setIndiceCorretta((byte)3);
		dom.setMotivazione("Perchè 2 alla seconda è 4");
		System.out.println(dao.update(dom));	*/
		/* List<Materia> m = new ArrayList<Materia>();
		
		
		MateriaDAOFactory daoM = new MateriaDAOFactory();
		MateriaDAO dao = daoM.create();
		System.out.println(dao.selectByNome("Algebra"));
		
		Materia materia = new Materia();
		materia.setId(2);
		materia.setNome("Geometria");
		dao.update(materia);
		m = dao.selectAll();
		for(int i=0;i<m.size();i++){
			Materia mat = new Materia();
			mat = m.get(i);
			System.out.println(mat.getId()+" "+mat.getNome());
		} */
	
	TestAllenamento test = new TestAllenamento();
	test = TestAllenamentoFactory.caricaTest(1, 2);
	System.out.println(test.getMateria());
	for(int i=0;i<2;i++){
		DomandaTest d = new DomandaTest();
		d = test.getDomanda(i);
		System.out.println(d.getId()+" "+d.getTesto()+" "+d.getRisp1()+" "+d.getRisp2());
	}
	System.out.println("Ciao");
	/*Risposte risp = new Risposte();
	List<Integer> d = new ArrayList<Integer>();
	d.add(1);
	d.add(4);
	risp = RisposteFactory.CaricaRisposte(d);
	System.out.println(risp.getIdDomanda(0)+" "+risp.getIndiceCorretta(0)+" "+risp.getMotivazione(0));
	System.out.println(risp.getIdDomanda(1)+" "+risp.getIndiceCorretta(1)+" "+risp.getMotivazione(1));
	*/
	}
}
