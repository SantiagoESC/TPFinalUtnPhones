package edu.utn.phones.Controller.Web;

import edu.utn.phones.Controller.Model.CallController;
import edu.utn.phones.Domain.Call;
import edu.utn.phones.Domain.User;
import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Session.SessionManager;
import edu.utn.phones.Utils.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

public class CallWebControllerTest {

    private  CallWebController callWebController;
    private CallController callController;
    private SessionManager sessionManager;



    @Before
    public void setUp(){
        this.callController=mock(CallController.class);
        this.sessionManager=mock(SessionManager.class);
        this.callWebController = new CallWebController( this.sessionManager ,this.callController);
    }

    @Test
    public void getCallsBetweenDatesOkNoParameters() throws ParseException, NoContentToShowException {
        User test = TestUtils.createUser();
        List<Call> listCall = TestUtils.createCallList();
        when(this.sessionManager.getCurrentUser(any())).thenReturn(test);
        when(this.callController.getAllByUser(test)).thenReturn(listCall);
        ResponseEntity<List<Call>> responseEntity = this.callWebController.getCallsBetweenDates("Hola",null,null);

        assertEquals(ResponseEntity.ok(listCall),responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(listCall, responseEntity.getBody());
        verify(this.sessionManager,times(1)).getCurrentUser(any());
        verify(this.callController,times(1)).getAllByUser(test);

    }


    @Test
    public void getCallsBetweenDatesOkWithParameters() throws ParseException, NoContentToShowException {
        User user = TestUtils.createUser();
        List<Call> listCall = TestUtils.createCallList();
        String from = "2020-10-10 00:00:00";
        String to = "2020-10-15 00:00:00";
        when(this.sessionManager.getCurrentUser(any())).thenReturn(user);
        when(this.callController.getAll(any(), any(),any())).thenReturn(listCall);
        ResponseEntity<List<Call>> responseEntity = this.callWebController.getCallsBetweenDates("Hola",from,to);

        assertEquals(ResponseEntity.ok(listCall),responseEntity);
        verify(this.sessionManager,times(1)).getCurrentUser(any());
        verify(this.callController,times(1)).getAll(any(),any(),any());

    }

    @Test(expected = NoContentToShowException.class)
    public void getCallsBetweenDatesNoParametersNoContentToShowException() throws ParseException, NoContentToShowException {
        User user = TestUtils.createUser();
        when(this.sessionManager.getCurrentUser(any())).thenReturn(user);
        when(this.callController.getAllByUser(any())).thenThrow(new NoContentToShowException());
       ResponseEntity responseEntity = this.callWebController.getCallsBetweenDates("Hola", null,null);
    }


    @Test(expected = NoContentToShowException.class)
    public void getCallsBetweenDatesWithParametersNoContentToShowException() throws ParseException, NoContentToShowException {
        User user = TestUtils.createUser();
        String from = "2020-10-10 00:00:00";
        String to = "2020-10-15 00:00:00";
        when(this.sessionManager.getCurrentUser(any())).thenReturn(user);
        when(this.callController.getAll(any(),any(),any())).thenThrow(new NoContentToShowException());
        ResponseEntity responseEntity = this.callWebController.getCallsBetweenDates("Hola", from,to);
    }

    @Test(expected = DateTimeParseException.class)
    public void getCallsBetweenDatesWithParametersParseException() throws ParseException, NoContentToShowException {
        User user = TestUtils.createUser();
        when(this.sessionManager.getCurrentUser(any())).thenReturn(user);
        ResponseEntity responseEntity = this.callWebController.getCallsBetweenDates("Hola", "Esto es una fecha", "esto tambien");
    }



}
