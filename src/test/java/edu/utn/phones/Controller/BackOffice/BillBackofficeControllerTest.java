package edu.utn.phones.Controller.BackOffice;

import edu.utn.phones.Controller.Model.ProvinceController;
import edu.utn.phones.Controller.Model.UserController;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class BillBackofficeControllerTest {

    @Test
    public void testConstructor (){
        ProvinceBackofficeController p = new ProvinceBackofficeController(mock(ProvinceController.class));
    }
}
