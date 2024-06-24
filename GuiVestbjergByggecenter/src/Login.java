import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
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
		
		JLabel lblNewLabel = new JLabel("Login Vestbjerg Byggecenter System");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(131, 11, 427, 49);
		panel.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Bruger ID");
		lblUsername.setBounds(92, 148, 98, 14);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Kode");
		lblPassword.setBounds(92, 185, 98, 14);
		panel.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(171, 145, 319, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(171, 182, 319, 20);
		panel.add(txtPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = txtUsername.getText();
				String password = txtPassword.getText();
				
				if (username.contains("khanh") && password.contains("dodo")) {
					txtPassword.setText(null);
					txtUsername.setText(null);
					
					MainMenu info = new MainMenu();
					MainMenu.main(null);
					
				} else {
					JOptionPane.showMessageDialog(null, "Login Fejl");
					txtPassword.setText(null);
					txtUsername.setText(null);
				}
				
				
			}
		});
		btnNewButton.setBounds(219, 359, 208, 23);
		panel.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(38, 326, 587, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(38, 70, 587, 2);
		panel.add(separator_1);
	}
}
