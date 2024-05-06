package it.unipv.sfw.reserve.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.table.DefaultTableModel;

import it.unipv.sfw.reserve.database.databasefacade.DatabaseFacade;
import it.unipv.sfw.reserve.model.Prenotazioni;
import it.unipv.sfw.reserve.model.Utente;
import it.unipv.sfw.reserve.model.Veicolo;
import it.unipv.sfw.reserve.view.AutoView;
import it.unipv.sfw.reserve.view.HomeView;
import it.unipv.sfw.reserve.view.PrenotazioneRiepilogoView;

public class PrenotaController {
	
	private AutoView autoView;
	private HomeView homeView;
	private Utente modelUtente;
	
	public PrenotaController(AutoView autoView,HomeView homeView, Utente modelUtente) {
		
		this.autoView = autoView;
		this.homeView = homeView;
		this.modelUtente = modelUtente;
		
		//AGGIUNTA DEI BOTTONI DELLA VIEW
		this.autoView.getBtnPrenota().addActionListener(new ButtonPrenota());
		this.autoView.getBtnIndietro().addActionListener(new ButtonIndietro());
		
	}
	
// GESTIONE BOTTONE PRENOTAZIONE	
	public class ButtonPrenota implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			autoView.dispose();
			
			 DefaultTableModel tableModel = new DefaultTableModel();
			 DatabaseFacade databaseFacade= new DatabaseFacade();
			 java.sql.Date dataI = null;
			 java.sql.Date dataF = null;
			 Veicolo veicolo = new Veicolo(null, null, null, 0);
			 String targa;
			 int giorni = 0;
			 
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 String dateInizio= dateFormat.format(homeView.getDateChooserDataI().getDate());
			 String dataFine = dateFormat.format(homeView.getDateChooserDataF().getDate());
			try {
				java.util.Date dataUtil1 = dateFormat.parse(dateInizio);
		    	java.util.Date dataUtil2 = dateFormat.parse(dataFine);
				dataI = new java.sql.Date(dataUtil1.getTime());
				dataF = new java.sql.Date(dataUtil2.getTime());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			long diffMilli=Math.abs(dataF.getTime()-dataI.getTime());
			
			giorni=(int) (diffMilli/(1000 * 60 * 60 * 24));
			targa=(String) autoView.getComboBox().getSelectedItem();
			
			
			try {
				veicolo = new Veicolo(targa, databaseFacade.getVeicoloDB().OttieniParametroVeicoloString("marca", targa),
						databaseFacade.getVeicoloDB().OttieniParametroVeicoloString("modello",targa), 
						databaseFacade.getVeicoloDB().OttieniParametroVeicoloFloat("prezzo",targa));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			Prenotazioni prenotazione =new Prenotazioni("",dataI, dataF, targa, veicolo.getPrezzo()*giorni);
			
			 tableModel.addColumn("Data Inizio");
			 tableModel.addColumn("Data Fine");
			 tableModel.addColumn("Targa");
			 tableModel.addColumn("Prezzo Totale");
			 String[] nomiColonne = {"Data Inizio", "Data Fine", "Targa","Prezzo Totale"};
			 tableModel.addRow(nomiColonne);
			 Object[] row = {prenotazione.getDataI(),prenotazione.getDataF(),prenotazione.getTarga(),
					 prenotazione.getPrezzo()+" €"};
			 tableModel.addRow(row);
			 
			//aggiornamento della tabella
			PrenotazioneRiepilogoView prenRiepView = new PrenotazioneRiepilogoView();
	    	prenRiepView.aggiornaTabella(tableModel);
			@SuppressWarnings("unused")
			PrenotazioneRiepilogoController controller = new PrenotazioneRiepilogoController(prenRiepView, modelUtente, prenotazione);
			
			
		}
	
		
	}
	
	// GESTIONE BOTTONE INDEITRO 	
	public class ButtonIndietro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			autoView.dispose();
			HomeView homeView =new HomeView();
			@SuppressWarnings("unused")
			HomeController controller = new HomeController(homeView, modelUtente);
			
			
		}
		
	}
	
	

}
