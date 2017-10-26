package model;

import java.util.Calendar;

public class Reservation {
	
	private double amount;
	
	private String username;
	
	private long reservationNumber;
	
	private Calendar checkIn;
	
	private Calendar checkOut;
	
	
	public Reservation(double amount, String username, long reservationNumber, Calendar checkIn, Calendar checkOut) {
		this.amount=amount;
		
		this.username=username;
		
		this.reservationNumber= reservationNumber;
		
		this.checkIn=checkIn;
		this.checkOut= checkOut;
	}
	

}
