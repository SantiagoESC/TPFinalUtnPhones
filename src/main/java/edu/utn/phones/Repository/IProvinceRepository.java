package edu.utn.phones.Repository;

import edu.utn.phones.Model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProvinceRepository extends JpaRepository<Province, Integer> {

    <String>List<Province> findByNameProvince(String filter);
}
