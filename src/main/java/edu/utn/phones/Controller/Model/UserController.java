package edu.utn.phones.Controller.Model;


import edu.utn.phones.Model.Temp.User;
import edu.utn.phones.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    //region serviceObject
    @Autowired
    UserService userService;
    //endregion


    @PostMapping("/")
    public void add(@RequestBody  User user){

        this.userService.add(user);

    }



    @GetMapping("/{id}")
    public User getByDni(@PathVariable Integer id ){

        return this.userService.getByDni(id);

    }


    @GetMapping("/")
    public List<User> getAll(){
       return this.userService.getAll();
    }


}
