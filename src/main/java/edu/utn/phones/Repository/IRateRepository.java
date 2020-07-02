package edu.utn.phones.Repository;

import edu.utn.phones.Domain.City;
import edu.utn.phones.Domain.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRateRepository extends JpaRepository<Rate, Integer> {
    List<Rate> findByCityOriginAndCityDestination(City idCityOrigin, City idCityDestination);

    List<Rate> findByCityOrigin(City idCityOrigin);


    List<Rate> findByCityDestination(City idCityDestination);
}
