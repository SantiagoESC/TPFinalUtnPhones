package edu.utn.phones.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.utn.phones.Iterfaces.IUriInterface;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "calls")
public class Call implements IUriInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer idCall;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idBill")
    Bill billCall;

    @NotNull
    @Column
    String  numberOrigin;
    @NotNull
    @Column
    String  numberDestination;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idLineOrigin")
    PhoneLine lineOrigin;



    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idLineDestination")
    PhoneLine lineDestination;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idCityOrigin")
    City cityOrigin;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idCityDestination")
    City cityDestination;

    @NotNull
    @Column
    Integer durationInSeconds;


    @Column
    Float   pricePerMinute;


    @Column
    Float   costPerMinute;


    @Column
    Float   priceTotal;

    @NotNull
    @Column
    LocalDateTime dateCall;



    @Override
    @JsonIgnore
    public Integer getId() {
        return idCall;
    }
}
