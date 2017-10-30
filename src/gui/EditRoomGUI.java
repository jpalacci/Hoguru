package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;

public class EditRoomGUI extends JFrame {

	private JPanel contentPane;
	private JTextField typeOfRoomTf;
	private JTextField characteristicTf;
	private JLabel typeOfRoomLbl;
	private JLabel numberOfGuestLbl;
	private JLabel characteristicsLbl;
	private JButton viewServicesBtn;
	private JButton addServicesBtn;
	private JLabel bathrommTypeLbl;
	private JLabel priceLbl;
	private JButton changeRoomBtn;
	private JButton cancelBtn;
	private JLabel titleLbl;
	private JButton viewPhotosBtn;
	private JButton addPhotosBtn;
	private JComboBox numerOfguestCb;
	private JComboBox bathRoomTypeCb;
	private JFormattedTextField priceTff;
	private JFrame hotelFrame;
	private JLabel errorLbl;
	private Timer deleteErrorMessage;
	
	public EditRoomGUI(JFrame hotelFrame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		this.hotelFrame = hotelFrame;
		typeOfRoomLbl = new JLabel("Tipo de Habitacion");
		typeOfRoomLbl.setBounds(10, 94, 98, 14);
		contentPane.add(typeOfRoomLbl);
		
		numberOfGuestLbl = new JLabel("Cantidad de Huespedes");
		numberOfGuestLbl.setBounds(10, 129, 121, 14);
		contentPane.add(numberOfGuestLbl);
		
		characteristicsLbl = new JLabel("Caracteristicas");
		characteristicsLbl.setBounds(10, 166, 89, 14);
		contentPane.add(characteristicsLbl);
		
		viewServicesBtn = new JButton("Ver Servicios");
		viewServicesBtn.setBounds(10, 233, 121, 23);
		contentPane.add(viewServicesBtn);
		
		addServicesBtn = new JButton("Agregar Servicio");
		addServicesBtn.setBounds(184, 233, 121, 23);
		contentPane.add(addServicesBtn);
		
		bathrommTypeLbl = new JLabel("Tipo de bano");
		bathrommTypeLbl.setBounds(10, 292, 80, 14);
		contentPane.add(bathrommTypeLbl);
		
		priceLbl = new JLabel("Precio");
		priceLbl.setBounds(10, 333, 80, 14);
		contentPane.add(priceLbl);
		
		typeOfRoomTf = new JTextField();
		typeOfRoomTf.setBounds(137, 91, 225, 20);
		contentPane.add(typeOfRoomTf);
		typeOfRoomTf.setColumns(10);
		
		characteristicTf = new JTextField();
		characteristicTf.setColumns(10);
		characteristicTf.setBounds(137, 163, 225, 59);
		contentPane.add(characteristicTf);
		
		changeRoomBtn = new JButton("Modificar Habitacion");
		changeRoomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isRoomValid()){
					sendRoom();
					hotelFrame.setVisible(true);
					new ThankYouPopUpGUI();
					EditRoomGUI.this.dispose();
				}
			}
		});
		changeRoomBtn.setBounds(42, 458, 137, 23);
		contentPane.add(changeRoomBtn);
		
		cancelBtn = new JButton("Cancelar");
		cancelBtn.setBounds(251, 458, 121, 23);
		contentPane.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hotelFrame.setVisible(true);
				EditRoomGUI.this.dispose();
			}
		});
		
		titleLbl = new JLabel("Datos de la Habitacion");
		titleLbl.setFont(new Font("Tahoma", Font.BOLD, 19));
		titleLbl.setBounds(10, 11, 242, 53);
		contentPane.add(titleLbl);
		
		viewPhotosBtn = new JButton("Ver Fotos");
		viewPhotosBtn.setBounds(10, 383, 121, 23);
		contentPane.add(viewPhotosBtn);
		
		addPhotosBtn = new JButton("Agregar Fotos");
		addPhotosBtn.setBounds(184, 383, 121, 23);
		contentPane.add(addPhotosBtn);
		
		numerOfguestCb = new JComboBox();
		numerOfguestCb.setBounds(141, 126, 221, 20);
		contentPane.add(numerOfguestCb);
		
		bathRoomTypeCb = new JComboBox();
		bathRoomTypeCb.setBounds(137, 289, 225, 20);
		contentPane.add(bathRoomTypeCb);
		
		priceTff = new JFormattedTextField();
		priceTff.setBounds(137, 330, 225, 20);
		contentPane.add(priceTff);
		
		errorLbl = new JLabel("");
		errorLbl.setForeground(Color.RED);
		errorLbl.setBounds(42, 427, 46, 14);
		contentPane.add(errorLbl);
		
		 ActionListener al = new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent arg0){
	            	errorLbl.setText("");
	            	typeOfRoomTf.setBorder(BorderFactory.createLineBorder(Color.black));
	            	characteristicTf.setBorder(BorderFactory.createLineBorder(Color.black));
	            	numerOfguestCb.setBorder(BorderFactory.createLineBorder(Color.black));
	            	bathRoomTypeCb.setBorder(BorderFactory.createLineBorder(Color.black));
	            	priceTff.setBorder(BorderFactory.createLineBorder(Color.black));
	            }
	        };
	        
	     deleteErrorMessage = new Timer(5000,al); // Timer(TimeInMilliSeconds, ActionListener) 1000ms = 1s 
	}
	
	protected void sendRoom(){
		String tipeOfRoom =  typeOfRoomTf.getText().trim();
		String characteristics = characteristicTf.getText().trim();
		String getNumber = (String) numerOfguestCb.getSelectedItem();
		String bathRoomType = (String) bathRoomTypeCb.getSelectedItem();
		String price = priceTff.getText();
		
	}
	
	protected boolean isRoomValid(){
		String tipeOfRoom =  typeOfRoomTf.getText().trim();
		String characteristics = characteristicTf.getText().trim();
		String getNumber = (String) numerOfguestCb.getSelectedItem();
		String bathRoomType = (String) bathRoomTypeCb.getSelectedItem();
		String price = priceTff.getText();
		boolean error = false;
		
		if(tipeOfRoom.equals(""))
		{
			typeOfRoomTf.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(characteristics.equals(""))
		{
			characteristicTf.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(getNumber.equals(""))
		{
			numerOfguestCb.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(bathRoomType.equals(""))
		{
			bathRoomTypeCb.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(price.equals(""))
		{
			priceTff.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(error)
		{
			errorLbl.setText("Complete los campos en rojo");
		}
		
		return !error;
	}

}
