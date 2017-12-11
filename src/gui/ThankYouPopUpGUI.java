package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ThankYouPopUpGUI {

	private JFrame frame;
	private JLabel thanksLbl;
	private JLabel explanationLbl;
	private JButton acceptBtn;

	public ThankYouPopUpGUI(long reservationCode) {
		initialize(reservationCode);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(long reservationCode) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 226);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		thanksLbl = new JLabel("Muchas Gracias");
		thanksLbl.setFont(new Font("Tahoma", Font.BOLD, 22));
		thanksLbl.setBounds(125, 47, 183, 37);
		frame.getContentPane().add(thanksLbl);
		
		explanationLbl = new JLabel("Se ha enviado un correo electronico a su mail para confirmar la reserva nro: " + String.valueOf(reservationCode));
		explanationLbl.setBounds(30, 95, 355, 14);
		frame.getContentPane().add(explanationLbl);
		
		acceptBtn = new JButton("Aceptar");
		acceptBtn.setBounds(175, 143, 89, 23);
		frame.getContentPane().add(acceptBtn);
		acceptBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}	
		});
	}

}
