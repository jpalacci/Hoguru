package model;
import com.sun.org.apache.regexp.internal.RE;

import java.sql.ResultSet;
import java.util.Calendar;
import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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
        StringBuilder sb = new StringBuilder();
        Address address = user.getAdress();
        sb.append("INSERT INTO USUARIOS VALUES('");
        sb.append(user.getEmail());
        sb.append("','");
        sb.append(user.getPassword());
        sb.append("','");
        sb.append(user.getUserName());
        sb.append("','");
        sb.append(user.getName());
        sb.append("','");
        sb.append(user.getSurname());
        sb.append("','");
        sb.append(user.getDocument());
        sb.append("','");
        sb.append(address.getCountry());
        sb.append("','");
        sb.append(address.getProvince());
        sb.append("','");
        sb.append(address.getCity());
        sb.append("','");
        sb.append(address.getStreet());
        sb.append("','");
        sb.append(address.getStreet_number());
        sb.append("','");
        sb.append(address.getPostalCode());
        sb.append("','");
        sb.append(user.getPhoneNumber());
        sb.append(user.getPhoneType());
        sb.append("')");
        return r.ejecutasql(sb.toString());
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
                Address address = new Address(res.getString("country"), res.getString("province"), res.getString("city"),
                        res.getString("street"), res.getString("street_number"), res.getString("cp"));
                u.setAdress(address);
                u.setPhoneNumber(res.getString("phone"));
                u.setPhoneType(PHONE_TYPE.valueOf(res.getString("phone_type")));
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
        Reservation reservation = null;
        List<Room> rooms = new LinkedList<>();
        boolean first = true;
        try {
            while(res.next())
            {
                if(first)
                {
                    User user = getUser(res.getString("username"));
                    Calendar checkIn = Calendar.getInstance();
                    checkIn.setTime(res.getDate("check_in"));
                    Calendar checkOut = Calendar.getInstance();
                    checkOut.setTime(res.getDate("check_out"));
                    reservation = new Reservation(user,
                            res.getInt("reservation_number"), checkIn, checkOut);
                    first = false;
                }
                Room r = getRoom(res.getInt("room_number"), res.getString("hotel_name"));
                rooms.add(r);

            }
            if(reservation != null)
            {
                reservation.setRooms(rooms);
            }
            return reservation;
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

        for(Room room : r.getRooms())
        {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO RESERVAS VALUES('");
            sb.append(userName);
            sb.append("',");
            sb.append(r.getReservationNumber());
            sb.append(",'");
            sb.append(checkIn);
            sb.append("','");
            sb.append(checkOut);
            sb.append("',");
            sb.append(room.getNumber());
            sb.append(",'");
            sb.append(room.getHotelName());
            sb.append("')");
            this.r.ejecutasql(sb.toString());
        }
        return true;

    }


    /**
     * Adds a Hotel administrator to the DB
     * @param admin
     * @param hotelName
     * @return
     */

    public boolean addHotelAdministrator(HotelAdministrator admin, String hotelName)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO USUARIOS_HOTEL VALUES('");
        sb.append(admin.getUserName());
        sb.append("','");
        sb.append(admin.getPassword());
        sb.append("','");
        sb.append(hotelName);
        sb.append("')");
        return r.ejecutasql(sb.toString());

    }

    /**
     * Adds a Hotel to the DB
     * @param h, a Hotel object
     * @return true if successful, false otherwise
     */

    public boolean addHotel(Hotel h)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO HOTELES VALUES('");
        sb.append(h.getName());
        sb.append("','");
        sb.append(h.getDirection());
        sb.append("',");
        sb.append(h.getRate());
        sb.append(")");
        return r.ejecutasql(sb.toString());
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
               hotel.setDirection(res.getString("address"));
               hotel.setRate(res.getFloat("rate"));
               return hotel;
            }
        }
        catch (Exception e)
        {
            System.out.println("Ocurrió un error al insertar el hotel");
            return null;
        }
        return null;
    }

    /**
     * Add a Room to a Hotel
     * @param r
     * @param
     * @return
     */

    public boolean addRoomToHotel(Room r)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO HABITACIONES VALUES('");
        sb.append(r.getType());
        sb.append("',");
        sb.append(r.getCapacity());
        sb.append(",");
        sb.append(r.getNumber());
        sb.append(",'");
        sb.append(r.getHotelName());
        sb.append("','");
        sb.append(r.getView());
        sb.append("')");
        return this.r.ejecutasql(sb.toString());

    }

    /**
     * Remove a Room from a Hotel
     * @param idRoom
     * @param hotelName
     * @return
     */

    public boolean deleteRoomFromHotel(int idRoom, String hotelName)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM HABITACIONES WHERE room_number = ");
        sb.append(idRoom);
        sb.append(" AND hotel_name = '");
        sb.append(hotelName);
        sb.append("'");
        return r.ejecutasql(sb.toString());

    }
    
    public boolean addComment(Comment c)
    {
    	StringBuilder sb = new StringBuilder();
    	sb.append("INSERT INTO COMENTARIOS VALUES('");
    	sb.append(c.getHotelName());
    	sb.append("','");
    	sb.append(c.getNombreUsuario());
        sb.append("','");
        sb.append(c.getComment());
        sb.append("','");
        sb.append(c.getDate().getTime().toString());
        sb.append("')");
        return r.ejecutasql(sb.toString());
    }
    
    public boolean removeComment(String nombreUsuario , String nombreHotel , Calendar date)
    {

        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM COMENTARIOS WHERE hotel_name = '");
        sb.append(nombreHotel);
        sb.append("' AND username = '");
        sb.append(nombreUsuario);
        sb.append("' AND comment_date = '");
        sb.append(date.getTime().toString());
        sb.append("'");
        return r.ejecutasql(sb.toString());
    }
    
    public boolean removeHotel(String hotelName)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM HOTELES WHERE hotel_name = '");
        sb.append(hotelName);
        sb.append("'");
        return r.ejecutasql(sb.toString());
    }
    
    public RoomType getRoomType(String type, String hotelName)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM TIPOS_HAB WHERE room_type = ");
        sb.append("'");
        sb.append(type);
        sb.append("' AND hotel_name = '");
        sb.append(hotelName);
        sb.append("'");
        ResultSet res = r.gXrGenerico(sb.toString());
        try
        {
            if(res.next())
            {
                RoomType roomType = new RoomType(res.getString("hotel_name"), res.getString("features"), res.getString("room_type"), res.getFloat("cost"));
                return roomType;
            }
            return null;
        }
        catch (Exception e )
        {
            return null;
        }
    }
    
    public boolean addPhotoToHotel(String photo , String hotelName)
    {
    	StringBuilder sb = new StringBuilder();
    	sb.append("INSERT INTO FOTOS VALUES('");
    	sb.append(hotelName);
    	sb.append("','");
    	sb.append(photo);
    	sb.append("')");
    	return r.ejecutasql(sb.toString());
    }
    
    public boolean removePhotoFromHotel(String hotelName , String photo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM FOTOS WHERE hotel_name = ");
        sb.append("'");
        sb.append(hotelName);
        sb.append("' AND photo = ");
        sb.append("'");
        sb.append(photo);
        sb.append("'");
        return r.ejecutasql(sb.toString());
    	

    }

    public boolean addRoomType(RoomType roomType)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO TIPOS_HAB VALUES('");
        sb.append(roomType.getType());
        sb.append("','");
        sb.append(roomType.getDescription());
        sb.append("','");
        sb.append(roomType.getHotelName());
        sb.append("',");
        sb.append(roomType.getCost());
        sb.append(")");
        return r.ejecutasql(sb.toString());

    }

    
    public Room getRoom(int roomNumber, String hotelName)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM HABITACIONES WHERE room_number = ");
        sb.append(roomNumber);
        sb.append(" AND hotel_name = '");
        sb.append(hotelName);
        sb.append("'");

        try
        {
            ResultSet res = r.gXrGenerico(sb.toString());
            if(res.next())
            {
                Room room = new Room(res.getString("hotel_name"), res.getInt("room_number"));
                room.setView(VIEW_TYPE.valueOf(res.getString("room_view")));
                room.setType(res.getString("room_type"));
                room.setCapacity(res.getInt("capacity"));
                return room;
            }
            return null;
        }
        catch (Exception e )
        {
            return null;
        }

    }
    
    public Comment getComment(String hotelName, String userName , Calendar date)
    {
    	StringBuilder sb = new StringBuilder();
    	sb.append("SELECT * FROM COMENTARIOS WHERE hotel_name = '");
    	sb.append(hotelName);
    	sb.append("' AND username = '");
    	sb.append(userName);
    	sb.append("' AND comment_date = '");
    	sb.append(date.getTime().toString());
    	sb.append("'");

    	ResultSet res = r.gXrGenerico(sb.toString());

    	try
        {
            if(res.next())
            {
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(res.getTimestamp("comment_date").getTime());
                Comment c = new Comment(res.getString("comment"), res.getString("username"), cal);
                c.setHotelName(res.getString("hotel_name"));
                return c;
            }
        }
        catch (Exception e)
        {
            return null;
        }

    	return null;

    }


    public static void main(String[] args)
    {
        DataBaseFacade db = getInstance();
        db.r.conectar("u2017b-1", "passwordING1");


    }

}