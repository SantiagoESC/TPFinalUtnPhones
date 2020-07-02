package edu.utn.phones.Service;

import edu.utn.phones.Domain.Bill;
import edu.utn.phones.Domain.Call;
import edu.utn.phones.Domain.User;
import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Repository.IBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class BillService extends AbstractService<Bill, IBillRepository> {

    @Autowired
    public BillService(IBillRepository repository) {
        super(repository);

    }


    public List<Bill> getAll(User loggedUser, LocalDateTime fromDate, LocalDateTime toDate) throws NoContentToShowException {


        List<Bill>list = this.repository.findByUserBillAndDateBillBetween(loggedUser,fromDate,toDate );



        if (list.size() == 0){
            throw new NoContentToShowException();
        }

        return list;
    }

    public List<Bill> getAll(User loggedUser) throws NoContentToShowException {
        List<Bill>list = this.repository.findByUserBill(loggedUser);
        if (list.size() == 0){
            throw new NoContentToShowException();
        }
        return list;
    }
}
