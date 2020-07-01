package edu.utn.phones.Controller.Web;

import edu.utn.phones.Controller.Model.CallController;
import edu.utn.phones.Model.Call;
import edu.utn.phones.Model.User;
import edu.utn.phones.Session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/call")
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
    public ResponseEntity<List<Call>> getCallsBetweenDates(@RequestHeader("Authorization") String token, @RequestParam(required = false, value = "from") String from, @RequestParam(required = false, value = "to") String to) throws ParseException {
        User loggedUser = this.sessionManager.getCurrentUser(token);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fromDate = LocalDateTime.parse(from, formatter);
        LocalDateTime toDate = LocalDateTime.parse(to, formatter);
        List<Call> calls = this.callController.getAll(loggedUser, fromDate,toDate);

        return ResponseEntity.ok(calls);
    }
}
