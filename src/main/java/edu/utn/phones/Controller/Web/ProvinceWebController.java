package edu.utn.phones.Controller.Web;

import edu.utn.phones.Controller.Model.ProvinceController;
import edu.utn.phones.Exceptions.ModelExceptions.ProvinceNotExitsException;
import edu.utn.phones.Model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/province")
public class ProvinceWebController {

    //region Atributes

    private final ProvinceController provinceController;
    //endregion


    //region Constructor
    @Autowired
    public ProvinceWebController(ProvinceController provinceController) {
        this.provinceController = provinceController;
    }
    //endregion

    //region ABM
    @PostMapping("/")
    public ResponseEntity addProvince(@RequestBody Province newProvince){
        Province p = this.provinceController.addProvince(newProvince);
        return ResponseEntity.created(this.getLocationProvince(p)).build();

    }

    @PutMapping("/")
    public ResponseEntity updateProvince(@RequestBody Province updatedProvince){
        this.provinceController.updateProvince(updatedProvince);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idProvince}")
    public ResponseEntity deleteProvince(@PathVariable Integer idProvince) throws ProvinceNotExitsException {
            Province p = this.provinceController.getById(idProvince);
            this.provinceController.deleteProvince(p);
        return ResponseEntity.ok().build();
    }





    //endregion

    //region EXTRA
    private URI getLocationProvince(Province province) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(province.getIdProvince())
                .toUri();
    }
    //endregion

}
