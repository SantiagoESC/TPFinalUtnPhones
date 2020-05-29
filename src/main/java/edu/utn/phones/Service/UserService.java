package edu.utn.phones.Service;

import edu.utn.phones.Model.Temp.User;
import edu.utn.phones.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;




    public void add(User user){

        this.userRepository.save(user);

    }





    public User getByDni(Integer dni ){

        return this.userRepository.getOne(dni);

    }

    public List<User> getAll() {

        return this.userRepository.findAll();
    }
}
