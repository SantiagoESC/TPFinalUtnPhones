package edu.utn.phones.Controller.Model;


import edu.utn.phones.Exceptions.ModelExceptions.ProvinceNotExitsException;
import edu.utn.phones.Model.Province;
import edu.utn.phones.Service.ProvinceService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ProvinceControllerTest {
    ProvinceController provinceController;
    ProvinceService provinceService;


    @Before
    public void setUp(){
        this.provinceService = mock(ProvinceService.class);
        this.provinceController = new ProvinceController(provinceService);
    }

    @Test
    public void testAddProvinceOk(){
        Province newProvince = new Province();
        newProvince.setNameProvince("Buenos Aires");
        when(this.provinceService.addProvince(newProvince)).thenReturn(new Province(1,"Buenos Aires"));
        Province actual = this.provinceController.addProvince(newProvince);

        verify(this.provinceService, times(1)).addProvince(newProvince);
        assertEquals(new Province(1,"Buenos Aires"), actual);

    }


    @Test
    public void testUpdateProvinceOK(){
        Province updatedProvince = new Province(1,"Corrientes");
        when(this.provinceService.updateProvince(any())).thenReturn(updatedProvince);
        Province actual = this.provinceController.updateProvince(updatedProvince);

        verify(this.provinceService, times(1)).updateProvince(updatedProvince);
        assertEquals(new Province(1, "Corrientes"), actual);
    }


    @Test
    public void testDeleteProvinceOk(){
        Province p = new Province(1,"Corrientes");
        doNothing().when(this.provinceService).deleteProvince(any());
        this.provinceController.deleteProvince(p);

        verify(this.provinceService,times(1)).deleteProvince(any());
    }

    @Test
    public void testGetByIdOk() throws ProvinceNotExitsException {
        when(this.provinceService.getById(any())).thenReturn(new Province(1, "Buenos Aires"));
        Province p = this.provinceController.getById(1);

        verify(this.provinceService,times(1)).getById(any());
        assertEquals(new Province(1, "Buenos Aires"), p);
    }

    @Test(expected = ProvinceNotExitsException.class)
    public void testGetByIdProvinceNotExists() throws ProvinceNotExitsException {
        when(this.provinceService.getById(any())).thenThrow(new ProvinceNotExitsException());

        this.provinceController.getById(-1);

    }

    @Test
    public void testGetAllOk(){
        List<Province> list = new ArrayList<Province>();
        list.add(new Province(1,"Buenos Aires"));
        list.add(new Province(2,"Corrientes"));
        when(this.provinceService.getAll(null)).thenReturn(list);
        List<Province> actual = this.provinceController.getAll(null);

        verify(this.provinceService,times(1)).getAll(any());
        assertEquals(list, actual);
    }


    @Test
    public void testGetAllNameProvinceFilterOk(){
        List<Province> list = new ArrayList<Province>();
        list.add(new Province(1,"Buenos Aires"));
        when(this.provinceService.getAll("Buenos Aires")).thenReturn(list);
        List<Province> actual = this.provinceController.getAll("Buenos Aires");

        verify(this.provinceService,times(1)).getAll(any());
        assertEquals(list, actual);
    }

}
