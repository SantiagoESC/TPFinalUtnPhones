package edu.utn.phones.Service;


import edu.utn.phones.Abstract.AbstractService;
import edu.utn.phones.Exceptions.ModelExceptions.CityNotExistsException;
import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Model.City;
import edu.utn.phones.Repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService extends AbstractService<City> {

    //region Atributes
    private final ICityRepository cityRepository;
    //endregion


    //region Constructor
    @Autowired
    public CityService(ICityRepository cityRepository) {
        super(cityRepository);
        this.cityRepository = cityRepository;
    }

    @Override
    public <F> List<City> getAll(F filter) {
        return null;
    }
    //endregion





}
