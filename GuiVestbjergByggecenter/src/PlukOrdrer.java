import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class PlukOrdrer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable jTableImport;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlukOrdrer frame = new PlukOrdrer();
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
	public PlukOrdrer() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowDeactivated(WindowEvent e) {
				DefaultTableModel modelImport = (DefaultTableModel) jTableImport.getModel();
				Vector<Vector> tableData = modelImport.getDataVector();
				
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
					
					DefaultTableModel modelImport = (DefaultTableModel) jTableImport.getModel();
					for (int i = 0; i < tableData.size(); i++) {
						Vector row = tableData.get(i);
						modelImport.addRow(new Object [] {row.get(0), row.get(1), row.get(2)});
					}
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		
		
		setTitle("PlukOrdrer");
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
		
		JButton btnNewButton = new JButton("Søg");
		btnNewButton.setBounds(113, 159, 89, 49);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(283, 22, 433, 359);
		panel.add(scrollPane);
		
		jTableImport = new JTable();
		jTableImport.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ordrenummer", "Bestillingsdato", "Leveringsdato"
			}
		));
		scrollPane.setViewportView(jTableImport);
		
		JButton Pluk = new JButton("Pluk");
		Pluk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TableModel modelImport = jTableImport.getModel();
				int index[] = jTableImport.getSelectedRows();
				
				Object[] row = new Object[3];
				
				Plukliste_1 pl = new Plukliste_1 ();
				DefaultTableModel modelpl = (DefaultTableModel) pl.jTableImport.getModel();
				
				for(int i = 0; i< index.length; i++) {
					row[0] = modelImport.getValueAt(index [1], 0);
					
					modelpl.addRow(row);
				
					Plukliste_1 info = new Plukliste_1();
					Plukliste_1.main(null);	
					
				}
				
				pl.setVisible(true);
				
				
				}
			
		});
		Pluk.setBounds(113, 230, 89, 49);
		panel.add(Pluk);
		
		JLabel lblNewLabel = new JLabel("Ordrenumer:");
		lblNewLabel.setBounds(29, 80, 88, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(130, 77, 119, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Tilbage");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OpretData info = new OpretData();
				OpretData.main(null);
				
			}
		});
		btnNewButton_2.setBounds(10, 406, 89, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Logud");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login info = new Login();
				Login.main(null);
				
			}
		});
		btnNewButton_3.setBounds(659, 406, 89, 23);
		panel.add(btnNewButton_3);
	}
}
