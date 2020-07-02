package edu.utn.phones.Controller.Model;

import edu.utn.phones.Service.CityService;
import edu.utn.phones.Service.ProvinceService;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class CityControllerTest {


    @Test
    public void testConstructor() {
        CityController p = new CityController(mock(CityService.class));
    }
}
