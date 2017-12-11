package test;

import gui.EditUserGUI;
import model.Person;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EditUserTest {
   @Test
   void editUserWithValidFields() {
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
   void editUserWithIncompleteFields() {
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
   void editUserWithoutAcceptingCondition() {
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
