package edu.utn.phones.Controller.Web;

import edu.utn.phones.Controller.Model.CallController;
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
@RequestMapping("/api/web/call")
public class CallWebController {


    private final SessionManager sessionManager;
    private final CallController callController;

    @Autowired
    public CallWebController(SessionManager sessionManager, CallController callController) {
        this.sessionManager = sessionManager;
        this.callController = callController;
    }


    /*Consulta de llamadas del usuario logueado por rango de fechas.*/
    @GetMapping("/")
    public ResponseEntity<List<Call>> getCallsBetweenDates(@RequestHeader("Authorization") String token, @RequestParam(required = false, value = "from") String from, @RequestParam(required = false, value = "to") String to) throws ParseException, NoContentToShowException {
        List<Call> calls;

        User loggedUser = this.sessionManager.getCurrentUser(token);
        if (from != null && to != null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime fromDate = LocalDateTime.parse(from, formatter);
            LocalDateTime toDate = LocalDateTime.parse(to, formatter);
            calls = this.callController.getAll(loggedUser, fromDate,toDate);
        }else{
            calls = this.callController.getAllByUser(loggedUser);
        }


        return ResponseEntity.ok(calls);
    }
}
