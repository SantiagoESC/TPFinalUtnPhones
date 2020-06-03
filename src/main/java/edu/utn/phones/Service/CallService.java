package edu.utn.phones.Service;

import edu.utn.phones.Abstract.AbstractService;
import edu.utn.phones.Exceptions.ModelExceptions.CallNotExistException;
import edu.utn.phones.Model.Call;
import edu.utn.phones.Projection.CallProjection;
import edu.utn.phones.Repository.ICallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallService extends AbstractService<Call, ICallRepository> {

    @Autowired
    public CallService(ICallRepository repository) {
        super(repository);

    }

    @Override
    public <F> List<Call> getAll(F filter) {
        return null;
    }

    public List<Call> GetAllCallById(Integer idUser) {
       return null;
    }

    public List<Call> GetCallByNow() throws CallNotExistException {
        return this.repository.GetCallByNow();
    }
}