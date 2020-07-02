package edu.utn.phones.Service;

import edu.utn.phones.Domain.Call;
import edu.utn.phones.Domain.City;
import edu.utn.phones.Domain.Enums.UserType;
import edu.utn.phones.Domain.User;
import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Repository.ICallRepository;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

public class CallServiceTest {


    private ICallRepository callRepository;
    private CallService callService;
    private List<Call> list;
    LocalDateTime from;
    LocalDateTime to;

    @Before
    public void setUp(){
        this.callRepository=mock(ICallRepository.class);
        this.callService = new CallService(this.callRepository);
        list = new ArrayList<>();
        from = LocalDateTime.now();
        to = LocalDateTime.now();
    }

    @Test
    public void testConstruct(){
        CallService c = new CallService(this.callRepository);
    }

    @Test
    public void getAll() throws NoContentToShowException {
        Call aux = new Call();
        list.add(aux);

        User u = new User();
        when(callRepository.findByLineOriginOwnerLine(u)).thenReturn(list);
        List<Call> ans = callService.getAll(u,null,null);

        assertEquals(ans,list);
        assertNotNull(ans);
        verify(this.callRepository, times(1)).findByLineOriginOwnerLine(u);

    }

    @Test
    public void getAllElse() throws NoContentToShowException {
        Call aux = new Call();
        list.add(aux);

        User u = new User();
        when(callRepository.findByLineOriginOwnerLineAndDateCallBetween(u,from,to)).thenReturn(list);
        List<Call> ans = callService.getAll(u,from,to);

        assertEquals(ans,list);
        assertNotNull(ans);
        verify(this.callRepository, times(1)).findByLineOriginOwnerLineAndDateCallBetween(u,from,to);

    }

    @Test(expected = NoContentToShowException.class)
    public void getAllException() throws NoContentToShowException {
        User u = new User();
        when(callRepository.findByLineOriginOwnerLineAndDateCallBetween(u,from,to)).thenReturn(list);
        List<Call> ans = callService.getAll(u,from,to);
    }

    @Test
    public void getAllByUser() throws NoContentToShowException {
        User u = new User(1,"asd","qwe","qwe","qwe","qwe", UserType.CLIENT,new City());
        Call aux = new Call();
        list.add(aux);
        when(callRepository.findByUser(1)).thenReturn(list);
        List<Call> ans = callService.getAllByUser(u);

        assertNotNull(ans);
        assertEquals(ans,list);
        verify(this.callRepository, times(1)).findByUser(1);

    }

    @Test(expected = NoContentToShowException.class)
    public void getAllByUserException() throws NoContentToShowException {
        User u = new User(1,"asd","qwe","qwe","qwe","qwe",UserType.CLIENT,new City());
        when(callRepository.findByUser(1)).thenReturn(list);
        List<Call> ans = callService.getAllByUser(u);
    }
}
