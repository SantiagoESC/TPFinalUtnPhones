package edu.utn.phones.Configuration;

import edu.utn.phones.Abstract.Iterfaces.IUriInterface;
import edu.utn.phones.Model.Province;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;

public class Configuration {


    public static <T extends IUriInterface> URI getLocation (T Obj){
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(Obj.getId())
                .toUri();
    }




}
