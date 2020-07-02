package edu.utn.phones.Controller.BackOffice;

import edu.utn.phones.Configuration.Configuration;
import edu.utn.phones.Controller.Model.CityController;
import edu.utn.phones.Domain.City;
import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import edu.utn.phones.Utils.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.when;


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
        when(this.cityController.add(preAdd)).thenReturn(postAdd);
        when(Configuration.getLocation(postAdd)).thenReturn(URI.create("http://localhost:8080/api/city/1"));
        ResponseEntity response = this.cityBackofficeController.add(preAdd);

    }

    @Test
    public void testContruct(){
        CityBackofficeController c = new CityBackofficeController(mock(CityController.class));
    }

    @Test
    public void testUpdateOk() throws ResourceNotFoundException {
        City c = TestUtils.createCity();
        City updated = TestUtils.createCity2();
        when(this.cityController.getById(1)).thenReturn(c);
        when(this.cityController.update(any())).thenReturn(updated);
        ResponseEntity responseEntity = this.cityBackofficeController.update(c,1);

        assertEquals(ResponseEntity.ok().build(),responseEntity);
        verify(this.cityController,times(1)).update(c);

    }

    @Test(expected = ResourceNotFoundException.class)
    public void testUpdateResourceNotFoundException() throws ResourceNotFoundException {
        when(this.cityController.getById(any())).thenThrow(new ResourceNotFoundException());
        ResponseEntity responseEntity = this.cityBackofficeController.update(new City(), 1);
    }


    @Test
    public void testDeleteOk() throws ResourceNotFoundException {

        City c = TestUtils.createCity();
        when(this.cityController.getById(1)).thenReturn(c);
        doNothing().when(this.cityController).delete(c);
        ResponseEntity responseEntity = this.cityBackofficeController.delete(1);

        assertEquals(ResponseEntity.ok().build(),responseEntity);

        verify(this.cityController, times(1)).delete(c);

    }


    @Test(expected = ResourceNotFoundException.class)
    public void testDeleteResourceNotFpundExcetion() throws ResourceNotFoundException {
        when(this.cityController.getById(any())).thenThrow(new ResourceNotFoundException());
        ResponseEntity responseEntity = this.cityBackofficeController.delete( 1);
    }

    @Test
    public void testGetByIdOK() throws ResourceNotFoundException {
        City c = TestUtils.createCity();
        when(this.cityController.getById(1)).thenReturn(c);

       ResponseEntity<City> resourceEntity= this.cityBackofficeController.getById(1);

       assertEquals(ResponseEntity.ok(c),resourceEntity);
       assertEquals(c,resourceEntity.getBody());
       verify(this.cityController, times(1)).getById(1);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetByIdResourceNotFoundException() throws ResourceNotFoundException {
        when(this.cityController.getById(any())).thenThrow(new ResourceNotFoundException());
        ResponseEntity responseEntity = this.cityBackofficeController.getById(1);
    }


    @Test
    public void testGetAllOk() throws NoContentToShowException {
        List<City> list =TestUtils.createCityList();
        when(this.cityController.getAll()).thenReturn(list);

        ResponseEntity<List<City>> responseEntity = this.cityBackofficeController.getAll();

        assertEquals(ResponseEntity.ok(list),responseEntity);
        verify(this.cityController, times(1)).getAll();
    }

    @Test(expected = NoContentToShowException.class)
    public void testGetAllNoContentToShowException() throws NoContentToShowException {
        when(this.cityController.getAll()).thenThrow(new NoContentToShowException());
        ResponseEntity responseEntity = this.cityBackofficeController.getAll();
    }

}
