package edu.utn.phones.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.utn.phones.Iterfaces.IUriInterface;
import edu.utn.phones.Model.Enums.LineStatus;
import edu.utn.phones.Model.Enums.LineType;
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
public class PhoneLine implements IUriInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idLine;
    @NotNull
    String  numberLine;
    @NotNull
    @Enumerated(EnumType.STRING)
    LineType typeLine;

    @NotNull
    @Enumerated(EnumType.STRING)
    LineStatus statusLine;


    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @NotNull
    User ownerLine;



    @Override
    @JsonIgnore
    public Integer getId() {
        return idLine;
    }
}
