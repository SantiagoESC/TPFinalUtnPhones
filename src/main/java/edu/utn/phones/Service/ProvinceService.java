package edu.utn.phones.Service;

import edu.utn.phones.Exceptions.ProvinceNotExitsException;
import edu.utn.phones.Exceptions.UserNotExitsException;
import edu.utn.phones.Model.Province;
import edu.utn.phones.Repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {

    @Autowired
    IProvinceRepository provinceRepository;

    public void add(Province province){

        this.provinceRepository.save(province);

    }

    public Province getById(Integer id) throws ProvinceNotExitsException {

        return this.provinceRepository.findById(id).orElseThrow( ProvinceNotExitsException::new);

    }

    public List<Province> getAll(){

        return this.provinceRepository.findAll();

    }


}
