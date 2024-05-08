package it.unipv.sfw.reserve.test;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import it.unipv.sfw.reserve.controller.*;
import it.unipv.sfw.reserve.model.*;
import it.unipv.sfw.reserve.view.*;

public class Test {

	public static void main(String[] args) throws SQLException, NoSuchAlgorithmException, ParseException {
		
		// AVVIO DEL PROGRAMMA
		Utente model= new Utente(null, null, null, null, null, false, null);
		LoginView view= new LoginView();
		@SuppressWarnings("unused")
		LoginController controller = new LoginController(view, model);
		
		
	}

}
