package model;

//Generamos una abstraccion sobre la conexion con la base de datos aplicando el patron de Facade
//Aplicamos patron de singleton , para que no se instancie muchas veces la clase de DB

import java.util.Calendar;
import java.util.Map;

public   class DataBaseFacade {

    StoragePersistence r ;

    DataBaseFacade dbInterface = new DataBaseFacade();

    private DataBaseFacade() {
        this.r = new StoragePersistence();
    }

    public DataBaseFacade getInstance(){
        return dbInterface;
    }

    //Add new user to DB

    public boolean addUser( User  u ){
        return true;
    }

    public User getUser(String userName){
        return new User();
    }

    public Reservation getReservation(long reservationNumber){
        return new Reservation(0 , new User()  , 1 , Calendar.getInstance() ,Calendar.getInstance() );
    }

    public boolean addReservation(Reservation r  , Map<Room , String> rooms , String userName){
        return true;
    }



    //ONLY HOTEL_ADMIN SHOULD ACCESS THE FOLLOWING METHODS

    public boolean addHotelAdministrator(HotelAdministrator admin , String hotelName){

        return true;
    }

    public boolean addHotel(Hotel h){
        return true;
    }

    public boolean getHotel(String hotelName){
        return true;
    }

    public boolean addRoomToHotel(Room r , String hotelName){
        return true;
    }

    public boolean deleteRoomFromHotel(String idRoom , String hotelName){
        return true;
    }
}
