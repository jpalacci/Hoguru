package model;

//HotelAdministrator is not a Person in this model, it only has two attributes , userName and password

public class HotelAdministrator  {

    private String userName;
    private String password;

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
