package edu.utn.phones.Abstract;

import edu.utn.phones.Abstract.Iterfaces.IAbstractCrud;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractService<T, R extends JpaRepository<T,Integer>> implements IAbstractCrud<T> {


    protected final R repository;

    public AbstractService(R repository) {
        this.repository =  repository;

    }


    @Override
    public T add(T newT) {
        return this.repository.save(newT);
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
    public List<T> getAll() {
        return repository.findAll();
    }
}
