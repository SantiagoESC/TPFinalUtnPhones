package edu.utn.phones.Model.Temp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String dni;
    String userName;
    String password;
    String name;
    String surname;

    @ManyToOne(fetch = FetchType.EAGER)
    City city;




}
