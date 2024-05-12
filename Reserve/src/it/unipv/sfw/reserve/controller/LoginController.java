package it.unipv.sfw.reserve.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.reserve.model.*;
import it.unipv.sfw.reserve.view.*;


public class LoginController {
	
	private LoginView view;
	private Utente model;
	
	public LoginController(LoginView view, Utente model) {
		this.view = view;
		this.model = model;
		
		//AGGIUNTA BOTTINI DELLA VIEW
		this.view.getBtnLogin().addActionListener(new ButtonLogin());
		this.view.getBtnRegistrati().addActionListener(new ButtonRegistrati());
		
	}
	
// GESTIONE BOTTONE LOGIN	
	public class ButtonLogin implements ActionListener {

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
			model.login(view.getTextFieldUsername().getText(), view.getPasswordField().getText());
			if(model.isLogin()) {
				view.dispose();
			HomeView homeView = new HomeView();
			@SuppressWarnings("unused")
			
			HomeController controller = new HomeController(homeView, model);
			
			}else {
				view.dispose();
				LoginView loginView = new LoginView();
				loginView.changeColorError();
				@SuppressWarnings("unused")
				LoginController controller = new LoginController(loginView, model);
				
			}
			
			
		}
		
	}

// GESTIONE BOTTONE REGISTRAZIONE 
	public class ButtonRegistrati implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			view.dispose();
			RegistrazioneView registrazioneView= new RegistrazioneView();
			@SuppressWarnings("unused")
			RegistrazioneController controller = new RegistrazioneController(registrazioneView, model);
			
		}
		
	}

}


