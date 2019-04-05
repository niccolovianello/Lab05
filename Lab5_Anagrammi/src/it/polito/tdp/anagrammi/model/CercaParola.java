package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class CercaParola {


	private List<String> soluzioni = new ArrayList<String>();
	
//	private void cerca(String parziale, int L) {
//		// Le caselle da 0 a l-1 sono piene
//		// devo trovare un valore per le caselle in posizione L
//		
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
//	}
//
//	@Override
//	public Object clone() throws CloneNotSupportedException {
//		return super.clone();
//	}
}
