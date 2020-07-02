package edu.utn.phones.Controller.Model;

import edu.utn.phones.Domain.Bill;
import edu.utn.phones.Domain.Call;
import edu.utn.phones.Domain.User;
import edu.utn.phones.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class BillController extends AbstractController<Bill, BillService> {

    @Autowired
    public BillController(BillService service) {
        super(service);
    }


    public List<Bill> getAll(User loggedUser, LocalDateTime fromDate, LocalDateTime toDate) {

        return this.service.getAll(loggedUser, fromDate,toDate);
    }

    public List<Bill> getAll(User loggedUser) {
        return  this.service.getAll(loggedUser);
    }
}
