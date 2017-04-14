package it.polito.tdp.anagrammi.model;

public class TestModel {

	public static void main(String[] args) {
		Model m= new Model();
		
		//int i= m.calcolaFatoriale("cia");
		//System.out.println(" fattoriale abc="+i);
		// TODO Auto-generated method stub
		
		System.out.println("le combinazione corrette sono: \n" +m.corrette("abc"));
		
		System.out.println("------");
		
		System.out.println("le combinazioni errate: \n"+m.errate("abc"));

	}

}
