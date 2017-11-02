/**
 * Created by sswinnen on 26/10/17.
 */

package test;

import gui.SearchGUI;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;

public class AvailabilityCheckTest {
    @Test
    public void availabilityCheckWithCityText() {
        SearchGUI tester = new SearchGUI();
        JButton submit = tester.getSearchBtn();
        tester.getCityTf().setText("Hola");
        submit.doClick();
        //Assert.assertTrue(LO QUE PASE SI LA BUSQUEDA SE PRODUCE);
    }

    @Test
    public void availabilityCheckWithoutCityText() {
        SearchGUI tester = new SearchGUI();
        JButton submit = tester.getSearchBtn();
        tester.getCityTf().setText("");
        submit.doClick();
        //Assert.assertFalse(LO QUE PASE SI LA BUSQUEDA ES VACIA);
    }

}
