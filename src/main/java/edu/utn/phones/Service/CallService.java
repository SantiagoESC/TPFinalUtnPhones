package edu.utn.phones.Service;

import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Domain.Call;
import edu.utn.phones.Domain.User;
import edu.utn.phones.Projetions.CallProjection;
import edu.utn.phones.Repository.ICallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CallService extends AbstractService<Call, ICallRepository> {

    @Autowired
    public CallService(ICallRepository repository) {
        super(repository);

    }


    public List<CallProjection> getAll2() throws NoContentToShowException {
        return this.repository.getAll() ;
    }


    public List<CallProjection> getAll(User loggedUser, LocalDateTime from, LocalDateTime to) throws NoContentToShowException {
        List<CallProjection> list;
        if (from == null && to == null){
           list = this.repository.findByLineOriginOwnerLine(loggedUser.getId());
        }else {
            list = this.repository.findByLineOriginOwnerLineAndDateCallBetween(loggedUser.getId(),from,to );
        }

        if (list.size() == 0){
            throw new NoContentToShowException();
        }

        return list;
    }

    public List<CallProjection> getAllByUser(User u) throws NoContentToShowException {
        List<CallProjection> list= this.repository.findByLineOriginOwnerLine(u.getIdUser());
        if (list.size() == 0){
            throw new NoContentToShowException();

        }
        return list;
    }

    public List<CallProjection> getTopDestinationsUser(User u) {
        return this.repository.getTopDestinationsUser(u.getIdUser());
    }
}
