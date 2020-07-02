package edu.utn.phones.Utils;

import edu.utn.phones.Domain.*;
import edu.utn.phones.Domain.Enums.LineStatus;
import edu.utn.phones.Domain.Enums.LineType;
import edu.utn.phones.Domain.Enums.UserType;
import edu.utn.phones.Projetions.CallProjection;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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


    public static User createUserNoId() {
        return User.builder()

                .firstName("Agustin").lastName("Bulzomi")
                .username("abulzomi").password("1234")
                .userType(UserType.EMPLOYEE)
                .dni("42568712")
                .city(createCity())
                .build();
    }

    public static User createUser2() {
        return User.builder()

                .firstName("Exequiel").lastName("Suarez")
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


    public static List<CallProjection> createCallList(){
        return new ArrayList<CallProjection>();
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


    public static List<User> createUserList() {
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 3 ; i++) {
            list.add(createUser());
        }
        return list;
    }

    public static PhoneLine createPhoneLineNoId() {
        return PhoneLine.builder()

                .numberLine("2235863142")
                .ownerLine(createUser())
                .statusLine(LineStatus.ACTIVE)
                .typeLine(LineType.MOVILE)
                .build();
    }

    public static PhoneLine createPhoneLine() {
        return PhoneLine.builder()
                .idLine(1)
                .numberLine("2235863142")
                .ownerLine(createUser())
                .statusLine(LineStatus.ACTIVE)
                .typeLine(LineType.MOVILE)
                .build();
    }

    public static PhoneLine createPhoneLine2() {       return PhoneLine.builder()
            .idLine(1)
            .numberLine("22358623412")
            .ownerLine(createUser())
            .statusLine(LineStatus.ACTIVE)
            .typeLine(LineType.MOVILE)
            .build();
    }

    public static List<PhoneLine> createPhoneLineList() {
        List<PhoneLine> list = new ArrayList<PhoneLine>();
        for (int i = 0; i < 3 ; i++) {
            list.add(createPhoneLine());
        }
        return list;
    }

    public static Call createCall() {
        return Call.builder()
                .idCall(1)
                .billCall(null)
                .cityDestination(createCity())
                .cityOrigin(createCity())
                .costPerMinute(new Random().nextFloat())
                .dateCall(LocalDateTime.now())
                .durationInSeconds(180)
                .pricePerMinute(new Random().nextFloat())
                .numberDestination("22342168547")
                .numberOrigin("2235863214")
                .priceTotal(new Random().nextFloat())
                .build();
    }


    public static Call createCallNoId() {
        return Call.builder()

                .billCall(null)
                .cityDestination(createCity())
                .cityOrigin(createCity())
                .costPerMinute(new Random().nextFloat())
                .dateCall(LocalDateTime.now())
                .durationInSeconds(180)
                .pricePerMinute(new Random().nextFloat())
                .numberDestination("22342168547")
                .numberOrigin("2235863214")
                .priceTotal(new Random().nextFloat())
                .build();
    }

    public static List<CallProjection> createCallProjectionList() {

        return new ArrayList<CallProjection>();
    }

    public static Province createProvince2() {
        Province p = Province.builder().nameProvince("Buenos Aires").idProvince(1).build();
        return p;
    }

    public static List<Province> createProvinceList() {

        List<Province> list =  new ArrayList<Province>();
        list.add(createProvince());
        return list;
    }
}
