package edu.utn.phones.Service;

import edu.utn.phones.Model.PhoneLine;
import edu.utn.phones.Repository.IPhoneLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneLineService extends AbstractService<PhoneLine, IPhoneLineRepository> {



    @Autowired
    public PhoneLineService( IPhoneLineRepository phoneLineRepository) {
        super(phoneLineRepository);

    }

}
