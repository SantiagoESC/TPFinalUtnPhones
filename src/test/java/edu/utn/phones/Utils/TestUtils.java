package edu.utn.phones.Utils;

import edu.utn.phones.Domain.Call;
import edu.utn.phones.Domain.City;
import edu.utn.phones.Domain.Enums.UserType;
import edu.utn.phones.Domain.Province;
import edu.utn.phones.Domain.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
       return   User.builder()
               .idUser(1)
               .firstName("Agustin").lastName("Bulzomi")
               .username("abulzomi").password("1234")
               .userType(UserType.EMPLOYEE)
               .dni("42568712")
               .city(createCity())
               .build();
    }


    public static List<Call> createCallList(){
        return null;
    }




}
