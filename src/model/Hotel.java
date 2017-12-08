package model;

import java.util.Calendar;
import java.util.List;


public class Hotel {
	
	private String name;
	private String direction;
	private List<String> basicInfo;
	private List<Comment> comments; 
	private float rate;
	
	public Hotel(String name) {
		this.name=name;
	}
	
	public static Hotel getHotel(String name) {
		DataBaseFacade db = DataBaseFacade.getInstance();
		return db.getHotel(name);

	}
	
	public boolean addHotel() {
		DataBaseFacade db = DataBaseFacade.getInstance();
		return db.addHotel(this);
	}
	
	public boolean removeHotel() {
		
		DataBaseFacade db = DataBaseFacade.getInstance();
		return db.removeHotel(this.name);
		
	}

	public float getRate() {
		return rate;
	}

	public boolean addRoom(String type, int roomNumber, int capacity , VIEW_TYPE view , String description) {
		
		DataBaseFacade db = DataBaseFacade.getInstance();
		
		return db.addRoomToHotel(new Room(capacity , roomNumber , name ,type , view));

		
	}
	
	public boolean deleteRoom(int roomNumber) {
		
		DataBaseFacade db = DataBaseFacade.getInstance();
		
		return db.deleteRoomFromHotel(roomNumber, name);
	}
	
	public boolean addPhoto(String photo) {
		
		DataBaseFacade db = DataBaseFacade.getInstance();
		
		return db.addPhotoToHotel(photo,name);
		
	}
	
	public boolean addComment( String comment , String nombreUsuario ,  int rate, Calendar date) {

		Comment c = new Comment(comment, nombreUsuario , rate , date);
		return c.addComment();
	}

	
	public boolean deleteComment(String user, Calendar c) {
		
		DataBaseFacade db = DataBaseFacade.getInstance();
		
		return db.removeComment(user, name, c);
		
	}
	
	public boolean deletePhoto(String photo) {
		

		DataBaseFacade db = DataBaseFacade.getInstance();
		
		return db.removePhotoFromHotel(name, photo);
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getDirection() {
		return direction;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public void setBasicInfo(List<String> basicInfo) {
		this.basicInfo = basicInfo;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}
}
