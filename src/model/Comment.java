package model;

import java.util.Calendar;

public class Comment {
	
	private String nombreUsuario;
	private String hotelName;
	private String comment;
	private Calendar date;
	private int rate;
	
	public Comment(String comment , String nombreUsuario ,  Calendar date) {
		this.comment=comment;
		this.nombreUsuario=nombreUsuario;
		this.date=date;
	}
	
	public static Comment getComment(String hotelName, String userName , Calendar date) {
		DataBaseFacade db = DataBaseFacade.getInstance();
		return db.getComment(hotelName, userName, date);
		
	}
	
	public boolean delete() {
		DataBaseFacade db = DataBaseFacade.getInstance();
		return db.removeComment(nombreUsuario , hotelName , date);
	}
	
	public boolean addComment() {
		DataBaseFacade db = DataBaseFacade.getInstance();
		return db.addComment(this);
	
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelName() {
		return hotelName;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getComment() {
		return comment;
	}

	public Calendar getDate() {
		return date;
	}
}
