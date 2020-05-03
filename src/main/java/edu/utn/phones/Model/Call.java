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
public class Call {

    @Id
    @GeneratedValue
    Integer idCall;
    Integer idBill;
    String  numberOrigin;
    String  numberDestination;
    Integer prefixOrigin;
    Integer prefixDestination;
    Float   priceMinutes;
    Integer duration;
    Float   priceTotal;
    Date    dateCall;
}
