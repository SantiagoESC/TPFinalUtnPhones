package edu.utn.phones.Controller.Model;


import edu.utn.phones.Exceptions.ProvinceNotExitsException;
import edu.utn.phones.Exceptions.UserNotExitsException;
import edu.utn.phones.Model.Province;
import edu.utn.phones.Service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    ProvinceService provinceService;

    @PostMapping("/")
    public void add (@RequestBody Province newProvince){

        this.provinceService.add(newProvince);

    }

    @GetMapping("/{id}")
    public Province getById(@PathVariable Integer id) throws ProvinceNotExitsException {

        return this.provinceService.getById(id);

    }

    @GetMapping("/")
    public List<Province> getAll(){

        return this.provinceService.getAll();

    }



}
