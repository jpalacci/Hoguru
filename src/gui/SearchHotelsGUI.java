package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;

import Controller.Controller;
import javafx.scene.control.SelectionMode;
import model.CalendarTranslator;
import model.Hotel;
import model.Person;
import model.User;

import javax.swing.JList;

public class SearchHotelsGUI extends JFrame {

	private JPanel contentPane;
	private JTextField cityTf;
	private JLabel messageLbl;
	private JLabel cityLbl;
	private JComboBox peopleCb;
	private JLabel chekInLbl;
	private JLabel checkOutLbl;
	private JLabel editUserLbl;
	private JFormattedTextField checkOutTextField;
	private JFormattedTextField checkInTextField;
	private JButton btnBuscar;
	private Controller controller;
	private User user;
	private JList<Hotel> list;
	private DefaultListModel<Hotel> listModel;
	private JScrollPane listScroller;
	private Calendar checkIn;
	private Calendar checkOut;


	public JTextField getCityTf() {
		return cityTf;
	}

	public JComboBox getPeopleCb() {
		return peopleCb;
	}

	public JFormattedTextField getCheckOutTextField() {
		return checkOutTextField;
	}

	public JFormattedTextField getCheckInTextField() {
		return checkInTextField;
	}

	public SearchHotelsGUI() {
		controller = new Controller();
		user = controller.getActivePerson();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		setResizable(false);
		contentPane.setLayout(null);
		
		messageLbl = new JLabel("Busca las mejores ofertas online:");
		messageLbl.setBounds(10, 60, 204, 14);
		contentPane.add(messageLbl);
		
		cityLbl = new JLabel("Ciudad:");
		cityLbl.setBounds(10, 114, 46, 14);
		contentPane.add(cityLbl);
		
		cityTf = new JTextField();
		cityTf.setBounds(64, 111, 158, 20);
		contentPane.add(cityTf);
		cityTf.setColumns(10);
		
		peopleCb = new JComboBox(new Integer[] {1,2,3,4,5,6,7});
		peopleCb.setBounds(318, 111, 153, 20);
		peopleCb.setRenderer(new MyComboBoxRenderer("Cantidad de Personas"));
		peopleCb.setSelectedIndex(-1);
		contentPane.add(peopleCb);
		
		chekInLbl = new JLabel("Check-In");
		chekInLbl.setBounds(10, 153, 91, 14);
		contentPane.add(chekInLbl);
		
		checkOutLbl = new JLabel("Check-Out");
		checkOutLbl.setBounds(239, 153, 61, 14);
		contentPane.add(checkOutLbl);
		
		editUserLbl = new JLabel("Edit User");
		editUserLbl.setBounds(448, 13, 74, 29);
		editUserLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(editUserLbl);
		
		
		MaskFormatter dateMask = null;
        try {
          
            dateMask = new MaskFormatter("##/##/####");
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		checkInTextField = new JFormattedTextField();
		checkInTextField.setBounds(87, 150, 124, 20);
		contentPane.add(checkInTextField);
		
		checkOutTextField = new JFormattedTextField();
		checkOutTextField.setBounds(319, 150, 124, 20);
		contentPane.add(checkOutTextField);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(453, 144, 89, 23);
		contentPane.add(btnBuscar);
		
		listModel = new DefaultListModel<Hotel>();
		

		listScroller = new JScrollPane();
		listScroller.setBounds(0, 182, 284, -182);
		listScroller.setPreferredSize(new Dimension(250, 80));
		contentPane.add(listScroller);
		
		list = new JList<Hotel>(listModel);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		list.setVisibleRowCount(-1);
		list.setBounds(10, 180, 532, 208);
		contentPane.add(list);
		list.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()){
				      if(list.getSelectedIndex()>-1){
				    	  if(listModel.isEmpty()){
								return;
							}
							Hotel selectedHotel = listModel.get(e.getFirstIndex());
							new JListRoomResultsGUI(selectedHotel,checkIn, checkOut,cityTf.getText().trim(), (Integer) peopleCb.getSelectedItem(),user.getUserName()  );
							list.clearSelection();
				      	}
				      }
				    }
			
		});
		contentPane.add(list);
		
		JButton reservationButton = new JButton("Buscar Reserva");
		reservationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReservationDisplayGUI();
			}
		});
		reservationButton.setBounds(389, 56, 153, 23);
		contentPane.add(reservationButton);
		
		btnBuscar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				checkIn = CalendarTranslator.stringToCalendar(checkInTextField.getText().trim());
				checkOut = CalendarTranslator.stringToCalendar(checkOutTextField.getText().trim());
				if(checkIn == null || checkOut == null){
					listModel.clear();
					return;
				}
				List<Hotel> hotelList = controller.getAvaillableHotels(cityTf.getText().trim(), checkIn, checkOut, (Integer) peopleCb.getSelectedItem());
				listModel.clear();
				for(Hotel h: hotelList){
					listModel.addElement(h);
				}
				list.setModel(listModel);
			}

		
		});
		
		editUserLbl.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EditUserGUI(SearchHotelsGUI.this, SearchHotelsGUI.this.user);
				SearchHotelsGUI.this.setVisible(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

        });


		
	}
}
