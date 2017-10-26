package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class MuchasGracias {

	private JFrame frame;
	private JLabel thanksLbl;
	private JLabel explanationLbl;
	private JButton acceptBtn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MuchasGracias window = new MuchasGracias();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MuchasGracias() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 226);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		thanksLbl = new JLabel("Muchas Gracias");
		thanksLbl.setFont(new Font("Tahoma", Font.BOLD, 22));
		thanksLbl.setBounds(125, 47, 183, 37);
		frame.getContentPane().add(thanksLbl);
		
		explanationLbl = new JLabel(" Se ha enviado un correo electronico a su mail para confirmar el registro");
		explanationLbl.setBounds(30, 95, 355, 14);
		frame.getContentPane().add(explanationLbl);
		
		acceptBtn = new JButton("Aceptar");
		acceptBtn.setBounds(175, 143, 89, 23);
		frame.getContentPane().add(acceptBtn);
	}

}
