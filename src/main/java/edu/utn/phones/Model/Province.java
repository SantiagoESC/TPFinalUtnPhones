package edu.utn.phones.Model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.utn.phones.Abstract.Iterfaces.IAbstractWebCrud;
import edu.utn.phones.Abstract.Iterfaces.IUriInterface;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Province implements IUriInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idProvince;


    @NotNull
    String nameProvince;


    @Override
    @JsonIgnore
    public Integer getId() {
        return idProvince;
    }
}
