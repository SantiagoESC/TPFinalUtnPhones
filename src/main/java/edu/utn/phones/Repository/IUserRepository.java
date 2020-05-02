package edu.utn.phones.Repository;

import edu.utn.phones.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {


}
