package edu.utn.phones.Controller.Web;

import edu.utn.phones.Controller.Model.ProvinceController;
import edu.utn.phones.Model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/province")
public class ProvinceWebController {

    //region Atributes
    @Autowired
    ProvinceController provinceController;
    //endregion

    //region ABM
    @PostMapping("/")
    public ResponseEntity addProvince(@RequestBody Province newProvince){
        Province p = this.provinceController.addProvince(newProvince);
        return ResponseEntity.created(this.getLocationProvince(p)).build();

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
