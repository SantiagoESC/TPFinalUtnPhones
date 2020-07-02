package edu.utn.phones.Controller.Model;

import edu.utn.phones.Domain.Call;
import edu.utn.phones.Domain.User;
import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Projetions.CallProjection;
import edu.utn.phones.Service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;


@Controller
public class CallController extends AbstractController<Call, CallService> {

    @Autowired
    public CallController(CallService service) {
        super(service);
    }



    public List<CallProjection> getAll2() throws NoContentToShowException {
        return this.service.getAll2() ;
    }

    public List<CallProjection> getAll(User loggedUser, LocalDateTime from, LocalDateTime to) throws NoContentToShowException {

        return this.service.getAll( loggedUser,  from,  to);
    }

    public List<CallProjection> getAllByUser(User u) throws NoContentToShowException {
        return this.service.getAllByUser(u);
    }

    public List<CallProjection> getTopDestinationsUser(User u) {
        return this.service.getTopDestinationsUser(u);
    }
}
