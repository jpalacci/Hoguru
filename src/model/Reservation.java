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

	public String getUser(){
		return user;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Reservation)) return false;

		Reservation that = (Reservation) o;

		return reservationNumber == that.reservationNumber;
	}

	@Override
	public int hashCode() {
		return (int) (reservationNumber ^ (reservationNumber >>> 32));
	}

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
		this.room = r;
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
        Boolean res =  db.addReservation(this , this.user);
        Reservation r = db.getReservation(user , checkIn , checkOut , room.getNumber() , room.getHotelName());
		if(r == null){
            System.out.println("EEORRORO");
            return false;
        }
        this.reservationNumber = r.reservationNumber;
        return res;
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

    public static boolean deleteReservation(long reservationNumber){
		DataBaseFacade db = DataBaseFacade.getInstance();
		return db.deleteReservation(reservationNumber);

	}

}
