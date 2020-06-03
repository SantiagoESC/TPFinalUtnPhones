package edu.utn.phones.Controller.Model;

import edu.utn.phones.Abstract.AbstractController;
import edu.utn.phones.Model.Call;
import edu.utn.phones.Service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class CallController extends AbstractController<Call, CallService> {

    @Autowired
    public CallController(CallService service) {
        super(service);
    }


}
