package edu.utn.phones.Service;

import edu.utn.phones.Abstract.AbstractService;
import edu.utn.phones.Model.Bill;
import edu.utn.phones.Repository.IBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BillService extends AbstractService<Bill, IBillRepository> {

    @Autowired
    public BillService(IBillRepository repository) {
        super(repository);
    }


}
