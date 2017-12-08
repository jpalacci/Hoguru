package model;

public class Room {
	
	private String type;
	private int capacity;
	private int number;
	private VIEW_TYPE view;
	private String hotelName;
	
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
	
	

}
