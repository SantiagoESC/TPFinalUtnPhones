package edu.utn.phones.Repository;

import edu.utn.phones.Model.Call;
import edu.utn.phones.Projection.CallProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICallRepository extends JpaRepository<Call, Integer> {

    @Query(value = "SELECT * from call where DATECALL = CURDATE()", nativeQuery = true)
    List<Call> GetCallByNow();
}
