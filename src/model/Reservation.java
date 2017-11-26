package model;

import java.util.Calendar;

public class Reservation {
	
	private double amount;
	
	private User user;
	
	private long reservationNumber;
	
	private Calendar checkIn;
	
	private Calendar checkOut;
	
	
	public Reservation(double amount, User username, long reservationNumber, Calendar checkIn, Calendar checkOut) {
		this.amount=amount;
		
		this.user=username;
		
		this.reservationNumber= reservationNumber;
		
		this.checkIn=checkIn;
		this.checkOut= checkOut;
	}
	

}
