package it.polito.tdp.anagrammi.model;

import java.util.*;


public class Model {
	private int i=1;
	//private int numeroDoppie=0;
	private List<String> mappaLettere= new LinkedList<String>();
	//private LinkedList<String> listaLettereDoppie= new LinkedList<String>();
	 
	public Set<String> commuta(String parola){
	
		creaMappa(parola);
		
		Set<String> soluzione= this.risolvi();
	
		
		System.out.println("\n"+"proooova"+ mappaLettere.toString()+"\n");
		return soluzione;
		
	}
	
	

	private HashSet<String> risolvi() {
		List<String> parziale = new ArrayList<String>();
		HashSet<String> elencoParole= new HashSet<String>();
		scegli (parziale,0,0, elencoParole);
		return elencoParole;
	}



	private void scegli(List<String> parziale, int livello, int posizione, Set<String> elencoParole) {
		
		if(parziale.size()==mappaLettere.size()){
			
			String s= trasformaStringa(parziale);
			//if(!elencoParole.contains(s))
			       elencoParole.add(s);
			
			System.out.println(s+" "+i++);
			
		}
		
		for(String lettera: mappaLettere){
			if ((controllaLettera(lettera, parziale, mappaLettere)==false)){
				String temp=""+posizione+" "+lettera;
				parziale.add(temp);
				posizione++;
				
				scegli(parziale,livello+1, posizione,elencoParole );
				
				parziale.remove(temp);
				
				
			}
		}
		
		
		
		
	}





	private boolean controllaLettera(String lettera, List<String> parziale, List<String> mappaLettere) {
		int comparsa= numeroVoltaPresente(lettera, mappaLettere);
		//System.out.println("aaaaaaaaaaaaaaa"+comparsa);
		int count=0;
		
		for(String s: parziale){
			if(s.contains(lettera))
				count++;
				
		}
		
		if(count==comparsa){
			return true;
		}
		return false;
	}



private int numeroVoltaPresente(String lettera, List<String> mappaLettere) {
	  int contatore=0;
	for(String s: mappaLettere){
		  if(s.equals(lettera))
			  contatore++;
	  }
	
	
		return contatore;
	}



	private String trasformaStringa(List<String> parziale) {
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
			//if(!mappaLettere.contains(""+caratteri[i]))
			    mappaLettere.add(""+caratteri[i]);
		/*	else{
				if(listaLettereDoppie.size()<10){
				      listaLettereDoppie.add(""+numeroDoppie+" "+caratteri[i]);
				       mappaLettere.add(""+numeroDoppie);
				      numeroDoppie++;
				      }
				
			}*/
		}
		
		
	}
	
	
	
	// fa piu commutazioni di quelli possibili

	

	

}
