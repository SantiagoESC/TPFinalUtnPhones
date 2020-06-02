package edu.utn.phones.Service;

import edu.utn.phones.Abstract.AbstractService;
import edu.utn.phones.Model.User;
import edu.utn.phones.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends AbstractService<User, IUserRepository> {

    //region Contructor
    @Autowired
    public UserService(IUserRepository userRepository) {
        super(userRepository);
    }
    //endregion


    @Override
    public <F> List<User> getAll(F filter) {
        return null;
    }


}
