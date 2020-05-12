package edu.utn.phones.Controller;


import edu.utn.phones.Model.City;
import edu.utn.phones.Model.User;
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
    public @ResponseBody
    City getByPrefix(@PathVariable Integer id ){

        return this.cityService.getByPrefix(id);

    }

    @GetMapping("/")
    public List<City> getAll(){
        return this.cityService.getAll();
    }

    //endregion
}
