package edu.utn.phones.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.utn.phones.Iterfaces.IUriInterface;
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
@Table(name = "users")
public class User implements IUriInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer idUser;


    @NotNull
    @Column
    String username;
    @NotNull
    @Column
    String password;
    @NotNull
    @Column
    String firstName;

    @NotNull
    @Column
    String lastName;
    @Column
    @NotNull
    String dni;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('CLIENT','EMPLOYEE')")
    UserType userType;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idCity")
    City city;


    @Override
    @JsonIgnore
    public Integer getId() {
        return idUser;
    }
}
