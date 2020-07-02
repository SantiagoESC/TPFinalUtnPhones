package edu.utn.phones.Controller.Antenna;

import edu.utn.phones.Configuration.Configuration;
import edu.utn.phones.Controller.Model.CallController;
import edu.utn.phones.Domain.Call;
import edu.utn.phones.Utils.TestUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(edu.utn.phones.Configuration.Configuration.class)

public class AntennaControllerTest {

    private CallController callController;

    private AntennaController antennaController;

    @Before
    public void setUp() throws Exception {
        callController = mock(CallController.class);
        antennaController = new AntennaController(callController);
    }

    @Test
    public void constructorTest() {
        AntennaController a = new AntennaController(callController);
    }

    @Test
    public void add() {

        Call newCall = TestUtils.createCall();
        PowerMockito.mockStatic(Configuration.class);

        when(callController.add(newCall)).thenReturn(newCall);

        when(Configuration.getLocation(newCall)).thenReturn(URI.create("http://localhost:8080/api/antenna/call/1"));

        ResponseEntity responseEntity = antennaController.add(newCall);
        List<String> location = responseEntity.getHeaders().get("location");

        Assert.assertEquals("http://localhost:8080/api/antenna/call/1" , location.get(0));
    }
}