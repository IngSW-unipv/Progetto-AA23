package it.unipv.sfw.reserve.model;



import java.text.ParseException;
import java.util.ArrayList;


import it.unipv.sfw.reserve.database.databasefacade.DatabaseFacade;

public class Prenotazioni {
	
	private String idPrenotazioni;
	private java.sql.Date dataI;
	private java.sql.Date dataF;
	private String targa;
	private float prezzo;
	
	public Prenotazioni(String idPrenotazioni,java.sql.Date dataI, java.sql.Date dataF, String targa, float prezzo) {
		this.idPrenotazioni = idPrenotazioni;
		this.dataI = dataI;
		this.dataF = dataF;
		this.targa = targa;
		this.prezzo = prezzo;
	}
//METODO PER OTTENERE LA TARGA DELLA PRENOTAZIONE
	public ArrayList<String> daiTargaPrenotata(String dataI,String dataF) throws ParseException{
		
		DatabaseFacade facade = new DatabaseFacade();
		ArrayList <String> targhe =facade.getVeicoloDB().OttieniVeicoliPrenotazionie(dataI, dataF);
		
		return targhe;
		
	}
	


	public java.sql.Date getDataI() {
		return dataI;
	}

	public void setDataI(java.sql.Date dataI) {
		this.dataI = dataI;
	}

	public java.sql.Date getDataF() {
		return dataF;
	}

	public void setDataF(java.sql.Date dataF) {
		this.dataF = dataF;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	

	public String getIdPrenotazioni() {
		return idPrenotazioni;
	}

	public void setIdPrenotazioni(String idPrenotazioni) {
		this.idPrenotazioni = idPrenotazioni;
	}

	@Override
	public String toString() {
		return "Prenotazioni [idPrenotazioni=" + idPrenotazioni + ", dataI=" + dataI + ", dataF=" + dataF + ", targa="
				+ targa + ", prezzo=" + prezzo + "]";
	}

	
	

}
