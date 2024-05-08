package it.unipv.sfw.reserve.database.beans;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import it.unipv.sfw.reserve.database.connection.DBConnection;
import it.unipv.sfw.reserve.model.Prenotazioni;


public class PrenotazioniDB {
	
		private Connection conn;
	
//QUARY PER OTTENERE LE PRENOTAZIONI
	 public ArrayList<Prenotazioni> OttieniPrenotazioni(String username) throws SQLException {
	    	
	    	DBConnection d =new DBConnection();
	    	conn=d.connessione(conn);
	    	String sql = "SELECT idprenotazioni,dataI, dataF, targa, prezzoTot FROM prenotazioni WHERE  username = ? ";
	    	ArrayList <Prenotazioni> prenotazioni= new ArrayList<Prenotazioni>();
	    	
	    	 try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	    		 
	             stmt.setString(1, username);
	             ResultSet rs = stmt.executeQuery();
	             while (rs.next()) {
	            	 String idPrenotazioni= rs.getString("idprenotazioni");
	                 java.sql.Date dataI = rs.getDate("dataI");
	                 java.sql.Date dataF = rs.getDate("dataF");
	                 String targa= rs.getString("targa");
	                 float prezzo = rs.getFloat("prezzoTot");
	                 Prenotazioni prenotazione = new Prenotazioni(idPrenotazioni,dataI, dataF, targa, prezzo);
	                 prenotazioni.add(prenotazione);
	               
	             }
	             rs.close();
	 	         stmt.close();
	 	         conn.close();
	                
	           
	    	   
	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	        }
			return prenotazioni;

	 }
	 


//QUERY PER LA PRENOTAZIONIE
	    
	    public void prenotazione(String idPrenotazioni,java.sql.Date dataI, java.sql.Date dataF, String username, String targa,float prezzoTot) throws SQLException, NoSuchAlgorithmException {

	    	 // Connessione al database
	    	DBConnection d =new DBConnection();
	       	Connection con=null;
	       	con=d.connessione(con);
	        PreparedStatement stmt = null;

	        try {
	            // Inserimento dei dati nella tabella user
	            String sql = "INSERT INTO prenotazioni (idPrenotazioni,dataI, dataF, username, targa, prezzoTot) VALUES (? ,?, ?, ?, ?, ?)";
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, idPrenotazioni);
	            stmt.setDate(2, dataI);
	            stmt.setDate(3, dataF);
	            stmt.setString(4, username);
	            stmt.setString(5, targa);
	            stmt.setFloat(6, prezzoTot);
	            
	            
	            stmt.executeUpdate();  
	            
	        } catch (SQLException e) {
	        	
	        } 
	        stmt.close();
	    }
	    
	    
//QUERY ELIMINAZIONE DI UN PRENOTAZIONE DATA ID
	    
	    public void eliminaPrenotazione(String idPrenotazione) throws SQLException, NoSuchAlgorithmException {

	    	 // Connessione al database
	    	DBConnection d =new DBConnection();
	       	Connection con=null;
	       	con=d.connessione(con);
	        PreparedStatement stmt = null;

	        try {
	            // Inserimento dei dati nella tabella user
	            String sql = "DELETE FROM prenotazioni WHERE idPrenotazioni = ?";
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, idPrenotazione);
	           
	            
	            
	            stmt.executeUpdate();  
	            
	        } catch (SQLException e) {
	        	
	        } 
	        stmt.close();
	    }
	    
//QUERY ELIMINAZIONE DI UN PRENOTAZIONE DATO L'USERNAME
	    
	    public void eliminaPrenotazioneAccount(String username) throws SQLException, NoSuchAlgorithmException {

	    	 // Connessione al database
	    	DBConnection d =new DBConnection();
	       	Connection con=null;
	       	con=d.connessione(con);
	        PreparedStatement stmt = null;

	        try {
	            // Inserimento dei dati nella tabella user
	            String sql = "DELETE FROM prenotazioni WHERE username = ?";
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, username);
	            
	            stmt.executeUpdate();  
	            
	        } catch (SQLException e) {
	        	
	        } 
	        stmt.close();
	    }
	    


}
