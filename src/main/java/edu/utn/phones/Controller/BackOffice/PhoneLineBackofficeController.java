package edu.utn.phones.Controller.BackOffice;

import edu.utn.phones.Configuration.Configuration;
import edu.utn.phones.Controller.Model.PhoneLineController;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import edu.utn.phones.Model.PhoneLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/backoffice/lines")
public class PhoneLineBackofficeController {

    private final PhoneLineController phoneLineController;

    @Autowired
    public PhoneLineBackofficeController(PhoneLineController phoneLineController) {
        this.phoneLineController = phoneLineController;
    }

    @PostMapping("/")

    public ResponseEntity add(@RequestBody PhoneLine newPhoneLine) {


        PhoneLine pl = this.phoneLineController.add(newPhoneLine);

        return ResponseEntity.created(Configuration.getLocation(pl)).build();
    }

    @PutMapping("/{idPhoneLine}")
    public ResponseEntity update(@RequestBody PhoneLine updatedPhoneLine, @PathVariable Integer idPhoneLine) throws ResourceNotFoundException {

        PhoneLine line = this.phoneLineController.getById(idPhoneLine);
        updatedPhoneLine.setIdLine(line.getIdLine());
        PhoneLine pl = this.phoneLineController.update(updatedPhoneLine);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idPhoneLine}")

    public ResponseEntity delete(@PathVariable Integer idPhoneLine) throws ResourceNotFoundException {

        PhoneLine pl = this.phoneLineController.getById(idPhoneLine);
        this.phoneLineController.delete(pl);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idPhoneLine}")

    public ResponseEntity<PhoneLine> getById(@PathVariable Integer id) throws ResourceNotFoundException {
        PhoneLine pl = this.phoneLineController.getById(id);
        return ResponseEntity.ok().body(pl);
    }

    @GetMapping("/")
    public ResponseEntity<List<PhoneLine>> getAll() {
        List<PhoneLine> list = this.phoneLineController.getAll();
        return ResponseEntity.ok().body(list);
    }


}
