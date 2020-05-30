package edu.utn.phones.Service;

import edu.utn.phones.Exceptions.ModelExceptions.ProvinceNotExitsException;
import edu.utn.phones.Model.Province;
import edu.utn.phones.Repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {

    //region Atributes
    private final IProvinceRepository provinceRepository;
    //endregion

    //region Constructor
    @Autowired
    public ProvinceService(IProvinceRepository provinceRepository) {

        this.provinceRepository = provinceRepository;
    }
    //endregion

    //region ABM
    public Province addProvince(Province province){

       return this.provinceRepository.save(province);

    }

    public Province updateProvince(Province updatedProvince){
        //todo Esto no puede quedar asi dijo german asique habra que hacer un metodo o algo
        return this.provinceRepository.save(updatedProvince);
    }

    public void deleteProvince(Province idProvince){
        this.provinceRepository.delete(idProvince);
    }
    //endregion

    //region GET
    public Province getById(Integer id) throws ProvinceNotExitsException {

        return this.provinceRepository.findById(id).orElseThrow(ProvinceNotExitsException::new);

    }

    public List<Province> getAll(String nameProvince){

        if (nameProvince != null)
            return this.provinceRepository.findByNameProvince(nameProvince);
        else
            return this.provinceRepository.findAll();

    }
    //endregion

}
