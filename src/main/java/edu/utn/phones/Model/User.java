package edu.utn.phones.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.utn.phones.Abstract.Iterfaces.IUriInterface;
import edu.utn.phones.Model.City;
import edu.utn.phones.Model.Enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class User implements IUriInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idUser;


    @NotNull
    String userName;
    @NotNull
    String password;
    @NotNull
    String name;
    @NotNull
    String lastName;
    @NotNull
    String dni;

    @NotNull
    @Enumerated(EnumType.STRING)
    UserType userType;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    City city;


    @Override
    @JsonIgnore
    public Integer getId() {
        return idUser;
    }
}
