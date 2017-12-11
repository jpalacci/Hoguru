package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;

public class AddHotelGUI extends JFrame {

	private JPanel contentPane;
	private JTextField hotelNameTf;
	private JTextField directionTf;
	private JLabel hotelNameLbl;
	private JLabel directionLbl;
	private JLabel starsLbl;
	private JButton createHotelBtn;
	private JButton cancelBtn;
	private JLabel lblDatosDelHotel;
	private JFrame administratorFrame;
	private Timer deleteErrorMessage;
	private JLabel errorLbl;
	private Controller controller;
	private JFormattedTextField rateFT;
	private JLabel cityLbl;
	private JTextField cityTf;
	
	public AddHotelGUI(JFrame administratorFrame) {
		
		controller = new Controller();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		this.administratorFrame = administratorFrame;
		
		hotelNameLbl = new JLabel("Nombre del Hotel");
		hotelNameLbl.setBounds(10, 78, 98, 14);
		contentPane.add(hotelNameLbl);
		
		directionLbl = new JLabel("Direccion");
		directionLbl.setBounds(10, 116, 98, 14);
		contentPane.add(directionLbl);
		
		starsLbl = new JLabel("Cantidad de Estrellas");
		starsLbl.setBounds(10, 162, 126, 14);
		contentPane.add(starsLbl);
		
		hotelNameTf = new JTextField();
		hotelNameTf.setColumns(10);
		hotelNameTf.setBounds(137, 75, 225, 20);
		contentPane.add(hotelNameTf);
		
		directionTf = new JTextField();
		directionTf.setColumns(10);
		directionTf.setBounds(137, 113, 225, 20);
		contentPane.add(directionTf);
		
		createHotelBtn = new JButton("Crear Hotel");
		createHotelBtn.setBounds(67, 289, 126, 23);
		contentPane.add(createHotelBtn);
		createHotelBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isHotelValid()){
					administratorFrame.setVisible(true);
					AddHotelGUI.this.dispose();
				}
				else{
					errorLbl.setText("El hotel no se pudo crear, intentelo devuelta");
					deleteErrorMessage.start();
				}
			}
		});
		
		cancelBtn = new JButton("Cancelar");
		cancelBtn.setBounds(226, 289, 111, 23);
		contentPane.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administratorFrame.setVisible(true);
				AddHotelGUI.this.dispose();
			}
		});
		
		lblDatosDelHotel = new JLabel("Datos del Hotel");
		lblDatosDelHotel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDatosDelHotel.setBounds(10, 11, 168, 53);
		contentPane.add(lblDatosDelHotel);
		
		errorLbl = new JLabel("");
		errorLbl.setForeground(Color.RED);
		errorLbl.setBounds(36, 262, 46, 14);
		contentPane.add(errorLbl);
		
		rateFT = new JFormattedTextField();
		rateFT.setBounds(137, 159, 225, 20);
		contentPane.add(rateFT);
		
		cityLbl = new JLabel("Ciudad");
		cityLbl.setBounds(10, 206, 111, 14);
		contentPane.add(cityLbl);
		
		cityTf = new JTextField();
		cityTf.setColumns(10);
		cityTf.setBounds(137, 203, 225, 20);
		contentPane.add(cityTf);
		
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
		
		return controller.isValidHotel(hotelName,direction, rateNumber, true, city);
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
