package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Timer;

import Controller.Controller;

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

	public JFrame frame;
	private JTextField userTf;
	private JPasswordField passwordField;
	private Label userLbl;
	private Label passwordLbl;
	private Label registerLbl;
	private Label label_4;
	private JButton acceptBtn;
	private JLabel errorLbl;
	private Timer deleteErrorMessage;
	private Controller controller;



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
		
		controller = new Controller();
		
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
				int userType = isValid(userTf.getText() ,new String(passwordField.getPassword()));
				if(userType == 1){
					SearchHotelsGUI searchHotelsGUI = new SearchHotelsGUI();
					frame.dispose();
				}
				else if(userType == 2)
				{
					new AdministratorGUI();
					frame.dispose();
				}
				else
				{
					errorLbl.setText("El usuario es Incorrecto");
					deleteErrorMessage.start();
				}
				
			}
		});
		acceptBtn.setBounds(184, 223, 89, 23);
		frame.getContentPane().add(acceptBtn);
		
		errorLbl = new JLabel("");
		errorLbl.setForeground(Color.RED);
		errorLbl.setBounds(64, 195, 321, 14);
		frame.getContentPane().add(errorLbl);
		
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0){
            	errorLbl.setText("");
            }
        };

        deleteErrorMessage = new Timer(5000,al); // Timer(TimeInMilliSeconds, ActionListener) 1000ms = 1s 
	}
	
	public int isValid(String userName, String password){
		String trimUserName = userName.trim();
		String trimPassword = password.trim();
		if(trimUserName.equals("") && trimPassword.equals(""))
		{
			errorLbl.setText("El nombre y la contrasena no pueden estar vacios");
			deleteErrorMessage.start();
			return 0;
		}
		else if(trimUserName.equals(""))
		{
			errorLbl.setText("El nombre no pueden estar vacio");
			deleteErrorMessage.start();
			return 0;
		}
		else if(trimPassword.equals(""))
		{
			errorLbl.setText("La contrasena no pueden estar vacio");
			deleteErrorMessage.start();
			return 0;
		}
        return controller.isValidUser(trimUserName, trimPassword);
	}

	public JTextField getUserTf() {
		return userTf;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
}
