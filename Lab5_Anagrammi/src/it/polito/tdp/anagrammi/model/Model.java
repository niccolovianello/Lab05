package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.dao.AnagrammaDAO;

public class Model {
	
	private Set<String> anagrammi;
	
	public boolean isCorrect(String parola) {
		AnagrammaDAO dao = new AnagrammaDAO();
		for(String s : anagrammi) {
			if(dao.isCorrect(parola))
				return true;
			else return false;
		}
		return false;
	}
	
	public Set<String> getAnagrammi(String parola) {
		anagrammi = new HashSet<String>();
		List<String> lettere = new LinkedList<String>();
		for(int i=0; i<parola.length(); i++) {
			lettere.add(parola.substring(i, i+1));
		}
		
		this.generaAnagramma("", lettere);
		return anagrammi;
	}
	
	/**
	 * Funzione ricorsiva per il calcolo degli anagrammi.
	 * Riceve la parte iniziale dell'anagramma già costruito nei livelli ricorsivi superiori e la lista delle lettere ancora non utilizzate. Prende una per una le lettere rianenti e le appende alla parola parziale, rilanciando la ricorsione.
	 * Quando non ci sono più lettere da inserire l'anagramma è completo, e la ricorione termina.
	 * 
	 * @param parziale
	 * @param lettereRimanenti
	 */
	private void generaAnagramma(String parziale, List<String> lettereRimanenti) {
	
		//condizione di terminazione
		if(lettereRimanenti.size()==0) {
			anagrammi.add(parziale);
		}
		
		else {
			// sono nel mezzo della ricorsione
			for(String lettera : lettereRimanenti) {
				List<String> subset = new LinkedList<>(lettereRimanenti);
				subset.remove(lettera);
				generaAnagramma(parziale+lettera, subset);
			}
		}
	}
}
