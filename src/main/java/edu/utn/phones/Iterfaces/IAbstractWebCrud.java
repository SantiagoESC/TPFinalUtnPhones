package edu.utn.phones.Iterfaces;

import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

public interface IAbstractWebCrud<T> {

    public ResponseEntity add( T newT);

    public ResponseEntity update( T updatedT, Integer id) throws ResourceNotFoundException;

    public ResponseEntity delete( Integer id) throws ResourceNotFoundException;

    public ResponseEntity<T> getById( Integer id) throws ResourceNotFoundException;

}
