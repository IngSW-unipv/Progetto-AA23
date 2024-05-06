package it.unipv.sfw.reserve.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class LePrenotazioniView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton btnIndietro;
	private JComboBox<String> comboBox;
	private JButton btnElimina;

	public LePrenotazioniView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Le tue prenotazioni");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(215, 0, 131, 29);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 530, 217);
		contentPane.add(scrollPane);
	
		
	    table = new JTable(tableModel);
		scrollPane.setColumnHeaderView(table);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.setBounds(10, 261, 89, 23);
		contentPane.add(btnIndietro);
		
		JLabel lblNewLabel_1 = new JLabel("id della prenotazione da eliminare");
		lblNewLabel_1.setBounds(109, 265, 208, 14);
		contentPane.add(lblNewLabel_1);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(329, 261, 112, 22);
		contentPane.add(comboBox);
		
		btnElimina = new JButton("Elimina");
		btnElimina.setBounds(451, 261, 89, 23);
		contentPane.add(btnElimina);
		setVisible(true);
		
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnIndietro() {
		return btnIndietro;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	 public JComboBox<String> getComboBox() {
		return comboBox;
	}
	 
	 public JButton getBtnElimina() {
		return btnElimina;
	}

	public void aggiornaBox(String stringa) {
			comboBox.addItem(stringa);
		}

	public void aggiornaTabella(DefaultTableModel model) {
	        table.setModel(model);
	    }
	 
	 
}
