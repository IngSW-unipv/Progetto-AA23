package it.unipv.sfw.reserve.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class LogoutView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNo;
	private JButton btnSi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogoutView frame = new LogoutView();
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
	public LogoutView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 284, 168);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sei sicuro ?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(101, 11, 91, 14);
		contentPane.add(lblNewLabel);
		
		btnSi = new JButton("si");
		btnSi.setBounds(10, 95, 89, 23);
		contentPane.add(btnSi);
		
		btnNo = new JButton("no");
		btnNo.setBounds(169, 95, 89, 23);
		contentPane.add(btnNo);
		setVisible(true);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JButton getBtnNo() {
		return btnNo;
	}

	public JButton getBtnSi() {
		return btnSi;
	}
	
	
}
