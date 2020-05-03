package edu.utn.phones.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bill {

    @Id
    @GeneratedValue
    Integer idBill;
    Integer idLine;         //O object PhoneLine?
    Integer idUser;         //same
    Integer quantityCall;
    Float   priceCost;
    Float   priceTotal;
    Date    dateBill;
    Date    dateExpiration;
    Boolean stateBill;
}
