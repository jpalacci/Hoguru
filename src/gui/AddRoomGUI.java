package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddRoomGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tipoOfRoomTf;
	private JTextField characteristicTf;
	private JLabel tipeOfRoomLbl;
	private JLabel guestNumberlbl;
	private JLabel characteristiclbl;
	private JButton viewSrvicesBtn;
	private JButton addServicesBtn;
	private JLabel bathroomTypeLbl;
	private JLabel priceLbl;
	private JButton creatRoomBtn;
	private JButton cancelBtn;
	private JLabel titleLbl;
	private JButton viewPhotosBtn;
	private JButton addPhotoBtn;
	private JComboBox guestNumberCB;
	private JComboBox bathrooTypeCb;
	private JFormattedTextField formattedTextField;
	private JFrame editRoomFrame;
	
	public AddRoomGUI(JFrame editRoomFrame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		this.editRoomFrame = editRoomFrame;
		tipeOfRoomLbl = new JLabel("Tipo de Habitacion");
		tipeOfRoomLbl.setBounds(10, 94, 98, 14);
		contentPane.add(tipeOfRoomLbl);
		
		guestNumberlbl = new JLabel("Cantidad de Huespedes");
		guestNumberlbl.setBounds(10, 129, 121, 14);
		contentPane.add(guestNumberlbl);
		
		characteristiclbl = new JLabel("Caracteristicas");
		characteristiclbl.setBounds(10, 166, 89, 14);
		contentPane.add(characteristiclbl);
		
		viewSrvicesBtn = new JButton("Ver Servicios");
		viewSrvicesBtn.setBounds(10, 233, 121, 23);
		contentPane.add(viewSrvicesBtn);
		
		addServicesBtn = new JButton("Agregar Servicio");
		addServicesBtn.setBounds(184, 233, 121, 23);
		contentPane.add(addServicesBtn);
		
		bathroomTypeLbl = new JLabel("Tipo de bano");
		bathroomTypeLbl.setBounds(10, 292, 80, 14);
		contentPane.add(bathroomTypeLbl);
		
		priceLbl = new JLabel("Precio");
		priceLbl.setBounds(10, 333, 80, 14);
		contentPane.add(priceLbl);
		
		tipoOfRoomTf = new JTextField();
		tipoOfRoomTf.setBounds(137, 91, 225, 20);
		contentPane.add(tipoOfRoomTf);
		tipoOfRoomTf.setColumns(10);
		
		characteristicTf = new JTextField();
		characteristicTf.setColumns(10);
		characteristicTf.setBounds(137, 163, 225, 59);
		contentPane.add(characteristicTf);
		
		creatRoomBtn = new JButton("Agregar Habitacion");
		creatRoomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		creatRoomBtn.setBounds(42, 458, 137, 23);
		contentPane.add(creatRoomBtn);
		
		cancelBtn = new JButton("Cancelar");
		cancelBtn.setBounds(251, 458, 121, 23);
		contentPane.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editRoomFrame.setVisible(true);
				AddRoomGUI.this.dispose();
			}
		});
		
		titleLbl = new JLabel("Datos de la Habitacion");
		titleLbl.setFont(new Font("Tahoma", Font.BOLD, 19));
		titleLbl.setBounds(10, 11, 307, 53);
		contentPane.add(titleLbl);
		
		viewPhotosBtn = new JButton("Ver Fotos");
		viewPhotosBtn.setBounds(10, 383, 121, 23);
		contentPane.add(viewPhotosBtn);
		
		addPhotoBtn = new JButton("Agregar Fotos");
		addPhotoBtn.setBounds(184, 383, 121, 23);
		contentPane.add(addPhotoBtn);
		
		guestNumberCB = new JComboBox();
		guestNumberCB.setBounds(141, 126, 221, 20);
		contentPane.add(guestNumberCB);
		
		bathrooTypeCb = new JComboBox();
		bathrooTypeCb.setBounds(137, 289, 225, 20);
		contentPane.add(bathrooTypeCb);
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(137, 330, 225, 20);
		contentPane.add(formattedTextField);
	}
}
