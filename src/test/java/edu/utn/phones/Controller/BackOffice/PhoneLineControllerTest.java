package edu.utn.phones.Controller.BackOffice;

import edu.utn.phones.Configuration.Configuration;
import edu.utn.phones.Controller.Model.PhoneLineController;
import edu.utn.phones.Domain.PhoneLine;
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
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Configuration.class)
public class PhoneLineControllerTest {


    private PhoneLineBackofficeController phoneLineBackofficeController;
    private PhoneLineController phoneLineController;

    @Before
    public void setUp(){
        this.phoneLineController = mock(PhoneLineController.class);
        this.phoneLineBackofficeController = new PhoneLineBackofficeController(this.phoneLineController);
    }


    @Test
    public void testAddOK() {


        PhoneLine preAdd = TestUtils.createPhoneLineNoId();
        PhoneLine postAdd = TestUtils.createPhoneLine();
        PowerMockito.mockStatic(Configuration.class);
        when(this.phoneLineController.add(preAdd)).thenReturn(postAdd);
        when(Configuration.getLocation(postAdd)).thenReturn(URI.create("http://localhost:8080/api/phoneLine/1"));
        ResponseEntity response = this.phoneLineBackofficeController.add(preAdd);

    }

    @Test
    public void testContruct() {
        PhoneLineBackofficeController c = new PhoneLineBackofficeController(mock(PhoneLineController.class));
    }

    @Test
    public void testUpdateOk() throws ResourceNotFoundException {
        PhoneLine c = TestUtils.createPhoneLine();
        PhoneLine updated = TestUtils.createPhoneLine2();
        when(this.phoneLineController.getById(1)).thenReturn(c);
        when(this.phoneLineController.update(any())).thenReturn(updated);
        ResponseEntity responseEntity = this.phoneLineBackofficeController.update(c, 1);

        assertEquals(ResponseEntity.ok().build(), responseEntity);
        verify(this.phoneLineController, times(1)).update(c);

    }

    @Test(expected = ResourceNotFoundException.class)
    public void testUpdateResourceNotFoundException() throws ResourceNotFoundException {
        when(this.phoneLineController.getById(any())).thenThrow(new ResourceNotFoundException());
        ResponseEntity responseEntity = this.phoneLineBackofficeController.update(new PhoneLine(), 1);
    }


    @Test
    public void testDeleteOk() throws ResourceNotFoundException {

        PhoneLine c = TestUtils.createPhoneLine();
        when(this.phoneLineController.getById(1)).thenReturn(c);
        doNothing().when(this.phoneLineController).delete(c);
        ResponseEntity responseEntity = this.phoneLineBackofficeController.delete(1);

        assertEquals(ResponseEntity.ok().build(), responseEntity);

        verify(this.phoneLineController, times(1)).delete(c);

    }


    @Test(expected = ResourceNotFoundException.class)
    public void testDeleteResourceNotFoundExcetion() throws ResourceNotFoundException {
        when(this.phoneLineController.getById(any())).thenThrow(new ResourceNotFoundException());
        ResponseEntity responseEntity = this.phoneLineBackofficeController.delete(1);
    }

    @Test
    public void testGetByIdOK() throws ResourceNotFoundException {
        PhoneLine c = TestUtils.createPhoneLine();
        when(this.phoneLineController.getById(1)).thenReturn(c);

        ResponseEntity<PhoneLine> resourceEntity = this.phoneLineBackofficeController.getById(1);

        assertEquals(ResponseEntity.ok(c), resourceEntity);
        assertEquals(c, resourceEntity.getBody());
        verify(this.phoneLineController, times(1)).getById(1);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetByIdResourceNotFoundException() throws ResourceNotFoundException {
        when(this.phoneLineController.getById(any())).thenThrow(new ResourceNotFoundException());
        ResponseEntity responseEntity = this.phoneLineBackofficeController.getById(1);
    }


    @Test
    public void testGetAllOk() throws NoContentToShowException, ResourceNotFoundException {
        List<PhoneLine> list = TestUtils.createPhoneLineList();
        when(this.phoneLineController.getAll()).thenReturn(list);

        ResponseEntity<List<PhoneLine>> responseEntity = this.phoneLineBackofficeController.getAll();

        assertEquals(ResponseEntity.ok(list), responseEntity);
        verify(this.phoneLineController, times(1)).getAll();
    }

    @Test(expected = NoContentToShowException.class)
    public void testGetAllNoContentToShowException() throws NoContentToShowException, ResourceNotFoundException {
        when(this.phoneLineController.getAll()).thenThrow(new NoContentToShowException());
        ResponseEntity responseEntity = this.phoneLineBackofficeController.getAll();
    }
}
