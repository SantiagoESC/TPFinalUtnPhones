package edu.utn.phones.Service;


import edu.utn.phones.Domain.City;
import edu.utn.phones.Repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService extends AbstractService<City, ICityRepository> {



    //region Constructor
    @Autowired
    public CityService(ICityRepository cityRepository) {
        super(cityRepository);
    }
    //endregion




}
