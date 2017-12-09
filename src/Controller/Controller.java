package Controller;

import java.util.LinkedList;

import java.util.List;

import model.Hotel;
import model.Room;
import model.VIEW_TYPE;

public class Controller {
			
	public static LinkedList<Hotel> hotels = new LinkedList<Hotel>();
	public static LinkedList<Room> rooms = new LinkedList<Room>();
	
	public int isValidUser(String userName, String password){
		if(userName.equals("Admin"))
		{
			return 2;
		}
		else if(userName.equals("Pepe"))
		{
		 return 1;
		}
		else
		{
			return 0;
		}
	}
		
	public boolean isValidHotel(String name, String direction,float rate, boolean isNewHotel){
			Hotel h = new Hotel(name);
			h.setRate(rate);
			h.setDirection(direction);
			return hotels.add(h);
	}
	
	public boolean isValidRoom(Hotel hotel, String tipeOfRoom, VIEW_TYPE viewType, int number,int capacity, boolean isNewRoom){
			Room r = new Room(hotel.getName(),number);
			r.setCapacity(capacity);
			r.setType(tipeOfRoom);
			r.setView(viewType);
			return rooms.add(r);
	}
	
	public List<String> getRoomTypes(Hotel hotel){
		List<String> s = new LinkedList<String>();
		s.add("CAMA DOBLE");
		s.add("CAMA SIMPLE");
		s.add("AAAAA");
		s.add("BBB");
		return s;
	}
	
	public List<Hotel> getHotels(){
		return hotels;
		
	}
	
	public List<Hotel> getAvaillableHotels(String Destination, String chekInDate, String checkOutDate){
		List<Hotel> list = new LinkedList<Hotel>();
		list.add(new Hotel("HOTEL1"));
		list.add(new Hotel("HOTEL2"));
		list.add(new Hotel("HOTEL3"));
		return list;
		
	}
	
	public List<Room> getRooms(Hotel hotel){
		return rooms;
	}

	public void getSearch() {
		
		
	}

	public boolean isEditUserValid(String mail, String password1, String password2, String name, String lastName, String documentNumber, String telephone, String street, String postalCode, String streetNumber, String place, String province, String country ) {
		if(name.equals("pepito")){
			return true;
		}
		return false;
	}

	public void deleteHotel(Hotel hotel) {
		hotels.remove(hotel);
	}

	public void deleteRoom(Room room) {
		rooms.remove(room);
	}
	
	public LinkedList<String> getProvinces(String country){
		LinkedList<String> list = new LinkedList<String>();
		if(country.equals("Argetina")){
			list.add("BSAS");
			list.add("Cordoba");
		}
		else if(country.equals("Holanda")){
			list.add("mfkrf");
			list.add("femkso");
		}
		return list;
		
	}
	
	public LinkedList<String> getCoutries(){
		LinkedList<String> list = new LinkedList<String>();
		list.add("Argentina");
		list.add("Holanda");
		return list;
	}
	
}
