package edu.utn.phones.Controller.Model;

import edu.utn.phones.Model.Call;
import edu.utn.phones.Model.City;
import edu.utn.phones.Service.CallService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CallControllerTest {

    private CallService callService;
    private  CallController callController;

    @Before
    public void setUp(){
        this.callService = mock(CallService.class);
        this.callController = new CallController(callService);
    }



    @Test
    public void testGetCallsWithPrefixBetweenOK(){
        List<Call> test = new ArrayList<>();

        /*Faltan datos, pero la lo unico que haria seria simular lo que yo necesito*/
        Call c = Call.builder().numberOriginCall("5147894561")
                .numberDestinationCall("6994789563")
                .dateCall(new Date())
                .durationSegCall(180)
                .cityOriginCall(City.builder().prefix("51").nameCity("asd").build())
                .cityDestinationCall(City.builder().prefix("699").nameCity("def").build())
                .build();

        Call c2 = Call.builder().numberOriginCall("5247894561")
                .numberDestinationCall("6984789563")
                .dateCall(new Date())
                .durationSegCall(180)
                .cityOriginCall(City.builder().prefix("52").nameCity("MDP").build())
                .cityDestinationCall(City.builder().prefix("698").nameCity("mch").build())
                .build();

         test.add(c);
         test.add(c2);


         when(this.callService.getCallsWithPrefixBetween("50", "700")).thenReturn(test);

         List<Call> actual = this.callController.getCallsWithPrefixBetween("50","700");

         assertEquals(actual, test);

    }

}
