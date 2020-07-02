package edu.utn.phones.Service;

import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Iterfaces.IAbstractCrud;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public  class AbstractService<T, R extends JpaRepository<T,Integer>> implements IAbstractCrud<T>  {


    protected final R repository;

    public AbstractService(R repository) {
        this.repository =  repository;

    }


    @Override
    public T add(T newT)  {
        return  this.repository.save(newT);
    }

    @Override
    public T update(T updatedT) {
        return this.repository.save(updatedT);
    }

    @Override
    public void delete(T ToDelete) {
        this.repository.delete(ToDelete);
    }

    @Override
    public T getById(Integer id) throws ResourceNotFoundException {
        return this.repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<T> getAll() throws NoContentToShowException {
         List<T> list= repository.findAll();
        if(list.size() == 0){
            throw new NoContentToShowException();
        }
         return list;
    }
}
