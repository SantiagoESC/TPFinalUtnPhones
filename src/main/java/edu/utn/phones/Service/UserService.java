package edu.utn.phones.Service;

import edu.utn.phones.Model.User;
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
        System.out.println(user);
    }


    public void addSome(List<User> users){

        this.userRepository.saveAll(users);

    }


    public User getByDni(Integer dni ){

        return this.userRepository.getOne(dni);

    }

    public List<User> getAll() {
        System.out.println("Llgue al service");
        return this.userRepository.findAll();
    }
}
