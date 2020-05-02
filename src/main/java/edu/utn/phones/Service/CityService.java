package edu.utn.phones.Service;


import edu.utn.phones.Model.City;
import edu.utn.phones.Repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    ICityRepository cityRepository;

    //region ABM


    public void add(City city){
        this.cityRepository.save(city);
        System.out.println(city);
    }


    //endregion
}
