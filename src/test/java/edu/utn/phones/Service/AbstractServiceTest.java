package edu.utn.phones.Service;

import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import edu.utn.phones.Model.Province;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AbstractServiceTest {

    private AbstractService<Province, JpaRepository<Province,Integer>> abstractService;
    private JpaRepository<Province,Integer> repository;

    @Before
    public void setUp(){
        this.repository = mock(JpaRepository.class);
        this.abstractService = new AbstractService(this.repository);
    }


    @Test
    public void testAddOk(){
        Province toAdd = Province.builder().nameProvince("Buenos Aires").build();
        Province added = Province.builder().nameProvince("Buenos Aires").idProvince(1).build();


        when(this.repository.save(toAdd)).thenReturn(added);
        Province actual = this.abstractService.add(toAdd);
        Province expected = Province.builder().nameProvince("Buenos Aires").idProvince(1).build();

        verify(this.repository, times(1)).save(toAdd);
        assertEquals(expected, actual);

    }

    @Test
    public void testUpdateOk(){
        Province toUpdate = Province.builder().idProvince(1).nameProvince("Buenos Aires").build();
        Province updateed = Province.builder().nameProvince("Buenos Aires").idProvince(1).build();


        when(this.repository.save(toUpdate)).thenReturn(updateed);
        Province actual = this.abstractService.update(toUpdate);
        Province expected = Province.builder().nameProvince("Buenos Aires").idProvince(1).build();

        verify(this.repository, times(1)).save(toUpdate);
        assertEquals(expected, actual);

    }


    @Test
    public void testDeleteOK(){
        Province toDelete = Province.builder().idProvince(1).nameProvince("Cordoba").build();
        doNothing().when(this.repository).delete(toDelete);

        this.abstractService.delete(toDelete);

        verify(this.repository, times(1)).delete(toDelete);
    }


    @Test
    public void testGetByIdOk() throws ResourceNotFoundException {
        Integer id = 1;
        Province toGet = Province.builder().idProvince(1).nameProvince("Buenos Aires").build();

        when(this.repository.findById(id)).thenReturn(java.util.Optional.ofNullable(toGet));
        Province actual = this.abstractService.getById(id);
        Province expected = Province.builder().idProvince(1).nameProvince("Buenos Aires").build();

        verify(this.repository, times(1)).findById(id);
        assertEquals(expected, actual);

    }



    @Test(expected = ResourceNotFoundException.class)
    public void testGetByIdResourceNotFoundException() throws ResourceNotFoundException {
        when(repository.findById(any())).thenReturn(java.util.Optional.ofNullable(null));//todo chekear porque no le gusta thenthrow
        Province p = this.abstractService.getById(1);
    }


    @Test
    public void testGetAll(){
        List<Province> list = new ArrayList<Province>();
        Province p = Province.builder().idProvince(1).nameProvince("Buenos Aires").build();
        Province p2 = Province.builder().idProvince(2).nameProvince("Cordoba").build();

        list.add(p);
        list.add(p2);

        when(this.repository.findAll()).thenReturn(list);


        List<Province> expected = list;

        List<Province> actual = this.abstractService.getAll();

        verify(this.repository, times(1)).findAll();
        assertEquals(expected,actual);
    }




}
