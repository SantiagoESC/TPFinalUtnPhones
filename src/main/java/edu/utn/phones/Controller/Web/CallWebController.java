package edu.utn.phones.Controller.Web;

import edu.utn.phones.Abstract.Iterfaces.IAbstractWebCrud;
import edu.utn.phones.Configuration.Configuration;
import edu.utn.phones.Controller.Model.CallController;
import edu.utn.phones.Controller.Model.ErrorResponse;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import edu.utn.phones.Exceptions.ModelExceptions.CallNotExistException;
import edu.utn.phones.Exceptions.ModelExceptions.UserTypeNotExistsException;
import edu.utn.phones.Model.Call;
import edu.utn.phones.Projection.CallProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/call")
public class CallWebController implements IAbstractWebCrud<Call> {

    //region Atributes
    private final CallController callController;
    //endregion

    //region Constructor
    @Autowired
    public CallWebController(CallController callController) {
        this.callController = callController;
    }
    //endregion

    //region ABM
    @PostMapping("/")
    public ResponseEntity add(@RequestBody Call newCall){
        Call ut = this.callController.add(newCall);

        return ResponseEntity.created(Configuration.getLocation(ut)).build() ;
    }

    @PutMapping("/{idCall}")
    public ResponseEntity update(@RequestBody Call updatedCall, @PathVariable Integer idCall) throws ResourceNotFoundException {

        Call u = this.callController.getById(idCall);
       // updatedCall.setIdCall(u.getIdCall());
        this.callController.update(updatedCall);
        return  ResponseEntity.ok().build();


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
    public ResponseEntity<List<Call>> getAll(@RequestParam(required = false) String nameCall){
        List<Call> list = this.callController.getAll();
        return ResponseEntity.ok().body(list);
    }
    //endregion

    //region Pruebas


    @GetMapping("/GetAllCallById")
    public ResponseEntity<List<Call>> GetAllCallById(@RequestParam Integer idUser) throws UserTypeNotExistsException {
        List<Call> calls = callController.GetAllCallById(idUser);
        if(calls.size() > 0){
            return ResponseEntity.ok().body(calls);
        }else{
            throw new UserTypeNotExistsException("");
        }
    }

    //endregion

    //region ENDPOINT PARCIAL
    //endpoint que devuelva listado de las llamadas de la fecha actual


    @GetMapping("/now")
    public ResponseEntity<List<Call>> GetCallByNow()  {
        try{
            List<Call> calls = callController.GetCallByNow();
            if (calls.size() == 0) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {
                return ResponseEntity.ok().body(calls);
            }
        } catch(CallNotExistException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    //ENDREGION
}




