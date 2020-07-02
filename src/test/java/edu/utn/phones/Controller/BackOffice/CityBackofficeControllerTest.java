package edu.utn.phones.Controller.BackOffice;

import edu.utn.phones.Configuration.Configuration;
import edu.utn.phones.Controller.Model.CityController;
import edu.utn.phones.Domain.City;
import edu.utn.phones.Utils.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.ResponseEntity;

import java.net.URI;

import static org.mockito.Mockito.mock;


@RunWith(PowerMockRunner.class)
@PrepareForTest(Configuration.class)
@SuppressWarnings(value = "")
public class CityBackofficeControllerTest {

    @Mock
    private CityController cityController;
    private CityBackofficeController cityBackofficeController;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.cityBackofficeController = new CityBackofficeController(this.cityController);
    }

    @Test
    public void testAddOK() {


        City preAdd = TestUtils.createCityNoId();
        City postAdd = TestUtils.createCity();
        PowerMockito.mockStatic(Configuration.class);
        Mockito.when(this.cityController.add(preAdd)).thenReturn(postAdd);
        Mockito.when(Configuration.getLocation(postAdd)).thenReturn(URI.create("http://localhost:8080/api/city/1"));
        ResponseEntity response = this.cityBackofficeController.add(preAdd);

    }

    @Test
    public void testContruct(){
        CityBackofficeController c = new CityBackofficeController(mock(CityController.class));
    }


}
