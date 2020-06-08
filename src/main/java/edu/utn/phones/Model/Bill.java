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
public class Bill implements IUriInterface {

    @Id
    @GeneratedValue
    Integer idBill;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    PhoneLine lineBill;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    User userBill;
    @NotNull
    Integer quantityCall;
    @NotNull
    Float   priceCost;
    @NotNull
    Float   priceTotal;
    @NotNull
    Date    dateBill;
    @NotNull
    Date    dateExpiration;
    @NotNull
    boolean isPaidBill;

    @Override
    @JsonIgnore
    public Integer getId() {
        return idBill;
    }
}
