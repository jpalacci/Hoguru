package test;

import Controller.Controller;
import gui.AddRoomGUI;
import gui.EditHotelGUI;
import gui.EditRoomGUI;
import javafx.scene.control.ComboBox;
import model.Hotel;
import model.Room;


import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;

import javax.swing.*;
import java.awt.*;

public class RoomCRUD {
    @Test
    public void addRoomWithValidParameters() {
        Controller.connect();
        AddRoomGUI screen = new AddRoomGUI(new JFrame(), new Hotel("hotel"));
        //screen.getTypeRoomCb().setSelectedIndex(0);
        screen.getGuestNumberCB().setSelectedIndex(1);
        screen.getFormattedTextField().setText("$134");
        screen.getViewTypeCB().setSelectedIndex(0);
        screen.getRoomNumberFT().setText("1234");
        Controller.disconnect();
        assertTrue(screen.fieldValidity());
    }

    @Test
    public void addRoomWithNoGuestNumber() {
        Controller.connect();
        AddRoomGUI screen = new AddRoomGUI(new JFrame(), new Hotel("hotel"));
        screen.getGuestNumberCB().setSelectedIndex(1);
        screen.getFormattedTextField().setText("$134");
        screen.getViewTypeCB().setSelectedIndex(1);
        screen.getRoomNumberFT().setText("1234");
        Controller.disconnect();
        assertFalse(screen.fieldValidity());
    }

    @Test
    public void addRoomWithNoPrice() {
        Controller.connect();
        AddRoomGUI screen = new AddRoomGUI(new JFrame(), new Hotel("hotel"));
        //screen.getTypeRoomCb().setSelectedIndex(1);
        screen.getGuestNumberCB().setSelectedIndex(1);
        screen.getFormattedTextField().setText("");
        screen.getViewTypeCB().setSelectedIndex(1);
        screen.getRoomNumberFT().setText("1234");
        Controller.disconnect();
        assertFalse(screen.fieldValidity());
    }

    @Test
    public void addRoomWithNoViewType() {
        Controller.connect();
        AddRoomGUI screen = new AddRoomGUI(new JFrame(), new Hotel("hotel"));
//        screen.getTypeRoomCb().setSelectedIndex(0);
        screen.getGuestNumberCB().setSelectedIndex(0);
        screen.getFormattedTextField().setText("$134");
        screen.getRoomNumberFT().setText("1234");
        Controller.disconnect();
        assertFalse(screen.fieldValidity());
    }

    @Test
    public void addRoomWithNoNumber() {
        //Controller.connect();
        AddRoomGUI screen = new AddRoomGUI(new JFrame(), new Hotel("hotel"));
//        screen.getTypeRoomCb().setSelectedIndex(0);
        screen.getGuestNumberCB().setSelectedIndex(0);
        screen.getFormattedTextField().setText("$134");
        screen.getViewTypeCB().setSelectedIndex(0);
        screen.getRoomNumberFT().setText("");
        Controller.disconnect();
        assertFalse(screen.fieldValidity());
    }


    @Test
    public void modifyRoomWithValidParameters(){
        EditRoomGUI screen = new EditRoomGUI(new JFrame(), new Hotel("testHotel"), new Room("testHotel" , 22));
//        screen.getRoomTypeCb().setSelectedIndex(0);
        screen.getGuestNumberCB().setSelectedIndex(1);
        screen.getRoomNumberFT().setText("123");
        screen.getFormattedTextField().setText("$1234");
        screen.getViewTypeCB().setSelectedIndex(1);
        Controller.disconnect();
        assertTrue(screen.fieldValidity());
    }

    @Test
    public void modifyRoomWithInvalidType(){
        Controller.connect();
        EditRoomGUI screen = new EditRoomGUI(new JFrame(), new Hotel("testHotel"), new Room("testHotel" , 22));
        screen.getGuestNumberCB().setSelectedIndex(1);
        screen.getRoomNumberFT().setText("123");
        screen.getFormattedTextField().setText("$1234");
       screen.getViewTypeCB().setSelectedIndex(1);
        Controller.disconnect();
        assertTrue(screen.fieldValidity());
    }

    @Test
    public void modifyRoomWithInvalidRoomNumber(){
        Controller.connect();
        EditRoomGUI screen = new EditRoomGUI(new JFrame(), new Hotel("testHotel"), new Room("testHotel" , 22));
//        screen.getRoomTypeCb().setSelectedIndex(0);
        screen.getGuestNumberCB().setSelectedIndex(1);
        screen.getRoomNumberFT().setText("");
        screen.getFormattedTextField().setText("$1234");
        screen.getViewTypeCB().setSelectedIndex(1);
        Controller.disconnect();
        assertFalse(screen.fieldValidity());
    }

    @Test
    public void modifyRoomWithInvalidGuestNumber(){
        //Controller.connect();
        EditRoomGUI screen = new EditRoomGUI(new JFrame(), new Hotel("testHotel"), new Room("testHotel" , 22));
//        screen.getRoomTypeCb().setSelectedIndex(0);
        screen.getRoomNumberFT().setText("123");
        screen.getFormattedTextField().setText("$1234");
        screen.getViewTypeCB().setSelectedIndex(1);
        Controller.disconnect();
        assertFalse(screen.fieldValidity());
    }
    @Test
    public void modifyRoomWithViewType(){
        Controller.connect();
        EditRoomGUI screen = new EditRoomGUI(new JFrame(), new Hotel("testHotel"), new Room("testHotel" , 22));
        //screen.getRoomTypeCb().setSelectedIndex(0);
        screen.getGuestNumberCB().setSelectedIndex(1);
        screen.getRoomNumberFT().setText("123");
        screen.getFormattedTextField().setText("$1234");
        Controller.disconnect();
        assertFalse(screen.fieldValidity());
    }

    @Test
    public void modifyRoomWithInvalidPrice(){
        Controller.connect();
        EditRoomGUI screen = new EditRoomGUI(new JFrame(), new Hotel("testHotel"), new Room("testHotel" , 22));
//        screen.getRoomTypeCb().setSelectedIndex(0);
        screen.getGuestNumberCB().setSelectedIndex(1);
        screen.getRoomNumberFT().setText("123");
        screen.getFormattedTextField().setText("");
        screen.getViewTypeCB().setSelectedIndex(1);
        Controller.disconnect();
        assertTrue(screen.fieldValidity());
    }


}