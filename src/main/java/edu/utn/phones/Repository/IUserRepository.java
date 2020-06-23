package edu.utn.phones.Repository;

import edu.utn.phones.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {


    List<User> findByFirstName(String nameUser);

    User findByUsernameAndPassword(String username, String password);
}
