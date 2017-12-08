package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import model.Hotel;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddRoomGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tipoOfRoomTf;
	private JTextField characteristicTf;
	private JLabel tipeOfRoomLbl;
	private JLabel guestNumberlbl;
	private JLabel characteristiclbl;
	private JButton viewSrvicesBtn;
	private JButton addServicesBtn;
	private JLabel bathroomTypeLbl;
	private JLabel priceLbl;
	private JButton creatRoomBtn;
	private JButton cancelBtn;
	private JLabel titleLbl;
	private JButton viewPhotosBtn;
	private JButton addPhotoBtn;
	private JComboBox guestNumberCB;
	private JComboBox bathrooTypeCb;
	private JFormattedTextField formattedTextField;
	private JFrame editHotelFrame;
	private JLabel errorLbl;
	private Timer deleteErrorMessage;
	private Controller controller;
	
	public AddRoomGUI(JFrame editHotelFrame) {
		controller = new Controller();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		this.editHotelFrame = editHotelFrame;
		tipeOfRoomLbl = new JLabel("Tipo de Habitacion");
		tipeOfRoomLbl.setBounds(10, 94, 98, 14);
		contentPane.add(tipeOfRoomLbl);
		
		guestNumberlbl = new JLabel("Cantidad de Huespedes");
		guestNumberlbl.setBounds(10, 129, 121, 14);
		contentPane.add(guestNumberlbl);
		
		characteristiclbl = new JLabel("Caracteristicas");
		characteristiclbl.setBounds(10, 166, 89, 14);
		contentPane.add(characteristiclbl);
		
		viewSrvicesBtn = new JButton("Ver Servicios");
		viewSrvicesBtn.setBounds(10, 233, 121, 23);
		contentPane.add(viewSrvicesBtn);
		
		addServicesBtn = new JButton("Agregar Servicio");
		addServicesBtn.setBounds(184, 233, 121, 23);
		contentPane.add(addServicesBtn);
		
		bathroomTypeLbl = new JLabel("Tipo de bano");
		bathroomTypeLbl.setBounds(10, 292, 80, 14);
		contentPane.add(bathroomTypeLbl);
		
		priceLbl = new JLabel("Precio");
		priceLbl.setBounds(10, 333, 80, 14);
		contentPane.add(priceLbl);
		
		tipoOfRoomTf = new JTextField();
		tipoOfRoomTf.setBounds(137, 91, 225, 20);
		contentPane.add(tipoOfRoomTf);
		tipoOfRoomTf.setColumns(10);
		
		characteristicTf = new JTextField();
		characteristicTf.setColumns(10);
		characteristicTf.setBounds(137, 163, 225, 59);
		contentPane.add(characteristicTf);
		
		creatRoomBtn = new JButton("Agregar Habitacion");
		creatRoomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isRoomValid()){
					sendRoom();
					editHotelFrame.setVisible(true);
					new ThankYouPopUpGUI();
					AddRoomGUI.this.dispose();
				}
			}
		});
		creatRoomBtn.setBounds(42, 458, 137, 23);
		contentPane.add(creatRoomBtn);
		
		cancelBtn = new JButton("Cancelar");
		cancelBtn.setBounds(251, 458, 121, 23);
		contentPane.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editHotelFrame.setVisible(true);
				AddRoomGUI.this.dispose();
			}
		});
		
		titleLbl = new JLabel("Datos de la Habitacion");
		titleLbl.setFont(new Font("Tahoma", Font.BOLD, 19));
		titleLbl.setBounds(10, 11, 307, 53);
		contentPane.add(titleLbl);
		
		viewPhotosBtn = new JButton("Ver Fotos");
		viewPhotosBtn.setBounds(10, 383, 121, 23);
		contentPane.add(viewPhotosBtn);
		
		addPhotoBtn = new JButton("Agregar Fotos");
		addPhotoBtn.setBounds(184, 383, 121, 23);
		contentPane.add(addPhotoBtn);
		
		guestNumberCB = new JComboBox();
		guestNumberCB.setBounds(141, 126, 221, 20);
		contentPane.add(guestNumberCB);
		
		bathrooTypeCb = new JComboBox();
		bathrooTypeCb.setBounds(137, 289, 225, 20);
		contentPane.add(bathrooTypeCb);
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(137, 330, 225, 20);
		contentPane.add(formattedTextField);
		
		errorLbl = new JLabel("");
		errorLbl.setForeground(Color.RED);
		errorLbl.setBounds(42, 427, 46, 14);
		contentPane.add(errorLbl);
		
		 ActionListener al = new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent arg0){
	            	errorLbl.setText("");
	            	tipoOfRoomTf.setBorder(BorderFactory.createLineBorder(Color.black));
	            	characteristicTf.setBorder(BorderFactory.createLineBorder(Color.black));
	            	guestNumberCB.setBorder(BorderFactory.createLineBorder(Color.black));
	            	bathrooTypeCb.setBorder(BorderFactory.createLineBorder(Color.black));
	            	formattedTextField.setBorder(BorderFactory.createLineBorder(Color.black));
	            }
	        };

	     deleteErrorMessage = new Timer(5000,al); // Timer(TimeInMilliSeconds, ActionListener) 1000ms = 1s 
		
	}
	
	protected void sendRoom(){
		String tipeOfRoom =  tipoOfRoomTf.getText().trim();
		String characteristics = characteristicTf.getText().trim();
		String getNumber = (String) guestNumberCB.getSelectedItem();
		String bathRoomType = (String) bathrooTypeCb.getSelectedItem();
		String price = formattedTextField.getText();
		
	}
	
	protected boolean isRoomValid(){
		String tipeOfRoom =  tipoOfRoomTf.getText().trim();
		String characteristics = characteristicTf.getText().trim();
		String getNumber = (String) guestNumberCB.getSelectedItem();
		String bathRoomType = (String) bathrooTypeCb.getSelectedItem();
		String price = formattedTextField.getText();
		boolean error = false;
		
		if(tipeOfRoom.equals(""))
		{
			tipoOfRoomTf.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(characteristics.equals(""))
		{
			characteristicTf.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(getNumber.equals(""))
		{
			guestNumberCB.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(bathRoomType.equals(""))
		{
			bathrooTypeCb.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(price.equals(""))
		{
			formattedTextField.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(error)
		{
			errorLbl.setText("Complete los campos en rojo");
			deleteErrorMessage.start();
			return error;
		}
		
		return controller.isValidRoom(new Hotel("HOla"),tipeOfRoom,characteristics,getNumber,bathRoomType,price,true);
	}

	public JTextField getTipoOfRoomTf() {
		return tipoOfRoomTf;
	}

	public void setTipoOfRoomTf(JTextField tipoOfRoomTf) {
		this.tipoOfRoomTf = tipoOfRoomTf;
	}

	public JTextField getCharacteristicTf() {
		return characteristicTf;
	}

	public void setCharacteristicTf(JTextField characteristicTf) {
		this.characteristicTf = characteristicTf;
	}

	public JComboBox getGuestNumberCB() {
		return guestNumberCB;
	}

	public void setGuestNumberCB(JComboBox guestNumberCB) {
		this.guestNumberCB = guestNumberCB;
	}

	public JFormattedTextField getFormattedTextField() {
		return formattedTextField;
	}

	public JComboBox getBathrooTypeCb() {

		return bathrooTypeCb;
	}
}
