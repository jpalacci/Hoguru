package test;

import gui.SearchHotelsGUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {
    @Test
    void searchWithValidFields() {
        SearchHotelsGUI screen = new SearchHotelsGUI();
        screen.getCityTf().setText("City");
        screen.getPeopleCb().setSelectedIndex(0);
        screen.getCheckInTextField().setText("10/12/14");
        screen.getCheckOutTextField().setText("12/12/2018");
        assertTrue(screen.isValid());
    }

    @Test
    void searchWithInvalidCity() {
        SearchHotelsGUI screen = new SearchHotelsGUI();
        screen.getCityTf().setText("");
        screen.getPeopleCb().setSelectedIndex(0);
        screen.getCheckInTextField().setText("10/12/14");
        screen.getCheckOutTextField().setText("12/12/2018");
        assertFalse(screen.isValid());
    }

    @Test
    void searchWithNoCheckIn() {
        SearchHotelsGUI screen = new SearchHotelsGUI();
        screen.getCityTf().setText("City");
        screen.getPeopleCb().setSelectedIndex(0);
        screen.getCheckInTextField().setText("");
        screen.getCheckOutTextField().setText("12/12/2018");
        assertFalse(screen.isValid());
    }

    @Test
    void searchWithNoCheckOut() {
        SearchHotelsGUI screen = new SearchHotelsGUI();
        screen.getCityTf().setText("City");
        screen.getPeopleCb().setSelectedIndex(0);
        screen.getCheckInTextField().setText("10/12/14");
        screen.getCheckOutTextField().setText("");
        assertFalse(screen.isValid());
    }
}

