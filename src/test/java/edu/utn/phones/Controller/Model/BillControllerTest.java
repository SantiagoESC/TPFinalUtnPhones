package edu.utn.phones.Controller.Model;

import edu.utn.phones.Domain.Bill;
import edu.utn.phones.Domain.User;
import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Service.BillService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BillControllerTest {


    private BillService billService;
    private BillController billController;

    @Before
    public void setUp(){
        this.billService=mock(BillService.class);
        this.billController = new BillController(this.billService);
    }

    @Test
    public void testConstructor(){
        BillController bc = new BillController(mock(BillService.class));
    }



    @Test
    public void getAll() throws NoContentToShowException {
        List<Bill> list = new ArrayList<>();

        Bill aux = new Bill();

        list.add(aux);

        User u = new User();
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = LocalDateTime.now();

        when(billService.getAll(u,from,to)).thenReturn(list);

        List<Bill> ans = billController.getAll(u,from,to);
        assertEquals(ans,list);
        Mockito.verify(billService, times(1)).getAll(u,from,to);

    }

    @Test
    public void testGetAll() throws NoContentToShowException {
        List<Bill> list = new ArrayList<>();

        Bill aux = new Bill();

        list.add(aux);

        User u = new User();

        when(billService.getAll(u)).thenReturn(list);

        List<Bill> ans = billController.getAll(u);
        assertEquals(ans,list);
        Mockito.verify(billService, times(1)).getAll(u);

    }




    @Test(expected = NoContentToShowException.class)
    public void getAllException() throws NoContentToShowException {
        List<Bill> list = new ArrayList<>();
        User aux = new User();
        when(billService.getAll(aux)).thenThrow(new NoContentToShowException());

        List<Bill> ans = billController.getAll(aux);
    }

    @Test(expected = NoContentToShowException.class)
    public void getAllException2() throws NoContentToShowException {
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = LocalDateTime.now();

        List<Bill> list = new ArrayList<>();
        User aux = new User();
        when(billService.getAll(aux,from,to)).thenThrow(new NoContentToShowException());
        List<Bill> ans = billController.getAll(aux,from,to);
    }


}
