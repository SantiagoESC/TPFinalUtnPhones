package edu.utn.phones.Controller.Model;


import edu.utn.phones.Exceptions.ProvinceNotExitsException;
import edu.utn.phones.Exceptions.UserNotExitsException;
import edu.utn.phones.Model.Province;
import edu.utn.phones.Service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class ProvinceController {


    //region Atributes
    @Autowired
    ProvinceService provinceService;
    //endregion


    //region ABM
    public Province addProvince(Province newProvince){
        return this.provinceService.addProvince(newProvince);
    }


    //endregion

    //region GET

    public Province getById(@PathVariable Integer id) throws ProvinceNotExitsException {

        return this.provinceService.getById(id);

    }

    public List<Province> getAll(){

        return this.provinceService.getAll();

    }

    //endregion

}
