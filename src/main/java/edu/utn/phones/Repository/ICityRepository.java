package edu.utn.phones.Repository;

import edu.utn.phones.Model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<City, Integer> {
}
