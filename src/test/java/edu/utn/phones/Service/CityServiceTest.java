package edu.utn.phones.Service;

import edu.utn.phones.Repository.ICityRepository;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class CityServiceTest {



    @Test
    public void testConstructor(){
        CityService aux = new CityService(mock(ICityRepository.class));
    }

}
