package Controller;

import java.awt.*;
import java.util.Calendar;
import java.util.LinkedList;

import java.util.List;

import gui.LoginGUI;
import model.*;


public class Controller {

	public static User actualPerson  =  new User("pepe",  "abc","@", "pepe","pepito", DOCUMENT_TYPE.DNI, "001", new Address("country", "province", "city", "street", "street_number", "postalCode"),"15-55", PHONE_TYPE.PERSONAL);
	
	public static void main(String args[]){
        Controller.connect();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginGUI window = new LoginGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

	public boolean addRoomTypeToHotel(String hotelName , String description , String type , double cost){
	    RoomType r = new RoomType(hotelName , description , type , cost);
	   return  r.addRoomType();
    }

    public boolean deleteRoomTypeFromHotel(String hotelName , String type){
	    return RoomType.deleteRoomType(hotelName , type);
    }
	public int isValidUser(String userName, String password){

		if(User.isAdmin(userName ,password))
		{
		    actualPerson = null;
			return 2;
		}
		User user = User.getUser(userName , password);
		if(user !=  null)
		{
		    actualPerson = user;
		    return 1;
		}
		else
		{
			return 0;
		}
	}

    public boolean loadNewUser(String email, String name, String surname, DOCUMENT_TYPE docType, String document, String country, String province, String city, String street, String street_number, String postalCode, String phoneNumber, PHONE_TYPE phoneType, String password){

		Address address = new Address(country, province, city, street, street_number, postalCode);
		User p = new User( email, password ,email ,name, surname, docType, document, address,phoneNumber, phoneType);
		actualPerson = p;
        p.addUser();
		return true;
		
	}
	
	public boolean changeUser(String email, String name, String surname, DOCUMENT_TYPE docType, String document, String country, String province, String city, String street, String street_number, String postalCode, String phoneNumber, PHONE_TYPE phoneType, String password){
		//TODO aca es para cambiar un usuario ya existente
        Address address = new Address(country, province, city, street, street_number, postalCode);
        User p = new User( name, password ,email ,name, surname, docType, document, address,phoneNumber, phoneType);
        actualPerson = p;
        return p.editUser();
		
	}
	
	
	public User getActivePerson(){
		return actualPerson;
	}
		
	public boolean addHotel(String name, String direction,float rate , String city , boolean isNewHotel){
			Hotel h = new Hotel(name);
			h.setRate(rate);
			h.setDirection(direction);
			h.setCity(city);
			if(isNewHotel){
                return h.addHotel();
            }else{
                return h.updateHotel();
            }

	}

	public Reservation getReservation(long reservationNumber){
	    Reservation r = Reservation.getReservation(reservationNumber);
	    if(r == null){
	    	return r;
	    }
	    if(r.getUser().equals(actualPerson.getUserName())){
	        return r;
        }else{
	        return null;
        }
    }

    public boolean deleteReservation(long reservationNumber){
        Reservation r = Reservation.getReservation(reservationNumber);
        if(r == null){
            return false;
        }
        if(r.getUser().equals(actualPerson.getUserName())){
            return Reservation.deleteReservation(reservationNumber);
        }else{
            return false;
        }
    }

	public boolean addRoom(Hotel hotel, String tipeOfRoom, VIEW_TYPE viewType, int number,int capacity, boolean isNewRoom){
			Room r = new Room(hotel.getName(),number);
			r.setCapacity(capacity);
			r.setType(tipeOfRoom);
			r.setView(viewType);
			if(isNewRoom) {
				return r.addRoom();
			}else{
				return r.updateRoom(r);
			}
	}
	
	public List<String> getRoomTypes(String  hotelName){
		return RoomType.getRoomTypes(hotelName);

	}

	public Hotel getHotel(String hotelName){
	    return Hotel.getHotel(hotelName);
    }
	public List<Hotel> getHotels(){
	    return Hotel.getHotels();
	}

    public List<Room> getAvaillableRoomsForHotel(String hotelName, String Destination, Calendar chekInDate, Calendar checkOutDate , int persons){
        return Hotel.getAvailableRooms(hotelName, Destination , chekInDate ,checkOutDate , persons );

    }
	public List<Hotel> getAvaillableHotels(String Destination, Calendar chekInDate, Calendar checkOutDate , int persons){
		return Hotel.getAvailableHotels(Destination , chekInDate ,checkOutDate , persons);
		
	}
	
	public List<Room> getRooms(Hotel hotel){
		return Room.getRooms(hotel.getName());
	}

	public void deleteHotel(Hotel hotel) {
	    hotel.removeHotel();
	}

	public void deleteRoom(Room room) {
		room.deleteRoom();
	}
	
	public String[] getProvinces(String country){
		LinkedList<String> list = new LinkedList<String>();
		if(country.equals("Argentina")){
			list.add("Buenos Aires");
			list.add("Cordoba");
			list.add("Santa Fe");
		}
		else if(country.equals("Uruguay")){
			list.add("Montevideo");
			list.add("Maldonado");
		}
		String[] array = list.toArray(new String[list.size()]);
		return array;
		
	}
	
	public String[] getCountries(){
		LinkedList<String> list = new LinkedList<String>();
		list.add("Argentina");
		list.add("Uruguay");
		list.add("Paraguay");
		String[] array = list.toArray(new String[list.size()]);
		return array;
	}

	public void deleteActualUser() {
		actualPerson.removeUser();
		LoginGUI window = new LoginGUI();
		window.frame.setVisible(true);
	}
	public static  void connect(){
        DataBaseFacade.connect();
    }

    public long addReservation(String userName , Calendar checkIn , Calendar checkOut , Room room  ){
        Reservation r = new Reservation(userName , checkIn , checkOut , room);
        r.addReservation();
        return r.getReservationNumber();
    }

    public boolean addComment(String comment , String userName , Calendar date, String hotelName ){
        Comment m = new Comment(comment, userName , date, hotelName);
        return m.addComment();
    }

    public boolean deleteComment(String userName , String hotelName, Calendar d){
        Comment m = new Comment("a" , userName , d , hotelName);
        return m.delete();
    }
	
}
