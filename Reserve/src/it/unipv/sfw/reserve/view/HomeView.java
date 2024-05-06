package it.unipv.sfw.reserve.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

public class HomeView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnLePrenotazioni;
	private JButton btnLogout;
	private JButton btnPrenota;
	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	private JDateChooser dateChooserDataI;
	private JDateChooser dateChooserDataF;


	public HomeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 193, 325);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnLePrenotazioni =new JButton("Le tue prenotazioni");
		btnLePrenotazioni.setBounds(0, 111, 193, 41);
		panel.add(btnLePrenotazioni);
		
		btnLogout = new JButton("LogOut");
		btnLogout.setBounds(0, 149, 193, 41);
		panel.add(btnLogout);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 519, 78);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Da");
		lblNewLabel.setBounds(203, 91, 50, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("A");
		lblNewLabel_1.setBounds(363, 91, 19, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Inserisci le date per la tua prenotazione");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(233, 24, 242, 36);
		contentPane.add(lblNewLabel_2);
		
		btnPrenota = new JButton("Prenota");
		btnPrenota.setBounds(203, 171, 89, 23);
		contentPane.add(btnPrenota);
		
		dateChooserDataI = new JDateChooser();
		dateChooserDataI.setBounds(203, 118, 143, 20);
		contentPane.add(dateChooserDataI);
		
		dateChooserDataF = new JDateChooser();
		dateChooserDataF.setBounds(359, 116, 143, 20);
		contentPane.add(dateChooserDataF);
		setVisible(true);
	}
	
	

	public JDateChooser getDateChooserDataI() {
		return dateChooserDataI;
	}

	public JDateChooser getDateChooserDataF() {
		return dateChooserDataF;
	}

	public JButton getBtnPrenota() {
		return btnPrenota;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JButton getBtnLePrenotazioni() {
		return btnLePrenotazioni;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}


	public JPanel getPanel_1() {
		return panel_1;
	}

	public JLabel getLblNewLabel_2() {
		return lblNewLabel_2;
	}
}
