package edu.utn.phones.Controller.Web;

import edu.utn.phones.Controller.Model.BillController;
import edu.utn.phones.Domain.Bill;
import edu.utn.phones.Domain.City;
import edu.utn.phones.Domain.Enums.UserType;
import edu.utn.phones.Domain.User;
import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Session.SessionManager;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BillWebControllerTest {

    private BillWebController billWebController;
    private BillController billController;
    private SessionManager sessionManager;
    private List<Bill> list;
    LocalDateTime from;
    LocalDateTime to ;

    @Before
    public void setUp() throws Exception {
        billController = mock(BillController.class);
        sessionManager = mock(SessionManager.class);
        list = new ArrayList<>();
        billWebController = new BillWebController(billController,sessionManager);
        this.from=LocalDateTime.now();
        this.to=LocalDateTime.now();
    }

    @Test
    public void constructorTest(){
        billController = mock(BillController.class);
        sessionManager = mock(SessionManager.class);

        billWebController = new BillWebController(billController,sessionManager);
    }

    @Test
    public void getCallsBetweenDates() throws ParseException, NoContentToShowException {
        User u = new User(1,"asd","qwe","qwe","qwe","qwe", UserType.CLIENT,new City());
        String token = sessionManager.createSession(u);

        when(sessionManager.getCurrentUser(token)).thenReturn(u);

        Bill bill = new Bill();
        list.add(bill);
        String fromString ="2020-06-02 00:00:00" ;
        String toString = "2020-06-03 00:00:00" ;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fromDate = LocalDateTime.parse(fromString, formatter);
        LocalDateTime toDate = LocalDateTime.parse(toString, formatter);

        when(billController.getAll(u, fromDate, toDate)).thenReturn(list);


        ResponseEntity<List<Bill>> response = billWebController.getCallsBetweenDates(token,fromString,toString);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(list, response.getBody());
    }



    @Test(expected = NoContentToShowException.class)
    public void getCallsBetweenDatesNoContentExeption() throws ParseException, NoContentToShowException {
        User u = new User(1, "asd", "qwe", "qwe", "qwe", "qwe", UserType.CLIENT, new City());
        String token = sessionManager.createSession(u);

        when(sessionManager.getCurrentUser(token)).thenReturn(u);

        Bill bill = new Bill();
        list.add(bill);
        String fromString = "2020-06-02 00:00:00";
        String toString = "2020-06-03 00:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fromDate = LocalDateTime.parse(fromString, formatter);
        LocalDateTime toDate = LocalDateTime.parse(toString, formatter);

        when(billController.getAll(u, fromDate, toDate)).thenThrow(new NoContentToShowException());

        ResponseEntity<List<Bill>> responseEntity = this.billWebController.getCallsBetweenDates(token,fromString,toString);
    }

    @Test
    public void getCallsBetweenDatesNullDate() throws ParseException, NoContentToShowException, ParseException {
        User u = new User(1,"asd","qwe","qwe","qwe","qwe",UserType.CLIENT,new City());
        String token = sessionManager.createSession(u);

        when(sessionManager.getCurrentUser(token)).thenReturn(u);

        Bill bill = new Bill();
        list.add(bill);

        when(billController.getAll(u)).thenReturn(list);

        String from = null;

        ResponseEntity<List<Bill>> response = billWebController.getCallsBetweenDates(token,from,from);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(list, response.getBody());
    }


    @Test(expected = NoContentToShowException.class)
    public void getCallsBetweenDatesNullDateNoContentException() throws ParseException, NoContentToShowException, ParseException {
        User u = new User(1, "asd", "qwe", "qwe", "qwe", "qwe", UserType.CLIENT, new City());
        String token = sessionManager.createSession(u);

        when(sessionManager.getCurrentUser(token)).thenReturn(u);

        Bill bill = new Bill();
        list.add(bill);

        when(billController.getAll(u)).thenThrow(new NoContentToShowException());

        String from = null;

        ResponseEntity<List<Bill>> response = billWebController.getCallsBetweenDates(token, from, from);
    }
}