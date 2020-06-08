package edu.utn.phones.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.utn.phones.Iterfaces.IUriInterface;
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
    @JsonIgnore
    public Integer getId() {
        return idCity;
    }
}
