package it.unipv.sfw.reserve.database.beans;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import it.unipv.sfw.reserve.database.connection.DBConnection;

import it.unipv.sfw.reserve.model.Veicolo;

public class VeicoloDB {
	
	private Connection conn;
	
//QUERY PER OTTENERE I PARAMETRI DELL VEICOLO STRINGA
		 public String OttieniParametroVeicoloString(String par1,String targa) throws SQLException {
		    	
		    	DBConnection d =new DBConnection();
		    	conn=d.connessione(conn);
		    	String sql = "SELECT "+par1+" FROM veicolo  WHERE  targa = ? ";
		    	String ris=null;
		    	
		    	 try (PreparedStatement stmt = conn.prepareStatement(sql)) {
		             stmt.setString(1, targa);

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
//QUERY PER OTTENERE I PARAMETRI DELL VEICOLO FLOAT	
		 public Float OttieniParametroVeicoloFloat(String par1,String targa) throws SQLException {
		    	
		    	DBConnection d =new DBConnection();
		    	conn=d.connessione(conn);
		    	String sql = "SELECT "+par1+" FROM veicolo  WHERE  targa = ? ";
		    	Float ris=null;
		    	
		    	 try (PreparedStatement stmt = conn.prepareStatement(sql)) {
		             stmt.setString(1, targa);

		             ResultSet rs = stmt.executeQuery();
		             if(rs.next()) {
		            	 ris=rs.getFloat(par1);
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
	
	
	
	
	
// query per ottenere le targhe dei veicoli gia prenotati 
	
	public ArrayList <String> OttieniVeicoliPrenotazionie(String data1,String data2) throws ParseException{

    	DBConnection d =new DBConnection();
    	conn=d.connessione(conn);
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	java.util.Date dataUtil1 = dateFormat.parse(data1);
    	java.util.Date dataUtil2 = dateFormat.parse(data2);
		java.sql.Date dataI = new java.sql.Date(dataUtil1.getTime());
		java.sql.Date dataF = new java.sql.Date(dataUtil2.getTime());
    	ArrayList <String> targhe = new ArrayList<String>();
    	

    	String sql = "SELECT prenotazioni.targa\r\n"
    			+ "FROM prenotazioni\r\n"
    			+ "WHERE (? between dataI and dataF \r\n"
    			+ "or ? between dataI and dataF \r\n"
    			+ "or dataI between ? and ? )";
    	
    	
    	 try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    		 
             stmt.setDate(1, dataI);
             stmt.setDate(2, dataF);
             stmt.setDate(3, dataI);
             stmt.setDate(4, dataF);
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 String targa = rs.getString("targa");
                 targhe.add(targa);
               
             }
             rs.close();
 	         stmt.close();
 	         conn.close();
                
           
    	   
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
		return targhe;

	}
	
	public ArrayList <Veicolo> OttieniVeicoli() {
		
		DBConnection d =new DBConnection();
    	conn=d.connessione(conn);
    	ArrayList <Veicolo> veicoli = new ArrayList<Veicolo>();
    	 
    	String sql = "SELECT * \r\n"
    			+ "FROM veicolo \r\n" ;
    	

    	
    	 try (PreparedStatement stmt = conn.prepareStatement(sql)) {

    		
    		 ResultSet rs = stmt.executeQuery();
           while(rs.next()) {
             
             String targa = rs.getString("targa");
             String marca = rs.getString("marca");
             String modello = rs.getString("modello");
             float prezzo = rs.getFloat("prezzo");
             Veicolo v=new Veicolo(targa, marca, modello, prezzo);
             veicoli.add(v);
           }
             stmt.close();
    	     conn.close();
               
    	   
        } catch (SQLException e) {
            e.printStackTrace();
            
        
    }
    	 
		return veicoli;
		
	}
}


