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
        screen.getTipoOfRoomTf().setText("test");
        screen.getCharacteristicTf().setText("test");
        screen.getGuestNumberCB().setSelectedIndex(0);
        screen.getBathrooTypeCb().setSelectedIndex(0);
        screen.getFormattedTextField().setText("$134");
        boolean error = !screen.isValid();

        assertFalse(error);
    }

    @Test
    void addRoomWithInvalidRoomType() {
        AddRoomGUI screen = new AddRoomGUI(new JFrame(), new Hotel("hotel"));
        screen.getTipoOfRoomTf().setText("");
        screen.getCharacteristicTf().setText("test1");
        screen.getGuestNumberCB().setSelectedIndex(1);
        screen.getBathrooTypeCb().setSelectedIndex(1);
        screen.getFormattedTextField().setText("invalidprice");
        boolean error = !screen.isValid();

        assertTrue(error);
    }

    @Test
    void addRoomWithInvalidCharacteristic() {
        AddRoomGUI screen = new AddRoomGUI(new JFrame(), new Hotel("hotel"));
        screen.getTipoOfRoomTf().setText("test");
        screen.getCharacteristicTf().setText("");
        screen.getGuestNumberCB().setSelectedIndex(0);
        screen.getBathrooTypeCb().setSelectedIndex(0);
        screen.getFormattedTextField().setText("$134");
        boolean error = !screen.isValid();

        assertTrue(error);
    }

    @Test
    void addRoomWithNoGuestNumberSelected() {
        AddRoomGUI screen = new AddRoomGUI(new JFrame(), new Hotel("hotel"));
        screen.getTipoOfRoomTf().setText("test");
        screen.getCharacteristicTf().setText("test");
        screen.getBathrooTypeCb().setSelectedIndex(0);
        screen.getFormattedTextField().setText("$134");
        boolean error = !screen.isValid();

        assertTrue(error);
    }

    @Test
    void addRoomWithNoBathRoomTypeSelected() {
        AddRoomGUI screen = new AddRoomGUI(new JFrame(), new Hotel("hotel"));
        screen.getTipoOfRoomTf().setText("test");
        screen.getCharacteristicTf().setText("test");
        screen.getGuestNumberCB().setSelectedIndex(0);
        screen.getFormattedTextField().setText("$134");
        boolean error = !screen.isValid();

        assertTrue(error);
    }

    @Test
    void addRoomWithInvalidPrice() {
        AddRoomGUI screen = new AddRoomGUI(new JFrame(), new Hotel("hotel"));
        screen.getTipoOfRoomTf().setText("test1");
        screen.getCharacteristicTf().setText("test1");
        screen.getGuestNumberCB().setSelectedIndex(1);
        screen.getBathrooTypeCb().setSelectedIndex(1);
        screen.getFormattedTextField().setText("invalid price");
        boolean error = !screen.isValid();

        assertTrue(error);
    }


    @Test
    void modifyRoomWithValidParameters(){
        EditRoomGUI screen = new EditRoomGUI(new JFrame(),new Room("hotel",123));
        screen.getTypeOfRoomTf().setText("test1");
        screen.getCharacteristicTf().setText("test1");
        screen.getNumerOfguestCb().setSelectedIndex(1);
        screen.getBathRoomTypeCb().setSelectedIndex(1);
        screen.getPriceTff().setText("$1234");

        boolean error = !screen.isValid();
        assertFalse(error);
    }

    @Test
    void modifyRoomWithInvalidType(){
        EditRoomGUI screen = new EditRoomGUI(new JFrame(),new Room("hotel",123));
        screen.getTypeOfRoomTf().setText("");
        screen.getCharacteristicTf().setText("test1");
        screen.getNumerOfguestCb().setSelectedIndex(1);
        screen.getBathRoomTypeCb().setSelectedIndex(1);
        screen.getPriceTff().setText("$1234");

        boolean error = !screen.isValid();
        assertTrue(error);
    }

    @Test
    void modifyRoomWithInvalidCharacteristic(){
        EditRoomGUI screen = new EditRoomGUI(new JFrame(),new Room("hotel",123));
        screen.getTypeOfRoomTf().setText("test1");
        screen.getCharacteristicTf().setText("");
        screen.getNumerOfguestCb().setSelectedIndex(1);
        screen.getBathRoomTypeCb().setSelectedIndex(1);
        screen.getPriceTff().setText("$1234");

        boolean error = !screen.isValid();
        assertTrue(error);
    }

    @Test
    void modifyRoomWithInvalidGuestNumber(){
        EditRoomGUI screen = new EditRoomGUI(new JFrame(),new Room("hotel",123));
        screen.getTypeOfRoomTf().setText("test1");
        screen.getCharacteristicTf().setText("test1");
        screen.getBathRoomTypeCb().setSelectedIndex(1);
        screen.getPriceTff().setText("$1234");

        boolean error = !screen.isValid();
        assertTrue(error);
    }

    @Test
    void modifyRoomWithInvalidBRoomType(){
        EditRoomGUI screen = new EditRoomGUI(new JFrame(),new Room("hotel",123));
        screen.getTypeOfRoomTf().setText("test1");
        screen.getCharacteristicTf().setText("test1");
        screen.getNumerOfguestCb().setSelectedIndex(1);
        screen.getPriceTff().setText("$1234");

        boolean error = !screen.isValid();
        assertTrue(error);
    }

    @Test
    void modifyRoomWithInvalidPrice(){
        EditRoomGUI screen = new EditRoomGUI(new JFrame(),new Room("hotel",123));
        screen.getTypeOfRoomTf().setText("test1");
        screen.getCharacteristicTf().setText("test1");
        screen.getNumerOfguestCb().setSelectedIndex(1);
        screen.getBathRoomTypeCb().setSelectedIndex(1);
        screen.getPriceTff().setText("invalid price");

        boolean error = !screen.isValid();
        assertTrue(error);
    }


}
