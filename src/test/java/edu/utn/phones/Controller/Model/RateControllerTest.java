package edu.utn.phones.Controller.Model;

import edu.utn.phones.Service.CityService;
import edu.utn.phones.Service.RateService;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class RateControllerTest {

    @Test
    public void testConstructor() {
        RateController p = new RateController(mock(RateService.class));
    }
}
