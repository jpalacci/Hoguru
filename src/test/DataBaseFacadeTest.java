package test;

import com.sun.tools.javac.util.Assert;
import model.DataBaseFacade;
import model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseFacadeTest {
    @Test
    void addGetUser() {

        User u1 = new User("mail" , "juan" , "perez", "402", "jPerez", "abc");

        DataBaseFacade db = DataBaseFacade.getInstance();

        boolean a  = db.addUser(u1);

        assertFalse(a , "db had an error while adding user");

        User u2 = db.getUser("jPerez");

        assertEquals(u2.getUserName() , u1.getUserName());

    }


    @Test
    void getReservation() {
    }

    @Test
    void addReservation() {
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