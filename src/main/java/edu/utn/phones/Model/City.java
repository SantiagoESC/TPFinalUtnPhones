package edu.utn.phones.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.utn.phones.Abstract.Iterfaces.IUriInterface;
import edu.utn.phones.Model.Province;
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
public class City  implements IUriInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCity;

    @NotNull
    String prefix;

    @NotNull
    String nameCity;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    Province province;

    @Override
    public Integer getId() {
        return idCity;
    }
}
