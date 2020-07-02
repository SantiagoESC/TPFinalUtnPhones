package edu.utn.phones.Controller.BackOffice;

import edu.utn.phones.Configuration.Configuration;
import edu.utn.phones.Controller.Model.ProvinceController;
import edu.utn.phones.Domain.Province;
import edu.utn.phones.Domain.Province;
import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.when;

@PrepareForTest(Configuration.class)
@RunWith(PowerMockRunner.class)
public class ProvinceBackofficeControllerTest {


    ProvinceBackofficeController provinceBackofficeController;
    ProvinceController provinceController;


    @Before
    public void setUp(){
        this.provinceController = mock(ProvinceController.class);
        this.provinceBackofficeController = new ProvinceBackofficeController(this.provinceController);
    }

    @Test
    public  void testAddOK(){




        Province p = TestUtils.createProvinceNoId();
        Province p2 = TestUtils.createProvince();
        PowerMockito.mockStatic(Configuration.class);

        when(this.provinceController.add(p)).thenReturn(p2);

        when(Configuration.getLocation(p2)).thenReturn(URI.create("http://localhost:8080/api/province/1"));

        ResponseEntity response = this.provinceBackofficeController.add(p);


        List<String> location = response.getHeaders().get("location");


        Assert.assertEquals("http://localhost:8080/api/province/1" , location.get(0));




    }


    @Test
    public void testUpdateOk() throws ResourceNotFoundException {
        Province c = TestUtils.createProvince();
        Province updated = TestUtils.createProvince2();
        PowerMockito.when(this.provinceController.getById(1)).thenReturn(c);
        PowerMockito.when(this.provinceController.update(any())).thenReturn(updated);
        ResponseEntity responseEntity = this.provinceBackofficeController.update(c,1);

        assertEquals(ResponseEntity.ok().build(),responseEntity);
        verify(this.provinceController,times(1)).update(c);

    }

    @Test(expected = ResourceNotFoundException.class)
    public void testUpdateResourceNotFoundException() throws ResourceNotFoundException {
        when(this.provinceController.getById(any())).thenThrow(new ResourceNotFoundException());
        ResponseEntity responseEntity = this.provinceBackofficeController.update(new Province(), 1);
    }


    @Test
    public void testDeleteOk() throws ResourceNotFoundException {

        Province c = TestUtils.createProvince();
        when(this.provinceController.getById(1)).thenReturn(c);
        doNothing().when(this.provinceController).delete(c);
        ResponseEntity responseEntity = this.provinceBackofficeController.delete(1);

        assertEquals(ResponseEntity.ok().build(),responseEntity);

        verify(this.provinceController, times(1)).delete(c);

    }


    @Test(expected = ResourceNotFoundException.class)
    public void testDeleteResourceNotFpundExcetion() throws ResourceNotFoundException {
        when(this.provinceController.getById(any())).thenThrow(new ResourceNotFoundException());
        ResponseEntity responseEntity = this.provinceBackofficeController.delete( 1);
    }

    @Test
    public void testGetByIdOK() throws ResourceNotFoundException {
        Province c = TestUtils.createProvince();
        when(this.provinceController.getById(1)).thenReturn(c);

        ResponseEntity<Province> resourceEntity= this.provinceBackofficeController.getById(1);

        assertEquals(ResponseEntity.ok(c),resourceEntity);
        assertEquals(c,resourceEntity.getBody());
        verify(this.provinceController, times(1)).getById(1);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetByIdResourceNotFoundException() throws ResourceNotFoundException {
        when(this.provinceController.getById(any())).thenThrow(new ResourceNotFoundException());
        ResponseEntity responseEntity = this.provinceBackofficeController.getById(1);
    }


    @Test
    public void testGetAllOk() throws NoContentToShowException, ResourceNotFoundException {
        List<Province> list =TestUtils.createProvinceList();
        when(this.provinceController.getAll()).thenReturn(list);

        ResponseEntity<List<Province>> responseEntity = this.provinceBackofficeController.getAll();

        assertEquals(ResponseEntity.ok(list),responseEntity);
        verify(this.provinceController, times(1)).getAll();
    }

    @Test(expected = NoContentToShowException.class)
    public void testGetAllNoContentToShowException() throws NoContentToShowException, ResourceNotFoundException {
        when(this.provinceController.getAll()).thenThrow(new NoContentToShowException());
        ResponseEntity responseEntity = this.provinceBackofficeController.getAll();
    }



}
