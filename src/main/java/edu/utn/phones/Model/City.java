package edu.utn.phones.Model;

import edu.utn.phones.Model.Province;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCity;
    String prefix;
    String nameCity;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    Province province;
}
