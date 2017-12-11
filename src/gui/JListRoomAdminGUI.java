package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.Controller;
import model.Hotel;
import model.Room;

public class JListRoomAdminGUI extends JFrame {
	private JPanel contentPane;
	private JList list;
	private DefaultListModel<Room> listModel;
	private JScrollPane listScroller;
	private JFrame hotelFrame;
	private Hotel hotel;
	Controller controller;
	
	public JListRoomAdminGUI(List<Room> roomList, Hotel hotel, JFrame hotelFrame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 225);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		controller = new Controller();
		this.hotelFrame = hotelFrame;
		this.hotel = hotel;
		
		listModel = new DefaultListModel<Room>();
		for(Room r: roomList){
			listModel.addElement(r);
		}
		

		listScroller = new JScrollPane();
		listScroller.setBounds(0, 182, 284, -182);
		listScroller.setPreferredSize(new Dimension(250, 80));

		
		contentPane.setLayout(null);
		contentPane.add(listScroller);
		list = new JList<Room>(listModel);
		list.setBounds(0, 0, 282, 157);
		contentPane.add(list);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		JButton Cancel = new JButton("Cancel");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				hotelFrame.setVisible(true);
			}
		});
		Cancel.setBounds(0, 162, 87, 24);
		contentPane.add(Cancel);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (list.getSelectedIndex() == -1) {
					 return;
			     } 
				 if(list.getSelectedValuesList().size() == 1 ){
					Room r = (Room)list.getSelectedValue();
			        JListRoomAdminGUI.this.setVisible(false);
			        new EditRoomGUI(hotelFrame, hotel, r);
			       
				 }
				 
	
			}
		});
		btnEdit.setBounds(97, 162, 92, 24);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (list.getSelectedIndex() == -1) {
					 return;
			     } else{
			    	 int[] indices = list.getSelectedIndices();
			    	 DefaultListModel<Room> model = (DefaultListModel<Room>) list.getModel();

			    	 for(int i = 0 ; i <= indices.length; i++){
						controller.deleteRoom(model.getElementAt(indices[i]-i));
						model.remove(indices[i]-i);
			    	 }
			    	
			     }
			}
		});
		btnDelete.setBounds(199, 163, 85, 24);
		contentPane.add(btnDelete);
		
	}
}
