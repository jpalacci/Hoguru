package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Label;
import java.awt.Button;
import javax.swing.JButton;

public class Login {

	private JFrame frame;
	private JTextField userTf;
	private JPasswordField passwordField;
	private Label userLbl;
	private Label passwordLbl;
	private Label registerLbl;
	private Label label_4;
	private JButton acceptBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		userTf = new JTextField();
		userTf.setBounds(137, 113, 184, 20);
		frame.getContentPane().add(userTf);
		userTf.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(137, 164, 184, 20);
		frame.getContentPane().add(passwordField);
		
		userLbl = new Label("Usuario");
		userLbl.setBounds(31, 113, 62, 22);
		frame.getContentPane().add(userLbl);
		
		passwordLbl = new Label("Contrasena");
		passwordLbl.setBounds(31, 164, 62, 22);
		frame.getContentPane().add(passwordLbl);
		
		registerLbl = new Label("Registrate");
		registerLbl.setAlignment(Label.CENTER);
		registerLbl.setBounds(184, 229, 89, 22);
		frame.getContentPane().add(registerLbl);
		
		label_4 = new Label("Hoguru");
		label_4.setBounds(174, 39, 62, 22);
		frame.getContentPane().add(label_4);
		
		acceptBtn = new JButton("Aceptar");
		acceptBtn.setBounds(184, 195, 89, 23);
		frame.getContentPane().add(acceptBtn);
	}
}
