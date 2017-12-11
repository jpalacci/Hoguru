package test;

import gui.AddRoomGUI;
import gui.EditHotelGUI;
import gui.EditRoomGUI;
import javafx.scene.control.ComboBox;
import model.Hotel;
import model.Room;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;
import java.awt.*;

public class RoomCRUD {
    @Test
    void addRoomWithValidParameters() {
        AddRoomGUI screen = new AddRoomGUI(new JFrame(), new Hotel("hotel"));
        screen.getTypeRoomCb().setSelectedIndex(0);
        screen.getGuestNumberCB().setSelectedIndex(0);
        screen.getFormattedTextField().setText("$134");
        screen.getViewTypeCB().setSelectedIndex(0);
        screen.getRoomNumberFT().setText("1234");

        assertTrue(screen.fieldValidity());
    }

    @Test
    void addRoomWithNoGuestNumber() {
        AddRoomGUI screen = new AddRoomGUI(new JFrame(), new Hotel("hotel"));
        screen.getGuestNumberCB().setSelectedIndex(0);
        screen.getFormattedTextField().setText("$134");
        screen.getViewTypeCB().setSelectedIndex(0);
        screen.getRoomNumberFT().setText("1234");

        assertFalse(screen.fieldValidity());
    }

    @Test
    void addRoomWithNoPrice() {
        AddRoomGUI screen = new AddRoomGUI(new JFrame(), new Hotel("hotel"));
        screen.getTypeRoomCb().setSelectedIndex(0);
        screen.getGuestNumberCB().setSelectedIndex(0);
        screen.getFormattedTextField().setText("");
        screen.getViewTypeCB().setSelectedIndex(0);
        screen.getRoomNumberFT().setText("1234");

        assertFalse(screen.fieldValidity());
    }

    @Test
    void addRoomWithNoViewType() {
        AddRoomGUI screen = new AddRoomGUI(new JFrame(), new Hotel("hotel"));
        screen.getTypeRoomCb().setSelectedIndex(0);
        screen.getGuestNumberCB().setSelectedIndex(0);
        screen.getFormattedTextField().setText("$134");
        screen.getRoomNumberFT().setText("1234");

        assertFalse(screen.fieldValidity());
    }

    @Test
    void addRoomWithNoNumber() {
        AddRoomGUI screen = new AddRoomGUI(new JFrame(), new Hotel("hotel"));
        screen.getTypeRoomCb().setSelectedIndex(0);
        screen.getGuestNumberCB().setSelectedIndex(0);
        screen.getFormattedTextField().setText("$134");
        screen.getViewTypeCB().setSelectedIndex(0);
        screen.getRoomNumberFT().setText("");

        assertFalse(screen.fieldValidity());
    }


    @Test
    void modifyRoomWithValidParameters(){
        EditRoomGUI screen = new EditRoomGUI(new JFrame(),null,null);
        screen.getRoomTypeCb().setSelectedIndex(0);
        screen.getGuestNumberCB().setSelectedIndex(1);
        screen.getRoomNumberFT().setText("123");
        screen.getFormattedTextField().setText("$1234");
        screen.getViewTypeCB().setSelectedIndex(0);

        assertTrue(screen.fieldValidity());
    }

    @Test
    void modifyRoomWithInvalidType(){
        EditRoomGUI screen = new EditRoomGUI(new JFrame(),null,null);
        screen.getGuestNumberCB().setSelectedIndex(1);
        screen.getRoomNumberFT().setText("123");
        screen.getFormattedTextField().setText("$1234");
        screen.getViewTypeCB().setSelectedIndex(0);

        assertTrue(screen.fieldValidity());
    }

    @Test
    void modifyRoomWithInvalidRoomNumber(){
        EditRoomGUI screen = new EditRoomGUI(new JFrame(),null,null);
        screen.getRoomTypeCb().setSelectedIndex(0);
        screen.getGuestNumberCB().setSelectedIndex(1);
        screen.getRoomNumberFT().setText("");
        screen.getFormattedTextField().setText("$1234");
        screen.getViewTypeCB().setSelectedIndex(0);

        assertFalse(screen.fieldValidity());
    }

    @Test
    void modifyRoomWithInvalidGuestNumber(){
        EditRoomGUI screen = new EditRoomGUI(new JFrame(),null,null);
        screen.getRoomTypeCb().setSelectedIndex(0);
        screen.getRoomNumberFT().setText("123");
        screen.getFormattedTextField().setText("$1234");
        screen.getViewTypeCB().setSelectedIndex(0);

        assertFalse(screen.fieldValidity());
    }

    @Test
    void modifyRoomWithViewType(){
        EditRoomGUI screen = new EditRoomGUI(new JFrame(),null,null);
        screen.getRoomTypeCb().setSelectedIndex(0);
        screen.getGuestNumberCB().setSelectedIndex(1);
        screen.getRoomNumberFT().setText("123");
        screen.getFormattedTextField().setText("$1234");

        assertFalse(screen.fieldValidity());
    }

    @Test
    void modifyRoomWithInvalidPrice(){
        EditRoomGUI screen = new EditRoomGUI(new JFrame(),null,null);
        screen.getRoomTypeCb().setSelectedIndex(0);
        screen.getGuestNumberCB().setSelectedIndex(1);
        screen.getRoomNumberFT().setText("123");
        screen.getFormattedTextField().setText("");
        screen.getViewTypeCB().setSelectedIndex(0);

        assertTrue(screen.fieldValidity());
    }


}