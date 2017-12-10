package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import model.Room;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class RoomDisplayGUI extends JFrame {

	private JPanel contentPane;
	private Room room;
	private JLabel roomNumberExplanationLbl;
	private JLabel hotelNameLbl;
	private JLabel roomNumberLbl;
	private JLabel viewTypeExplanationLbl;
	private JLabel viewType;
	private JLabel roomTypeExplanationLbl;
	private JLabel roomTypeLbl;
	private JLabel numberOfPeopleInformationLbl;
	private JLabel numberOfPeopleLbl;
	private JLabel roomPriceInformationLbl;
	private JLabel roomPriceLbl;
	private JButton reserveBtn;
	private Controller controller;
	
	public RoomDisplayGUI(Room room, Calendar checkIn, Calendar checkOut, String city, int numberOfPeople, String userName) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.controller = new Controller();
		this.room = room;
		
		roomNumberExplanationLbl = new JLabel("Numero de cuarto");
		roomNumberExplanationLbl.setBounds(10, 61, 115, 14);
		contentPane.add(roomNumberExplanationLbl);
		
		hotelNameLbl = new JLabel("Nombre del hotel");
		hotelNameLbl.setBounds(10, 25, 148, 14);
		contentPane.add(hotelNameLbl);
		
		roomNumberLbl = new JLabel("2");
		roomNumberLbl.setBounds(135, 61, 46, 14);
		contentPane.add(roomNumberLbl);
		
		viewTypeExplanationLbl = new JLabel("Vista:");
		viewTypeExplanationLbl.setBounds(217, 61, 46, 14);
		contentPane.add(viewTypeExplanationLbl);
		
		viewType = new JLabel("typo de vista");
		viewType.setBounds(298, 61, 126, 14);
		contentPane.add(viewType);
		
		roomTypeExplanationLbl = new JLabel("Tipo de Cuarto");
		roomTypeExplanationLbl.setBounds(10, 102, 88, 14);
		contentPane.add(roomTypeExplanationLbl);
		
		roomTypeLbl = new JLabel("Tipo de Cuarto");
		roomTypeLbl.setBounds(108, 102, 109, 14);
		contentPane.add(roomTypeLbl);
		
		numberOfPeopleInformationLbl = new JLabel("Cantidad de personas");
		numberOfPeopleInformationLbl.setBounds(217, 102, 118, 14);
		contentPane.add(numberOfPeopleInformationLbl);
		
		numberOfPeopleLbl = new JLabel("4");
		numberOfPeopleLbl.setBounds(345, 102, 79, 14);
		contentPane.add(numberOfPeopleLbl);
		
		roomPriceInformationLbl = new JLabel("Precio");
		roomPriceInformationLbl.setBounds(10, 143, 115, 14);
		contentPane.add(roomPriceInformationLbl);
		
		roomPriceLbl = new JLabel("200");
		roomPriceLbl.setBounds(171, 143, 46, 14);
		contentPane.add(roomPriceLbl);
		
		reserveBtn = new JButton("Reservar");
		reserveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.addReservation(userName, checkIn, checkOut, room);
			}

		});
		reserveBtn.setBounds(286, 139, 89, 23);
		contentPane.add(reserveBtn);
		
		loadRoom();
	}
	
	private void loadRoom() {
		hotelNameLbl.setText(room.getHotelName());;
		roomNumberLbl.setText(String.valueOf(room.getNumber()));;
		viewType.setText(room.getView().name());;
		roomTypeLbl.setText(room.getType());;
		numberOfPeopleLbl.setText(String.valueOf(room.getCapacity()));;
		roomPriceLbl.setText(String.valueOf(room.getNightCost()));;
		
	}

}
