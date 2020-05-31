package edu.utn.phones.Controller.Model;


import edu.utn.phones.Exceptions.ModelExceptions.CityNotExistsException;
import edu.utn.phones.Model.City;
import edu.utn.phones.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CityController {

    //region Atributes
    private final CityService cityService;
    //endregion

    //region Contructor
    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }


    //endregion



    public City addCity(City newCity) {
        return this.cityService.addCity(newCity);
    }

    public City updateCity(City updatedCity){
        return this.cityService.updateCity(updatedCity);
    }
    //region GET
    public City getCityById(Integer idCity) throws CityNotExistsException {
        return this.cityService.getCityById(idCity);
    }

    public List<City> getAll() {
        return this.cityService.getAll();
    }

    public void deleteCity(City cityToDelete) {
        this.cityService.deleteCity(cityToDelete);
    }
    //endregion
}
