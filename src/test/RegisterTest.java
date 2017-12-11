package test;

import Controller.Controller;
import gui.RegisterGUI;


import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;

import javax.swing.*;

public class RegisterTest {

    @Test
    public void registerWithValidFields() {
        //Controller.connect();
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
    public void registerWithIncompleteFields() {
        //Controller.connect();
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
    public void registerWithoutAcceptingConditions() {
        //Controller.connect();
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