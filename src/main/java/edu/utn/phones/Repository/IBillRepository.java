package edu.utn.phones.Repository;

import edu.utn.phones.Domain.Bill;
import edu.utn.phones.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IBillRepository extends JpaRepository<Bill, Integer>{

    List<Bill> findByUserBillAndDateBillBetween(User loggedUser, LocalDateTime fromDate, LocalDateTime toDate);

    List<Bill> findByUserBill(User loggedUser);
}