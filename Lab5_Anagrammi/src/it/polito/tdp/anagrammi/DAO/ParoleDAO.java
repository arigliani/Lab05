package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


public class ParoleDAO {//`dizionario`.`parola`
	
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
		final	String sql= "SELECT nome " + "FROM dizionario.parola ";
		//boolean result=false;
			
		String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root&password=root" ;
		
		try{
			Connection conn = DriverManager.getConnection(jdbcURL) ;
			
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				String s = res.getString("nome");
				if(s.equals(parola)){
				flag=true;
				return flag;}
				
			
			} 
			
			
			return flag;
			
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			throw new RuntimeException("Errore Db");
		}
		
		
		
		
		
	}
	
	
	
}
