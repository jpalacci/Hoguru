package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.Controller;
import model.Hotel;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class JListHotelGUI extends JFrame {

	private JPanel contentPane;
	private JList<Hotel> list;
	private DefaultListModel<Hotel> listModel;
	private JScrollPane listScroller;
	private JFrame editHotelFrame;
	private final JButton Cancel = new JButton("Cancel");
	private Controller controller;
	
	public JListHotelGUI(List<Hotel> hotelList, JFrame editHotelFrame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 225);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		controller = new Controller();
		this.editHotelFrame = editHotelFrame;
		
		listModel = new DefaultListModel<Hotel>();
		for(Hotel h: hotelList){
			listModel.addElement(h);
		}
		

		listScroller = new JScrollPane();
		listScroller.setBounds(0, 182, 284, -182);
		listScroller.setPreferredSize(new Dimension(250, 80));

		
		contentPane.setLayout(null);
		contentPane.add(listScroller);
		list = new JList<Hotel>(listModel);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		list.setBounds(0, 0, 282, 161);
		contentPane.add(list);
		
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				editHotelFrame.setVisible(true);
			}
		});
		Cancel.setBounds(0, 162, 72, 24);
		contentPane.add(Cancel);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (list.getSelectedIndex() == -1) {
					 return;
			     } 
				 if(list.getSelectedValuesList().size() == 1 ){
					Hotel h = (Hotel)list.getSelectedValue();
			        JListHotelGUI.this.setVisible(false);
			        new EditHotelGUI(editHotelFrame, h);
			       
				 }
				 
	
			}
		});
		btnEdit.setBounds(108, 162, 72, 24);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (list.getSelectedIndex() == -1) {
					 return;
			     } else{			    
			    	 int[] indices = list.getSelectedIndices();
			    	 DefaultListModel<Hotel> model = (DefaultListModel<Hotel>) list.getModel();

			    	 for(int i = 0 ; i <= indices.length; i++){
						controller.deleteHotel(model.getElementAt(indices[i]-i));
						model.remove(indices[i]-i);
			    	 }
			    	
			     }
			}
		});
		btnDelete.setBounds(212, 163, 72, 24);
		contentPane.add(btnDelete);
		
	}
}
