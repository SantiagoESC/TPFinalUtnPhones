package edu.utn.phones.Controller.BackOffice;

import edu.utn.phones.Configuration.Configuration;
import edu.utn.phones.Controller.Model.UserController;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import edu.utn.phones.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/backoffice/user")
public class UserBackofficeController   {

    //region Atributes
    private final UserController userController;
    //endregion

    //region Constructor
    @Autowired
    public UserBackofficeController(UserController userController) {
        this.userController = userController;
    }
    //endregion

    //region ABM
    @PostMapping("/")
    public ResponseEntity add(@RequestBody User newUser){
        User ut = this.userController.add(newUser);

        return ResponseEntity.created(Configuration.getLocation(ut)).build() ;
    }

    @PutMapping("/{idUser}")
    public ResponseEntity update(@RequestBody User updatedUser, @PathVariable Integer idUser) throws ResourceNotFoundException {

        User u = this.userController.getById(idUser);
        updatedUser.setIdUser(u.getIdUser());
        this.userController.update(updatedUser);
        return  ResponseEntity.ok().build();


    }


    @DeleteMapping("/{idUser}")
    public ResponseEntity delete(@PathVariable Integer idUser) throws ResourceNotFoundException {
        User p = this.userController.getById(idUser);
        this.userController.delete(p);
        return ResponseEntity.ok().build();

    }
    //endregion

    //region GET
    @GetMapping("/{idUser}")
    public ResponseEntity<User> getById(@PathVariable Integer idUser) throws ResourceNotFoundException {

        User ut = this.userController.getById(idUser);
        return ResponseEntity.ok().body(ut);


    }



    @GetMapping("/")
    public ResponseEntity<List<User>> getAll(){
        List<User> list = this.userController.getAll();
        return ResponseEntity.ok().body(list);
    }
    //endregion



}
