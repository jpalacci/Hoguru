package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import model.Hotel;
import model.Room;
import model.VIEW_TYPE;

import javax.swing.JFormattedTextField;

public class EditRoomGUI extends JFrame {
	private JPanel contentPane;
	private JLabel tipeOfRoomLbl;
	private JLabel guestNumberlbl;
	private JButton creatRoomBtn;
	private JButton cancelBtn;
	private JLabel titleLbl;
	private JComboBox<Integer> guestNumberCB;
	private JFormattedTextField roomNumberFT;
	private JFrame editHotelFrame;
	private JLabel errorLbl;
	private Timer deleteErrorMessage;
	private Controller controller;
	private JComboBox<VIEW_TYPE> viewTypeCB;
	private Hotel hotel;
	private Room room;
	private JComboBox<String> roomTypeCb;
	
	public EditRoomGUI(JFrame editHotelFrame, Hotel hotel, Room room) {
		controller = new Controller();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		this.editHotelFrame = editHotelFrame;
		tipeOfRoomLbl = new JLabel("Tipo de Habitacion");
		tipeOfRoomLbl.setBounds(10, 94, 98, 14);
		contentPane.add(tipeOfRoomLbl);
		
		this.hotel = hotel;
		this.room = room;
		
		guestNumberlbl = new JLabel("Cantidad de Huespedes");
		guestNumberlbl.setBounds(10, 129, 121, 14);
		contentPane.add(guestNumberlbl);
		
		creatRoomBtn = new JButton("Agregar Habitacion");
		creatRoomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isRoomValid()){
					editHotelFrame.setVisible(true);
					new ThankYouPopUpGUI();
				 EditRoomGUI.this.dispose();
				}
			}
		});
		creatRoomBtn.setBounds(40, 272, 137, 23);
		contentPane.add(creatRoomBtn);
		
		cancelBtn = new JButton("Cancelar");
		cancelBtn.setBounds(209, 272, 121, 23);
		contentPane.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editHotelFrame.setVisible(true);
				EditRoomGUI.this.dispose();
			}
		});
		
		titleLbl = new JLabel("Datos de la Habitacion");
		titleLbl.setFont(new Font("Tahoma", Font.BOLD, 19));
		titleLbl.setBounds(10, 11, 307, 53);
		contentPane.add(titleLbl);
		
		guestNumberCB = new JComboBox<Integer>();
		for(int i = 0; i<10 ; i++){
			guestNumberCB.addItem(i);
		}
		guestNumberCB.setBounds(141, 126, 221, 20);
		contentPane.add(guestNumberCB);
		
		roomNumberFT = new JFormattedTextField();
		roomNumberFT.setBounds(137, 214, 225, 20);
		contentPane.add(roomNumberFT);
		
		errorLbl = new JLabel("");
		errorLbl.setForeground(Color.RED);
		errorLbl.setBounds(40, 247, 46, 14);
		contentPane.add(errorLbl);
		
		JLabel viewTypeLbl = new JLabel("Vista");
		viewTypeLbl.setBounds(10, 173, 121, 14);
		contentPane.add(viewTypeLbl);
		
		//viewTypeCB = new JComboBox<VIEW_TYPE>();
		viewTypeCB = new JComboBox<VIEW_TYPE>(VIEW_TYPE.values());

		viewTypeCB.setBounds(141, 170, 221, 20);
		contentPane.add(viewTypeCB);
		
		JLabel roomNumberLbl = new JLabel("Numero de Cuarto");
		roomNumberLbl.setBounds(10, 217, 121, 14);
		contentPane.add(roomNumberLbl);
		
		List<String> roomType = controller.getRoomTypes(hotel.getName()); 
		roomTypeCb = new JComboBox<String>();
		for(String typeName: roomType){
			roomTypeCb.addItem(typeName);
		}
		roomTypeCb.setBounds(141, 91, 221, 20);
		contentPane.add(roomTypeCb);
		
		 ActionListener al = new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent arg0){
	            	errorLbl.setText("");
	            	roomTypeCb.setBorder(BorderFactory.createLineBorder(Color.black));
	            	guestNumberCB.setBorder(BorderFactory.createLineBorder(Color.black));
	            	roomNumberFT.setBorder(BorderFactory.createLineBorder(Color.black));
	            }
	        };

	     deleteErrorMessage = new Timer(5000,al); // Timer(TimeInMilliSeconds, ActionListener) 1000ms = 1s 
	     loadRoom();
	}
	
	
	private void loadRoom() {
		guestNumberCB.setSelectedItem(room.getCapacity());
		viewTypeCB.setSelectedItem(room.getView());
		roomNumberFT.setText(String.valueOf(room.getNumber()));
	}


	protected boolean isRoomValid(){
		String tipeOfRoom = (String) roomTypeCb.getSelectedItem();
		Integer getNumber = (Integer) guestNumberCB.getSelectedItem();
		VIEW_TYPE viewType = (VIEW_TYPE) viewTypeCB.getSelectedItem();
		String room = roomNumberFT.getText();
		Integer roomNumber;
		boolean error = false;
		
		if(tipeOfRoom.equals(""))
		{
			roomTypeCb.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(getNumber.equals(0))
		{
			guestNumberCB.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(viewType.equals(""))
		{
			viewTypeCB.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(room.equals(""))
		{
			viewTypeCB.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		
		if(error)
		{
			errorLbl.setText("Complete los campos en rojo");
			deleteErrorMessage.start();
			return error;
		}
		try{
			roomNumber = Integer.parseInt(room);
		}catch(Exception e){
			errorLbl.setText("Ponga un numero valido como numero de la habitacion");
			deleteErrorMessage.start();
			return false;
		}
		
		return controller.isValidRoom(hotel,tipeOfRoom,viewType,roomNumber,getNumber,false);
	}

	

	public JComboBox getGuestNumberCB() {
		return guestNumberCB;
	}

	public void setGuestNumberCB(JComboBox guestNumberCB) {
		this.guestNumberCB = guestNumberCB;
	}

	public JFormattedTextField getFormattedTextField() {
		return roomNumberFT;
	}

}
