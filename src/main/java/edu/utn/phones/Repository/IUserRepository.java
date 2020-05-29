package edu.utn.phones.Repository;

import edu.utn.phones.Model.Temp.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {


}
