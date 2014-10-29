package it.uniroma2.TestIngresso.Model;

import it.uniroma2.TestIngresso.DAO.DomandaDAO;
import it.uniroma2.TestIngresso.DAO.DAOFactory;

import java.util.List;

public class RisposteFactory {
	/**
	 * Metodo che riceve una lista di idDomande e restituisce un oggetto Risposte
	 * le relative risposte corrette e la motivazione
	 * @param i
	 * @return Oggetto Risposte
	 */
	public static Risposte CaricaRisposte(List<Integer> id){
		Risposte risp = new Risposte();
		DomandaDAO dd = DAOFactory.createDomanda();
		
		int c = id.size();
		int[] idDomanda = new int[c];
		int[] indiceCorretta = new int[c];
		String[] motivazione = new String[c];
		for(int i=0;i < c;i++){
			Risposta r;
			r = dd.selectRispById(id.get(i));
			idDomanda[i] = r.getIdDomanda();
			indiceCorretta[i] = r.getIndiceCorretta();
			motivazione[i] = r.getMotivazione();
		} // gestione errori!
		risp.setIdDomanda(idDomanda);
		risp.setIndiceCorretta(indiceCorretta);
		risp.setMotivazione(motivazione);
		return risp;
	}
}
