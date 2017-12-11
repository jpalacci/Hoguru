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
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddRoomTypeGUI extends JFrame {

	private JPanel contentPane;
	private JTextField nameTypeTf;
	private JTextField descrpitionTf;
	private JTextField priceTf;
	private Hotel hotel;
	private JFrame editHotelFrame;
	private Controller controller;
	private Timer deleteErrorMessage;
	private JLabel errorLbl;

	public AddRoomTypeGUI(Hotel hotel, JFrame editHotelFrame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		setResizable(false);
		contentPane.setLayout(null);
		
		this.controller = new Controller();
		this.hotel = hotel;
		this.editHotelFrame = editHotelFrame;
		
		JLabel typeNameLbl = new JLabel("Nombre del tipo");
		typeNameLbl.setBounds(10, 76, 89, 14);
		contentPane.add(typeNameLbl);
		
		nameTypeTf = new JTextField();
		nameTypeTf.setBounds(109, 73, 250, 20);
		contentPane.add(nameTypeTf);
		nameTypeTf.setColumns(10);
		
		JLabel descriptionLbl = new JLabel("Descripcion");
		descriptionLbl.setBounds(10, 122, 89, 14);
		contentPane.add(descriptionLbl);
		
		descrpitionTf = new JTextField();
		descrpitionTf.setBounds(109, 119, 250, 20);
		contentPane.add(descrpitionTf);
		descrpitionTf.setColumns(10);
		
		JLabel priceLbl = new JLabel("Precio");
		priceLbl.setBounds(10, 165, 89, 14);
		contentPane.add(priceLbl);
		
		priceTf = new JTextField();
		priceTf.setBounds(109, 162, 250, 20);
		contentPane.add(priceTf);
		priceTf.setColumns(10);
		
		JLabel lblAgregarUnTipo = new JLabel("Agregar un Tipo de cuarto");
		lblAgregarUnTipo.setBounds(10, 26, 174, 14);
		contentPane.add(lblAgregarUnTipo);
		
		JButton CreateBtn = new JButton("Agregar Tipo");
		CreateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sendRoomTypeIfValid()){
					dispose();
				};
				
			}

		});
		CreateBtn.setBounds(21, 226, 151, 23);
		contentPane.add(CreateBtn);
		
		JButton cancelBtn = new JButton("Cencelar");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editHotelFrame.setVisible(true);
				dispose();
			}
		});
		cancelBtn.setBounds(221, 226, 151, 23);
		contentPane.add(cancelBtn);
		
		errorLbl = new JLabel("");
		errorLbl.setBounds(21, 201, 338, 14);
		contentPane.add(errorLbl);
		
		 ActionListener al = new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent arg0){
	            	errorLbl.setText("");
	            	nameTypeTf.setBorder(BorderFactory.createLineBorder(Color.black));
	            	descrpitionTf.setBorder(BorderFactory.createLineBorder(Color.black));
	            	priceTf.setBorder(BorderFactory.createLineBorder(Color.black));
	            }
	        };

	     deleteErrorMessage = new Timer(5000,al); // Timer(TimeInMilliSeconds, ActionListener) 1000ms = 1s 
		
	}
	
	private boolean sendRoomTypeIfValid() {
		String name = nameTypeTf.getText().trim();
		String description = descrpitionTf.getText().trim();
		String price = priceTf.getText().trim();
		double priceNumber = 0;
		boolean error = false;
		
		if(price.equals("")){
			error = true;
			priceTf.setBorder(BorderFactory.createLineBorder(Color.red));
		}
		if(description.equals("")){
			error = true;
			descrpitionTf.setBorder(BorderFactory.createLineBorder(Color.red));
		}
		if(name.equals("")){
			error = true;
			nameTypeTf.setBorder(BorderFactory.createLineBorder(Color.red));
		}
		if(error){
			errorLbl.setText("Complete los campos en rojo");
			deleteErrorMessage.start();
			return !error;
		}
		try{
			priceNumber = Double.parseDouble(price);
		}catch(Exception e){
			errorLbl.setText("Ponga un numero valido para el precio");
			deleteErrorMessage.start();
			return false;
		}
		
		if(!controller.addRoomTypeToHotel(hotel.getName(), description, name, priceNumber)){
			errorLbl.setText("Hay porblemas con la base de datos por favor vuelva a intentar");
			deleteErrorMessage.start();
			return false;
		}
		return true;
	}
}
