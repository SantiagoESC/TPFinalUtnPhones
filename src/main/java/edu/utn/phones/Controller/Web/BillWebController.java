package edu.utn.phones.Controller.Web;

import edu.utn.phones.Controller.Model.BillController;
import edu.utn.phones.Domain.Bill;
import edu.utn.phones.Domain.Call;
import edu.utn.phones.Domain.User;
import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/web/bill")
public class BillWebController {

    private final BillController billController;
    private final SessionManager sessionManager;

    @Autowired
    public BillWebController(BillController billController, SessionManager sessionManager) {
        this.billController = billController;
        this.sessionManager = sessionManager;
    }

    @GetMapping("/")
    public ResponseEntity<List<Bill>> getCallsBetweenDates(@RequestHeader("Authorization") String token, @RequestParam(required = false, value = "from") String from, @RequestParam(required = false, value = "to") String to) throws ParseException, NoContentToShowException {
        User loggedUser = this.sessionManager.getCurrentUser(token);
        List<Bill> bills;
        if (from != null && to != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime fromDate = LocalDateTime.parse(from, formatter);
            LocalDateTime toDate = LocalDateTime.parse(to, formatter);
            bills = this.billController.getAll(loggedUser, fromDate, toDate);

        } else {
            bills = this.billController.getAll(loggedUser);
        }

        return ResponseEntity.ok(bills);
    }
}
