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
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditHotelGUI extends JFrame {

	private JPanel contentPane;
	private JTextField cityTf;
	private JTextField hotelNameTf;
	private JTextField directionTf;
	private JTextField starTf;
	private JTextField recreationTf;
	private JTextField textField_6;
	private JLabel cityLbl;
	private JLabel hotelNameLbl;
	private JLabel directionLbl;
	private JLabel starsLbl;
	private JButton viewServicesBtn;
	private JButton addServiceBtn;
	private JLabel recreationLbl;
	private JLabel lblParticularidades;
	private JButton changeHotelBtn;
	private JButton cancelBtn;
	private JLabel lblDatosDelHotel;
	private JButton viewPhotoBtn;
	private JButton addPhotoBtn;
	private JFrame administratorFrame;
	private JButton btnAgregarHabitacion;
	private JButton btnEditarHabitacion;
	private Timer deleteErrorMessage;
	private JLabel errorLbl;
	private Controller controller;
	private Hotel hotel;
	
	public EditHotelGUI(JFrame administratorFrame, Hotel hotel) {
		controller = new Controller();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		this.administratorFrame = administratorFrame;
		this.hotel = hotel;
		cityLbl = new JLabel("Ciudad:");
		cityLbl.setBounds(10, 94, 46, 14);
		contentPane.add(cityLbl);
		
		hotelNameLbl = new JLabel("Nombre del Hotel");
		hotelNameLbl.setBounds(10, 129, 98, 14);
		contentPane.add(hotelNameLbl);
		
		directionLbl = new JLabel("Direccion");
		directionLbl.setBounds(10, 166, 46, 14);
		contentPane.add(directionLbl);
		
		starsLbl = new JLabel("Cantidad de Estrellas");
		starsLbl.setBounds(10, 205, 111, 14);
		contentPane.add(starsLbl);
		
		viewServicesBtn = new JButton("Ver Servicios");
		viewServicesBtn.setBounds(10, 262, 121, 23);
		contentPane.add(viewServicesBtn);
		
		addServiceBtn = new JButton("Agregar Servicio");
		addServiceBtn.setBounds(215, 262, 125, 23);
		contentPane.add(addServiceBtn);
		
		recreationLbl = new JLabel("Recreacion");
		recreationLbl.setBounds(10, 326, 80, 14);
		contentPane.add(recreationLbl);
		
		lblParticularidades = new JLabel("Particularidades");
		lblParticularidades.setBounds(10, 362, 80, 14);
		contentPane.add(lblParticularidades);
		
		cityTf = new JTextField();
		cityTf.setBounds(137, 91, 225, 20);
		contentPane.add(cityTf);
		cityTf.setColumns(10);
		
		hotelNameTf = new JTextField();
		hotelNameTf.setColumns(10);
		hotelNameTf.setBounds(137, 126, 225, 20);
		contentPane.add(hotelNameTf);
		
		directionTf = new JTextField();
		directionTf.setColumns(10);
		directionTf.setBounds(137, 163, 225, 20);
		contentPane.add(directionTf);
		
		starTf = new JTextField();
		starTf.setColumns(10);
		starTf.setBounds(137, 202, 225, 20);
		contentPane.add(starTf);
		
		recreationTf = new JTextField();
		recreationTf.setColumns(10);
		recreationTf.setBounds(137, 323, 225, 20);
		contentPane.add(recreationTf);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(137, 359, 225, 20);
		contentPane.add(textField_6);
		
		changeHotelBtn = new JButton("Modificar Hotel");
		changeHotelBtn.setBounds(57, 458, 121, 23);
		contentPane.add(changeHotelBtn);
		changeHotelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isHotelValid()){
					administratorFrame.setVisible(true);
					new ThankYouPopUpGUI();
					EditHotelGUI.this.dispose();
				}
			}
		});
		
		cancelBtn = new JButton("Cancelar");
		cancelBtn.setBounds(229, 458, 111, 23);
		contentPane.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administratorFrame.setVisible(true);
				EditHotelGUI.this.dispose();
			}
		});
		
		lblDatosDelHotel = new JLabel("Datos del Hotel");
		lblDatosDelHotel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDatosDelHotel.setBounds(10, 11, 168, 53);
		contentPane.add(lblDatosDelHotel);
		
		viewPhotoBtn = new JButton("Ver Fotos");
		viewPhotoBtn.setBounds(10, 398, 121, 23);
		contentPane.add(viewPhotoBtn);
		
		addPhotoBtn = new JButton("Agregar Fotos");
		addPhotoBtn.setBounds(182, 398, 121, 23);
		contentPane.add(addPhotoBtn);
		
		btnAgregarHabitacion = new JButton("Agregar Habitacion");
		btnAgregarHabitacion.setBounds(215, 289, 125, 23);
		contentPane.add(btnAgregarHabitacion);
		btnAgregarHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditHotelGUI.this.setVisible(false);
				new AddRoomGUI(EditHotelGUI.this);
			}
		});

		
		btnEditarHabitacion = new JButton("Editar Habitacion");
		btnEditarHabitacion.setBounds(10, 292, 125, 23);
		contentPane.add(btnEditarHabitacion);
		btnEditarHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditHotelGUI.this.setVisible(false);
				new JListRoomGUI(controller.getRooms(new Hotel("Hola")), EditHotelGUI.this);
			}
		});
		
		errorLbl = new JLabel("");
		errorLbl.setForeground(Color.RED);
		errorLbl.setBounds(57, 433, 46, 14);
		contentPane.add(errorLbl);
		
		 ActionListener al = new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent arg0){
	            	errorLbl.setText("");
	            	cityTf.setBorder(BorderFactory.createLineBorder(Color.black));
	            	hotelNameTf.setBorder(BorderFactory.createLineBorder(Color.black));
	            	directionTf.setBorder(BorderFactory.createLineBorder(Color.black));
	            	starTf.setBorder(BorderFactory.createLineBorder(Color.black));
	            	recreationTf.setBorder(BorderFactory.createLineBorder(Color.black));
	            	
	            	
	            }
	        };

	     deleteErrorMessage = new Timer(5000,al); // Timer(TimeInMilliSeconds, ActionListener) 1000ms = 1s 
	}
	
	
	
	protected boolean isHotelValid(){
		String city = cityTf.getText().trim();
		String hotelName = hotelNameTf.getText().trim();
		String direction = directionTf.getText().trim();
		String stars =  starTf.getText().trim();
		String recreation = recreationTf.getText().trim();
		
		boolean error = false;
		
		if(city.equals(""))
		{
			cityTf.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(hotelName.equals(""))
		{
			hotelNameTf.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(direction.equals(""))
		{
			directionTf.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(stars.equals(""))
		{
			starTf.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(recreation.equals(""))
		{
			recreationTf.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(error)
		{
			errorLbl.setText("Complete los campos en rojo");
			deleteErrorMessage.start();
			return false;
		}
		return  controller.isValidHotel(city, hotelName,direction, stars, recreation, false);
	}

	public JTextField getCityTf() {
		return cityTf;
	}

	public JTextField getHotelNameTf() {
		return hotelNameTf;
	}

	public JTextField getDirectionTf() {
		return directionTf;
	}

	public JTextField getStarTf() {
		return starTf;
	}

	public JTextField getRecreationTf() {
		return recreationTf;
	}
}
