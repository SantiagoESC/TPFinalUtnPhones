package edu.utn.phones.Repository;

import edu.utn.phones.Domain.PhoneLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhoneLineRepository extends JpaRepository<PhoneLine, Integer> {
}
