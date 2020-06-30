package edu.utn.phones.Controller.BackOffice;

import edu.utn.phones.Configuration.Configuration;
import edu.utn.phones.Controller.Model.ProvinceController;
import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import edu.utn.phones.Model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/backoffice/province")
public class ProvinceBackofficeController  {

    private final ProvinceController provinceController;

    //region Constructor
    @Autowired
    public ProvinceBackofficeController(ProvinceController provinceController) {
        this.provinceController = provinceController;
    }
    //endregion

    //region ABM
    @PostMapping("/")
    public ResponseEntity add(@RequestBody Province newProvince){

        Province p = this.provinceController.add(newProvince);
        return ResponseEntity.created(Configuration.getLocation(p)).build();

    }

    @PutMapping("/{idProvince}")
    public ResponseEntity update(@RequestBody Province updatedProvince, @PathVariable Integer idProvince) throws ResourceNotFoundException {
        Province p = this.provinceController.getById(idProvince);
        updatedProvince.setIdProvince(p.getIdProvince());
        this.provinceController.update(updatedProvince);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{idProvince}")
    public ResponseEntity delete(@PathVariable Integer idProvince) throws ResourceNotFoundException {
        Province p = this.provinceController.getById(idProvince);
        this.provinceController.delete(p);
        return ResponseEntity.ok().build();

    }

    //endregion



    //region GET
    @GetMapping("/")
    public ResponseEntity<List<Province>> getAll(@RequestParam(required = false) String nameProvince) throws NoContentToShowException {

        List<Province> provinces = this.provinceController.getAll();

        if (provinces.size() > 0)
            return ResponseEntity.ok().body(provinces);
        else{
            throw new NoContentToShowException();
        }


    }


    @GetMapping("/{idProvince}")
    public ResponseEntity<Province> getById(@PathVariable Integer idProvince) throws ResourceNotFoundException {
        Province p = this.provinceController.getById(idProvince);
        return ResponseEntity.ok().body(p);
    }
    //endregion



}
