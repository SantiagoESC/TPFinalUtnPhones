package edu.utn.phones.Configuration;

import edu.utn.phones.Iterfaces.IUriInterface;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
