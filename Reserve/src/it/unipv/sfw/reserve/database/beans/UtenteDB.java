package it.unipv.sfw.reserve.database.beans;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import it.unipv.sfw.reserve.database.connection.DBConnection;

public class UtenteDB {
	
	private Connection conn;
	
//QUERY PER OTTENERE I PARAMETRI DELL UTENTE
	 public String OttieniParametroUtenteString(String par1,String username,String password ) throws SQLException {
	    	
	    	DBConnection d =new DBConnection();
	    	conn=d.connessione(conn);
	    	String sql = "SELECT "+par1+" FROM utente WHERE  username = ? and password = ? ";
	    	String ris=null;
	    	
	    	 try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	             stmt.setString(1, username);
	             stmt.setString(2, password);
	             ResultSet rs = stmt.executeQuery();
	             if(rs.next()) {
	            	 ris=rs.getString(par1);
	            	 rs.close();
	            	 stmt.close();
	            	 
	            	 return ris;
	             }else {
	            	 rs.close();
	            	 stmt.close();
	            	 return ris;
	             }
	           
	         }

	 }
//query per verificare l'esistenza del utente 
	 
	    public boolean login(String username, String password) throws SQLException {
	        Connection conn = null;
	        DBConnection d =new DBConnection();
	       	conn=d.connessione(conn);        
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        boolean loggedIn = false;
	    
	        try {
	            
	            String sql = "SELECT * FROM utente WHERE username = ? AND password = ?";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, username);
	            stmt.setString(2, password);
	            
	            
	            rs = stmt.executeQuery();

	            if (rs.next()) {
	            
	                loggedIn = true;
	            }
	        } finally {
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        }
	        if(loggedIn) {
	        	System.out.println("Login effettuato con successo");
	        } else {
	        	System.out.println("username o password sbagliati");
	        }
	        return loggedIn;
	        
	        
	       
	    }
	    
//QUERY PER LA REGISTRAZIONE
	    
	    public void user_Register(String username, String nome, String cognome, String password,String numPatente) throws SQLException, NoSuchAlgorithmException {
	    	
	    	
	    	 // Connessione al database
	    	DBConnection d =new DBConnection();
	       	Connection con=null;
	       	con=d.connessione(con);
	        PreparedStatement stmt = null;
	        
	        


	        try {
	            // Inserimento dei dati nella tabella user
	            String sql = "INSERT INTO utente (username, nome, cognome, password, numPatente) VALUES (?, ?, ?, ?, ?)";
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, username);
	            stmt.setString(2, nome);
	            stmt.setString(3, cognome);
	            stmt.setString(4, password);
	            stmt.setString(5, numPatente);
	            
	            
	            stmt.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Registrazione completata con successo");        
	        } catch (SQLException e) {
	        	
	        } 
	        stmt.close();
	    }
	    
	    public void eliminaAccount(String username) throws SQLException, NoSuchAlgorithmException {

	    	 // Connessione al database
	    	DBConnection d =new DBConnection();
	       	Connection con=null;
	       	con=d.connessione(con);
	        PreparedStatement stmt = null;

	        try {
	            // Inserimento dei dati nella tabella user
	            String sql = "DELETE FROM utente WHERE username = ?";
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, username);
	           
	            
	            
	            stmt.executeUpdate();  
	            
	        } catch (SQLException e) {
	        	
	        } 
	        stmt.close();
	    }
	    
}
