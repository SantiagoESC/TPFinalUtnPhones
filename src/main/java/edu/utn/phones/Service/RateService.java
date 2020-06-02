package edu.utn.phones.Service;

import edu.utn.phones.Abstract.AbstractService;
import edu.utn.phones.Exceptions.ModelExceptions.RateNotExistsException;
import edu.utn.phones.Model.City;
import edu.utn.phones.Model.Rate;
import edu.utn.phones.Repository.IRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateService extends AbstractService<Rate> {

    //region Atributes
    private final IRateRepository rateRepository;
    //endregion

    //region Contructor
    @Autowired
    public RateService(IRateRepository rateRepository) {
        super(rateRepository);
        this.rateRepository = rateRepository;
    }
    //endregion


    public List<Rate> getAll(City cityOrigin, City cityDestination){

            if (cityOrigin == null && cityOrigin == null){
                return this.rateRepository.findAll();
            }else{

               if (cityOrigin != null && cityOrigin != null){
                   return this.rateRepository.findByCityOriginAndCityDestination(cityOrigin,cityDestination);
               }else{
                   if (cityOrigin != null && cityOrigin == null){
                       return this.rateRepository.findByCityOrigin(cityOrigin);
                   }else{
                       return this.rateRepository.findByCityDestination(cityDestination);
                   }
               }

            }


    }

    @Override
    public <F> List<Rate> getAll(F filter) {
        return null;
    }
    //endregion
}
