package model;

import java.util.Calendar;
import java.util.List;


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
	
	public Hotel getHotel(String name) {
		//QUERY TO DATA BASE
		return  new Hotel("TODO");
	}

	
	public boolean addRoom(String type, int roomNumber, int capacity, double price, String view) {
		
		//QUERY TO DATA BASE

        return true;
		
	}
	
	public boolean deleteRoom(int roomNumber) {
		//QUERY TO DATA BASEm

        return true;
	}
	
	public boolean addPhoto(String photo) {
		
		//QUERY TO DATA BASE

        return true;
		
	}
	
	public boolean addComment(String user,  Comment c) {

		//QUERY TO DATA  BASE
	    return true;
	}

	
	public boolean deleteComment(String user, Calendar c) {
		
		
		// QUERY TO DATABASE
        return true;
		
	}
	
	public boolean deletePhoto(String photo) {
		
		//QUERY TO DATABASE

        return true;
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getDirection() {
		return direction;
	}
	

}
