package edu.utn.phones.Controller.Model;

import edu.utn.phones.Controller.AbstractController;
import edu.utn.phones.Model.City;
import edu.utn.phones.Model.Rate;
import edu.utn.phones.Service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RateController extends AbstractController<Rate, RateService> {


    //region Atributes
    private final CityController cityController;
    //endregion

    //region Contructor
    @Autowired
    public RateController(RateService rateService, CityController cityController) {
        super(rateService);
        this.cityController = cityController;
    }
    //endregion


    public List<Rate> getAll(City  cityOrigin,City cityDestination) {

            return this.service.getAll(cityOrigin,cityDestination);

    }



}
