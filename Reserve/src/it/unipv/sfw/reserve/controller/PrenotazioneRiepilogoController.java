package it.unipv.sfw.reserve.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.Random;
import it.unipv.sfw.reserve.model.Prenotazioni;
import it.unipv.sfw.reserve.controller.LePrenotazioniController.ChiudiReserve;
import it.unipv.sfw.reserve.model.*;
import it.unipv.sfw.reserve.view.*;


public class PrenotazioneRiepilogoController {
	
	private PrenotazioneRiepilogoView prenotazionieView;
	private Utente modelUtente;
	private Prenotazioni modelPrenotazioni;
	
	
	public PrenotazioneRiepilogoController(PrenotazioneRiepilogoView prenotazionieView,Utente modelUtente,Prenotazioni modelPrenotazioni) {
		this.prenotazionieView=prenotazionieView;
		this.modelUtente=modelUtente;
		this.modelPrenotazioni=modelPrenotazioni;
		
		// AGGIUNTA DEI BOTTONI DELLA VIEW	
		this.prenotazionieView.getBtnPrenota().addActionListener(new ButtonPrenota());
		this.prenotazionieView.getBtnIndierto().addActionListener(new ButtonIndietro());
		this.prenotazionieView.addWindowListener(new ChiudiReserve());
		
	}
	
// GESTIONE BOTTONE PRENOTAZIONE	
	public class ButtonPrenota implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			// generazione della ciave primaria idprenotazione
			 StringBuilder sb = new StringBuilder();
		        Random random = new Random();
		        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		        for (int i = 0; i < 20; i++) {
		            int randomIndex = random.nextInt(characters.length());
		            char randomChar = characters.charAt(randomIndex);
		            sb.append(randomChar);
		        }

		        modelPrenotazioni.setIdPrenotazioni(sb.toString());
		
			prenotazionieView.dispose();
			
			try {
				modelUtente.prenota(modelPrenotazioni, modelUtente.getUsername());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//aggiornamento delle prenotazioni tramite il metodologin
			modelUtente.login(modelUtente.getUsername(), modelUtente.getPassword());
			
			//ritorno alla home
			HomeView homeView =new HomeView();
			@SuppressWarnings("unused")
			HomeController controller = new HomeController(homeView, modelUtente);
			
		
			
			
		}
	
		
	}

// GESTIONE BOTTONE INDEITRO	
	public class ButtonIndietro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			prenotazionieView.dispose();
			HomeView homeView = new HomeView();
			@SuppressWarnings("unused")
			HomeController controller = new HomeController(homeView, modelUtente);

			
			
		}
		
	}
	
	public class ChiudiReserve implements WindowListener {


		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			
			modelUtente.logout(true);
			prenotazionieView.dispose();
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	

}
