package edu.utn.phones.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rate {

    @Id
    @GeneratedValue
    Integer idRate;
    Integer prefixOrigin;
    Integer prefixDestination;
    Float   priceMinutes;
    Boolean stateRate;
}
