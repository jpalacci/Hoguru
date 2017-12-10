package test;

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

        assertTrue(screen.isRegistrationValid());
    }

    @Test
    void registerWithIncompleteFields() {
        RegisterGUI screen = new RegisterGUI(new JFrame());
        screen.getAcceptConditionChckbx().doClick();
        screen.getCountryCb().setSelectedIndex(0);
        screen.getDocumentNumberFtf().setText("");
        screen.getDocumentTypeCb().setSelectedIndex(0);
        screen.getLastNameTf().setText("");
        screen.getNameTf().setText("Juan");
        screen.getMailTf().setText("jperez@itba.edu.ar");
        screen.getPasswordField().setText("12345abcde");
        screen.getPasswordConfirmationField().setText("12345abcde");
        screen.getTelephoneFtf().setText("");
        screen.getNumberFtf().setText("1234");
        screen.getStreetTf().setText("Street");
        screen.getProvinceCb().setSelectedIndex(0);
        screen.getCountryCb().setSelectedIndex(0);
        screen.getPostCodeFtf().setText("1234");
        screen.getPlaceTf().setText("place");

        assertFalse(screen.isRegistrationValid());
    }

    @Test
    void registerWithoutAcceptingConditions() {
        RegisterGUI screen = new RegisterGUI(new JFrame());
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

        assertFalse(screen.isRegistrationValid());
    }




}
