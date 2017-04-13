package it.polito.tdp.anagrammi.model;

import java.util.*;

public class Model {
	private List<String> elencoParole= new LinkedList<String>();
	
	 
	public List<String> commuta(String parola){
		int fattoriale= calcolaFatoriale(parola);
		int livello=0;
		char[] arrayCaratteri= parola.toCharArray();
	//	elencoParole.add(parola);
		String parziale="";
		this.listaCommutazioni(parola,parziale, arrayCaratteri, fattoriale, livello);
		
		
		return elencoParole;
		
	}
	
	private void listaCommutazioni(String parola,String parziale,char[] arrayCaratteri, int fattoriale, int livello){
		if(parziale.length()==parola.length()){
			if(!elencoParole.contains(parziale))
				elencoParole.add(parziale);
			  //parziale="";
		}
		
		for(int i=0; i<parola.length();i++){
			//if(i!=livello) {                        
			parziale+=arrayCaratteri[i];
			System.out.println(livello);
			//livello=livello+1;
			listaCommutazioni(parola, parziale,arrayCaratteri, fattoriale, livello+1);
			//livello=livello-1;
		   parziale.lastIndexOf("", i);
		}
		
	}
	
	

	/*private List<String> listaCommutazioni(char[] parziale,char[] arrayCaratteri, int fattoriale, int livello) {// inizializza parziale e aggiungi a lista
		int i=livello;
		int j=livello+1;
		
		 while((elencoParole.size()<fattoriale)&&(j< arrayCaratteri.length-1)){
		   
			 String s= this.commutazione(parziale, i, j);
			 System.out.println(s+" "+i+" "+j+" "+" "+elencoParole.size()+elencoParole);
			 
			if(!elencoParole.contains(s)){
				 elencoParole.add(s);
				 if((i==livello)&&(j==(livello+1))){
					 i++;
					 j++;
				 }
				 else{
					 i--;
					 j--;
				 }
			 }
			else{
				livello++;
				listaCommutazioni(arrayCaratteri, arrayCaratteri,fattoriale, livello);
			}
			 
		 }
		
		
		return elencoParole;
	}

	private String commutazione(char[] parziale, int i, int j) {
		char scambioI= parziale[i];
		char scambioJ=parziale[j];
		
		parziale[j]=scambioI;
		parziale[i]=scambioJ;
		
		String s="";
		
		for(char c: parziale){
			s+=c;
		}
		
		
		return s;
	}
	*/

	private int calcolaFatoriale(String parola) {
		int lunghezza=parola.length();
		int fattorialeMetodo=1;
		
		for(int k=1; k<=lunghezza; k++ ){
			fattorialeMetodo= fattorialeMetodo*k;
		}
		
		return fattorialeMetodo;
	}
	
	

	

}
