package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;



public class ParoleDAO {//`dizionario`.`parola`
	/**
	 * N=parole presenti nel vocabolario
	 */
	private int N=697846;
	
	public Set<String> getTuttiCorsi(){
	final	String sql= "SELECT nome " + "FROM dizionario.parola ";
	//boolean result=false;
		
	String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root&password=root" ;
	Set<String> parole= new HashSet<String>();
	
	try{
		Connection conn = DriverManager.getConnection(jdbcURL) ;
		
		PreparedStatement st = conn.prepareStatement(sql) ;
		
		
		ResultSet res = st.executeQuery() ;
		
		while(res.next()) {
			
			String s = res.getString("nome");
		
			parole.add(s);
			
		} 
		
		
		return parole;
		
	
	
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block

		throw new RuntimeException("Errore Db");
	}
	
	
	
	
	}
	
	
	public boolean isCorrect(String parola){
		boolean flag=false;

				flag=ricercaDicotomica(parola,1, N);
		return flag;
		
		
		} 
		
	
	
	public boolean ricercaDicotomica(String parola, int low, int high) {
		parola.trim();
		 int mid;
       mid = (low + high)/2;
        if ((mid < low)||(high<0))
        {    //  RichWord temp= new RichWord(parola,false);
	        //	controllate.add(temp);
               return false; //Valore non trovato
        }
        else if( parola.compareTo(this.find(mid))<0){
        
        	return ricercaDicotomica(parola, low, mid-1);
        }
        else if(parola.compareTo(this.find(mid))>0){
        	return ricercaDicotomica(parola, mid+1, high);
        }
        else{
        	
           return true; //Valore  trovato
        	
        }
		
		
	}


	public String find(int mid) {
		
		String sql = 
				"SELECT id, nome "+
		         "FROM dizionario.parola "+
				"WHERE id=?" ;
		String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root&password=root" ;
        
		String result="";
		try{
             Connection conn = DriverManager.getConnection(jdbcURL) ;
			
			PreparedStatement st = conn.prepareStatement(sql) ;
						
			st.setInt(1, mid);
			ResultSet res = st.executeQuery() ;
			
			if(res.next()) {
				String s= res.getString("nome");
				
				result=s;
			}else {
				result = null;
			}

			conn.close();
			return result ;

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}
	
}
