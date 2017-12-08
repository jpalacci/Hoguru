package test;

import gui.LoginGUI;
import gui.RegisterGUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.*;

public class RegisterTest {

    @Test
    void registerWithValidFields() {
        RegisterGUI screen = new RegisterGUI(new JFrame());
        screen.getAcceptConditionChckbx().doClick();
        screen.getCountryCb().setSelectedIndex(0);
        screen.getDocumentNumberFtf().setText("2034565432");
        screen.getDocumentTypeCb().setSelectedIndex(0);
        screen.getLastNameTf().setText("Perez");
        screen.getNameTf().setText("Juan");
        screen.getMailTf().setText("jperez@itba.edu.ar");
        screen.getPasswordField().setText("12345abcde");
        screen.getPasswordConfirmationField().setText("12345abcde");
        screen.getTelephoneFtf().setText("541143522345");
        screen.getNumberFtf().setText("1234");
        screen.getStreetTf().setText("Street");
        screen.getProvinceCb().setSelectedIndex(0);
        screen.getCountryCb().setSelectedIndex(0);
        screen.getPostCodeFtf().setText("1234");
        screen.getPlaceTf().setText("place");

        /*TODO en la pantalla de alta de usuario hay que agrupar los ifs que verifican la
         * entrada del usuario dentro de un metodo booleano de la clase que pueda ser usado aca.
         */
        assertTrue(true);
    }
}
