package edu.utn.phones.Controller.Model;

import edu.utn.phones.Abstract.AbstractController;
import edu.utn.phones.Exceptions.ModelExceptions.UserNotExistsException;
import edu.utn.phones.Model.User;
import edu.utn.phones.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class UserController extends AbstractController<User, UserService> {


    //region Contructor
    @Autowired
    public UserController(UserService userService) {
        super(userService);
    }
    //endregion







}
