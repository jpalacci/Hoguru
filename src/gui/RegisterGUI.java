package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class RegisterGUI {

	private JFrame frame;
	private JFrame loginFrame;
	private JTextField mailTf;
	private JTextField nameTf;
	private JTextField lastNameTf;
	private JTextField placeTf;
	private JTextField streetTf;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirmationField;
	private JLabel lblCompletaLosSiguientes;
	private JLabel mailLbl;
	private JLabel label;
	private JLabel passwordLbl;
	private JLabel passwordConfirmationLbl;
	private JLabel nameLbl;
	private JLabel lastNameLbl;
	private JLabel documentNumberLbl;
	private JComboBox documentTypeCb;
	private JComboBox provinceCb;
	private JComboBox countryCb;
	private JLabel placeLbl;
	private JLabel numberLbl;
	private JLabel streetLbl;
	private JLabel postCodeLbl;
	private JLabel telephoneLbl;
	private JCheckBox acceptConditionChckbx;
	private JButton acceptBtn;
	private JButton cancelBtn;
	private JFormattedTextField DocumentNumberFtf;
	private JFormattedTextField numberFtf;
	private JFormattedTextField postCodeFtf;
	private JFormattedTextField telephoneFtf;
	private JLabel errorLbl;
	private Timer deleteErrorMessage;

	/**
	 * Create the application.
	 */
	public RegisterGUI(JFrame loginFrame) {
		this.loginFrame = loginFrame;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 523, 552);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		lblCompletaLosSiguientes = new JLabel("Completa los siguientes campos para registrarse");
		lblCompletaLosSiguientes.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCompletaLosSiguientes.setBounds(10, 11, 414, 29);
		frame.getContentPane().add(lblCompletaLosSiguientes);
		
		mailLbl = new JLabel("Mail");
		mailLbl.setBounds(10, 70, 46, 14);
		frame.getContentPane().add(mailLbl);
		
		label = new JLabel("Mail");
		label.setBounds(10, 70, 46, 14);
		frame.getContentPane().add(label);
		
		passwordLbl = new JLabel("Contrasena");
		passwordLbl.setBounds(10, 99, 68, 14);
		frame.getContentPane().add(passwordLbl);
		
		passwordConfirmationLbl = new JLabel("Confirmar contrasena");
		passwordConfirmationLbl.setBounds(10, 130, 141, 14);
		frame.getContentPane().add(passwordConfirmationLbl);
		
		nameLbl = new JLabel("Nombre");
		nameLbl.setBounds(10, 161, 46, 14);
		frame.getContentPane().add(nameLbl);
		
		lastNameLbl = new JLabel("Apellido");
		lastNameLbl.setBounds(10, 197, 46, 14);
		frame.getContentPane().add(lastNameLbl);
		
		documentNumberLbl = new JLabel("Numero de documento");
		documentNumberLbl.setBounds(10, 231, 141, 14);
		frame.getContentPane().add(documentNumberLbl);
		
		mailTf = new JTextField();
		mailTf.setBackground(Color.WHITE);
		mailTf.setForeground(Color.BLACK);
		mailTf.setBounds(175, 67, 285, 20);
		frame.getContentPane().add(mailTf);
		mailTf.setColumns(10);
		
		nameTf = new JTextField();
		nameTf.setColumns(10);
		nameTf.setBounds(175, 158, 285, 20);
		frame.getContentPane().add(nameTf);
		
		lastNameTf = new JTextField();
		lastNameTf.setColumns(10);
		lastNameTf.setBounds(175, 194, 285, 20);
		frame.getContentPane().add(lastNameTf);
		
		documentTypeCb = new JComboBox();
		documentTypeCb.setToolTipText("Tipo");
		documentTypeCb.setModel(new DefaultComboBoxModel(new String[] {"DNI", "Pasaporte"}));
		documentTypeCb.setBounds(319, 228, 141, 20);
		frame.getContentPane().add(documentTypeCb);
		
		provinceCb = new JComboBox();
		provinceCb.setModel(new DefaultComboBoxModel(new String[] {"Provincia"}));
		provinceCb.setBounds(175, 269, 134, 20);
		frame.getContentPane().add(provinceCb);
		
		countryCb = new JComboBox();
		countryCb.setModel(new DefaultComboBoxModel(new String[] {"Pais"}));
		countryCb.setBounds(319, 269, 141, 20);
		frame.getContentPane().add(countryCb);
		
		placeLbl = new JLabel("Localidad");
		placeLbl.setBounds(10, 303, 81, 14);
		frame.getContentPane().add(placeLbl);
		
		placeTf = new JTextField();
		placeTf.setColumns(10);
		placeTf.setBounds(175, 300, 285, 20);
		frame.getContentPane().add(placeTf);
		
		streetLbl = new JLabel("Calle");
		streetLbl.setBounds(10, 336, 46, 14);
		frame.getContentPane().add(streetLbl);
		
		streetTf = new JTextField();
		streetTf.setColumns(10);
		streetTf.setBounds(66, 333, 134, 20);
		frame.getContentPane().add(streetTf);
		
		numberLbl = new JLabel("Numero");
		numberLbl.setBounds(210, 336, 46, 14);
		frame.getContentPane().add(numberLbl);
		
		postCodeLbl = new JLabel("<html>codigo<br> postal</html>");
		postCodeLbl.setBounds(335, 331, 46, 30);
		frame.getContentPane().add(postCodeLbl);
		
		telephoneLbl = new JLabel("Telefono");
		telephoneLbl.setBounds(10, 380, 81, 14);
		frame.getContentPane().add(telephoneLbl);
		
		acceptConditionChckbx = new JCheckBox("Acepto los terminos y condiciones");
		acceptConditionChckbx.setBounds(195, 449, 194, 23);
		frame.getContentPane().add(acceptConditionChckbx);
		
		acceptBtn = new JButton("Aceptar");
		acceptBtn.setBounds(141, 479, 89, 23);
		frame.getContentPane().add(acceptBtn);
		acceptBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isRegistrationValid()){
					sendRegistration();
					loginFrame.setVisible(true);
					new ThankYouPopUpGUI();
					frame.dispose();
				}
			}
		});
		
		cancelBtn = new JButton("Cancelar");
		cancelBtn.setBounds(335, 479, 89, 23);
		frame.getContentPane().add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				loginFrame.setVisible(true);
				frame.dispose();
			}
		});
		
		MaskFormatter phoneMask = null;
        try {
          
            phoneMask = new MaskFormatter("## ####-####");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        MaskFormatter numberMask = null;
        try {
          
            numberMask = new MaskFormatter("####");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        MaskFormatter DNIMask = null;
        try {
          
            DNIMask = new MaskFormatter("##########");
        } catch (ParseException e) {
            e.printStackTrace();
        }


		
		DocumentNumberFtf = new JFormattedTextField(DNIMask);
		DocumentNumberFtf.setBounds(175, 228, 132, 20);
		frame.getContentPane().add(DocumentNumberFtf);
		
		numberFtf = new JFormattedTextField(numberMask);
		numberFtf.setBounds(266, 333, 59, 20);
		frame.getContentPane().add(numberFtf);
		
		postCodeFtf = new JFormattedTextField(numberMask);
		postCodeFtf.setBounds(390, 333, 70, 20);
		frame.getContentPane().add(postCodeFtf);
		
		telephoneFtf = new JFormattedTextField(phoneMask);
		telephoneFtf.setBounds(139, 377, 285, 20);
		frame.getContentPane().add(telephoneFtf);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(175, 96, 285, 20);
		frame.getContentPane().add(passwordField);
		
		passwordConfirmationField = new JPasswordField();
		passwordConfirmationField.setBounds(175, 127, 285, 20);
		frame.getContentPane().add(passwordConfirmationField);
		
		errorLbl = new JLabel("");
		errorLbl.setHorizontalAlignment(SwingConstants.CENTER);
		errorLbl.setForeground(Color.RED);
		errorLbl.setBounds(141, 420, 283, 14);
		frame.getContentPane().add(errorLbl);
		
		 ActionListener al = new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent arg0){
	            	errorLbl.setText("");
	            	mailTf.setBorder(BorderFactory.createLineBorder(Color.black));
	            	passwordField.setBorder(BorderFactory.createLineBorder(Color.black));
	            	nameTf.setBorder(BorderFactory.createLineBorder(Color.black));
	            	lastNameTf.setBorder(BorderFactory.createLineBorder(Color.black));
	            	DocumentNumberFtf.setBorder(BorderFactory.createLineBorder(Color.black));
	            	passwordConfirmationField.setBorder(BorderFactory.createLineBorder(Color.black));
	            	telephoneFtf.setBorder(BorderFactory.createLineBorder(Color.black));
	            }
	        };

	     deleteErrorMessage = new Timer(5000,al); // Timer(TimeInMilliSeconds, ActionListener) 1000ms = 1s 
	}

	protected void sendRegistration() {
		// TODO Auto-generated method stub
		
	}

	protected boolean isRegistrationValid() {
		String mail = mailTf.getText().trim();
		String password1 = new String(passwordField.getPassword()).trim();
		String password2 = new String(passwordConfirmationField.getPassword()).trim();
		String name = nameTf.getText().trim();
		String lastName = lastNameTf.getText().trim();
		String documentNumber = DocumentNumberFtf.getText().trim();
		String telephone = telephoneFtf.getText().trim();
		
		Boolean error = false;
		
		if(mail.equals(""))
		{
			mailTf.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(password1.equals(""))
		{
			passwordField.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(password2.equals(""))
		{
			passwordConfirmationField.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(name.equals(""))
		{
			nameTf.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(telephone.equals(""))
		{
			telephoneFtf.setBorder(BorderFactory.createLineBorder(Color.red));
		}
		if(lastName.equals(""))
		{
			lastNameTf.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}

		if(documentNumber.equals(""))
		{
			DocumentNumberFtf.setBorder(BorderFactory.createLineBorder(Color.red));
			error = true;
		}
		if(!password1.equals(password2))
		{
			error = true;
		}
		if(error)
		{
			errorLbl.setText("Complete los campos en rojo");
			deleteErrorMessage.start();
		}
		
		return !error;
	}
}
