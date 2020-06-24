package edu.utn.phones.Controller.Model;


import edu.utn.phones.Model.Call;
import edu.utn.phones.Model.City;
import edu.utn.phones.Repository.ICallRepository;
import edu.utn.phones.Service.CallService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CallServiceTest {


    CallService callService;
    @Mock
    ICallRepository callRepository;



    @Before
    public void setUp(){
        this.callRepository = mock(ICallRepository.class);
        this.callService = new CallService(this.callRepository);
    }

    @Test
    public void testGetCallsWithPrefixBetweenOK (){
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


        when(this.callRepository.findByCityOriginCallPrefixBetweenAndCityDestinationCallPrefixBetween("50","700","50","700")).thenReturn(test);

        List<Call> actual = this.callService.getCallsWithPrefixBetween("50", "700");

        assertEquals(test, actual);
        verify(this.callRepository, times(1)).findByCityOriginCallPrefixBetweenAndCityDestinationCallPrefixBetween(any(),any(),any(),any());

    }


}
