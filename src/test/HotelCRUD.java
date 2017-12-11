package test;

import Controller.Controller;
import gui.AddHotelGUI;
import gui.EditHotelGUI;
import model.Hotel;


import javax.swing.*;


import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class HotelCRUD {
    @Test
    public void addHotelWithValidParameters() {
        Controller.connect();
        AddHotelGUI screen = new AddHotelGUI(new JFrame());
        screen.getCityTf().setText("city");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("5");

        assertTrue(screen.validFields());
    }


    @Test
    public void addRoomWithInvalidDirection() {
        Controller.connect();
        AddHotelGUI screen = new AddHotelGUI(new JFrame());
        screen.getCityTf().setText("city");
        screen.getDirectionTf().setText("");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("5");

        assertFalse(screen.validFields());
    }

    @Test
    public void addRoomWithInvalidName() {
        Controller.connect();
        AddHotelGUI screen = new AddHotelGUI(new JFrame());
        screen.getCityTf().setText("city");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("");
        screen.getRateFT().setText("5");

        assertFalse(screen.validFields());
    }

    @Test
    public void addRoomWithInvalidStar() {
        Controller.connect();
        AddHotelGUI screen = new AddHotelGUI(new JFrame());
        screen.getCityTf().setText("city");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("");

        assertFalse(screen.validFields());
    }

    @Test
    public void addRoomWithInvalidCity() {
        Controller.connect();
        AddHotelGUI screen = new AddHotelGUI(new JFrame());
        screen.getCityTf().setText("");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("");

        assertFalse(screen.validFields());
    }

    @Test
    void modifyHotelWithValidParameters() {
        Controller.connect();
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getCityTf().setText("city");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("Five");

        assertTrue(screen.validFields());
    }

    @Test
    public void modifyHotelWithInvalidCity() {
        Controller.connect();
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getCityTf().setText("");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("Five");

        assertFalse(screen.validFields());
    }

    @Test
    public void modifyHotelWithInvalidDirection() {
        Controller.connect();
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getCityTf().setText("city");
        screen.getDirectionTf().setText("");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("Five");

        assertFalse(screen.validFields());
    }

    @Test
    public void modifyHotelWithInvalidName() {
        Controller.connect();
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getCityTf().setText("city");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("");
        screen.getRateFT().setText("Five");

        assertFalse(screen.validFields());
    }


    @Test
    public void modifyHotelWithInvalidRate() {
        Controller.connect();
        Hotel hotel = new Hotel("hotel");
        EditHotelGUI screen = new EditHotelGUI(new JFrame(),hotel);
        screen.getCityTf().setText("");
        screen.getDirectionTf().setText("23 Test");
        screen.getHotelNameTf().setText("Test Hotel");
        screen.getRateFT().setText("");

        assertFalse(screen.validFields());
    }

}
