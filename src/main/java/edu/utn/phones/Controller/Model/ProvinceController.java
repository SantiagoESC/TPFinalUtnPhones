package edu.utn.phones.Controller.Model;


import edu.utn.phones.Exceptions.ModelExceptions.ProvinceNotExitsException;
import edu.utn.phones.Model.Province;
import edu.utn.phones.Service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class ProvinceController {


    //region Atributes
    private final ProvinceService provinceService ;
    //endregion

    //region Constructor
    @Autowired
    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }
    //endregion


    //region ABM
    public Province addProvince(Province newProvince){
        return this.provinceService.addProvince(newProvince);
    }

    public Province updateProvince(Province updatedProvince){
        return this.provinceService.updateProvince(updatedProvince);
    }

    public void deleteProvince(Province provinceToDelete) {
        this.provinceService.deleteProvince(provinceToDelete);
    }

    //endregion

    //region GET

    public Province getById(Integer id) throws ProvinceNotExitsException {

        return this.provinceService.getById(id);

    }

    public List<Province> getAll(String nameProvince){

        return this.provinceService.getAll(nameProvince);

    }

    //endregion

}
