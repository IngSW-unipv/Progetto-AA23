package it.unipv.sfw.reserve.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import it.unipv.sfw.reserve.model.*;
import it.unipv.sfw.reserve.view.*;


public class HomeController {
	
	private HomeView view;
	private Utente model;
	
	
	public HomeController(HomeView view, Utente model) {
		this.view = view;
		this.model = model;
		
		//AGGIUNTA BOTTONI VIEW
		this.view.getBtnLogout().addActionListener(new ButtonLogout());
		this.view.getBtnLePrenotazioni().addActionListener(new ButtonLePrenotazioni());
		this.view.getBtnPrenota().addActionListener(new ButtonPrenota());
		this.view.getBtnEliminaAccount().addActionListener(new ButtoneEliminaAccount());
		
	}
	
// GESTIONE BOTTONE LOGOUT
	public class ButtonLogout implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ConfermaView confermaView = new ConfermaView();
			@SuppressWarnings("unused")
			LogoutController controller= new LogoutController(confermaView,view,model);
			
			
		}
		
	}
	
// GESTIONE BOTTONE ELIMINA ACCOUNT
		public class ButtoneEliminaAccount implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ConfermaView confermaView = new ConfermaView();
		EliminaAccountController controller = new EliminaAccountController(model, confermaView, view);
		
	}

		
			
		}
// GESTIONE BOTTONE VISULAZZA LE PRENOTAZIONI
	public class ButtonLePrenotazioni implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			view.dispose();
			DefaultTableModel tableModel = new DefaultTableModel();
			tableModel.addColumn("id");
			tableModel.addColumn("Data Inizio");
		    tableModel.addColumn("Data Fine");
		    tableModel.addColumn("Targa");
		    tableModel.addColumn("Prezzo Totale");
		    String[] nomiColonne = {"id","Data Inizio", "Data Fine", "Targa","Prezzo Totale"};
		    tableModel.addRow(nomiColonne);
		    
		    for(Prenotazioni prenotazioni :model.getPrenotazione()) {
		    	 Object[] row = { prenotazioni.getIdPrenotazioni(),prenotazioni.getDataI(),prenotazioni.getDataF(),prenotazioni.getTarga(),
		    			 prenotazioni.getPrezzo()+" €"};
		    	 tableModel.addRow(row);
		    	
		    }
		    
		    LePrenotazioniView prenotazioniView =new LePrenotazioniView();
		    
			for(Prenotazioni prenotazioni :model.getPrenotazione()) {
		    	 
				prenotazioniView.aggiornaBox(prenotazioni.getIdPrenotazioni());
		    	 
		    }
			
			
		    prenotazioniView.aggiornaTabella(tableModel);
		    @SuppressWarnings("unused")
			LePrenotazioniController controller= new LePrenotazioniController(prenotazioniView, model);
			
			
		}
	
		
	}
	
	// GESTIONE BOTTONE PRENOTAZIONE	
	public class ButtonPrenota implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.dispose();
			
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 String dateInizio= dateFormat.format(view.getDateChooserDataI().getDate());
			 String dataFine = dateFormat.format(view.getDateChooserDataF().getDate());
			 DefaultTableModel tableModel = new DefaultTableModel();
			 tableModel.addColumn("Targa");
			 tableModel.addColumn("Marca");
			 tableModel.addColumn("Modello");
			 tableModel.addColumn("Prezzo al giorno");
			 String[] nomiColonne = {"Targa", "Marca", "Modello","Prezzo al giorno"};
			 tableModel.addRow(nomiColonne);
			 
			 Veicolo veicolo = new Veicolo(null, null, null, 0);
			 Prenotazioni prenotazione = new Prenotazioni(null,null, null, null, 0);
			 ArrayList<String> targhePrenotate;
			 ArrayList<Veicolo> auto =new ArrayList<Veicolo>();
			 ArrayList <String> targheDaPrenotare = new ArrayList<String>();
			 AutoView autoView =new AutoView();
			
			 
				try {
					targhePrenotate = prenotazione.daiTargaPrenotata(dateInizio, dataFine);
					auto =veicolo.OttieniVeicoliDaPrenoatre(targhePrenotate);
					
					for(Veicolo automobili :auto) {
						
				    	 Object[] row = {automobili.getTarga(),automobili.getMarca(),automobili.getModello(),
				    			 automobili.getPrezzo()+" €"};
				    	 tableModel.addRow(row);	 	
				    }
					
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				for(Veicolo automobili :auto) {
					
				targheDaPrenotare.add(automobili.getTarga());	
				autoView.aggiornaBox(automobili.getTarga());
			    }
				autoView.aggiornaTabella(tableModel);
				@SuppressWarnings("unused")
				PrenotaController controller = new PrenotaController(autoView, view, model);
				
			
		}
		
	}
	
	

}
