package edu.utn.phones.Configuration;

import edu.utn.phones.Iterfaces.IUriInterface;
import edu.utn.phones.Session.SessionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@org.springframework.context.annotation.Configuration
@EnableScheduling
@EnableCaching
public class Configuration {


    @Autowired
    SessionFilter sessionFilter;



    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(sessionFilter);
        registration.addUrlPatterns("/api/*");
        return registration;
    }

    public static <T extends IUriInterface> URI getLocation (T Obj){
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(Obj.getId())
                .toUri();
    }







}
