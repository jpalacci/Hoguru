package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Hotel;

import javax.swing.JList;


public class JListHotelGUI extends JFrame {

	private JPanel contentPane;
	private JList list;
	private DefaultListModel<Hotel> listModel;
	private JScrollPane listScroller;
	private JFrame editHotelFrame;
	public JListHotelGUI(List<Hotel> hotelList, JFrame editHotelFrame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 225);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
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
		list.setBounds(0, 0, 282, 186);
		contentPane.add(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		list.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false) {

			        if (list.getSelectedIndex() == -1) {

			        } else {
			        	Hotel h = (Hotel)list.getSelectedValue();
			        	JListHotelGUI.this.setVisible(false);
			        	new EditHotelGUI(editHotelFrame, h);
			        }
			    }
			}
			
		});
	}
}
