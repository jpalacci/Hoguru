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

	public AddRoomTypeGUI(Hotel hotel, JFrame editHotelFrame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.controller = controller;
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
				sendRoomTypeIfValid();
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
		
		JLabel errorLbl = new JLabel("");
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
	
	private void sendRoomTypeIfValid() {
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
		try{
			priceNumber = Double.parseDouble(price);
		}catch(Exception e){
			
		}
		controller.addRoomTypeToHotel(hotel.getName(), description, name, priceNumber);
	}
}
