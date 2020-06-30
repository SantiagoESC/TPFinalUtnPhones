package edu.utn.phones.Service;

import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Model.Call;
import edu.utn.phones.Model.User;
import edu.utn.phones.Repository.ICallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CallService extends AbstractService<Call, ICallRepository> {

    @Autowired
    public CallService(ICallRepository repository) {
        super(repository);

    }


    public List<Call> getAll(User loggedUser, LocalDateTime from, LocalDateTime to) {
        List<Call> list;
        if (from == null && to == null){
           list = this.repository.findByLineOriginOwnerLine(loggedUser);
        }else {
            list = this.repository.findByLineOriginOwnerLineAndDateCallBetween(loggedUser,from,to );
        }

        if (list.size() == 0){
            throw new NoContentToShowException();
        }

        return list;
    }
}
