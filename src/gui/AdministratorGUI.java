package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class AdministratorGUI extends JFrame {

	private JPanel contentPane;

	
	public AdministratorGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAgregarHotel = new JButton("Agregar Hotel");
		btnAgregarHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddHotelGUI(AdministratorGUI.this);
				AdministratorGUI.this.setVisible(false);
			}
		});
		btnAgregarHotel.setBounds(35, 100, 126, 23);
		contentPane.add(btnAgregarHotel);
		
		JButton btnEditarHotel = new JButton("Editar Hotel");
		btnEditarHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditHotelGUI(AdministratorGUI.this);
				AdministratorGUI.this.setVisible(false);
			}
		});
		btnEditarHotel.setBounds(213, 100, 126, 23);
		contentPane.add(btnEditarHotel);
		
		JLabel lblBienvenidoAdministrador = new JLabel("Bienvenido Administrador");
		lblBienvenidoAdministrador.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblBienvenidoAdministrador.setBounds(35, 28, 422, 47);
		contentPane.add(lblBienvenidoAdministrador);
		setVisible(true);
	}
}
