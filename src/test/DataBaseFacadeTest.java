package test;

import model.DataBaseFacade;
import model.Reservation;
import model.User;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseFacadeTest {
    @Test
    void addGetUser() {

        User u1 = new User("mail" , "juan" , "perez", "402", "jPerez", "abc");

        DataBaseFacade db = DataBaseFacade.getInstance();

        boolean a  = db.addUser(u1);

        assertTrue(a ,  "db had an error while adding user");

        User u2 = db.getUser("jPerez");

        assertEquals(u2.getUserName() , u1.getUserName());

    }


    @Test
    void addGetReservation() {
        long reservationNumber = 17;
        DataBaseFacade db = DataBaseFacade.getInstance();
        User u1 = new User("mail" , "juan" , "perez", "402", "jPerez", "abc");

        Reservation r = new Reservation(10.0 , u1 , reservationNumber, Calendar.getInstance(), Calendar.getInstance() );

        boolean ret = db.addReservation(r , "jose");

        assertTrue(ret , "connection to db failed");

        Reservation r2 = db.getReservation(reservationNumber);

        assertEquals(r.getAmount() , r2.getAmount());
        assertEquals(r.getReservationNumber() , r2.getReservationNumber());
        assertEquals(r.getUser() , r2.getUser());

    }

    @Test
    void addHotelAdministrator() {
    }

    @Test
    void addHotel() {
    }

    @Test
    void getHotel() {
    }

    @Test
    void addRoomToHotel() {
    }

    @Test
    void deleteRoomFromHotel() {
    }

}