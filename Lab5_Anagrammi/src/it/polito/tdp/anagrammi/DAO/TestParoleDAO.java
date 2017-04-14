package it.polito.tdp.anagrammi.DAO;

import java.util.Set;

public class TestParoleDAO {

	public static void main(String[] args) {
		ParoleDAO p= new ParoleDAO();
		
	//	Set<String> a= p.getTuttiCorsi();
		
	//	System.out.println(a.toString());
		//for(int i=0; i<90; i++)
		if(p.isCorrect("weppo")==true){
			System.out.println("isCorrect: ook");
		}
		else{
			System.out.println("buuuu");
		} 
		
		if(p.trova("weppo")==true){
			System.out.println("trova: ook");
		}
		else{
			System.out.println("buuuu");
		} 
		
		
		//System.out.println(p.find(38754));
		
		/*boolean b= p.ricercaDicotomica("fghjk",0, 697846);
		if(b==true){
			System.out.println("ook");
		}
		else{
			System.out.println("buuuu");
		}*/
}
}
