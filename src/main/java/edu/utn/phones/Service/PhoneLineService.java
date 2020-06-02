package edu.utn.phones.Service;

import edu.utn.phones.Abstract.AbstractService;
import edu.utn.phones.Model.PhoneLine;
import edu.utn.phones.Repository.IPhoneLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneLineService extends AbstractService<PhoneLine> {

    private final IPhoneLineRepository phoneLineRepository;

    @Autowired
    public PhoneLineService( IPhoneLineRepository phoneLineRepository) {
        super(phoneLineRepository);
        this.phoneLineRepository = phoneLineRepository;
    }

    @Override
    public <F> List<PhoneLine> getAll(F filter) {
        return null;
    }
}
