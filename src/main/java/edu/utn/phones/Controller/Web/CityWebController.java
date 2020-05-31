package edu.utn.phones.Controller.Web;

import edu.utn.phones.Controller.Model.CityController;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import edu.utn.phones.Exceptions.ModelExceptions.CityNotExistsException;
import edu.utn.phones.Model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/city")
public class CityWebController {

    //region Atributes
    private final CityController cityController;
    //endregion

    //region Constructor
    @Autowired
    public CityWebController(CityController cityController) {
        this.cityController = cityController;
    }
    //endregion


    //region ABM

    @PostMapping("/")
    public ResponseEntity addCity(@RequestBody City newCity){
        City c =  this.cityController.addCity(newCity);
        return (ResponseEntity) ResponseEntity.created(getLocationCity(c));
    }

    @PutMapping("/{idCity}")
    public ResponseEntity updateCity(@RequestBody City updatedCity, @PathVariable Integer idCity) throws ResourceNotFoundException {
        try {
            City c = this.cityController.getCityById(idCity);
             updatedCity.setIdCity(c.getIdCity());
             this.cityController.updateCity(updatedCity);
             return ResponseEntity.ok().build();
        } catch (CityNotExistsException e) {
            throw new ResourceNotFoundException();
        }
    }

    @DeleteMapping("/{idCity}")
    public ResponseEntity deleteCity(@PathVariable Integer idCity) throws ResourceNotFoundException {
        try {
            City c =this.cityController.getCityById(idCity);
            this.cityController.deleteCity(c);
            return ResponseEntity.ok().build();
        } catch (CityNotExistsException e) {
            throw  new ResourceNotFoundException();
        }


    }

    //endregion


    //region GET

    @GetMapping("/{idCity}")
    public ResponseEntity<City> getCityById(@PathVariable Integer idCity ) throws ResourceNotFoundException {

        try {
            City c = this.cityController.getCityById(idCity);
            return ResponseEntity.ok().body(c);
        } catch (CityNotExistsException e) {
            throw new ResourceNotFoundException();
        }

    }

    @GetMapping("/")
    public ResponseEntity<List<City>> getAll() {
        this.cityController.getAll();
        return null;
    }


    //endregion

    //region EXTRA
    private URI getLocationCity(City city) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(city.getIdCity())
                .toUri();
    }
    //endregion

}
