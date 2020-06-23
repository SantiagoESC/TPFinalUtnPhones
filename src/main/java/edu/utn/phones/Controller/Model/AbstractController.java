package edu.utn.phones.Controller.Model;

import edu.utn.phones.Iterfaces.IAbstractCrud;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import edu.utn.phones.Service.AbstractService;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public class AbstractController<T, S extends   IAbstractCrud<T>> implements IAbstractCrud<T>{

    //region Atributes
    protected final S service;
    //endregion


    //region Contructor
    public AbstractController( S service) {
        this.service = service;
    }
    //endregion

    @Override
    public T add(T newT) {
        return this.service.add(newT);
    }

    @Override
    public T update(T updatedT) {
        return this.service.update(updatedT);
    }

    @Override
    public void delete(T ToDelete) {
        this.service.delete(ToDelete);
    }

    @Override
    public T getById(Integer id) throws ResourceNotFoundException {
        return this.service.getById(id);
    }

    @Override
    public List<T> getAll() {
        return this.service.getAll();
    }


}
