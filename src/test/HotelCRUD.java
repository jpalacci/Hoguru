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
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("5");

        boolean error = !screen.isValid();
        assertFalse(error);
    }


    @Test
    void addRoomWithInvalidDirection() {
        AddHotelGUI screen = new AddHotelGUI(new JFrame());
        screen.getDirectionTf().setText("");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("5");

        boolean error = screen.isValid();
        assertTrue(error);
    }

    @Test
    void addRoomWithInvalidName() {
        AddHotelGUI screen = new AddHotelGUI(new JFrame());
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("");
        screen.getRateFT().setText("5");

        boolean error = screen.isValid();

        assertTrue(error);
    }

    @Test
    void addRoomWithInvalidStar() {
        AddHotelGUI screen = new AddHotelGUI(new JFrame());
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("");

        boolean error = screen.isValid();

        assertTrue(error);
    }

    @Test
    void modifyHotelWithValidParameters() {
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("Five");

        boolean error = !screen.isValid();
        assertFalse(error);
    }

    @Test
    void modifyHotelWithInvalidCity() {
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("Five");

        boolean error = !screen.isValid();
        assertTrue(error);
    }

    @Test
    void modifyHotelWithInvalidDirection() {
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getDirectionTf().setText("");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("Five");

        boolean error = !screen.isValid();
        assertTrue(error);
    }

    @Test
    void modifyHotelWithInvalidName() {
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("");
        screen.getRateFT().setText("Five");

        boolean error = !screen.isValid();
        assertTrue(error);
    }


    @Test
    void modifyHotelWithInvalidStars() {
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("");

        boolean error = !screen.isValid();
        assertTrue(error);
    }

}
