package it.unipv.sfw.reserve.database.databasefacade;

import it.unipv.sfw.reserve.database.beans.*;

public class DatabaseFacade {
	
	private PrenotazioniDB prenotazioniDB;
	private UtenteDB utenteDB;
	private VeicoloDB veicoloDB;
	
	public DatabaseFacade() {
		prenotazioniDB= new PrenotazioniDB();
		utenteDB = new UtenteDB();
		veicoloDB = new VeicoloDB();
	}

	public PrenotazioniDB getPrenotazioniDB() {
		return prenotazioniDB;
	}

	public UtenteDB getUtenteDB() {
		return utenteDB;
	}

	public VeicoloDB getVeicoloDB() {
		return veicoloDB;
	}
	
	

}
