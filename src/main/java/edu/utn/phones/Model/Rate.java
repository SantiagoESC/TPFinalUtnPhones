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
public class Rate implements IUriInterface {

    @Id
    @GeneratedValue
    Integer idRate;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    City cityOrigin;
    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    City cityDestination;
    @NotNull
    Float   priceMinute;

    @Override
    @JsonIgnore
    public Integer getId() {
        return idRate;
    }

}
