package Controller;

import java.util.LinkedList;
import java.util.List;

import model.Hotel;
import model.Room;

public class Controller {
			
	
	
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
		
	public boolean isValidHotel(String city, String name, String direction, String stars, String recreation, boolean isNewHotel){
		if(name.equals("1")){
			return true;
		}else{
			return false;	
		}
		
	}
	
	public boolean isValidRoom(Hotel hotel, String tipeOfRoom, String characteristics, String getNumber, String bathRoomtype, String price, boolean isNewRoom){
		return true;
	}
	
	public List<Hotel> getHotels(){
		List<Hotel> list = new LinkedList<Hotel>();
		list.add(new Hotel("HOTEL1"));
		list.add(new Hotel("HOTEL2"));
		list.add(new Hotel("HOTEL3"));
		return list;
		
	}
	
	public List<Hotel> getAvaillableHotels(String Destination, String chekInDate, String checkOutDate){
		List<Hotel> list = new LinkedList<Hotel>();
		list.add(new Hotel("HOTEL1"));
		list.add(new Hotel("HOTEL2"));
		list.add(new Hotel("HOTEL3"));
		return list;
		
	}
	
	public List<Room> getRooms(Hotel hotel){
		List<Room> list = new LinkedList<Room>();
		list.add(new Room("HOTEL1", 1));
		list.add(new Room("HOTEL2",1));
		list.add(new Room("HOTEL3",1));
		return list;
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
		System.out.println(hotel.toString());
	}

	public void deleteRoom(Room room) {
		System.out.println(room.toString());
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
