package Controller;

import java.util.LinkedList;

import java.util.List;

import gui.LoginGUI;
import model.Address;
import model.DOCUMENT_TYPE;
import model.Hotel;
import model.PHONE_TYPE;
import model.Person;
import model.Room;
import model.User;
import model.VIEW_TYPE;

public class Controller {
			
	public static LinkedList<Hotel> hotels = new LinkedList<Hotel>();
	public static LinkedList<Room> rooms = new LinkedList<Room>();
	public static Person actualPerson = new Person("@", "pepe","pepito", DOCUMENT_TYPE.DNI, "001", new Address("country", "province", "city", "street", "street_number", "postalCode"),"15-55", PHONE_TYPE.PERSONAL);
	
	public int isValidUser(String userName, String password){
		//TODO se deberia cargar la persona para pasarla en getActivePerson
		if(userName.equals("Admin"))
		{
			return 2;
		}
		else if(userName.equals(actualPerson.getName()))
		{
		 return 1;
		}
		else
		{
			return 0;
		}
	}
	
	public boolean loadNewUser(String email, String name, String surname, DOCUMENT_TYPE docType, String document, String country, String province, String city, String street, String street_number, String postalCode, String phoneNumber, PHONE_TYPE phoneType, String password){
		//TODO aca es para crear un nuevo usuario no se donde proner las contrasenas y eso
		Address address = new Address(country, province, city, street, street_number, postalCode);
		Person p = new Person(email, name, surname, docType, document, address,phoneNumber, phoneType);
		actualPerson = p;
		return true;
		
	}
	
	public boolean changeUser(String email, String name, String surname, DOCUMENT_TYPE docType, String document, String country, String province, String city, String street, String street_number, String postalCode, String phoneNumber, PHONE_TYPE phoneType, String password){
		//TODO aca es para cambiar un usuario ya existente
		Address address = new Address(country, province, city, street, street_number, postalCode);
		Person p = new Person(email, name, surname, docType, document, address,phoneNumber, phoneType);
		actualPerson = p;
		return true;
		
	}
	
	
	public Person getActivePerson(){
		return actualPerson;
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

	public boolean isPersonValid(String mail, String password1, String password2, String name, String lastName, String documentNumber, String telephone, String street, String postalCode, String streetNumber, String place, String province, String country ) {
		if(name.equals("pepito")){
			return true;
		}
		return true;
	}

	public void deleteHotel(Hotel hotel) {
		hotels.remove(hotel);
	}

	public void deleteRoom(Room room) {
		rooms.remove(room);
	}
	
	public String[] getProvinces(String country){
		LinkedList<String> list = new LinkedList<String>();
		if(country.equals("Argentina")){
			list.add("BSAS");
			list.add("Cordoba");
		}
		else if(country.equals("Holanda")){
			list.add("mfkrf");
			list.add("femkso");
		}
		String[] array = list.toArray(new String[list.size()]);
		return array;
		
	}
	
	public String[] getCoutries(){
		LinkedList<String> list = new LinkedList<String>();
		list.add("Argentina");
		list.add("Holanda");
		String[] array = list.toArray(new String[list.size()]);
		return array;
	}

	public void deleteActualUser() {
		//TODO
		LoginGUI window = new LoginGUI();
		window.frame.setVisible(true);
	}
	
}
