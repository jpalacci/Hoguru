package model;

import java.util.Calendar;
import java.util.Map;

public class Reservation {
	
	private double amount;
	
	private User user;
	
	private long reservationNumber;
	
	private Calendar checkIn;
	
	private Calendar checkOut;

	Map<Room, String> rooms;


	public Reservation(double amount, User username, long reservationNumber, Calendar checkIn, Calendar checkOut) {
		this.amount=amount;
		
		this.user=username;
		
		this.reservationNumber= reservationNumber;
		
		this.checkIn=checkIn;
		this.checkOut= checkOut;
	}

	public double getAmount() {
		return amount;
	}

    public void setRooms(Map<Room, String> rooms) {
        this.rooms = rooms;
    }

    public void setAmount(double amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(long reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public Calendar getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Calendar checkIn) {
		this.checkIn = checkIn;
	}

	public Calendar getCheckOut()
	{
		return checkOut;
	}

	public void setCheckOut(Calendar checkOut) {
		this.checkOut = checkOut;
	}

	public String getCalendarString(Calendar c)
    {
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        char hyphen = '-';

        StringBuilder sb = new StringBuilder();
        sb.append(year);
        sb.append(hyphen);
        sb.append(month);
        sb.append(hyphen);
        sb.append(day);

        return sb.toString();
    }

}
