package edu.utn.phones.Service;

import edu.utn.phones.Repository.IPhoneLineRepository;
import org.junit.Test;

import static org.powermock.api.mockito.PowerMockito.mock;

public class PhoneLineServiceTest {

    @Test
    public void testConstructor(){
        PhoneLineService pls = new PhoneLineService(mock(IPhoneLineRepository.class));
    }
}
