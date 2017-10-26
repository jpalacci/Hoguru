package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class SearchGUI extends JFrame {

	private JPanel contentPane;
	private JTextField cityTf;
	private JLabel messageLbl;
	private JLabel cityLbl;
	private JComboBox roomsCb;
	private JComboBox peopleCb;
	private JLabel chekInLbl;
	private JLabel checkOutLbl;
	private JButton searchBtn;
	private JButton advancedSearchBtn;

	/**
	 * Create the frame.
	 */
	public SearchGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setVisible(true);
		
		messageLbl = new JLabel("Busca las mejores ofertas online:");
		messageLbl.setBounds(10, 77, 169, 14);
		contentPane.add(messageLbl);
		
		cityLbl = new JLabel("Ciudad:");
		cityLbl.setBounds(10, 114, 46, 14);
		contentPane.add(cityLbl);
		
		cityTf = new JTextField();
		cityTf.setBounds(55, 111, 124, 20);
		contentPane.add(cityTf);
		cityTf.setColumns(10);
		
		roomsCb = new JComboBox(new String[] {"1","2","3","4","5","6","7"});
		roomsCb.setRenderer(new MyComboBoxRenderer("Cantidad de Habitaciones"));
		roomsCb.setSelectedIndex(-1);
		roomsCb.setBounds(10, 328, 156, 20);
		contentPane.add(roomsCb);
		
		peopleCb = new JComboBox(new String[] {"1","2","3","4","5","6","7"});
		peopleCb.setRenderer(new MyComboBoxRenderer("Cantidad de Personas"));
		peopleCb.setSelectedIndex(-1);
		peopleCb.setBounds(239, 328, 156, 20);
		contentPane.add(peopleCb);
		
		chekInLbl = new JLabel("Check-In");
		chekInLbl.setBounds(55, 142, 46, 14);
		contentPane.add(chekInLbl);
		
		checkOutLbl = new JLabel("Check-Out");
		checkOutLbl.setBounds(262, 142, 61, 14);
		contentPane.add(checkOutLbl);
		
		searchBtn = new JButton("Buscar");
		searchBtn.setBounds(10, 373, 156, 23);
		contentPane.add(searchBtn);
		
		advancedSearchBtn = new JButton("Busquedad Avanzada");
		advancedSearchBtn.setBounds(239, 373, 156, 23);
		contentPane.add(advancedSearchBtn);
	}

}
