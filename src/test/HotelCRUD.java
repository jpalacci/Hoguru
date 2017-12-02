package test;

import gui.AddHotelGUI;
import gui.AdministratorGUI;
import gui.EditHotelGUI;
import gui.EditRoomGUI;
import model.Hotel;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HotelCRUD {
    @Test
    void addHotelWithValidParameters() {
        AddHotelGUI screen = new AddHotelGUI(new JFrame());
        screen.getCityTf().setText("City Test");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRecreationTf().setText("No recreation");
        screen.getStarTf().setText("5");

        boolean error = !screen.isValid();
        assertFalse(error);
    }

    @Test
    void addRoomWithInvalidCity() {
        AddHotelGUI screen = new AddHotelGUI(new JFrame());
        screen.getCityTf().setText("");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRecreationTf().setText("No recreation");
        screen.getStarTf().setText("5");

        boolean error = screen.isValid();
        assertTrue(error);
    }

    @Test
    void addRoomWithInvalidDirection() {
        AddHotelGUI screen = new AddHotelGUI(new JFrame());
        screen.getCityTf().setText("City Test");
        screen.getDirectionTf().setText("");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRecreationTf().setText("No recreation");
        screen.getStarTf().setText("5");

        boolean error = screen.isValid();
        assertTrue(error);
    }

    @Test
    void addRoomWithInvalidName() {
        AddHotelGUI screen = new AddHotelGUI(new JFrame());
        screen.getCityTf().setText("Test City");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("");
        screen.getRecreationTf().setText("No recreation");
        screen.getStarTf().setText("5");

        boolean error = screen.isValid();

        assertTrue(error);
    }

    @Test
    void addRoomWithInvalidRecreation() {
        AddHotelGUI screen = new AddHotelGUI(new JFrame());
        screen.getCityTf().setText("Test City");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRecreationTf().setText("");
        screen.getStarTf().setText("5");

        boolean error = screen.isValid();

        assertTrue(error);
    }

    @Test
    void addRoomWithInvalidStar() {
        AddHotelGUI screen = new AddHotelGUI(new JFrame());
        screen.getCityTf().setText("Test city");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRecreationTf().setText("No recreation");
        screen.getStarTf().setText("");

        boolean error = screen.isValid();

        assertTrue(error);
    }

    @Test
    void deleteHotel() {
        AdministratorGUI screen = new AdministratorGUI();
        /* TODO falta la opcion de eliminar hoteles en el GUI */
    }

    @Test
    void modifyHotelWithValidParameters() {
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getCityTf().setText("Test city");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRecreationTf().setText("No recreation");
        screen.getStarTf().setText("Five");

        boolean error = !screen.isValid();
        assertFalse(error);
    }

    @Test
    void modifyHotelWithInvalidCity() {
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getCityTf().setText("");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRecreationTf().setText("No recreation");
        screen.getStarTf().setText("Five");

        boolean error = !screen.isValid();
        assertTrue(error);
    }

    @Test
    void modifyHotelWithInvalidDirection() {
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getCityTf().setText("Test city");
        screen.getDirectionTf().setText("");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRecreationTf().setText("No recreation");
        screen.getStarTf().setText("Five");

        boolean error = !screen.isValid();
        assertTrue(error);
    }

    @Test
    void modifyHotelWithInvalidName() {
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getCityTf().setText("Test city");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("");
        screen.getRecreationTf().setText("No recreation");
        screen.getStarTf().setText("Five");

        boolean error = !screen.isValid();
        assertTrue(error);
    }

    @Test
    void modifyHotelWithInvalidRecreation() {
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getCityTf().setText("Test city");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRecreationTf().setText("");
        screen.getStarTf().setText("Five");

        boolean error = !screen.isValid();
        assertTrue(error);
    }

    void modifyHotelWithInvalidStars() {
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getCityTf().setText("Test city");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRecreationTf().setText("No recreation");
        screen.getStarTf().setText("");

        boolean error = !screen.isValid();
        assertTrue(error);
    }

}
