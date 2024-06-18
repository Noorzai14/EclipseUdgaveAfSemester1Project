import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {
	
	JMenuBar menubar;
	JMenu VarerBestilling_menu;
	JMenu Opfyldning_menu;
	JMenu Lageropdatering_menu;
	JMenu PlukOrdre_menu;
	JMenu Hjem_menu;
	
	JMenuItem SøgOrdre_item;
	JMenuItem Plukliste_item;
	JMenuItem SenesteOrdrer_item;
	

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Main Menu");
		getContentPane().setLayout(new FlowLayout());
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		menubar = new JMenuBar();
		
		VarerBestilling_menu = new JMenu("VarerBestilling");
		Opfyldning_menu = new JMenu("Opfyldning");
		Lageropdatering_menu = new JMenu("Lageropdatering");
		PlukOrdre_menu = new JMenu("PlukOrdre");
		Hjem_menu = new JMenu("Hjem");
		
		SøgOrdre_item = new JMenuItem("SøgOrdre");
		SøgOrdre_item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SøgOrdre info = new SøgOrdre();
				SøgOrdre.main(null);
			}
		});
		Plukliste_item = new JMenuItem("Plukliste");
		Plukliste_item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Plukliste info = new Plukliste();
				Plukliste.main(null);
			}
		});
		SenesteOrdrer_item = new JMenuItem("SenesteOrdrer");
		SenesteOrdrer_item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SenesteOrdrer info = new SenesteOrdrer();
				SenesteOrdrer.main(null);
			}
		});
		
		setJMenuBar(menubar);
		
		menubar.add(VarerBestilling_menu);
		menubar.add(Opfyldning_menu);
		menubar.add(Lageropdatering_menu);
		menubar.add(PlukOrdre_menu);
		menubar.add(Hjem_menu);
		
		PlukOrdre_menu.add(SøgOrdre_item);
		PlukOrdre_menu.add(Plukliste_item);
		PlukOrdre_menu.add(SenesteOrdrer_item);
	
	}

}
