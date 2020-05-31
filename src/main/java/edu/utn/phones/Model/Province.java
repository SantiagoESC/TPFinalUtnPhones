package edu.utn.phones.Model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idProvince;
    String nameProvince;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "province")
    @JsonBackReference
    List<City> cities;


}
