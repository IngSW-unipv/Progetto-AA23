package it.unipv.sfw.reserve.view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class AutoView extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	
	private JComboBox<String> comboBox;
	private JButton btnPrenota;
	private JScrollPane scrollPane;
	private JButton btnIndietro ;


	public AutoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Auto disponibili");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(202, 0, 136, 33);
		contentPane.add(lblNewLabel);
		
		comboBox= new JComboBox<String>();
		comboBox.setBounds(301, 228, 98, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Targa del veicolo da prenotare");
		lblNewLabel_1.setBounds(109, 230, 182, 18);
		contentPane.add(lblNewLabel_1);
		
		btnPrenota = new JButton("Prenota");
		btnPrenota.setBounds(409, 228, 89, 23);
		contentPane.add(btnPrenota);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 488, 184);
		contentPane.add(scrollPane);
		
		table = new JTable(tableModel);
		scrollPane.setColumnHeaderView(table);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.setBounds(10, 228, 89, 23);
		contentPane.add(btnIndietro);
		setVisible(true);
	}
	
	public void aggiornaTabella(DefaultTableModel model) {
        table.setModel(model);
    }
	public void aggiornaBox(String stringa) {
		comboBox.addItem(stringa);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTable getTable() {
		return table;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public JButton getBtnPrenota() {
		return btnPrenota;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JButton getBtnIndietro() {
		return btnIndietro;
	}
	
	
}
