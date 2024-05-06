package it.unipv.sfw.reserve.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class LoginView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textFieldUsername;
	private JButton btnLogin;
	private JButton btnRegistrati;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(212, 0, 222, 261);
		contentPane.add(panel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 154, 192, 20);
		contentPane.add(passwordField);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBackground(Color.WHITE);
		textFieldUsername.setBounds(10, 79, 192, 20);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 54, 106, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 129, 93, 14);
		contentPane.add(lblPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(10, 227, 93, 23);
		contentPane.add(btnLogin);
		
		btnRegistrati = new JButton("Registrati");
		btnRegistrati.setBounds(105, 227, 97, 23);
		contentPane.add(btnRegistrati);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(89, 11, 46, 32);
		contentPane.add(lblNewLabel);
		
		setVisible(true);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	

	public JTextField getTextFieldUsername() {
		return textFieldUsername;
	}

	
	public JButton getBtnLogin() {
		return btnLogin;
	}

	

	public JButton getBtnRegistrati() {
		return btnRegistrati;
	}

	
	
	
}
