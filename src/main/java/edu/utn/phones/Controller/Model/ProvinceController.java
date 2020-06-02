package edu.utn.phones.Controller.Model;


import edu.utn.phones.Abstract.AbstractController;
import edu.utn.phones.Abstract.AbstractService;
import edu.utn.phones.Model.Province;
import edu.utn.phones.Service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProvinceController extends AbstractController<Province, ProvinceService> {


    @Autowired
    public ProvinceController(ProvinceService service) {
        super(service);
    }


    @Override
    public <String> List<Province> getAll(String filter) {
        return this.service.getAll(filter);
    }


}

