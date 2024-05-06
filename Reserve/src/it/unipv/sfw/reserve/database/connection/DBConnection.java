package it.unipv.sfw.reserve.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnection {
	
	    private String url = "jdbc:mysql://localhost:3306/Db";
	    private String user = "root";
	    private String password = "Biuss90!";
	    private String driver = "com.mysql.cj.jdbc.Driver";

	    public Connection connessione(Connection con) {
	        try {
	            Class.forName(driver);
	            con = DriverManager.getConnection(url, user, password);
	        } catch (ClassNotFoundException e) {
	            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
	        } catch (SQLException e) {
	            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
	        }
	        return con;
	    }

	    public boolean verificaConnessione() {
	        Connection con = null;
	        con = connessione(con);

	        try { 
	        	System.out.println("on");
	            return con.isValid(5);
	           
	        } catch (SQLException e) {
	            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
	            System.out.println("off");
	            return false;
	        }
	    }
	
	}

