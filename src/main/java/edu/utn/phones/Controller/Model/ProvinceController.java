package edu.utn.phones.Controller.Model;


import edu.utn.phones.Controller.AbstractController;
import edu.utn.phones.Model.Province;
import edu.utn.phones.Service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProvinceController extends AbstractController<Province, ProvinceService> {


    @Autowired
    public ProvinceController(ProvinceService service) {
        super(service);
    }





}

