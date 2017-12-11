package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import model.Hotel;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

public class EditHotelGUI extends JFrame {

	private JPanel contentPane;
	private JTextField hotelNameTf;
	private JTextField directionTf;
	private JLabel hotelNameLbl;
	private JLabel directionLbl;
	private JLabel starsLbl;
	private JButton editHotelBtn;
	private JButton cancelBtn;
	private JLabel lblDatosDelHotel;
	private JButton viewRoomsBtn;
	private JButton addTypeBtn;
	private JFrame administratorFrame;
	private Timer deleteErrorMessage;
	private JLabel errorLbl;
	private Controller controller;
	private JFormattedTextField rateFT;
	private Hotel hotel;
	private JTextField cityTf;
	
	public EditHotelGUI(JFrame administratorFrame, Hotel hotel) {
		
		controller = new Controller();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		this.administratorFrame = administratorFrame;
		this.hotel = hotel;
		hotelNameLbl = new JLabel("Nombre del Hotel");
		hotelNameLbl.setBounds(10, 78, 98, 14);
		contentPane.add(hotelNameLbl);
		
		directionLbl = new JLabel("Direccion");
		directionLbl.setBounds(10, 116, 46, 14);
		contentPane.add(directionLbl);
		
		starsLbl = new JLabel("Cantidad de Estrellas");
		starsLbl.setBounds(10, 162, 111, 14);
		contentPane.add(starsLbl);
		
		hotelNameTf = new JTextField();
		hotelNameTf.setColumns(10);
		hotelNameTf.setBounds(137, 75, 225, 20);
		hotelNameTf.setEditable(false);
		contentPane.add(hotelNameTf);
		
		directionTf = new JTextField();
		directionTf.setColumns(10);
		directionTf.setBounds(137, 113, 225, 20);
		contentPane.add(directionTf);
		
		editHotelBtn = new JButton("Editar Hotel");
		editHotelBtn.setBounds(67, 361, 111, 23);
		contentPane.add(editHotelBtn);
		editHotelBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isHotelValid()){
					administratorFrame.setVisible(true);
					EditHotelGUI.this.dispose();
				}
				else{
					errorLbl.setText("El hotel no se pudo crear, intentelo devuelta");
					deleteErrorMessage.start();
				}
			}
		});
		
		cancelBtn = new JButton("Cancelar");
		cancelBtn.setBounds(226, 361, 89, 23);
		contentPane.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administratorFrame.setVisible(true);
				EditHotelGUI.this.dispose();
			}
		});
		
		lblDatosDelHotel = new JLabel("Datos del Hotel para Editar");
		lblDatosDelHotel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDatosDelHotel.setBounds(10, 11, 266, 53);
		contentPane.add(lblDatosDelHotel);
		
		viewRoomsBtn = new JButton("Ver Cuartos");
		viewRoomsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JListRoomGUI(controller.getRooms(hotel),hotel,EditHotelGUI.this);
				dispose();
			}
		});
		viewRoomsBtn.setBounds(20, 300, 121, 23);
		contentPane.add(viewRoomsBtn);
		
		addTypeBtn = new JButton("Agregar Tipos de Habitacion");
		addTypeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddRoomTypeGUI(hotel, EditHotelGUI.this);
			}
		});
		addTypeBtn.setBounds(194, 253, 168, 23);
		contentPane.add(addTypeBtn);
		
		errorLbl = new JLabel("");
		errorLbl.setForeground(Color.RED);
		errorLbl.setBounds(30, 334, 285, 14);
		contentPane.add(errorLbl);
		
		rateFT = new JFormattedTextField();
		rateFT.setBounds(137, 159, 225, 20);
		contentPane.add(rateFT);
		
		JButton viewTypesBtn = new JButton("Ver Tipos de Habitacion");
		viewTypesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JListRoomTypesGUI(hotel, EditHotelGUI.this);
			}
		});
		viewTypesBtn.setBounds(20, 253, 158, 23);
		contentPane.add(viewTypesBtn);
		
		JButton addRoombtn = new JButton("Agregar Cuarto");
		addRoombtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddRoomGUI(EditHotelGUI.this, hotel);
				dispose();
			}
		});
		addRoombtn.setBounds(194, 300, 121, 23);
		contentPane.add(addRoombtn);
		
		cityTf = new JTextField();
		cityTf.setText((String) null);
		cityTf.setColumns(10);
		cityTf.setBounds(137, 207, 225, 20);
		contentPane.add(cityTf);
		
		JLabel cityLbl = new JLabel("Ciudad");
		cityLbl.setHorizontalAlignment(SwingConstants.TRAILING);
		cityLbl.setBounds(10, 210, 111, 14);
		contentPane.add(cityLbl);
		
		 ActionListener al = new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent arg0){
	            	errorLbl.setText("");
	            	hotelNameTf.setBorder(BorderFactory.createLineBorder(Color.black));
	            	directionTf.setBorder(BorderFactory.createLineBorder(Color.black));
	            	rateFT.setBorder(BorderFactory.createLineBorder(Color.black));
	            	cityTf.setBorder(BorderFactory.createLineBorder(Color.black));
	            	
	            }
	        };

	     deleteErrorMessage = new Timer(5000,al); // Timer(TimeInMilliSeconds, ActionListener) 1000ms = 1s 
		loadHotel();
	}
	
	
	
	private void loadHotel() {
		hotelNameTf.setText(hotel.getName());
		directionTf.setText(hotel.getDirection());
		rateFT.setText(String.valueOf(hotel.getRate()));
		cityTf.setText(String.valueOf(hotel.getCity()));
	}



	protected boolean isHotelValid(){
		String hotelName = hotelNameTf.getText().trim();
		String direction = directionTf.getText().trim();
		String rate =  rateFT.getText().trim();
		String city = cityTf.getText().trim();
		float rateNumber;
		boolean error = false;
		
		
		if(hotelName.equals(""))
		{
			hotelNameTf.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(city.equals(""))
		{
			cityTf.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(direction.equals(""))
		{
			directionTf.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(rate.equals(""))
		{
			rateFT.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}

		if(error)
		{
			errorLbl.setText("Complete los campos en rojo");
			deleteErrorMessage.start();
			return false;
		}
		try{
			rateNumber = Float.parseFloat(rate);
		}catch(Exception e){
			errorLbl.setText("Ponga un numero valido como cantidad de Estrellas");
			deleteErrorMessage.start();
			return false;
		}
		
		return controller.isValidHotel(hotelName,direction, rateNumber, false, city);
	}

	

	public JTextField getHotelNameTf() {
		return hotelNameTf;
	}

	public JTextField getDirectionTf() {
		return directionTf;
	}

	public JTextField getRateFT() {
		return rateFT;
	}
}
