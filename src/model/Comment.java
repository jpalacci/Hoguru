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
	
}
