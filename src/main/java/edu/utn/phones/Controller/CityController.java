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

    @PostMapping("/add")
    public void add(@RequestBody City city){
        this.cityService.add(city);
    }

    //endregion

    //region SELECT

    @GetMapping("/get/{prefix}")
    public @ResponseBody
    City getByPrefix(@PathVariable Integer prefix ){

        return this.cityService.getByPrefix(prefix);

    }

    @GetMapping("/getAll")
    public List<City> getAll(){
        return this.cityService.getAll();
    }

    //endregion
}
