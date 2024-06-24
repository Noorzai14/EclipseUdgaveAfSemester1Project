import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class OpretData extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t_ordrenummer;
	private JTextField t_bestillingsdato;
	private JTextField t_leveringsdato;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpretData frame = new OpretData();
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
	public OpretData() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowDeactivated(WindowEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				Vector<Vector> tableData = model.getDataVector();
				
				// Gemmer Date når vinduet lukkes ned
				try {
					FileOutputStream file = new FileOutputStream ("File.bin");
					ObjectOutputStream output = new ObjectOutputStream (file);
					
					// Method for serialization of ojbect
					output.writeObject(tableData);
					
					output.close();
					file.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
							
			}
			@Override
			public void windowOpened(WindowEvent e) {
				
				try {
					FileInputStream file = new FileInputStream ("file.bin");
					ObjectInputStream input = new ObjectInputStream (file);
					//Method for deserialization of object
					Vector<Vector> tableData = (Vector<Vector>) input.readObject();
					
					input.close();
					file.close();
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					for (int i = 0; i < tableData.size(); i++) {
						Vector row = tableData.get(i);
						model.addRow(new Object [] {row.get(0), row.get(1), row.get(2)});
					}
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		setTitle("OpretData");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(145, 196, 198));
		panel.setBounds(0, 0, 758, 440);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblOrdrenummer = new JLabel("Ordrenummer:");
		lblOrdrenummer.setBounds(24, 36, 98, 14);
		panel.add(lblOrdrenummer);
		
		JLabel lblBestillingsdato = new JLabel("Bestillingsdato:");
		lblBestillingsdato.setBounds(24, 61, 98, 14);
		panel.add(lblBestillingsdato);
		
		JLabel lblLeveringsdato = new JLabel("Leveringsdato:");
		lblLeveringsdato.setBounds(24, 86, 98, 14);
		panel.add(lblLeveringsdato);
		
		t_ordrenummer = new JTextField();
		t_ordrenummer.setBounds(132, 33, 113, 20);
		panel.add(t_ordrenummer);
		t_ordrenummer.setColumns(10);
		
		t_bestillingsdato = new JTextField();
		t_bestillingsdato.setBounds(132, 58, 113, 20);
		panel.add(t_bestillingsdato);
		t_bestillingsdato.setColumns(10);
		
		t_leveringsdato = new JTextField();
		t_leveringsdato.setBounds(132, 83, 113, 20);
		panel.add(t_leveringsdato);
		t_leveringsdato.setColumns(10);
		
		JScrollPane jTableExport = new JScrollPane();
		jTableExport.setBounds(278, 25, 445, 351);
		panel.add(jTableExport);
		
		table = new JTable();
		model =new DefaultTableModel();
		Object[] column = {"Ordrenummer","Bestillingsdato","Leveringsdato"}; //Angiv navne til kolonnerne
		final Object [] row = new Object[3]; // Antal kolonner
		model.setColumnIdentifiers(column);
		table.setModel(model); // Gør tabellen synlig
		jTableExport.setViewportView(table);
		
		JButton btnTilføj = new JButton("Tilføj");
		btnTilføj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(t_ordrenummer.getText().equals("") || t_bestillingsdato.getText().equals("") || t_leveringsdato.getText().equals("") ) 
				{
					JOptionPane.showMessageDialog(null, "Udfyld venligst alle felterne");
				} 
				else
				{
					row[0] = t_ordrenummer.getText();
					row[1] = t_bestillingsdato.getText();
					row[2] = t_leveringsdato.getText();
					model.addRow(row);
					
					t_ordrenummer.setText(""); //nulstiller felterne igen 
					t_bestillingsdato.setText("");
					t_leveringsdato.setText("");
					JOptionPane.showMessageDialog(null, "Gemt");
				}
				
				
			}
		
			});
			
		btnTilføj.setBounds(85, 162, 89, 46);
		panel.add(btnTilføj);
		
		JButton btnSlet = new JButton("Slet");
		btnSlet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = table.getSelectedRow();
				if(i>=0)
				{
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Slettet");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Vælg venligst en række at slette");
				}
			}
		});
		btnSlet.setBounds(85, 219, 89, 46);
		panel.add(btnSlet);
		
		JButton btnTilbage = new JButton("Tilbage");
		btnTilbage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainMenu info = new MainMenu(); 
				MainMenu.main(null);
				
			}
		});
		btnTilbage.setBounds(10, 406, 89, 23);
		panel.add(btnTilbage);
		
		JButton btnLogud = new JButton("Logud");
		btnLogud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login info = new Login();
				Login.main(null);
				
			}
		});
		btnLogud.setBounds(659, 406, 89, 23);
		panel.add(btnLogud);
	}
}
