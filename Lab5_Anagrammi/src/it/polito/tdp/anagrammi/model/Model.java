package it.polito.tdp.anagrammi.model;

import java.util.*;


public class Model {
	private int i=0;
	private Map<Integer, String> mappaLettere= new HashMap<Integer, String>();
	 
	public Set<String> commuta(String parola){
	
		creaMappa(parola);
		
		Set<String> soluzione= this.risolvi();
	//	itera(mappaLettere, 0, Set<Pezzo> parziale );// metodo per riempire la lista con iterazione
	//	itera(vettorePosizione, prova, arrayCaratteri,0);
		
		return soluzione;
		
	}
	
	

	private Set<String> risolvi() {
		TreeMap<Integer,String> parziale = new TreeMap<Integer,String>();
		Set<String> elencoParole= new HashSet<String>();
		scegli (parziale,0, elencoParole);
		return elencoParole;
	}



	private void scegli(TreeMap<Integer,String> parziale, int livello, Set<String> elencoParole) {
		
		if(parziale.size()==mappaLettere.size()){
			//trovata una commutazione
			// devo salvarla in elencoParole
			
			//trasformo parziale in stringa
			// e controllo se gia esiste
			String s= trasformaStringa(parziale);
			elencoParole.add(s);
			
		}
		
		for(int j=0; j<mappaLettere.size();j++){//parziale linkedList perchemantiene ordine inserimento
			if(!parziale.containsKey(j)){
				String temp=(""+i+" "+mappaLettere.get(j));
				parziale.put(j,temp);
				i++;
				
				scegli(parziale, livello+1, elencoParole);
				parziale.remove(mappaLettere.get(j));
				
			}
		}
		
	}



	private String trasformaStringa(TreeMap<Integer, String> parziale) {
		LinkedList<String> lettere=  new LinkedList<String>(parziale.values());
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
			Integer j= i;
			mappaLettere.put(j, ""+caratteri[i]);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

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
