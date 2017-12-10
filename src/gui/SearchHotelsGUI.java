package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Controller.Controller;
import model.Person;

public class SearchHotelsGUI extends JFrame {

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
	private JLabel editUserLbl;
	private JFormattedTextField checkOutTextField;
	private JFormattedTextField checkInTextField;
	private JButton btnBuscar;
	private Controller controller;
	private Person person;

	
	public SearchHotelsGUI() {
		controller = new Controller();
		person = controller.getActivePerson();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		contentPane.setLayout(null);
		
		messageLbl = new JLabel("Busca las mejores ofertas online:");
		messageLbl.setBounds(10, 60, 276, 14);
		contentPane.add(messageLbl);
		
		cityLbl = new JLabel("Ciudad:");
		cityLbl.setBounds(10, 114, 46, 14);
		contentPane.add(cityLbl);
		
		cityTf = new JTextField();
		cityTf.setBounds(64, 111, 158, 20);
		contentPane.add(cityTf);
		cityTf.setColumns(10);
		
		roomsCb = new JComboBox(new String[] {"1","2","3","4","5","6","7"});
		roomsCb.setBounds(10, 328, 156, 20);
		roomsCb.setRenderer(new MyComboBoxRenderer("Cantidad de Habitaciones"));
		roomsCb.setSelectedIndex(-1);
		contentPane.add(roomsCb);
		
		peopleCb = new JComboBox(new String[] {"1","2","3","4","5","6","7"});
		peopleCb.setBounds(239, 328, 156, 20);
		peopleCb.setRenderer(new MyComboBoxRenderer("Cantidad de Personas"));
		peopleCb.setSelectedIndex(-1);
		contentPane.add(peopleCb);
		
		chekInLbl = new JLabel("Check-In");
		chekInLbl.setBounds(55, 142, 91, 14);
		contentPane.add(chekInLbl);
		
		checkOutLbl = new JLabel("Check-Out");
		checkOutLbl.setBounds(262, 142, 61, 14);
		contentPane.add(checkOutLbl);
		
		searchBtn = new JButton("Buscar");
		searchBtn.setBounds(10, 373, 156, 23);
		contentPane.add(searchBtn);
		
		advancedSearchBtn = new JButton("Busqueda Avanzada");
		advancedSearchBtn.setBounds(239, 373, 156, 23);
		contentPane.add(advancedSearchBtn);
		
		editUserLbl = new JLabel("Edit User");
		editUserLbl.setBounds(448, 13, 74, 29);
		editUserLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(editUserLbl);
		
		
		MaskFormatter dateMask = null;
        try {
          
            dateMask = new MaskFormatter("##/##/####");
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		checkInTextField = new JFormattedTextField();
		checkInTextField.setBounds(55, 167, 124, 20);
		contentPane.add(checkInTextField);
		
		checkOutTextField = new JFormattedTextField();
		checkOutTextField.setBounds(262, 167, 124, 20);
		contentPane.add(checkOutTextField);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(258, 105, 89, 23);
		contentPane.add(btnBuscar);
		
		btnBuscar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isValidSearch()){
					controller.getSearch();
				}
			}

		
		});
		
		editUserLbl.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EditUserGUI(SearchHotelsGUI.this, person);
				SearchHotelsGUI.this.setVisible(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

        });
		
		
	}
	
	private boolean isValidSearch() {
		// TODO Auto-generated method stub
		return true;
	}
}
