import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setTitle("Main Menu");
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
		
		JButton btnNewButton = new JButton("Bestil Produkt");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(118, 99, 160, 80);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Opfyld Lager");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(423, 99, 160, 80);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Pluk Ordrer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PlukOrdrer info = new PlukOrdrer();
				PlukOrdrer.main(null);
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_2.setBounds(118, 216, 160, 80);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Opret data");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OpretData info = new OpretData();
				OpretData.main(null);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_3.setBounds(423, 216, 160, 80);
		panel.add(btnNewButton_3);
		
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
