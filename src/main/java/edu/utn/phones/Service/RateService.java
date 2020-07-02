package edu.utn.phones.Service;

import edu.utn.phones.Domain.City;
import edu.utn.phones.Domain.Rate;
import edu.utn.phones.Repository.IRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateService extends AbstractService<Rate, IRateRepository> {


    //region Contructor
    @Autowired
    public RateService(IRateRepository rateRepository) {
        super(rateRepository);
    }
    //endregion


    public List<Rate> getAll(City cityOrigin, City cityDestination){

        return this.repository.findAll();

    }



}
