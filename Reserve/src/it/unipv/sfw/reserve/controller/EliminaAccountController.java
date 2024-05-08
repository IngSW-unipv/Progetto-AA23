package it.unipv.sfw.reserve.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import it.unipv.sfw.reserve.model.*;
import it.unipv.sfw.reserve.view.*;

public class EliminaAccountController {
	
	private Utente model;
	private ConfermaView view;
	private HomeView homeView;
	
	public EliminaAccountController(Utente model, ConfermaView view, HomeView homeView) {
		this.model = model;
		this.view = view;
		this.homeView = homeView;
		
		//AGGIUNTA DEI BOTTONI
		this.view.getBtnNo().addActionListener(new ButtonNo());
		this.view.getBtnSi().addActionListener(new ButtonSi());
		
	}
	
	// GESTIONE BOTTONE SI	
	class ButtonSi implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				model.eliminaAccount();
			} catch (NoSuchAlgorithmException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			model.logout(model.isLogin());
			Utente modelUtente =new Utente(null, null, null, null, null, false, null);
			view.dispose();
			homeView.dispose();
			LoginView loginView = new LoginView();
			@SuppressWarnings("unused")
			LoginController controller = new LoginController(loginView, modelUtente);
			
		}
		
	}
	
// GESTIONE BOTTONE NO	
	class ButtonNo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.dispose();
			
		}
	
		
	}
	
	

}
