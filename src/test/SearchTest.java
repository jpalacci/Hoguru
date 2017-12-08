package test;

import gui.SearchGUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {
    @Test
    void searchWithValidFields() {
        SearchGUI screen = new SearchGUI();
        screen.getCityTf().setText("City");
        screen.getPeopleCb().setSelectedIndex(0);
        screen.getRoomsCb().setSelectedIndex(0);
        assertTrue(screen.isValid());
    }

    @Test
    void searchWithInvalidCity() {
        SearchGUI screen = new SearchGUI();
        screen.getCityTf().setText("");
        screen.getPeopleCb().setSelectedIndex(0);
        screen.getRoomsCb().setSelectedIndex(0);
        assertFalse(screen.isValid());
    }

    @Test
    void searchWithNoGuestsNumberSelected() {
        SearchGUI screen = new SearchGUI();
        screen.getCityTf().setText("City");
        screen.getRoomsCb().setSelectedIndex(0);
        assertFalse(screen.isValid());
    }

    @Test
    void searchWithNoRoomsNumberSelected() {
        SearchGUI screen = new SearchGUI();
        screen.getCityTf().setText("City");
        screen.getPeopleCb().setSelectedIndex(0);
        assertFalse(screen.isValid());
    }



}
