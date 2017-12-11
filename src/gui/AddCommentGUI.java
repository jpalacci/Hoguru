package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class AddCommentGUI extends JFrame {

	private JPanel contentPane;
	private final JButton addBtn = new JButton("Agregar");
	Controller controller = new Controller();
	
	public AddCommentGUI(String hotelName, String userName) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JTextArea commentTa = new JTextArea();
		commentTa.setBounds(0, 25, 434, 119);
		contentPane.add(commentTa);
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar today = Calendar.getInstance();
				String comment = commentTa.getText().trim();
				if(comment.equals("")){
					return;
				}
				controller.addComment(comment, userName, today, hotelName);
			}
		});
		addBtn.setBounds(304, 155, 120, 31);
		contentPane.add(addBtn);
		
		JLabel writeComentLbl = new JLabel("Escriba un Comentario:");
		writeComentLbl.setBounds(0, 0, 161, 14);
		contentPane.add(writeComentLbl);
	}
}
