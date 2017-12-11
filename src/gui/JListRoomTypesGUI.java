package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import model.Hotel;
import model.Room;
import model.RoomType;

public class JListRoomTypesGUI extends JFrame {

	private JPanel contentPane;
	private JList list;
	private DefaultListModel<String> listModel;
	private JScrollPane listScroller;
	private JFrame hotelFrame;
	private Hotel hotel;
	private Controller controller;
	private List<String> roomTypes;
	
	public JListRoomTypesGUI(Hotel hotel, JFrame hotelFrame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 225);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		controller = new Controller();
		this.hotelFrame = hotelFrame;
		this.hotel = hotel;
		
		listModel = new DefaultListModel<String>();

		roomTypes = controller.getRoomTypes(hotel.getName());
		
		for(String roomType: roomTypes){
			listModel.addElement(roomType);
		}
		

		listScroller = new JScrollPane();
		listScroller.setBounds(0, 182, 284, -182);
		listScroller.setPreferredSize(new Dimension(250, 80));

		
		contentPane.setLayout(null);
		contentPane.add(listScroller);
		list = new JList<String>(listModel);
		list.setBounds(0, 0, 282, 157);
		contentPane.add(list);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		
		JButton Cancel = new JButton("Cancelar");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hotelFrame.setVisible(true);
				dispose();
			}
		});
		Cancel.setBounds(0, 162, 93, 24);
		contentPane.add(Cancel);
		
		
		JButton btnDelete = new JButton("Borrar");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (list.getSelectedIndex() == -1) {
					 return;
			     } else{
			    	 int[] indices = list.getSelectedIndices();
			    	 DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();

			    	 for(int i = 0 ; i < indices.length; i++){
						controller.deleteRoomTypeFromHotel(hotel.getName(), model.getElementAt(indices[i]-i));
						model.remove(indices[i]-i);
			    	 }
			    	
			     }
			}
		});
		btnDelete.setBounds(198, 163, 86, 24);
		contentPane.add(btnDelete);
		
	}
}
