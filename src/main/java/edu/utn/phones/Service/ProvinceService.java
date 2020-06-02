package edu.utn.phones.Service;

import edu.utn.phones.Abstract.AbstractService;
import edu.utn.phones.Model.Province;
import edu.utn.phones.Repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService extends AbstractService<Province, IProvinceRepository> {



    @Autowired
    public ProvinceService(IProvinceRepository repository) {
        super(repository);
    }

    @Override
    public <String> List<Province> getAll(String filter) {

        return this.repository.findByNameProvince(filter);
    }
}
