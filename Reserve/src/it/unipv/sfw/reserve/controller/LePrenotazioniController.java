package it.unipv.sfw.reserve.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import it.unipv.sfw.reserve.model.Utente;
import it.unipv.sfw.reserve.view.*;


public class LePrenotazioniController {
	
	private LePrenotazioniView view;
	private Utente model;
	
	
	public LePrenotazioniController(LePrenotazioniView view,Utente model) {
		this.view = view;
		this.model = model;
		
		// BOTTONI DELLA VIEW
		this.view.getBtnIndietro().addActionListener(new ButtonIndietro());
		this.view.getBtnElimina().addActionListener(new ButtonElimina());
		
	}
	
// GESTIONE BOTTONE ELIMINAZIONE DELLA PRENOTAZIOND	
	public class ButtonElimina implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			view.dispose();
			String idPrenotazione =(String) view.getComboBox().getSelectedItem();
			System.out.println(idPrenotazione);
			try {
				model.eliminaPrenotazione(idPrenotazione);
			} catch (NoSuchAlgorithmException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			model.login(model.getUsername(), model.getPassword());
			
			HomeView  homeView = new HomeView();
			@SuppressWarnings("unused")
			HomeController controller =new HomeController(homeView, model);
			
			
		}
		
	}

// GESTIONE BOTTONE TORNA INDIETRO NELLA HOME	
	public class ButtonIndietro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			view.dispose();
			HomeView  homeView = new HomeView();
			@SuppressWarnings("unused")
			HomeController controller =new HomeController(homeView, model);
			
			
		}
		
	}
	

}

	