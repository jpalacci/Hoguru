package test;

import gui.AddHotelGUI;
import gui.EditHotelGUI;
import model.Hotel;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HotelCRUD {
    @Test
    void addHotelWithValidParameters() {
        AddHotelGUI screen = new AddHotelGUI(new JFrame());
        screen.getCityTf().setText("city");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("5");

        assertTrue(screen.validFields());
    }


    @Test
    void addRoomWithInvalidDirection() {
        AddHotelGUI screen = new AddHotelGUI(new JFrame());
        screen.getCityTf().setText("city");
        screen.getDirectionTf().setText("");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("5");

        assertFalse(screen.validFields());
    }

    @Test
    void addRoomWithInvalidName() {
        AddHotelGUI screen = new AddHotelGUI(new JFrame());
        screen.getCityTf().setText("city");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("");
        screen.getRateFT().setText("5");

        assertFalse(screen.validFields());
    }

    @Test
    void addRoomWithInvalidStar() {
        AddHotelGUI screen = new AddHotelGUI(new JFrame());
        screen.getCityTf().setText("city");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("");

        assertFalse(screen.validFields());
    }

    @Test
    void addRoomWithInvalidCity() {
        AddHotelGUI screen = new AddHotelGUI(new JFrame());
        screen.getCityTf().setText("");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("");

        assertFalse(screen.validFields());
    }

    @Test
    void modifyHotelWithValidParameters() {
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getCityTf().setText("city");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("Five");

        assertTrue(screen.validFields());
    }

    @Test
    void modifyHotelWithInvalidCity() {
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getCityTf().setText("");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("Five");

        assertFalse(screen.validFields());
    }

    @Test
    void modifyHotelWithInvalidDirection() {
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getCityTf().setText("city");
        screen.getDirectionTf().setText("");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("Five");

        assertFalse(screen.validFields());
    }

    @Test
    void modifyHotelWithInvalidName() {
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getCityTf().setText("city");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("");
        screen.getRateFT().setText("Five");

        assertFalse(screen.validFields());
    }


    @Test
    void modifyHotelWithInvalidRate() {
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getCityTf().setText("");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("");

        assertFalse(screen.validFields());
    }

}
