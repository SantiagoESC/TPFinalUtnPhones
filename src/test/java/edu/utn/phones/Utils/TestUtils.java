package edu.utn.phones.Utils;

import edu.utn.phones.Iterfaces.IUriInterface;
import edu.utn.phones.Model.City;
import edu.utn.phones.Model.Province;
import edu.utn.phones.Model.User;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class TestUtils {



    public  static Province createProvince (){

        Province p = Province.builder().nameProvince("Buenos Aires").idProvince(1).build();
        return p;
    }


    public  static Province createProvinceNoId (){

        Province p = Province.builder().nameProvince("Buenos Aires").build();
        return p;
    }


    public static City createCity(){
        City c = City.builder().idCity(1).nameCity("Mar del Plata").prefix("223").province(createProvince()).build();
        return c;
    }

    public static City createCityNoId(){
        City c = City.builder().nameCity("Mar del Plata").prefix("223").province(createProvince()).build();
        return c;
    }
    public static User createUser(){
       return   new User();
    }


}
