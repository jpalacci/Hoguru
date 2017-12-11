package model;

import java.util.List;

public class Room {
	
	private String type;
	private int capacity;
	private int number;
	private VIEW_TYPE view;
	private String hotelName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;

        Room room = (Room) o;

        if (number != room.number) return false;
        return hotelName != null ? hotelName.equals(room.hotelName) : room.hotelName == null;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (hotelName != null ? hotelName.hashCode() : 0);
        return result;
    }

    public Room(String hotelName, int number) {
		this.hotelName = hotelName;
		this.number = number;
	}
	
	public boolean addRoom() {
		DataBaseFacade db = DataBaseFacade.getInstance();
		return db.addRoomToHotel(this);
	}
	
	public boolean deleteRoom() {
		DataBaseFacade db = DataBaseFacade.getInstance();
		return db.deleteRoomFromHotel(number, hotelName);
	}
	
	public static  Room getRoom(int roomNumber, String hotel) {
		
		DataBaseFacade db = DataBaseFacade.getInstance();
		
		return db.getRoom(roomNumber, hotel);
	}

	public int getNumber() {
		return number;
	}

	public String getHotelName() {
		return hotelName;
	}

	public String getType() {
		return type;
	}

	public int getCapacity() {
		return capacity;
	}

	public VIEW_TYPE getView() {
		return view;
	}

	/*
                 * This constructor uses the Builder Patron because it internally generates a RoomType
                 */
	public Room(int capacity , int number , String hotelName, String type , VIEW_TYPE view  ) {
		this.capacity = capacity;
		this.number = number;
		this.type = type;
		this.hotelName = hotelName;
		this.view = view;
	}
	
	public double getNightCost() {
		return getTypeCost() * viewIncrement();
	}
	
	private double getTypeCost() {
		DataBaseFacade db = DataBaseFacade.getInstance();
		RoomType roomType =  db.getRoomType(type, hotelName);
		
		return roomType.getCost();

	}
	
	private double viewIncrement() {
		double increment;
		
		switch(view) {
			case GARDENS : increment = 1.5;
				break;
			case INTERIOR : increment = 1;
				break;
			case EXTERIOR : increment = 2;
				break;
			default : increment = 1;	
		}
		
		return increment;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public void setView(VIEW_TYPE v)
	{
		view = v;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public static List<Room> getRooms(String hotelName){
		DataBaseFacade db = DataBaseFacade.getInstance();
		return db.getRoomsFromHotel(hotelName);
	}

	public boolean updateRoom(Room r ){
		DataBaseFacade db = DataBaseFacade.getInstance();
		return db.editRoom(r);
	}

    @Override
    public String toString() {
        return 	"Numero de cuarto: " + number +
        		" Tipo: " + type  +
                " Vista: " + view +
                " Capacidad: " + capacity;
    }
}
