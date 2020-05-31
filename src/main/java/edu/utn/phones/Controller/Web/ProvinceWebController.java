package edu.utn.phones.Controller.Web;

import edu.utn.phones.Controller.Model.ProvinceController;
import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import edu.utn.phones.Exceptions.ModelExceptions.ProvinceNotExitsException;
import edu.utn.phones.Model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @PutMapping("/{idProvince}")
    public ResponseEntity updateProvince(@RequestBody Province updatedProvince, @PathVariable Integer idProvince) throws ResourceNotFoundException {
        try {
            Province p = this.provinceController.getById(idProvince);
            updatedProvince.setIdProvince(p.getIdProvince());
            this.provinceController.updateProvince(updatedProvince);
            return ResponseEntity.ok().build();
        } catch (ProvinceNotExitsException e) {
            throw new ResourceNotFoundException("Province not exists");
        }
    }


    @DeleteMapping("/{idProvince}")
    public ResponseEntity deleteProvince(@PathVariable Integer idProvince) throws ResourceNotFoundException {
        try {
            Province p = this.provinceController.getById(idProvince);
            this.provinceController.deleteProvince(p);
            return ResponseEntity.ok().build();
        } catch (ProvinceNotExitsException e) {
            throw new ResourceNotFoundException("Province not exists");
        }

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

    //region GET
    @GetMapping("/")
    public ResponseEntity<List<Province>> getAll(@RequestParam(required = false) String nameProvince) throws NoContentToShowException {

        List<Province> provinces = this.provinceController.getAll(nameProvince);

        if (provinces.size() > 0)
            return ResponseEntity.ok().body(provinces);
        else{
            throw new NoContentToShowException();
        }


    }


    @GetMapping("/{idProvince}")
    public ResponseEntity<Province> getById(@PathVariable Integer idProvince) throws ResourceNotFoundException {
        try {
            Province p = this.provinceController.getById(idProvince);
            return ResponseEntity.ok().body(p);
        } catch (ProvinceNotExitsException e) {
            throw new ResourceNotFoundException();
        }
    }
    //endregion

}
