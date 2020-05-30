package edu.utn.phones.Controller.Advice;

import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(NoContentToShowException.class)
    public ResponseEntity handleNoContentToShowException (){

        return ResponseEntity.ok().body("You don't have any object of that type.");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity handleResourceNotFoundException(){

        return ResponseEntity.notFound().build();
    }

}
