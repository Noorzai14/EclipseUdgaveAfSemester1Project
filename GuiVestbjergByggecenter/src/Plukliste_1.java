import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class Plukliste_1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Plukliste_1 frame = new Plukliste_1();
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
	public Plukliste_1() {
		setTitle("Plukliste");
	
	
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
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{},
			},
			new String[] {
				"Ordrenummer", "Bestillingsdato", "Leveringsdato"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(76);
		table.getColumnModel().getColumn(2).setPreferredWidth(76);
		table.setBounds(47, 11, 690, 32);
		panel.add(table);
		
		JButton btnNewButton = new JButton("Tilbage");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PlukOrdrer info = new PlukOrdrer();
				PlukOrdrer.main(null);
				
			}
		});
		btnNewButton.setBounds(10, 406, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Logud");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login info = new Login();
				Login.main(null);
				
			}
		});
		btnNewButton_1.setBounds(659, 406, 89, 23);
		panel.add(btnNewButton_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(166, 62, 571, 23);
		panel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		chckbxNewCheckBox_1.setBounds(166, 88, 571, 23);
		panel.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("New check box");
		chckbxNewCheckBox_2.setBounds(166, 114, 571, 23);
		panel.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("New check box");
		chckbxNewCheckBox_3.setBounds(166, 140, 571, 23);
		panel.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("New check box");
		chckbxNewCheckBox_4.setBounds(166, 166, 571, 23);
		panel.add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("New check box");
		chckbxNewCheckBox_5.setBounds(166, 191, 571, 23);
		panel.add(chckbxNewCheckBox_5);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("New check box");
		chckbxNewCheckBox_6.setBounds(166, 217, 571, 23);
		panel.add(chckbxNewCheckBox_6);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("New check box");
		chckbxNewCheckBox_7.setBounds(166, 243, 571, 23);
		panel.add(chckbxNewCheckBox_7);
		
		JCheckBox chckbxNewCheckBox_8 = new JCheckBox("New check box");
		chckbxNewCheckBox_8.setBounds(166, 269, 571, 23);
		panel.add(chckbxNewCheckBox_8);
		
		JCheckBox chckbxNewCheckBox_9 = new JCheckBox("New check box");
		chckbxNewCheckBox_9.setBounds(166, 295, 571, 23);
		panel.add(chckbxNewCheckBox_9);
		
		JCheckBox chckbxNewCheckBox_10 = new JCheckBox("New check box");
		chckbxNewCheckBox_10.setBounds(166, 321, 571, 23);
		panel.add(chckbxNewCheckBox_10);
		
		JCheckBox chckbxNewCheckBox_11 = new JCheckBox("New check box");
		chckbxNewCheckBox_11.setBounds(166, 347, 571, 23);
		panel.add(chckbxNewCheckBox_11);
		
		JCheckBox chckbxNewCheckBox_12 = new JCheckBox("New check box");
		chckbxNewCheckBox_12.setBounds(166, 373, 571, 23);
		panel.add(chckbxNewCheckBox_12);
		
		JButton btnNewButton_2 = new JButton("Gem");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		btnNewButton_2.setBounds(47, 166, 89, 49);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Færdig");
		btnNewButton_2_1.setBounds(47, 230, 89, 49);
		panel.add(btnNewButton_2_1);
	}
}
