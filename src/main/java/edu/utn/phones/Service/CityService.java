package edu.utn.phones.Service;


import edu.utn.phones.Exceptions.ModelExceptions.CityNotExistsException;
import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Model.City;
import edu.utn.phones.Repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    //region Atributes
    ICityRepository cityRepository;
    //endregion


    //region Constructor
    @Autowired
    public CityService(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    //endregion

    //region ABM
    public City addCity(City newCity) {
        return  this.cityRepository.save(newCity);
    }

    public City updateCity(City updatedCity) {
        return this.cityRepository.save(updatedCity);
    }


    //endregion

    //region GET

    public City getCityById(Integer id ) throws CityNotExistsException {
        return this.cityRepository.findById(id).orElseThrow(CityNotExistsException::new);
    }

    public List<City> getAll()  {
        return this.cityRepository.findAll();
    }

    public void deleteCity(City cityToDelete) {
        this.cityRepository.delete(cityToDelete);
    }


    //endregion
}
