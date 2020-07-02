package edu.utn.phones.Configuration;

import edu.utn.phones.Iterfaces.IUriInterface;
import edu.utn.phones.Session.Session;
import edu.utn.phones.Session.SessionFilter;
import edu.utn.phones.Session.SessionFilterAntenna;
import edu.utn.phones.Session.SessionFilterBackoffice;
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
    @Autowired
    SessionFilterBackoffice sessionFilterBackoffice;
    @Autowired
    SessionFilterAntenna sessionFilterAntenna;



    @Bean
    public FilterRegistrationBean myFilterWeb() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(sessionFilter);
        registration.addUrlPatterns("/api/web/*");
        return registration;
    }


    @Bean
    public FilterRegistrationBean myFilterBackOffice() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(sessionFilterBackoffice);
        registration.addUrlPatterns("/api/backoffice/*");
        return registration;
    }


    @Bean
    public FilterRegistrationBean myFilterAntenna() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(sessionFilterAntenna);
        registration.addUrlPatterns("/api/antenna/*");
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
