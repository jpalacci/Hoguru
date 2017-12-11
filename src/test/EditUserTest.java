package test;

import Controller.Controller;
import gui.EditUserGUI;
import model.Person;


import javax.swing.*;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class EditUserTest {

   @Test
   public void editUserWithValidFields() {
        Controller.connect();
        EditUserGUI screen = new EditUserGUI(new JFrame(),null);
        screen.getAcceptConditionChckbx().doClick();
        screen.getCountryCb().setSelectedIndex(0);
        screen.getDocumentNumberFtf().setText("2034565432");
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
        screen.getPhoneTypeCB().setSelectedIndex(0);
        assertTrue(screen.isRegistrationValid());
   }

   @Test
   public void editUserWithIncompleteFields() {
        Controller.connect();
        EditUserGUI screen = new EditUserGUI(new JFrame(),null);
        screen.getAcceptConditionChckbx().doClick();
        screen.getCountryCb().setSelectedIndex(0);
        screen.getDocumentNumberFtf().setText("");
        screen.getLastNameTf().setText("");
        screen.getNameTf().setText("Juan");
        screen.getMailTf().setText("jperez@itba.edu.ar");
        screen.getPasswordField().setText("");
        screen.getPasswordConfirmationField().setText("");
        screen.getTelephoneFtf().setText("541143522345");
        screen.getNumberFtf().setText("1234");
        screen.getStreetTf().setText("Street");
        screen.getProvinceCb().setSelectedIndex(0);
        screen.getCountryCb().setSelectedIndex(0);
        screen.getPostCodeFtf().setText("1234");
        screen.getPlaceTf().setText("place");
        screen.getPhoneTypeCB().setSelectedIndex(0);

        assertFalse(screen.isRegistrationValid());
   }

   @Test
   public void editUserWithoutAcceptingCondition() {
        Controller.connect();
        EditUserGUI screen = new EditUserGUI(new JFrame(),null);
        screen.getCountryCb().setSelectedIndex(0);
        screen.getDocumentNumberFtf().setText("2034565432");
        screen.getLastNameTf().setText("");
        screen.getNameTf().setText("Juan");
        screen.getMailTf().setText("jperez@itba.edu.ar");
        screen.getPasswordField().setText("");
        screen.getPasswordConfirmationField().setText("12345abcde");
        screen.getTelephoneFtf().setText("541143522345");
        screen.getNumberFtf().setText("1234");
        screen.getStreetTf().setText("Street");
        screen.getProvinceCb().setSelectedIndex(0);
        screen.getCountryCb().setSelectedIndex(0);
        screen.getPostCodeFtf().setText("1234");
        screen.getPlaceTf().setText("place");
        screen.getPhoneTypeCB().setSelectedIndex(0);

        assertFalse(screen.isRegistrationValid());
   }

}
