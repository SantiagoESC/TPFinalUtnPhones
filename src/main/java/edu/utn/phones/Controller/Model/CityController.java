package edu.utn.phones.Controller.Model;


import edu.utn.phones.Model.City;
import edu.utn.phones.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CityController extends AbstractController<City, CityService> {

    //region Contructor
    @Autowired
    public CityController(CityService cityService) {
        super(cityService);
    }
    //endregion

}
