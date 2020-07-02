package edu.utn.phones.Repository;

import edu.utn.phones.Domain.Call;
import edu.utn.phones.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ICallRepository extends JpaRepository<Call, Integer> {


    List<Call> findByLineOriginOwnerLineAndDateCallBetween(User loggedUser, LocalDateTime from, LocalDateTime to);

    List<Call> findByLineOriginOwnerLine(User loggedUser);


    @Query(nativeQuery = true,
            value = "SELECT * FROM calls c INNER JOIN phoneLines pl ON pl.numberLine = c.numberOrigin WHERE idUser = ?1")
    List<Call> findByUser(Integer idUser);
}
