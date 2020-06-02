package edu.utn.phones.Controller.Model;


import edu.utn.phones.Abstract.AbstractController;
import edu.utn.phones.Abstract.AbstractService;
import edu.utn.phones.Exceptions.ModelExceptions.CityNotExistsException;
import edu.utn.phones.Model.City;
import edu.utn.phones.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CityController extends AbstractController<City> {

    //region Atributes
    private final CityService cityService;
    //endregion

    //region Contructor
    @Autowired
    public CityController(CityService cityService) {
        super(cityService);
        this.cityService = cityService;
    }


    @Override
    public <F> List<City> getAll(F filter) {
        return null;
    }
}
