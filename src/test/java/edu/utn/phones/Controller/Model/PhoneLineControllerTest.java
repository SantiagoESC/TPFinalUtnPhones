package edu.utn.phones.Controller.Model;

import edu.utn.phones.Domain.PhoneLine;
import edu.utn.phones.Service.PhoneLineService;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class PhoneLineControllerTest {

    private  PhoneLineController phoneLineController;
    private PhoneLineService phoneLineService;


    @Before
    public void setUp(){
        this.phoneLineService=mock(PhoneLineService.class);
        this.phoneLineController = new PhoneLineController(this.phoneLineService);
    }


    @Test
    public void testConstruct(){
        PhoneLineController p =new PhoneLineController(this.phoneLineService);
    }

}
