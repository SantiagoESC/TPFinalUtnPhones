package edu.utn.phones.Controller.Model;

import edu.utn.phones.Abstract.AbstractController;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import edu.utn.phones.Model.City;
import edu.utn.phones.Model.Rate;
import edu.utn.phones.Service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RateController extends AbstractController<Rate> {


    //region Atributes
    private final RateService rateService;
    private final CityController cityController;
    //endregion

    //region Contructor
    @Autowired
    public RateController(RateService rateService, CityController cityController) {
        super(rateService);
        this.rateService = rateService;
        this.cityController = cityController;
    }



    public List<Rate> getAll(City  cityOrigin,City cityDestination) {

            return this.rateService.getAll(cityOrigin,cityDestination);

    }


    @Override
    public <F> List<Rate> getAll(F filter) {
        return null;
    }
}
