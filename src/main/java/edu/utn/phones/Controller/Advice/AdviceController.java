package edu.utn.phones.Controller.Advice;

import edu.utn.phones.Exceptions.NoContentToShowException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(NoContentToShowException.class)
    public ResponseEntity handleProvinceNotExistException (){

        System.out.println("AAAAAA");
        return ResponseEntity.ok().body("You don't have any object of that type.");
    }

}
