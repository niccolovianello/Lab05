package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.dao.AnagrammaDAO;

public class Model {
	
	private char[] arrayChar;
	private List<String> anagrammi = new ArrayList<String>();
	
	public List<String> getParoleAll() {
		AnagrammaDAO dao = new AnagrammaDAO();
		return dao.getParole();
	}
	
	public List<String> AnagrammiModel(String parola) {
		arrayChar = parola.toCharArray();
		anagrammi.add(parola);
		
		List<String> res = new ArrayList<String>();
		
		int L = 1;
		
		for(int i = 0; i < fatt(parola.length()); i++)//per fargli scrivere n! anagrammi, ma non dà il risultato voluto
			generaAnagramma(arrayChar, L, 0);
		
	}
	
	private void generaAnagramma(String parziale, int L, int start) {
		
//		Le caselle da 0 a l-1 sono piene
//		devo trovare un valore per le caselle in posizione L
		
//	private void cerca(String parziale, int L) 
//		if(L == parziale.length()*parziale.length()) {
//			if(parziale.isMagic()) {
//				soluzioni.add(parziale.clone());
//			}
//			return;
//		}
//		
//		for(int i = 1; i<=parziale.getSize()*parziale.getSize(); i++) {
//			// provo a mettere il valore i nella casella L
//			if(!parziale.contains(i))
//				parziale.add(i);
//			
//			cerca(parziale, L+1);
//			parziale.;
//		}
	}
}
