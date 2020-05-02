package edu.utn.phones.Controller;


import edu.utn.phones.Model.City;
import edu.utn.phones.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityService cityService;

    //region ABM

    @PostMapping("/addCity")
    public void add(@RequestBody City city){
        this.cityService.add(city);
    }

    //endregion
}
