package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Label;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class LoginGUI {

	private JFrame frame;
	private JTextField userTf;
	private JPasswordField passwordField;
	private Label userLbl;
	private Label passwordLbl;
	private Label registerLbl;
	private Label label_4;
	private JButton acceptBtn;
	private JLabel errorLbl;
	private Timer deleteErrorMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
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
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 316);
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
		registerLbl.setBounds(184, 252, 89, 22);
		frame.getContentPane().add(registerLbl);
		registerLbl.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new RegisterGUI(frame);
				frame.setVisible(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

        });
		
		label_4 = new Label("Hoguru");
		label_4.setBounds(174, 39, 62, 22);
		frame.getContentPane().add(label_4);
		
		acceptBtn = new JButton("Aceptar");
		acceptBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isValid(userTf.getText() ,passwordField.getPassword().toString())){
					SearchGUI searchGUI = new SearchGUI();
					frame.dispose();
				}
			}
		});
		acceptBtn.setBounds(184, 223, 89, 23);
		frame.getContentPane().add(acceptBtn);
		
		errorLbl = new JLabel("");
		errorLbl.setForeground(Color.RED);
		errorLbl.setBounds(137, 195, 184, 14);
		frame.getContentPane().add(errorLbl);
	}
	
	private boolean isValid(String userName, String password){
		String trimUserName = userName.trim();
		String trimPassword = password.trim();
		if(trimUserName.equals("") || trimPassword.equals(""))
		{
			errorLbl.setText("El nombre y la contrasena no Pueden estar vacios");;
			return false;
		}
		return true;
	}
}
