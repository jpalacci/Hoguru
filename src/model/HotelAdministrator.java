package model;

//HotelAdministrator is not a Person in this model, it only has two attributes , userName and password

public class HotelAdministrator extends User {
	
	private String hotelName;

    public HotelAdministrator(String hotelName , String email, String password, String userName, String name, String surname,
			String document) {
    	
		super(email, password, userName, name, surname, document);
		this.hotelName = hotelName;
	}

}
