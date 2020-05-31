package edu.utn.phones.Exceptions.GeneralExceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResourceNotFoundException extends Throwable {

    public ResourceNotFoundException(String s) {
        super(s);
    }

}
