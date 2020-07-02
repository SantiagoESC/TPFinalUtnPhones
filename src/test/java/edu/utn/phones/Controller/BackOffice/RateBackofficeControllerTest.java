package edu.utn.phones.Controller.BackOffice;

import edu.utn.phones.Controller.Model.RateController;
import org.junit.Before;

import static org.mockito.Mockito.mock;

public class RateBackofficeControllerTest {

    private RateBackofficeController rateBackofficeController;
    private RateController rateController;


    @Before
    public void setUp(){
        this.rateController = mock(RateController.class);
        this.rateBackofficeController= new RateBackofficeController(this.rateController);
    }
}
