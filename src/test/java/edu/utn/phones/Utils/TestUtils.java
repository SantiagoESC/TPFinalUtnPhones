package edu.utn.phones.Utils;

import edu.utn.phones.Domain.*;
import edu.utn.phones.Domain.Enums.UserType;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public static City createCity2(){
        City c = City.builder().idCity(1).nameCity("Mar del Plata").prefix("224").province(createProvince()).build();
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


    public static List<City> createCityList(){
        ArrayList<City> list = new ArrayList<>();
        for (int i = 0; i < 3 ; i++) {
            list.add(createCity());
        }
        return list;
    }


    public static List<Call> createCallList(){
        return new ArrayList<Call>();
    }


    public static List<Rate> createRateList() {
        return new ArrayList<>();
    }

    public static Rate createRate() {
        return Rate.builder()
                .idRate(1)
                .cityOrigin(createCity())
                .cityDestination(createCity())
                .pricePerMinute((float) 10)
                .build();
    }

    public static Rate createRate2() {
        return Rate.builder()
                .idRate(1)
                .cityOrigin(createCity())
                .cityDestination(createCity())
                .pricePerMinute((float) 15)
                .build();
    }

    public static Rate createRateNoId() {
        return Rate.builder()
                .cityOrigin(createCity())
                .cityDestination(createCity())
                .pricePerMinute((float) 10)
                .build();
    }
}
