package it.unipv.sfw.reserve.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import it.unipv.sfw.reserve.model.Utente;
import it.unipv.sfw.reserve.view.HomeView;
import it.unipv.sfw.reserve.view.LoginView;
import it.unipv.sfw.reserve.view.LogoutView;

public class LogoutController {

	private Utente model;
	private LogoutView view;
	private HomeView homeView;
	
	
	public LogoutController(LogoutView view,HomeView homeView,Utente model) {
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
	

		
	
		
		
	

