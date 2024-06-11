package it.unipv.sfw.reserve.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class PrenotazioneRiepilogoView extends JFrame {

	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private DefaultTableModel tableModel;
	private JButton btnPrenota;
	private JButton btnIndierto;
	private JTable table;


	public PrenotazioneRiepilogoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRiepilogo = new JLabel("Riepilogo");
		lblRiepilogo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRiepilogo.setBounds(179, 0, 75, 31);
		contentPane.add(lblRiepilogo);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		scrollPane.setBounds(10, 33, 414, 154);
		
		table = new JTable();
		scrollPane.setRowHeaderView(table);
		
		btnIndierto = new JButton("Indietro");
		btnIndierto.setBounds(10, 198, 89, 23);
		contentPane.add(btnIndierto);
		
		btnPrenota = new JButton("Prenota");
		btnPrenota.setBounds(335, 198, 89, 23);
		contentPane.add(btnPrenota);
		setVisible(true);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}


	public JTable getTable() {
		return table;
	}

	public JButton getBtnPrenota() {
		return btnPrenota;
	}

	public JButton getBtnIndierto() {
		return btnIndierto;
	}
	
	public void aggiornaTabella(DefaultTableModel model) {
        table.setModel(model);
    }
	
	
}
