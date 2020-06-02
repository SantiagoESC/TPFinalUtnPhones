package edu.utn.phones.Abstract;

import edu.utn.phones.Abstract.Iterfaces.IAbstractCrud;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;


import java.util.List;

public abstract class AbstractController<T> implements IAbstractCrud<T>{

    //region Atributes
    protected final AbstractService<T> service;
    //endregion


    //region Contructor
    public AbstractController(AbstractService<T> service) {
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
