package model;

import java.util.Calendar;
import java.util.List;

public class Comment {
	
	private String nombreUsuario;
	private String hotelName;
	private String comment;
	private Calendar date;
	private int rate;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Comment)) return false;

		Comment comment = (Comment) o;

		if (nombreUsuario != null ? !nombreUsuario.equals(comment.nombreUsuario) : comment.nombreUsuario != null)
			return false;
		return date != null ? date.equals(comment.date) : comment.date == null;
	}

	@Override
	public int hashCode() {
		int result = nombreUsuario != null ? nombreUsuario.hashCode() : 0;
		result = 31 * result + (date != null ? date.hashCode() : 0);
		return result;
	}

	public Comment(String comment , String nombreUsuario , Calendar date , String hotelName) {
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

	@Override
	public String toString() {
		return  nombreUsuario + " -- " + "Comentario: " + comment
				+System.lineSeparator()+ " Publicado en:" + date ;
	}

	public static List<Comment> getComments(String hotelName){
		DataBaseFacade db = DataBaseFacade.getInstance();
		return db.getComments( hotelName);
	}
	
	
}
