package edu.utn.phones.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.utn.phones.Iterfaces.IUriInterface;
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
@Table(name = "rates")
public class Rate implements IUriInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer idRate;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "idCityOrigin")
    City cityOrigin;
    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "idCityDestination")
    City cityDestination;

    @NotNull
    @Column
    Float   pricePerMinute;

    @Override
    @JsonIgnore
    public Integer getId() {
        return idRate;
    }

}
