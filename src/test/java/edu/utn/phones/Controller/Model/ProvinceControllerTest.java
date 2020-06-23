package edu.utn.phones.Controller.Model;


import edu.utn.phones.Service.ProvinceService;
import org.junit.Before;

import static org.mockito.Mockito.mock;


public class ProvinceControllerTest {
    ProvinceController provinceController;
    ProvinceService provinceService;


    @Before
    public void setUp(){
        this.provinceService = mock(ProvinceService.class);
        this.provinceController = new ProvinceController(provinceService);
    }



}
