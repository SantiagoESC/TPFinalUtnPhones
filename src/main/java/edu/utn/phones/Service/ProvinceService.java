package edu.utn.phones.Service;

import edu.utn.phones.Domain.Province;
import edu.utn.phones.Repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceService extends AbstractService<Province, IProvinceRepository> {



    @Autowired
    public ProvinceService(IProvinceRepository repository) {
        super(repository);
    }


}
