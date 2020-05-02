package edu.utn.phones.Repository;

import edu.utn.phones.Model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepository extends JpaRepository<Province, Integer> {
}
