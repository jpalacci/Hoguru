package test;

import Controller.Controller;
import gui.LoginGUI;

import model.DataBaseFacade;
import model.StoragePersistence;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;

public class LoginTest {
    /*
    @Test
    public void loginWithValidFields() {
        Controller.connect();
        LoginGUI screen = new LoginGUI();
        screen.getUserTf().setText("name");
        String user = screen.getUserTf().getText();
        screen.getPasswordField().setText("name");
        String pword = screen.getPasswordField().getPassword().toString();
        int t = screen.isValid(user , pword);
        Controller.disconnect();
        assertNotEquals(t,0);

    }
    */

    @Test
    public void loginWithIncompleteUser() {
        Controller.connect();
        LoginGUI screen = new LoginGUI();
        screen.getUserTf().setText("");
        String user = screen.getUserTf().getText();
        screen.getPasswordField().setText("Key");
        String pword = screen.getPasswordField().getPassword().toString();
        int t = screen.isValid(user , pword);
        Controller.disconnect();

        assertEquals(t,0);
    }

    @Test
    public  void loginWithIncompletePassword() {
        Controller.connect();
        LoginGUI screen = new LoginGUI();
        screen.getUserTf().setText("User");
        String user = screen.getUserTf().getText();
        screen.getPasswordField().setText("");
        String pword = screen.getPasswordField().getPassword().toString();
        int t = screen.isValid(user , pword);
        Controller.disconnect();
        assertEquals(t,0);
    }
}