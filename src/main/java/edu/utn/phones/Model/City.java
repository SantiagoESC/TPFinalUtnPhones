package edu.utn.phones.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class City {
    @Id
    @GeneratedValue
    Integer id;
    String prefix;
    String nameCity;

    @OneToOne
    Province province;
}
