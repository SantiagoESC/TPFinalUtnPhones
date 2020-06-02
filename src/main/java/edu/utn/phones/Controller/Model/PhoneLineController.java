package edu.utn.phones.Controller.Model;


import edu.utn.phones.Abstract.AbstractController;
import edu.utn.phones.Abstract.AbstractService;
import edu.utn.phones.Model.PhoneLine;
import edu.utn.phones.Service.PhoneLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PhoneLineController extends AbstractController<PhoneLine> {

    private final PhoneLineService phoneLineService;

    @Autowired
    public PhoneLineController(AbstractService<PhoneLine> service, PhoneLineService phoneLineService) {
        super(service);
        this.phoneLineService = phoneLineService;
    }




    @Override
    public <F> List<PhoneLine> getAll(F filter) {
        return null;
    }
}
