package edu.utn.phones.Controller.BackOffice;

import edu.utn.phones.Configuration.Configuration;
import edu.utn.phones.Controller.Model.CallController;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import edu.utn.phones.Model.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/backoffice/call")
public class CallBackofficeController {

    //region Atributes
    private final CallController callController;
    //endregion

    //region Constructor
    @Autowired
    public CallBackofficeController(CallController callController) {
        this.callController = callController;
    }
    //endregion

    //region ABM
    @PostMapping("/")

    public ResponseEntity add(@RequestBody Call newCall) {
        Call ut = this.callController.add(newCall);

        return ResponseEntity.created(Configuration.getLocation(ut)).build();


    }

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
    public ResponseEntity<List<Call>> getAll(@RequestParam(required = false) String nameCall) {
        List<Call> list = this.callController.getAll();
        return ResponseEntity.ok().body(list);
    }
    //endregion


}

