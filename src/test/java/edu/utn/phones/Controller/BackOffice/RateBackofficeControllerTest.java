package edu.utn.phones.Controller.BackOffice;

import edu.utn.phones.Configuration.Configuration;
import edu.utn.phones.Controller.Model.RateController;
import edu.utn.phones.Domain.Rate;
import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import edu.utn.phones.Utils.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class RateBackofficeControllerTest {

    private RateBackofficeController rateBackofficeController;
    private RateController rateController;


    @Before
    public void setUp(){
        this.rateController = mock(RateController.class);
        this.rateBackofficeController= new RateBackofficeController(this.rateController);
    }


    @Test
    public void testAddOK() {


        Rate preAdd = TestUtils.createRateNoId();
        Rate postAdd = TestUtils.createRate();
        PowerMockito.mockStatic(Configuration.class);
        when(this.rateController.add(preAdd)).thenReturn(postAdd);
        when(Configuration.getLocation(postAdd)).thenReturn(URI.create("http://localhost:8080/api/rate/1"));
        ResponseEntity response = this.rateBackofficeController.add(preAdd);

    }

    @Test
    public void testContruct(){
        RateBackofficeController c = new RateBackofficeController(mock(RateController.class));
    }

    @Test
    public void testUpdateOk() throws ResourceNotFoundException {
        Rate c = TestUtils.createRate();
        Rate updated = TestUtils.createRate2();
        when(this.rateController.getById(1)).thenReturn(c);
        when(this.rateController.update(any())).thenReturn(updated);
        ResponseEntity responseEntity = this.rateBackofficeController.update(c,1);

        assertEquals(ResponseEntity.ok().build(),responseEntity);
        verify(this.rateController,times(1)).update(c);

    }

    @Test(expected = ResourceNotFoundException.class)
    public void testUpdateResourceNotFoundException() throws ResourceNotFoundException {
        when(this.rateController.getById(any())).thenThrow(new ResourceNotFoundException());
        ResponseEntity responseEntity = this.rateBackofficeController.update(new Rate(), 1);
    }


    @Test
    public void testDeleteOk() throws ResourceNotFoundException {

        Rate c = TestUtils.createRate();
        when(this.rateController.getById(1)).thenReturn(c);
        doNothing().when(this.rateController).delete(c);
        ResponseEntity responseEntity = this.rateBackofficeController.delete(1);

        assertEquals(ResponseEntity.ok().build(),responseEntity);

        verify(this.rateController, times(1)).delete(c);

    }


    @Test(expected = ResourceNotFoundException.class)
    public void testDeleteResourceNotFpundExcetion() throws ResourceNotFoundException {
        when(this.rateController.getById(any())).thenThrow(new ResourceNotFoundException());
        ResponseEntity responseEntity = this.rateBackofficeController.delete( 1);
    }

    @Test
    public void testGetByIdOK() throws ResourceNotFoundException {
        Rate c = TestUtils.createRate();
        when(this.rateController.getById(1)).thenReturn(c);

        ResponseEntity<Rate> resourceEntity= this.rateBackofficeController.getById(1);

        assertEquals(ResponseEntity.ok(c),resourceEntity);
        assertEquals(c,resourceEntity.getBody());
        verify(this.rateController, times(1)).getById(1);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetByIdResourceNotFoundException() throws ResourceNotFoundException {
        when(this.rateController.getById(any())).thenThrow(new ResourceNotFoundException());
        ResponseEntity responseEntity = this.rateBackofficeController.getById(1);
    }


    @Test
    public void testGetAllOk() throws NoContentToShowException, ResourceNotFoundException {
        List<Rate> list =TestUtils.createRateList();
        when(this.rateController.getAll()).thenReturn(list);

        ResponseEntity<List<Rate>> responseEntity = this.rateBackofficeController.getAll();

        assertEquals(ResponseEntity.ok(list),responseEntity);
        verify(this.rateController, times(1)).getAll();
    }

    @Test(expected = NoContentToShowException.class)
    public void testGetAllNoContentToShowException() throws NoContentToShowException, ResourceNotFoundException {
        when(this.rateController.getAll()).thenThrow(new NoContentToShowException());
        ResponseEntity responseEntity = this.rateBackofficeController.getAll();
    }

}
