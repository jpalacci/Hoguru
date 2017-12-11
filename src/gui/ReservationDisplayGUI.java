package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import model.CalendarTranslator;
import model.Reservation;
import model.Room;
import javax.swing.JTextField;

public class ReservationDisplayGUI extends JFrame {


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
	private JButton searchBtn;
	private Controller controller;
	private JTextField reservationNumberTf;
	private JButton cancelReservationBtn;
	private JLabel CityExplanationlbl;
	private JLabel cityLbl;
	private JLabel lblCheckin;
	private JLabel checkInLbl;
	private JLabel lblCheckout;
	private JLabel checkOutLbl;
	
	public ReservationDisplayGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 336);
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.controller = new Controller();
		
		roomNumberExplanationLbl = new JLabel("Numero de cuarto");
		roomNumberExplanationLbl.setBounds(10, 120, 115, 14);
		contentPane.add(roomNumberExplanationLbl);
		
		hotelNameLbl = new JLabel("");
		hotelNameLbl.setBounds(10, 79, 148, 14);
		contentPane.add(hotelNameLbl);
		
		roomNumberLbl = new JLabel("");
		roomNumberLbl.setBounds(123, 120, 46, 14);
		contentPane.add(roomNumberLbl);
		
		viewTypeExplanationLbl = new JLabel("Vista:");
		viewTypeExplanationLbl.setBounds(220, 120, 46, 14);
		contentPane.add(viewTypeExplanationLbl);
		
		viewType = new JLabel("");
		viewType.setBounds(276, 120, 126, 14);
		contentPane.add(viewType);
		
		roomTypeExplanationLbl = new JLabel("Tipo de Cuarto");
		roomTypeExplanationLbl.setBounds(10, 167, 88, 14);
		contentPane.add(roomTypeExplanationLbl);
		
		roomTypeLbl = new JLabel("");
		roomTypeLbl.setBounds(108, 167, 109, 14);
		contentPane.add(roomTypeLbl);
		
		numberOfPeopleInformationLbl = new JLabel("Cantidad de personas");
		numberOfPeopleInformationLbl.setBounds(217, 167, 148, 14);
		contentPane.add(numberOfPeopleInformationLbl);
		
		numberOfPeopleLbl = new JLabel("");
		numberOfPeopleLbl.setBounds(361, 167, 63, 14);
		contentPane.add(numberOfPeopleLbl);
		
		roomPriceInformationLbl = new JLabel("Precio");
		roomPriceInformationLbl.setBounds(10, 207, 115, 14);
		contentPane.add(roomPriceInformationLbl);
		
		roomPriceLbl = new JLabel("");
		roomPriceLbl.setBounds(171, 207, 46, 14);
		contentPane.add(roomPriceLbl);
		
		searchBtn = new JButton("Buscar");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long reservationNumber;
				try{
					reservationNumber = Long.parseLong(reservationNumberTf.getText().trim());
					loadReservation(controller.getReservation(reservationNumber));
				}catch(Exception e1){
					
				}
					
			}

		});
		searchBtn.setBounds(313, 26, 89, 23);
		contentPane.add(searchBtn);
		
		JLabel reservationExplanationLbl = new JLabel("Numero de Reserva");
		reservationExplanationLbl.setBounds(10, 30, 115, 14);
		contentPane.add(reservationExplanationLbl);
		
		reservationNumberTf = new JTextField();
		reservationNumberTf.setBounds(123, 27, 180, 20);
		contentPane.add(reservationNumberTf);
		reservationNumberTf.setColumns(10);
		
		cancelReservationBtn = new JButton("Cancelar Reserva");
		cancelReservationBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				long reservationNumber;
				try{
					reservationNumber = Long.parseLong(reservationNumberTf.getText().trim());
					controller.deleteReservation(reservationNumber);
				}catch(Exception e1){
					
				}
					
			}
		});
		cancelReservationBtn.setBounds(270, 263, 154, 23);
		contentPane.add(cancelReservationBtn);
		
		CityExplanationlbl = new JLabel("Ciudad");
		CityExplanationlbl.setBounds(220, 207, 118, 14);
		contentPane.add(CityExplanationlbl);
		
		cityLbl = new JLabel("");
		cityLbl.setBounds(345, 207, 79, 14);
		contentPane.add(cityLbl);
		
		lblCheckin = new JLabel("CheckIn");
		lblCheckin.setBounds(10, 238, 55, 14);
		contentPane.add(lblCheckin);
		
		checkInLbl = new JLabel("");
		checkInLbl.setBounds(75, 238, 118, 14);
		contentPane.add(checkInLbl);
		
		lblCheckout = new JLabel("CheckOut");
		lblCheckout.setBounds(220, 238, 68, 14);
		contentPane.add(lblCheckout);
		
		checkOutLbl = new JLabel("");
		checkOutLbl.setBounds(276, 238, 126, 14);
		contentPane.add(checkOutLbl);
		
		
	}
	
	private void loadReservation(Reservation r) {
		if(r == null){
			hotelNameLbl.setText("");
			roomNumberLbl.setText("");
			viewType.setText("");
			roomTypeLbl.setText("");
			numberOfPeopleLbl.setText("");
			roomPriceLbl.setText("");
			checkInLbl.setText("");
			checkOutLbl.setText("");
			cityLbl.setText("");
		}else{
			hotelNameLbl.setText(r.getRoom().getHotelName());
			roomNumberLbl.setText(String.valueOf(r.getRoom().getNumber()));
			viewType.setText(r.getRoom().getView().name());
			roomTypeLbl.setText(r.getRoom().getType());
			numberOfPeopleLbl.setText(String.valueOf(r.getRoom().getCapacity()));
			roomPriceLbl.setText(String.valueOf(r.getRoom().getNightCost()));
			checkInLbl.setText(CalendarTranslator.calendarToString(r.getCheckIn()));
			checkOutLbl.setText(CalendarTranslator.calendarToString(r.getCheckOut()));
			String city = controller.getHotel(r.getRoom().getHotelName()).getCity();
			cityLbl.setText(city);
		}
		
	}
}
