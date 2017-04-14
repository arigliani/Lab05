package it.polito.tdp.anagrammi.model;

import java.util.*;


public class Model {
	private int i=1;
	private Set<String> mappaLettere= new HashSet<String>();
	 
	public Set<String> commuta(String parola){
	
		creaMappa(parola);
		
		Set<String> soluzione= this.risolvi();
	//	itera(mappaLettere, 0, Set<Pezzo> parziale );// metodo per riempire la lista con iterazione
	//	itera(vettorePosizione, prova, arrayCaratteri,0);
		
		return soluzione;
		
	}
	
	

	private HashSet<String> risolvi() {
		Set<String> parziale = new HashSet<String>();
		HashSet<String> elencoParole= new HashSet<String>();
		scegli (parziale,0,0, elencoParole);
		return elencoParole;
	}



	private void scegli(Set<String> parziale, int livello, int posizione, Set<String> elencoParole) {
		
		if(parziale.size()==mappaLettere.size()){
			//trovata una commutazione
			// devo salvarla in elencoParole
			
			//trasformo parziale in stringa
			// e controllo se gia esiste
			String s= trasformaStringa(parziale);
			elencoParole.add(s);
			
			System.out.println(s+" "+i++);
			
		}
		
		for(String lettera: mappaLettere){
			if ((controllaLettera(lettera, parziale)==false)){
				String temp=""+posizione+" "+lettera;
				parziale.add(temp);
				posizione++;
				
				scegli(parziale,livello+1, posizione,elencoParole );
				
				parziale.remove(temp);
				
				
			}
		}
		
		
		
		
	}



	private boolean controllaLettera(String lettera, Set<String> parziale) {
		for(String s: parziale){
			if(s.contains(lettera))
				return true;
		}
		return false;
	}



	private String trasformaStringa(Set<String> parziale) {
		LinkedList<String> lettere=new LinkedList<String>();
	    
		 for(String s: parziale ){
		    	lettere.add(s);
		    	
		    }
		
		Collections.sort(lettere);
	    String parola="";
	    for(String s: lettere ){
	    	String[] temp=s.split(" ");
	    	parola+=temp[1];
	    	
	    }
	    return parola.trim();
		
	}



	private void creaMappa(String parola) {
		char[] caratteri=parola.toCharArray();
		
		for(int i=0; i<parola.length();i++){
			
			mappaLettere.add(""+caratteri[i]);
		}
		
		
	}
	
	
	
	
	/*for(int j=0; j<mappaLettere.size();j++){//parziale linkedList perchemantiene ordine inserimento
			if(!parziale.containsKey(j)){
			//	int rimuovi=j;
				String temp=(""+i+" "+mappaLettere.get(j));
				parziale.put(j,temp);
				i++;
				
				scegli(parziale, livello+1, elencoParole);
				parziale.remove(temp);
				
			}
		}*/
	
	
	
	
	
	
	
	
	
	
	
	

	/*private int[] creaVettore(String parola) {
		int i= parola.length();
		int[] vett= new int[i];
		
		for(int j=0;j<i;j++){
			vett[j]=j;
		}
		return vett;
	}
	
	String verifica="";
	private void itera(int[] vettPosizione,char[] prova, char[] arrayCaratteri,int livello ){
		
		
		for(int i: vettPosizione){
			if(!verifica.contains(""+i)){
				prova[i]=arrayCaratteri[livello];
				verifica+=this.verificaParola(prova, vettPosizione.length,livello, verifica);
				itera(vettPosizione,prova,arrayCaratteri, livello+1);
				
				
				
		     }
		}
	}
	
	*/
	
	

	

	

}
