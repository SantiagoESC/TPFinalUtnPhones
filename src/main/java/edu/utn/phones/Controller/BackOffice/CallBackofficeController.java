package edu.utn.phones.Controller.BackOffice;

import edu.utn.phones.Configuration.Configuration;
import edu.utn.phones.Controller.Model.CallController;
import edu.utn.phones.Controller.Model.UserController;
import edu.utn.phones.Domain.User;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import edu.utn.phones.Domain.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/backoffice/call")
public class CallBackofficeController {

    //region Atributes
    private final CallController callController;
    private final UserController userController;
    //endregion

    //region Constructor
    @Autowired
    public CallBackofficeController(CallController callController, UserController userController) {
        this.callController = callController;
        this.userController = userController;
    }
    //endregion

    //region ABM


    @PutMapping("/{idCall}")
    public ResponseEntity update(@RequestBody Call updatedCall, @PathVariable Integer idCall) throws ResourceNotFoundException {

        Call u = this.callController.getById(idCall);
        updatedCall.setIdCall(u.getIdCall());
        this.callController.update(updatedCall);
        return ResponseEntity.ok().build();


    }


    @DeleteMapping("/{idCall}")
    public ResponseEntity delete(@PathVariable Integer idCall) throws ResourceNotFoundException {
        Call p = this.callController.getById(idCall);
        this.callController.delete(p);
        return ResponseEntity.ok().build();

    }
    //endregion

    //region GET
    @GetMapping("/{idCall}")
    public ResponseEntity<Call> getById(@PathVariable Integer idCall) throws ResourceNotFoundException {

        Call ut = this.callController.getById(idCall);
        return ResponseEntity.ok().body(ut);


    }


    @GetMapping("/")
    public ResponseEntity<List<Call>> getAll(@RequestParam(required = false) Integer idUser) throws ResourceNotFoundException {
        List<Call> list;
        if (idUser == null){
            list= this.callController.getAll();
        }else{
            User u = this.userController.getById(idUser);
            list= this.callController.getAllByUser(u);
        }

        return ResponseEntity.ok().body(list);
    }
    //endregion


}

