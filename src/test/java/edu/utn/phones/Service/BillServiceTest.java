package edu.utn.phones.Service;

import edu.utn.phones.Domain.Bill;
import edu.utn.phones.Domain.User;
import edu.utn.phones.Exceptions.GeneralExceptions.LoginException;
import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Repository.IBillRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BillServiceTest {

    private IBillRepository billRepository;
    private BillService billService;

    @Before
    public void setUp(){
        this.billRepository=mock(IBillRepository.class);
        this.billService = new BillService(this.billRepository);
    }

    @Test
    public void testConstruct(){
        BillService aux = new BillService(mock(IBillRepository.class));
    }

    @Test
    public void getAll() throws NoContentToShowException {
        List<Bill> list = new ArrayList<>();

        Bill aux = new Bill();

        list.add(aux);

        User u = new User();
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = LocalDateTime.now();

        when(billRepository.findByUserBillAndDateBillBetween(u,from,to)).thenReturn(list);

        List<Bill> ans = billService.getAll(u,from,to);
        assertEquals(ans,list);
        Mockito.verify(billRepository, times(1)).findByUserBillAndDateBillBetween(u,from,to);

    }

    @Test
    public void testGetAll() throws NoContentToShowException {
        List<Bill> list = new ArrayList<>();

        Bill aux = new Bill();

        list.add(aux);

        User u = new User();

        when(billRepository.findByUserBill(u)).thenReturn(list);

        List<Bill> ans = billService.getAll(u);
        assertEquals(ans,list);
        Mockito.verify(billRepository, times(1)).findByUserBill(u);

    }




    @Test(expected = NoContentToShowException.class)
    public void getAllException() throws NoContentToShowException {
        List<Bill> list = new ArrayList<>();
        User aux = new User();
        when(billRepository.findByUserBill(aux)).thenReturn(list);

        List<Bill> ans = billService.getAll(aux);
    }

    @Test(expected = NoContentToShowException.class)
    public void getAllException2() throws NoContentToShowException {
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = LocalDateTime.now();

        List<Bill> list = new ArrayList<>();
        User aux = new User();
        when(billRepository.findByUserBillAndDateBillBetween(aux,from,to)).thenReturn(list);
        List<Bill> ans = billService.getAll(aux,from,to);
    }
}
