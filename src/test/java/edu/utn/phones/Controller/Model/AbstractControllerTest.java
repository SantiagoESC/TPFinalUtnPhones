package edu.utn.phones.Controller.Model;

import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import edu.utn.phones.Domain.Province;
import edu.utn.phones.Repository.IProvinceRepository;
import edu.utn.phones.Service.AbstractService;
import edu.utn.phones.Service.ProvinceService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class AbstractControllerTest {

    private AbstractController<Province, ProvinceService> abstractController;
    @Mock
    private AbstractService<Province, IProvinceRepository> abstractService;


    @Before
    public void setUp() {
        initMocks(this);
        this.abstractController = new AbstractController(this.abstractService);
    }

    @Test
    public void testAddOk() {
        Province toAdd = Province.builder().nameProvince("Buenos Aires").build();
        Province added = Province.builder().nameProvince("Buenos Aires").idProvince(1).build();

        when(abstractService.add(toAdd)).thenReturn(added);

        Province actual = this.abstractController.add(toAdd);
        Province expected = Province.builder().nameProvince("Buenos Aires").idProvince(1).build();

        verify(this.abstractService, times(1)).add(toAdd);
        assertEquals(expected, actual);
    }


    @Test
    public void testUpdateOk() {
        Province toUpdate = Province.builder().idProvince(1).nameProvince("Cordoba").build();
        Province updated = Province.builder().idProvince(1).nameProvince("Cordoba").build();

        when(abstractService.update(toUpdate)).thenReturn(updated);

        Province actual = this.abstractController.update(toUpdate);
        Province expected = Province.builder().idProvince(1).nameProvince("Cordoba").build();

        verify(this.abstractService, times(1)).update(toUpdate);
        assertEquals(expected, actual);
    }


    @Test
    public void testDeleteOk() {
        Province toDelete = Province.builder().idProvince(1).nameProvince("Cordoba").build();
        doNothing().when(this.abstractService).delete(toDelete);

        this.abstractController.delete(toDelete);

        verify(this.abstractService, times(1)).delete(any());
    }

    @Test
    public void testGetByIdOk() throws ResourceNotFoundException {
        Integer id = 1;
        Province toGet = Province.builder().idProvince(1).nameProvince("Buenos Aires").build();

        when(this.abstractService.getById(id)).thenReturn(toGet);
        Province actual = this.abstractController.getById(id);
        Province expected = Province.builder().idProvince(1).nameProvince("Buenos Aires").build();

        verify(this.abstractService, times(1)).getById(id);
        assertEquals(expected, actual);

    }


    @Test(expected = ResourceNotFoundException.class)
    public void testGetByIdResourceNotFoundException() throws ResourceNotFoundException {
        when(this.abstractService.getById(any())).thenThrow(new ResourceNotFoundException());
        Province p = this.abstractController.getById(1);
    }

    @Test
    public void testGetAll() throws NoContentToShowException {
        List<Province> list = new ArrayList<Province>();
        Province p = Province.builder().idProvince(1).nameProvince("Buenos Aires").build();
        Province p2 = Province.builder().idProvince(2).nameProvince("Cordoba").build();

        list.add(p);
        list.add(p2);

        when(this.abstractService.getAll()).thenReturn(list);


        List<Province> expected = list;

        List<Province> actual = this.abstractController.getAll();

        verify(this.abstractService, times(1)).getAll();
        assertEquals(expected,actual);
    }
}
