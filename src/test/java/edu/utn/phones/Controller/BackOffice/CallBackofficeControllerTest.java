package edu.utn.phones.Controller.BackOffice;

import edu.utn.phones.Controller.Model.CallController;
import edu.utn.phones.Controller.Model.UserController;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class CallBackofficeControllerTest {

    @Test
    public void testContructor(){
        CallBackofficeController c = new CallBackofficeController(mock(CallController.class), mock(UserController.class));
    }
}
