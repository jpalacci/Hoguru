package model;

import java.util.Calendar;

public class Comment {
	private int rate;
	
	private String nombreUsuario;
	private String hotelName;
	private String comment;
	private Calendar date;
	
	public Comment(String comment , String nombreUsuario ,  int rate, Calendar date) {
		this.rate=rate;
		this.comment=comment;
		this.nombreUsuario=nombreUsuario;
		this.date=date;

		//QUERY a DATA BASE
	}
	
	public boolean delete(String nombreUsuario, String nombreHotel) {
		return true;//QUERY TO DATA BASE
	}
	
}
