package test;

import gui.LoginGUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LoginTest {
    @Test
    void loginWithValidFields() {
        LoginGUI screen = new LoginGUI();
        screen.getUserTf().setText("User");
        String user = screen.getUserTf().getText();
        screen.getPasswordField().setText("Key");
        String pword = screen.getPasswordField().getPassword().toString();
        assertNotEquals(screen.isValid(user,pword),0);
    }

    @Test
    void loginWithIncompleteUser() {
        LoginGUI screen = new LoginGUI();
        screen.getUserTf().setText("");
        String user = screen.getUserTf().getText();
        screen.getPasswordField().setText("Key");
        String pword = screen.getPasswordField().getPassword().toString();
        assertEquals(screen.isValid(user,pword),0);
    }

    @Test
    void loginWithIncompletePassword() {
        LoginGUI screen = new LoginGUI();
        screen.getUserTf().setText("User");
        String user = screen.getUserTf().getText();
        screen.getPasswordField().setText("");
        String pword = screen.getPasswordField().getPassword().toString();
        assertEquals(screen.isValid(user,pword),0);
    }
}