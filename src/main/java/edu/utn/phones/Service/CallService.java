package edu.utn.phones.Service;

import edu.utn.phones.Abstract.AbstractService;
import edu.utn.phones.Model.Call;
import edu.utn.phones.Repository.ICallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CallService extends AbstractService<Call, ICallRepository> {

    @Autowired
    public CallService(ICallRepository repository) {
        super(repository);

    }


    public List<Call> getCallsWithPrefixBetween(String minPrefix, String maxPrefix) {

        /*Lo de antes*/
//        List<Call>  listOrigin = this.repository.findByCityOriginCallPrefixBetween(minPrefix,maxPrefix);
//
//        listOrigin.addAll( this.repository.findByCityDestinationCallPrefixBetween(minPrefix,maxPrefix));
//

        List<Call> list = this.repository.findByCityOriginCallPrefixBetweenAndCityDestinationCallPrefixBetween(minPrefix, maxPrefix,minPrefix,maxPrefix);


        return list;
    }
}
