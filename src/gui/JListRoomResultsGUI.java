package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.Controller;
import model.Hotel;
import model.Room;

public class JListRoomResultsGUI extends JFrame  {
	private JPanel contentPane;
	private JList<Room> list;
	private DefaultListModel<Room> listModel;
	private JScrollPane listScroller;
	Controller controller;
	List<Room> roomList;
	
	public JListRoomResultsGUI(Hotel hotel, Calendar checkIn,Calendar checkOut, String city , int numberOfPeople, String userName) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 304, 225);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		controller = new Controller();
		
		roomList = controller.getAvaillableRoomsForHotel(hotel.getName(), city, checkIn, checkOut, numberOfPeople);
		
		listModel = new DefaultListModel<Room>();
		for(Room r: roomList){
			listModel.addElement(r);
		}
		
		
		listScroller = new JScrollPane();
		listScroller.setBounds(100, 100, 304, 225);
		listScroller.setPreferredSize(new Dimension(250, 80));

		
		contentPane.setLayout(null);
		contentPane.add(listScroller);
		list = new JList<Room>(listModel);
		list.setBounds(0, 0, 282, 157);
		contentPane.add(list);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		list.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				Room selectedRoom =listModel.getElementAt(e.getFirstIndex()); 
				new RoomDisplayGUI(selectedRoom, checkIn, checkOut, city, numberOfPeople, userName);
			}
			
		});
	
	}
}
