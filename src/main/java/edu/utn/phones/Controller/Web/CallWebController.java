package edu.utn.phones.Controller.Web;

import edu.utn.phones.Controller.Model.CallController;
import edu.utn.phones.Model.Call;
import edu.utn.phones.Model.User;
import edu.utn.phones.Session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public ResponseEntity<List<Call>> getCallsBetweenDates(@RequestHeader("Authorization") String token, @RequestParam(required = false) LocalDateTime from, @RequestParam(required = false) LocalDateTime to){
        User loggedUser = this.sessionManager.getCurrentUser(token);

        List<Call> calls = this.callController.getAll(loggedUser, from,to);

        return ResponseEntity.ok(calls);
    }
}
