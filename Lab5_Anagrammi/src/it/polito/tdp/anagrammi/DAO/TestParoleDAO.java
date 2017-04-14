package it.polito.tdp.anagrammi.DAO;

import java.util.Set;

public class TestParoleDAO {

	public static void main(String[] args) {
		ParoleDAO p= new ParoleDAO();
		
	//	Set<String> a= p.getTuttiCorsi();
		
	//	System.out.println(a.toString());
		
		if(p.isCorrect("ewrdftgyhj")==true){
			System.out.println("ook");
		}
		else{
			System.out.println("buuuu");
		}
}
}
