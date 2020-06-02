package edu.utn.phones.Abstract.Iterfaces;


import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import edu.utn.phones.Model.Province;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IAbstractWebCrud<T> {

    public ResponseEntity add(@RequestBody T newT);

    public ResponseEntity update(@RequestBody T updatedT, @PathVariable Integer id) throws ResourceNotFoundException;

    public ResponseEntity delete(@PathVariable Integer id) throws ResourceNotFoundException;

    public ResponseEntity<T> getById(@PathVariable Integer id) throws ResourceNotFoundException;

}
