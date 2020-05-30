package edu.utn.phones.Controller.Model;


import edu.utn.phones.Exceptions.ModelExceptions.CityNotExistsException;
import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Model.Temp.City;
import edu.utn.phones.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityService cityService;


    //region ABM

    @PostMapping("/")
    public void add(@RequestBody City city){
        this.cityService.add(city);
    }

    //endregion

    //region SELECT

    @GetMapping("/{id}")
    public City getByPrefix(@PathVariable Integer id ) throws CityNotExistsException {

        return this.cityService.getById(id);

    }

    @GetMapping("/")
    public List<City> getAll() throws NoContentToShowException {
        return this.cityService.getAll();
    }


    //endregion
}
