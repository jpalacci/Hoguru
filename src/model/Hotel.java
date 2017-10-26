package model;

import java.util.Calendar;

public class Hotel {
	
	private String name;
	private String direction;
	private List<String> basicInfo;
	private List<Comment> comments; 
	private int rate; 
	
	public Hotel(String name) {
		//query to data base
		
		this.name=name;
	}
	
	public getHotel(String name) {
		//QUERY TO DATA BASE
		return  res;
	}

	
	public boolean addRoom(String type, int roomNumber, int capacity, double price, String view) {
		
		//QUERY TO DATA BASE
		
	}
	
	public boolean deleteRoom(int roomNumber) {
		//QUERY TO DATA BASEm
	}
	
	public boolean addPhoto(String photo) {
		
		//QUERY TO DATA BASE
		
	}
	
	public boolean addComment(String user,  Comment c) {
		
		//QUERY TO DATA  BASE
		
	}
	
	public boolean deleteRoom(int roomNumber) {
		
		//QUERY TO DATA BASE
		
	}
	
	public boolean deleteComment(String user, Calendar c) {
		
		
		// QUERY TO DATABASE
		
	}
	
	public boolean deletePhoto(String photo) {
		
		//QUERY TO DATABASE
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getDirection() {
		return direction;
	}
	

}
