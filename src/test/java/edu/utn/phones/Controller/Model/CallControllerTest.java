package edu.utn.phones.Controller.Model;

import edu.utn.phones.Domain.Call;
import edu.utn.phones.Domain.City;
import edu.utn.phones.Domain.Enums.UserType;
import edu.utn.phones.Domain.User;
import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Repository.ICallRepository;
import edu.utn.phones.Service.CallService;
import edu.utn.phones.Utils.TestUtils;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

public class CallControllerTest {
    private CallService callService;
    private CallController callController;
    private List<Call> list;
    LocalDateTime from;
    LocalDateTime to;

    @Before
    public void setUp(){
        this.callService=mock(CallService.class);
        this.callController = new CallController(this.callService);
        list = new ArrayList<>();
        from = LocalDateTime.now();
        to = LocalDateTime.now();
    }

    @Test
    public void testConstruct(){
        CallController c = new CallController(this.callService);
    }

    @Test
    public void testGetAll() throws NoContentToShowException {

        List<Call> listCall = TestUtils.createCallList();
        when(this.callService.getAll(any(),any(),any())).thenReturn(listCall);

        List<Call> actual = this.callController.getAll(TestUtils.createUser(), this.from,this.to);

        assertNotNull(actual);
        assertEquals(listCall,actual);
        verify(this.callService,times(1)).getAll(any(),any(),any());
    }


    @Test(expected = NoContentToShowException.class)
    public void getAllNoContentToShow() throws NoContentToShowException {
        when(this.callService.getAll(any(),any(),any())).thenThrow(new NoContentToShowException());
        List<Call> actual = this.callController.getAll(TestUtils.createUser(), this.from,this.to);
    }

    @Test
    public void TestgetAllByUser() throws NoContentToShowException {
        User u = TestUtils.createUser();
        when(this.callService.getAllByUser(u)).thenReturn(this.list);
        List<Call> listCall = this.callController.getAllByUser(u);

        assertNotNull(list);
        assertEquals(list, listCall);
    }

    @Test(expected = NoContentToShowException.class)
    public void TestgetAllByUserNoContentToShowException() throws NoContentToShowException {
        when(this.callService.getAllByUser(any())).thenThrow(new NoContentToShowException());
        List<Call> actual = this.callController.getAllByUser(TestUtils.createUser());
    }


}
