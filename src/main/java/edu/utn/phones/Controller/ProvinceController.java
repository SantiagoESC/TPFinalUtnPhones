package edu.utn.phones.Controller;


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

    @PostMapping("/add")
    public void add (@RequestBody Province newProvince){

        this.provinceService.add(newProvince);

    }

    @PostMapping("/addSome")
    public void addSome (@RequestBody List<Province> newListProvinces){

        this.provinceService.addSome(newListProvinces);

    }

    @GetMapping("/get/{id}")
    public Province getById(@PathVariable Integer id){

        return this.provinceService.getById(id);

    }

    @GetMapping("/getAll")
    public List<Province> getAll(){

        return this.provinceService.getAll();

    }



}
