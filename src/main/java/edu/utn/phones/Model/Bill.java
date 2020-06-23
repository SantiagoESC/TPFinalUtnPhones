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
@Table(name = "bills")
public class Bill implements IUriInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer idBill;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idLine")
    PhoneLine lineBill;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idUser")
    User userBill;

    @NotNull
    @Column
    Integer quantityOfCalls;

    @NotNull
    @Column
    Float   costPerMinute;
    @NotNull
    @Column
    Float   pricePerMinute;
    @NotNull
    @Column
    LocalDateTime    dateBill;
    @NotNull
    @Column
    LocalDateTime dateExpiration;
    @NotNull
    @Column
    boolean isPaidBill;

    @Override
    @JsonIgnore
    public Integer getId() {
        return idBill;
    }
}
