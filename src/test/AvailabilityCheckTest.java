/**
 * Created by sswinnen on 26/10/17.
 */

package test;

import gui.SearchGUI;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AvailabilityCheckTest {
    @Test
    public void availabilityCheckWithCityText() {
        SearchGUI tester = new SearchGUI();
        JButton submit = tester.getSearchBtn();
        tester.getCityTf().setText("Hola");
        submit.doClick();
        assertTrue(tester.isValid());
        //Assert.assertTrue(LO QUE PASE SI LA BUSQUEDA SE PRODUCE);
    }

    @Test
    public void availabilityCheckWithoutCityText() {
        SearchGUI tester = new SearchGUI();
        JButton submit = tester.getSearchBtn();
        tester.getCityTf().setText("");
        submit.doClick();
        assertTrue(tester.isValid());
    }

}
