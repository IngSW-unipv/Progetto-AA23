package it.unipv.sfw.reserve.model;

import java.text.ParseException;
import java.util.ArrayList;

import it.unipv.sfw.reserve.database.databasefacade.DatabaseFacade;

public class Veicolo {
	
	private String targa;
	private String marca;
	private String modello;
	private float prezzo;
	
	public Veicolo(String targa, String marca, String modello, float prezzo) {
		this.targa = targa;
		this.marca = marca;
		this.modello = modello;
		this.prezzo = prezzo;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
//METODO PER OTTENERE UN VEICOLO DATA UNA TARGA
	public ArrayList <Veicolo> OttieniVeicoliDaPrenoatre(ArrayList<String> targhe) throws ParseException{
		
		DatabaseFacade facade= new DatabaseFacade ();
		
		ArrayList <Veicolo> veicoli= facade.getVeicoloDB().OttieniVeicoli();
		ArrayList<Veicolo> veicoliPrenotabili = new ArrayList<>();
		  for (Veicolo veicolo : veicoli) {
	            if (!targhe.contains(veicolo.getTarga())) {
	            	veicoliPrenotabili.add(veicolo);
	            }
	        }
		
		
		return veicoliPrenotabili;
		
		
	}

	@Override
	public String toString() {
		return "Veicolo [targa=" + targa + ", marca=" + marca + ", modello=" + modello + ", prezzo=" + prezzo + "]";
	}
	
	
	

}
