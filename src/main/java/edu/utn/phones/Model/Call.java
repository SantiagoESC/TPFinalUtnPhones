package edu.utn.phones.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.utn.phones.Iterfaces.IUriInterface;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Call implements IUriInterface {

    @Id
    @GeneratedValue
    Integer idCall;


    @ManyToOne(fetch = FetchType.EAGER)
    Bill billCall;

    @NotNull
    String  numberOriginCall;
    @NotNull
    String  numberDestinationCall;

    @ManyToOne(fetch = FetchType.EAGER)
    City cityOriginCall;

    @ManyToOne(fetch = FetchType.EAGER)
    City cityDestinationCall;

    Float   priceMinuteCall;
    @NotNull
    Integer durationSegCall;

    Float   priceTotalCall;

    @NotNull
    Date    dateCall;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    PhoneLine lineCall;

    @Override
    @JsonIgnore
    public Integer getId() {
        return idCall;
    }
}
