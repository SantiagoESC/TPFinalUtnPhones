package edu.utn.phones.Controller.Model;

import edu.utn.phones.Service.ProvinceService;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class ProvinceControllerTest {

    @Test
    public void testConstructor(){
        ProvinceController p = new ProvinceController(mock(ProvinceService.class));
    }
}
