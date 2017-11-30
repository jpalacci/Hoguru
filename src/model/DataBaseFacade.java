package model;
import java.sql.ResultSet;
import java.util.Calendar;
import java.sql.Date;
import java.util.HashMap;

/**
 *  Generamos una abstraccion sobre la conexion con la base de datos aplicando el patron de Facade
 * Aplicamos patron de Singleton, para que no se instancie muchas veces la clase de DB
 */

public class DataBaseFacade
{

    StoragePersistence r;

    static DataBaseFacade dbInterface = new DataBaseFacade();

    private DataBaseFacade()
    {
        this.r = new StoragePersistence();
    }

    public static DataBaseFacade getInstance()
    {
        return dbInterface;
    }

    /**
     * Adds a user to the DB
     * @param user
     * @return true if successful, false otherwise
     */

    public boolean addUser(User user)
    {
        return r.ejecutasql("INSERT INTO USUARIOS VALUES('" + user.getEmail() + "','" + user.getPassword() + "','" + user.getUserName() + "','" + user.getName()
                + "','" + user.getSurname() + "','"
                + user.getDocument()+"')");
        //Faltan mas atributos de las tablas... no están las variables ni getterns necesarios en User y Person
    }

    /**
     * Gets a user from the DB
     * @param userName
     * @return an instance of User
     */

    public User getUser(String userName)
    {

        ResultSet res = r.gXrGenerico("SELECT * FROM USUARIOS WHERE username LIKE " + "'" + userName + "'");
        User u;
        try
        {
            if(res.next())
            {
                u = new User(res.getString("email"), res.getString("password"), res.getString("username"), res.getString("name"), res.getString("surname"), res.getString("document"));
                return u;

            }
            return null;
        }
        catch (Exception e)
        {
            System.out.println("Ocurrió un error al obtener el usuario");
            return null;
        }

    }

    /**
     * Gets a Reservation from the DB
     * @param reservationNumber
     * @return an instance of Reservation
     */

    public Reservation getReservation(long reservationNumber)
    {
        ResultSet res = r.gXrGenerico("SELECT * FROM RESERVAS WHERE reservation_number = " + reservationNumber);
        Reservation reservation;
        try {
            if (res.next())
            {
                User user = getUser(res.getString("username"));
                Calendar checkIn = Calendar.getInstance();
                checkIn.setTime(res.getDate("check_in"));
                Calendar checkOut = Calendar.getInstance();
                checkOut.setTime(res.getDate("check_out"));

                reservation = new Reservation(res.getDouble("total_amount"), user,
                        res.getInt("reservation_number"), checkIn, checkOut);

                return reservation;

            }
            return null;
        }
        catch (Exception e)
        {
            System.out.println("Ocurrió un error al obtener la reserva");
            return null;
        }
    }

    /**
     * Adds a Reservation to the DB
     * @param r, reservation
     * @param userName, username
     * @return true if successful, false otherwise
     */

    public boolean addReservation(Reservation r, String userName)
    {
        String checkIn = r.getCalendarString(r.getCheckIn());
        String checkOut = r.getCalendarString(r.getCheckOut());

        return this.r.ejecutasql("INSERT INTO RESERVAS VALUES('"+userName+"','"+r.getReservationNumber()+"','"+checkIn+"','"+
        checkOut+"',"+100+","+10+",'"+"SHERATON')");
    }


    /**
     * Adds a Hotel administrator to the DB
     * @param admin
     * @param hotelName
     * @return
     */

    public boolean addHotelAdministrator(HotelAdministrator admin, String hotelName)
    {
        return false;
    }

    /**
     * Adds a Hotel to the DB
     * @param h, a Hotel object
     * @return true if successful, false otherwise
     */

    public boolean addHotel(Hotel h)
    {
        return r.ejecutasql("INSERT INTO HOTELES VALUES('"+h.getName()+"','"+h.getDirection()+"'");
    }

    /**
     * Gets a Hotel from the DB
     * @param hotelName
     * @return an instance of Hotel
     */

    public Hotel getHotel(String hotelName)
    {

        ResultSet res = r.gXrGenerico("SELECT * FROM HOTELES WHERE hotel_name LIKE " + "'" + hotelName + "'");
        try
        {
            if(res.next())
            {
               Hotel hotel = new Hotel(res.getString("hotel_name"));
               return hotel; //Faltan mas parametros de constructor
            }
        }
        catch (Exception e)
        {
            System.out.println("OCURRIO UN ERROR");
            return null;
        }
        return null;
    }

    /**
     * Add a Room to a Hotel
     * @param r
     * @param hotelName
     * @return
     */

    public boolean addRoomToHotel(Room r, String hotelName)
    {
        return true;
    }

    /**
     * Remove a Room from a Hotel
     * @param idRoom
     * @param hotelName
     * @return
     */

    public boolean deleteRoomFromHotel(String idRoom, String hotelName) {
        return true;
    }


    public static void main(String[] args) {
        DataBaseFacade db = getInstance();
        db.r.conectar("u2017b-1", "passwordING1");
        User u = db.getUser("ADAS");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 10);
        c.set(Calendar.MONTH, 10);
        c.set(Calendar.YEAR, 2010);
        Reservation r = new Reservation(10, u, 100, c, c);
        db.addReservation(r, "ADAS");

    }

}