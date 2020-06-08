package edu.utn.phones.Controller.Model;

import edu.utn.phones.Controller.AbstractController;
import edu.utn.phones.Model.Call;
import edu.utn.phones.Service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class CallController extends AbstractController<Call, CallService> {

    @Autowired
    public CallController(CallService service) {
        super(service);
    }


}
