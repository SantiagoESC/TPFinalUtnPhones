package edu.utn.phones.Service;


import edu.utn.phones.Model.City;
import edu.utn.phones.Model.User;
import edu.utn.phones.Repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    ICityRepository cityRepository;

    //region ABM

    public void add(City city){
        this.cityRepository.save(city);

    }

    //endregion

    //region SELECT

    public City getByPrefix(Integer prefix ){
        return this.cityRepository.getOne(prefix);
    }

    public List<City> getAll() {
        return this.cityRepository.findAll();
    }

    //endregion
}
