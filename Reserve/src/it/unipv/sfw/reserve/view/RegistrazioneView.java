package it.unipv.sfw.reserve.view;

import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;

public class RegistrazioneView extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
	private JTextField textFieldNumPatente;
	private JButton btnLogin;
	private JButton btnRegistrati;
	private final JPasswordField passwordField = new JPasswordField();
	private JLabel lblNewLabel;
	

	public RegistrazioneView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 166, 281);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("utente esistente");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 256, 127, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(176, 23, 248, 20);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(176, 73, 248, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCognome = new JTextField();
		textFieldCognome.setBounds(176, 123, 248, 20);
		contentPane.add(textFieldCognome);
		textFieldCognome.setColumns(10);
		
		textFieldNumPatente = new JTextField();
		textFieldNumPatente.setBounds(176, 173, 248, 20);
		contentPane.add(textFieldNumPatente);
		textFieldNumPatente.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(176, 0, 78, 25);
		contentPane.add(lblUsername);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(176, 54, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(176, 104, 208, 14);
		contentPane.add(lblCognome);
		
		JLabel lblNumPatente = new JLabel("Numero Patente");
		lblNumPatente.setBounds(176, 158, 129, 14);
		contentPane.add(lblNumPatente);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(176, 204, 78, 14);
		contentPane.add(lblPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(176, 254, 129, 23);
		contentPane.add(btnLogin);
		
		btnRegistrati = new JButton("Registrati");
		btnRegistrati.setBounds(302, 254, 122, 23);
		contentPane.add(btnRegistrati);
		passwordField.setBounds(176, 223, 248, 20);
		contentPane.add(passwordField);
		
		setVisible(true);
	}
	
	public void changeColorError() {
		textFieldUsername.setBackground(new Color(240, 115, 119));
		textFieldNome.setBackground(new Color(240, 115, 119));
		textFieldCognome.setBackground(new Color(240, 115, 119));
		textFieldNumPatente.setBackground(new Color(240, 115, 119));
		passwordField.setBackground(new Color(240, 115, 119));
	}
	
	public void userExist() {
		lblNewLabel.setVisible(true);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextFieldUsername() {
		return textFieldUsername;
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public JTextField getTextFieldCognome() {
		return textFieldCognome;
	}

	public JTextField getTextFieldNumPatente() {
		return textFieldNumPatente;
	}


	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public JButton getBtnRegistrati() {
		return btnRegistrati;
	}
}
