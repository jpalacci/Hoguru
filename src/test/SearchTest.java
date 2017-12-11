package test;

import Controller.Controller;
import gui.SearchHotelsGUI;

import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;

public class SearchTest {
    @Test
    public void searchWithValidFields() {
        //Controller.connect();
        SearchHotelsGUI screen = new SearchHotelsGUI();
        screen.getCityTf().setText("City");
        screen.getPeopleCb().setSelectedIndex(1);
        screen.getCheckInTextField().setText("10/12/2014");
        screen.getCheckOutTextField().setText("12/12/2018");
        assertFalse(screen.isValid());
    }

    @Test
    public void searchWithInvalidCity() {
        //Controller.connect();
        SearchHotelsGUI screen = new SearchHotelsGUI();
        screen.getCityTf().setText("");
        screen.getPeopleCb().setSelectedIndex(0);
        screen.getCheckInTextField().setText("10/12/14");
        screen.getCheckOutTextField().setText("12/12/2018");
        assertFalse(screen.isValid());
    }

    @Test
    public void searchWithNoCheckIn() {

        //Controller.connect();
        SearchHotelsGUI screen = new SearchHotelsGUI();
        screen.getCityTf().setText("City");
        screen.getPeopleCb().setSelectedIndex(0);
        screen.getCheckInTextField().setText("");
        screen.getCheckOutTextField().setText("12/12/2018");
        assertFalse(screen.isValid());
    }

    @Test
    public void searchWithNoCheckOut() {
        //Controller.connect();
        SearchHotelsGUI screen = new SearchHotelsGUI();
        screen.getCityTf().setText("City");
        screen.getPeopleCb().setSelectedIndex(0);
        screen.getCheckInTextField().setText("10/12/14");
        screen.getCheckOutTextField().setText("");
        assertFalse(screen.isValid());
    }
}

