package edu.utn.phones.Controller.Model;

import edu.utn.phones.Abstract.AbstractController;
import edu.utn.phones.Exceptions.ModelExceptions.UserNotExistsException;
import edu.utn.phones.Model.User;
import edu.utn.phones.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController extends AbstractController<User> {

    //region Atributes
    private final UserService userService;
    //endregion

    //region Contructor
    @Autowired
    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }
    //endregion
    @Override
    public <F> List<User> getAll(F filter) {
        return null;
    }







}
