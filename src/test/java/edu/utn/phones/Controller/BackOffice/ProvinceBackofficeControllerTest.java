package edu.utn.phones.Controller.BackOffice;

import edu.utn.phones.Configuration.Configuration;
import edu.utn.phones.Controller.Model.ProvinceController;
import edu.utn.phones.Model.Province;
import edu.utn.phones.Utils.TestUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@PrepareForTest(Configuration.class)
@RunWith(PowerMockRunner.class)
public class ProvinceBackofficeControllerTest {


    ProvinceBackofficeController provinceWebController;
    ProvinceController provinceController;


    @Before
    public void setUp(){
        this.provinceController = mock(ProvinceController.class);
        this.provinceWebController = new ProvinceBackofficeController(this.provinceController);
    }

    @Test
    public  void testAddOK(){




        Province p = TestUtils.createProvinceNoId();
        Province p2 = TestUtils.createProvince();
        PowerMockito.mockStatic(Configuration.class);

        when(this.provinceController.add(p)).thenReturn(p2);

        when(Configuration.getLocation(p2)).thenReturn(URI.create("http://localhost:8080/api/province/1"));

        ResponseEntity response = this.provinceWebController.add(p);


        List<String> location = response.getHeaders().get("location");


        Assert.assertEquals("http://localhost:8080/api/province/1" , location.get(0));




    }


}
