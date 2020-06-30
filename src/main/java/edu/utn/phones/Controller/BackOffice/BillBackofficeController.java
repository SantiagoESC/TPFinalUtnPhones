package edu.utn.phones.Controller.BackOffice;


import edu.utn.phones.Configuration.Configuration;
import edu.utn.phones.Controller.Model.BillController;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import edu.utn.phones.Model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/backoffice/bill")
public class BillBackofficeController {

    //region Atributes
    private final BillController billController;
    //endregion

    //region Constructor
    @Autowired
    public BillBackofficeController(BillController billController) {
        this.billController = billController;
    }
    //endregion

    //region ABM
    @PostMapping("/")
    public ResponseEntity add(@RequestBody Bill newBill){

        /*traer el usuario logeado*/
        /**/

        Bill ut = this.billController.add(newBill);

        return ResponseEntity.created(Configuration.getLocation(ut)).build() ;
    }

    @PutMapping("/{idBill}")
    public ResponseEntity update(@RequestBody Bill updatedBill, @PathVariable Integer idBill) throws ResourceNotFoundException {

        Bill u = this.billController.getById(idBill);
        updatedBill.setIdBill(u.getIdBill());
        this.billController.update(updatedBill);
        return  ResponseEntity.ok().build();


    }


    @DeleteMapping("/{idBill}")
    public ResponseEntity delete(@PathVariable Integer idBill) throws ResourceNotFoundException {
        Bill p = this.billController.getById(idBill);
        this.billController.delete(p);
        return ResponseEntity.ok().build();

    }
    //endregion

    //region GET
    @GetMapping("/{idBill}")
    public ResponseEntity<Bill> getById(@PathVariable Integer idBill) throws ResourceNotFoundException {

        Bill ut = this.billController.getById(idBill);
        return ResponseEntity.ok().body(ut);


    }



    @GetMapping("/")
    public ResponseEntity<List<Bill>> getAll(@RequestParam(required = false) String nameBill){
        List<Bill> list = this.billController.getAll();
        return ResponseEntity.ok().body(list);
    }
    //endregion



}
