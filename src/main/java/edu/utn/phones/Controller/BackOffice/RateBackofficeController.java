package edu.utn.phones.Controller.BackOffice;

import edu.utn.phones.Configuration.Configuration;
import edu.utn.phones.Controller.Model.CityController;
import edu.utn.phones.Controller.Model.RateController;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import edu.utn.phones.Domain.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/backoffice/rate")
public class RateBackofficeController {

    //region Atributes
    private final RateController rateController;
    private final CityController cityController;
    //endregion

    //region Constructor
    @Autowired
    public RateBackofficeController(RateController rateController, CityController cityController) {
        this.rateController = rateController;
        this.cityController = cityController;
    }
    //endregion

    //region ABM
    @PostMapping("/")
    public ResponseEntity add(@RequestBody Rate newRate) {
        Rate ut = this.rateController.add(newRate);

        return ResponseEntity.created(Configuration.getLocation(ut)).build();
    }

    @PutMapping("/{idRate}")
    public ResponseEntity update(@RequestBody Rate updatedRate, @PathVariable Integer idRate) throws ResourceNotFoundException {

        Rate u = this.rateController.getById(idRate);
        updatedRate.setIdRate(u.getIdRate());
        this.rateController.update(updatedRate);
        return ResponseEntity.ok().build();


    }


    @DeleteMapping("/{idRate}")
    public ResponseEntity delete(@PathVariable Integer idRate) throws ResourceNotFoundException {
        Rate p = this.rateController.getById(idRate);
        this.rateController.delete(p);
        return ResponseEntity.ok().build();

    }
    //endregion

    //region GET
    @GetMapping("/{idRate}")
    public ResponseEntity<Rate> getById(@PathVariable Integer idRate) throws ResourceNotFoundException {

        Rate ut = this.rateController.getById(idRate);
        return ResponseEntity.ok().body(ut);


    }


    @GetMapping("/")
    public ResponseEntity<List<Rate>> getAll(@RequestParam(required = false) Integer idCityOrigin, @RequestParam(required = false) Integer idCityDestination) throws ResourceNotFoundException {

        List<Rate> list = this.rateController.getAll();

        return ResponseEntity.ok().body(list);
    }
    //endregion


}
