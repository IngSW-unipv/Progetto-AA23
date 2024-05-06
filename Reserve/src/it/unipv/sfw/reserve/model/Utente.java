package it.unipv.sfw.reserve.model;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unipv.sfw.reserve.database.databasefacade.DatabaseFacade;

public class Utente {
	
	private String username;
	private String nome;
	private String cognome;
	private String password;
	private String numPatente;
	private boolean login;
	private ArrayList <Prenotazioni> prenotazione;
	
	public Utente(String username, String nome, String cognome, String password, String numPatente,
			boolean login, ArrayList<Prenotazioni> prenotazione) {
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.numPatente = numPatente;
		this.login = login;
		this.prenotazione = prenotazione;
	}
	
	public void registrazione(String username, String nome, String cognome, String password, String numPatente) {
		
		DatabaseFacade dbFacade = new DatabaseFacade();
		try {
			dbFacade.getUtenteDB().user_Register(username, nome, cognome, password, numPatente);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//METODO PER ILLOGIN E IL SETTAGGIO DEI ATTRIBUTI
	public boolean login(String user, String pass) {
		
		DatabaseFacade facadeDB = new DatabaseFacade();
		
		try {
			
			login=facadeDB.getUtenteDB().login(user, pass);
			prenotazione=facadeDB.getPrenotazioniDB().OttieniPrenotazioni(user);
			username=facadeDB.getUtenteDB().OttieniParametroUtenteString("username", user, pass);
			nome=facadeDB.getUtenteDB().OttieniParametroUtenteString("nome", user, pass);
			cognome=facadeDB.getUtenteDB().OttieniParametroUtenteString("cognome", user, pass);
			password=facadeDB.getUtenteDB().OttieniParametroUtenteString("password", user, pass);
			numPatente=facadeDB.getUtenteDB().OttieniParametroUtenteString("numPatente", user, pass);
			 System.out.println(toString());
			
			
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}
		
		
		
		return login;
	}
//METODO LOGOUT
	public boolean logout(boolean login) {
		
		if(login==true) {
			
			login=false;
			username=null;
			nome=null;
			cognome=null;
			password=null;
			numPatente=null;
			prenotazione=null;
			
		}
		System.out.println("Logout effettuato");
		System.out.println(toString());
		
		return login;
		
	}

//METODO PER LA PRENOTAZIONE DEL VEICOLO
	public void prenota(Prenotazioni prenotazione,String username) throws SQLException{
		

        // richiamo query per l'inserimento nel db
		DatabaseFacade facade = new DatabaseFacade();
		try {
			facade.getPrenotazioniDB().prenotazione(prenotazione.getIdPrenotazioni(), 
					prenotazione.getDataI(), prenotazione.getDataF(), username, prenotazione.getTarga(), prenotazione.getPrezzo());
		} catch (NoSuchAlgorithmException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

// METODO DELLA ELIMINAZIONE DI UNA PRENOTAZIONE
	public void eliminaPrenotazione(String idPrenotazione) throws NoSuchAlgorithmException, SQLException {
		
		DatabaseFacade facadeDB = new DatabaseFacade();
		facadeDB.getPrenotazioniDB().eliminaPrenotazione(idPrenotazione);
		
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumPatente() {
		return numPatente;
	}

	public void setNumPatente(String numPatente) {
		this.numPatente = numPatente;
	}

	public ArrayList<Prenotazioni> getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(ArrayList<Prenotazioni> prenotazione) {
		this.prenotazione = prenotazione;
	}
	

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Utente [username=" + username + ", nome=" + nome + ", cognome=" + cognome + ", password=" + password
				+ ", numPatente=" + numPatente + ", prenotazione=" + prenotazione + "]";
	}
	
	
	
	
	

}


