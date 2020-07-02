package edu.utn.phones.Service;

import edu.utn.phones.Repository.IProvinceRepository;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class ProvinceServiceTest {

    @Test
    public void testConstructor(){
        ProvinceService ps = new ProvinceService(mock(IProvinceRepository.class));
    }
}
