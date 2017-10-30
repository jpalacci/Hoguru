package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditHotelGUI extends JFrame {

	private JPanel contentPane;
	private JTextField cityTf;
	private JTextField hotelNameTf;
	private JTextField directionTf;
	private JTextField starTf;
	private JTextField recreationTf;
	private JTextField textField_6;
	private JLabel cityLbl;
	private JLabel hotelNameLbl;
	private JLabel directionLbl;
	private JLabel starsLbl;
	private JButton viewServicesBtn;
	private JButton addServiceBtn;
	private JLabel recreationLbl;
	private JLabel lblParticularidades;
	private JButton changeHotelBtn;
	private JButton cancelBtn;
	private JLabel lblDatosDelHotel;
	private JButton viewPhotoBtn;
	private JButton addPhotoBtn;
	private JFrame administratorFrame;
	private JButton btnAgregarHabitacion;
	private JButton btnEditarHabitacion;
	
	public EditHotelGUI(JFrame administratorFrame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		this.administratorFrame = administratorFrame;
		cityLbl = new JLabel("Ciudad:");
		cityLbl.setBounds(10, 94, 46, 14);
		contentPane.add(cityLbl);
		
		hotelNameLbl = new JLabel("Nombre del Hotel");
		hotelNameLbl.setBounds(10, 129, 98, 14);
		contentPane.add(hotelNameLbl);
		
		directionLbl = new JLabel("Direccion");
		directionLbl.setBounds(10, 166, 46, 14);
		contentPane.add(directionLbl);
		
		starsLbl = new JLabel("Cantidad de Estrellas");
		starsLbl.setBounds(10, 205, 111, 14);
		contentPane.add(starsLbl);
		
		viewServicesBtn = new JButton("Ver Servicios");
		viewServicesBtn.setBounds(10, 262, 121, 23);
		contentPane.add(viewServicesBtn);
		
		addServiceBtn = new JButton("Agregar Servicio");
		addServiceBtn.setBounds(215, 262, 125, 23);
		contentPane.add(addServiceBtn);
		
		recreationLbl = new JLabel("Recreacion");
		recreationLbl.setBounds(10, 326, 80, 14);
		contentPane.add(recreationLbl);
		
		lblParticularidades = new JLabel("Particularidades");
		lblParticularidades.setBounds(10, 362, 80, 14);
		contentPane.add(lblParticularidades);
		
		cityTf = new JTextField();
		cityTf.setBounds(137, 91, 225, 20);
		contentPane.add(cityTf);
		cityTf.setColumns(10);
		
		hotelNameTf = new JTextField();
		hotelNameTf.setColumns(10);
		hotelNameTf.setBounds(137, 126, 225, 20);
		contentPane.add(hotelNameTf);
		
		directionTf = new JTextField();
		directionTf.setColumns(10);
		directionTf.setBounds(137, 163, 225, 20);
		contentPane.add(directionTf);
		
		starTf = new JTextField();
		starTf.setColumns(10);
		starTf.setBounds(137, 202, 225, 20);
		contentPane.add(starTf);
		
		recreationTf = new JTextField();
		recreationTf.setColumns(10);
		recreationTf.setBounds(137, 323, 225, 20);
		contentPane.add(recreationTf);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(137, 359, 225, 20);
		contentPane.add(textField_6);
		
		changeHotelBtn = new JButton("Modificar Hotel");
		changeHotelBtn.setBounds(57, 458, 121, 23);
		contentPane.add(changeHotelBtn);
		
		cancelBtn = new JButton("Cancelar");
		cancelBtn.setBounds(229, 458, 111, 23);
		contentPane.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administratorFrame.setVisible(true);
				EditHotelGUI.this.dispose();
			}
		});
		
		lblDatosDelHotel = new JLabel("Datos del Hotel");
		lblDatosDelHotel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDatosDelHotel.setBounds(10, 11, 168, 53);
		contentPane.add(lblDatosDelHotel);
		
		viewPhotoBtn = new JButton("Ver Fotos");
		viewPhotoBtn.setBounds(10, 409, 121, 23);
		contentPane.add(viewPhotoBtn);
		
		addPhotoBtn = new JButton("Agregar Fotos");
		addPhotoBtn.setBounds(184, 409, 121, 23);
		contentPane.add(addPhotoBtn);
		
		btnAgregarHabitacion = new JButton("Agregar Habitacion");
		btnAgregarHabitacion.setBounds(215, 289, 125, 23);
		contentPane.add(btnAgregarHabitacion);
		btnAgregarHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditHotelGUI.this.setVisible(false);
				new AddRoomGUI(EditHotelGUI.this);
			}
		});

		
		btnEditarHabitacion = new JButton("Editar Habitacion");
		btnEditarHabitacion.setBounds(10, 292, 125, 23);
		contentPane.add(btnEditarHabitacion);
		btnEditarHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditHotelGUI.this.setVisible(false);
				new EditRoomGUI(EditHotelGUI.this);
			}
		});
		
	}

}
