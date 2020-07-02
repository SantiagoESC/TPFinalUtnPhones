package edu.utn.phones.Repository;

import edu.utn.phones.Domain.Call;
import edu.utn.phones.Projetions.CallProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface ICallRepository extends JpaRepository<Call, Integer> {

    @Query(nativeQuery = true,value = "SELECT *  from vCallReport vc where vc.idUser  = ?1 AND vc.dateCall BETWEEN ?2 AND ?3;")
    List<CallProjection> findByLineOriginOwnerLineAndDateCallBetween(Integer loggedUserId, LocalDateTime from, LocalDateTime to);
    @Query(nativeQuery = true, value = "SELECT *  from vCallReport vc where vc.idUser  = ?1;")
    List<CallProjection> findByLineOriginOwnerLine(Integer loggedUserId);


    @Query(nativeQuery = true,
            value = "SELECT * FROM calls c INNER JOIN phoneLines pl ON pl.numberLine = c.numberOrigin WHERE idUser = ?1")
    List<Call> findByUser(Integer idUser);

    @Query(nativeQuery = true, value = "SELECT  cityDestination, count(cityDestination) as cant from vCallReport vc where vc.idUser  = ?1 group by cityDestination order by cant desc limit 10;")
    List<CallProjection> getTopDestinationsUser(Integer idUser);


    @Query(nativeQuery = true, value = "select * fromvCallReport;")
    List<CallProjection> getAll();
}
