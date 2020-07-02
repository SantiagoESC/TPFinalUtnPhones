package edu.utn.phones.Service;

import edu.utn.phones.Domain.Rate;
import edu.utn.phones.Repository.IRateRepository;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class RateServiceTest {

    @Test
    public void testConstructor(){
        RateService rs = new RateService(mock(IRateRepository.class));
    }
}
