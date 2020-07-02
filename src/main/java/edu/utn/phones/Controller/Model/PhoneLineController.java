package edu.utn.phones.Controller.Model;


import edu.utn.phones.Domain.PhoneLine;
import edu.utn.phones.Service.PhoneLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PhoneLineController extends AbstractController<PhoneLine, PhoneLineService> {



    @Autowired
    public PhoneLineController(PhoneLineService service) {
        super(service);
    }







}
