package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class viewCommentsGUI extends JFrame {

	private JPanel contentPane;
	private Controller controller = new Controller();
	
	public viewCommentsGUI(String hotelName) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		setResizable(false);
		JTextArea commentViewrTa = new JTextArea();
		commentViewrTa.setBounds(0, 29, 434, 232);
		contentPane.add(commentViewrTa);
		
		JLabel hotelNameLbl = new JLabel("");
		hotelNameLbl.setBounds(0, 11, 46, 14);
		contentPane.add(hotelNameLbl);
		
		loadComments(hotelName);
		
	}

	private void loadComments(String hotelName) {
		
		//controller.getComment(hotelName);
	}
}
