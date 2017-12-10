package model;

import java.util.Calendar;
import java.util.List;


public class Reservation {

	private static long reservationNumberInc = 1;
	private String user;
	
	private long reservationNumber;
	
	private Calendar checkIn;
	
	private Calendar checkOut;

	Room room;

	public Room getRoom(){
		return room;
	}
	
	public static Reservation getReservation(long reservationNumber)
    {
		DataBaseFacade db = DataBaseFacade.getInstance();
		return db.getReservation(reservationNumber);
	}


	public Reservation(String username, Calendar checkIn, Calendar checkOut , Room r ) {

		this.user=username;
		
		this.reservationNumber= reservationNumberInc++;
		
		this.checkIn=checkIn;
		this.checkOut= checkOut;
		this.room = room;
	}

	public Reservation(String username, long reservationNumber , Calendar checkIn, Calendar checkOut) {

		this.user=username;

		this.reservationNumber= reservationNumber;

		this.checkIn=checkIn;
		this.checkOut= checkOut;
	}


    public void setRoom(Room room)
    {
        this.room = room;
    }



	public long getReservationNumber()
    {
		return reservationNumber;
	}

	public void setReservationNumber(long reservationNumber)
    {
		this.reservationNumber = reservationNumber;
	}

	public Calendar getCheckIn()
    {
		return checkIn;
	}

	public void setCheckIn(Calendar checkIn)
    {
		this.checkIn = checkIn;
	}

	public Calendar getCheckOut()
	{
		return checkOut;
	}

	public void setCheckOut(Calendar checkOut)
    {
		this.checkOut = checkOut;
	}

	public boolean addReservation(){
		DataBaseFacade db = DataBaseFacade.getInstance();
		return db.addReservation(this , this.user);
	}
	public String getCalendarString(Calendar c)
    {
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
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
