package it.unipv.sfw.reserve.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import it.unipv.sfw.reserve.model.*;
import it.unipv.sfw.reserve.view.*;

public class RegistrazioneController {
	
	private RegistrazioneView view;
	private Utente model;
	
	
	public RegistrazioneController(RegistrazioneView view, Utente model) {
		this.view = view;
		this.model = model;
		
		// AGGIUNTA DEI BOTTONI DELLA VIEW	
		this.view.getBtnLogin().addActionListener(new ButtonLogin());
		this.view.getBtnRegistrati().addActionListener(new ButtonRegistrati());
		
	}
	
// GESTIONE BOTTONE LOGIN	
	public class ButtonLogin implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			view.dispose();
			LoginView loginView = new LoginView();
			@SuppressWarnings("unused")
			LoginController controller =new LoginController(loginView, model);
			
			
		}
		
	}

// GESTIONE BOTTONE REGISTRAZIONE	
	public class ButtonRegistrati implements ActionListener {

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			
			// controllo se i campi non sono vuoti
			if(!view.getTextFieldUsername().getText().isEmpty() && !view.getTextFieldNome().getText().isEmpty()
					&& !view.getTextFieldCognome().getText().isEmpty() && !view.getPasswordField().getText().isEmpty()
					&& !view.getTextFieldNumPatente().getText().isEmpty()) {
				
			model.registrazione(view.getTextFieldUsername().getText(), view.getTextFieldNome().getText()
					, view.getTextFieldCognome().getText(), view.getPasswordField().getText()
					, view.getTextFieldNumPatente().getText());
			
			if(model.isLogin()) {
				model.setLogin(false);
				view.dispose();
				RegistrazioneView registrazioneView = new RegistrazioneView();
				registrazioneView.userExist();
				@SuppressWarnings("unused")
				RegistrazioneController controller = new RegistrazioneController(registrazioneView, model);
				
			}else{
			
			view.dispose();
			
			Utente modelUtente = new Utente(null, null, null, null, null, false, null);
			LoginView loginView = new LoginView();
			@SuppressWarnings("unused")
			LoginController controller =new LoginController(loginView, modelUtente);
			}
			
			}else{
				
				view.dispose();
				
				RegistrazioneView registrazioneView = new RegistrazioneView();
				registrazioneView.changeColorError();
				@SuppressWarnings("unused")
				RegistrazioneController controller = new RegistrazioneController(registrazioneView, model);
				
			}
			
		}
		
	}

}
