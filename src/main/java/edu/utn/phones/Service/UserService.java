package edu.utn.phones.Service;

import edu.utn.phones.Exceptions.GeneralExceptions.LoginException;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import edu.utn.phones.Exceptions.ModelExceptions.UserNotExistsException;
import edu.utn.phones.Model.User;
import edu.utn.phones.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService extends AbstractService<User, IUserRepository> {

    //region Contructor
    @Autowired
    public UserService(IUserRepository userRepository) {
        super(userRepository);
    }

    public User login(String username, String password) throws LoginException {

        return repository.findByUsernameAndPassword(username, password).orElseThrow(LoginException::new);
    }
    //endregion





}
