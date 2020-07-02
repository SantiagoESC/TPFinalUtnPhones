package edu.utn.phones.Controller.Model;

import edu.utn.phones.Domain.Rate;
import edu.utn.phones.Service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RateController extends AbstractController<Rate, RateService> {


    //region Atributes

    //endregion

    //region Contructor
    @Autowired
    public RateController(RateService rateService) {
        super(rateService);
    }
    //endregion
}







