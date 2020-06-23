package edu.utn.phones.Repository;

import edu.utn.phones.Model.Call;
import edu.utn.phones.Model.User;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICallRepository extends JpaRepository<Call, Integer> {



}
