package edu.utn.phones.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.utn.phones.Iterfaces.IUriInterface;
import edu.utn.phones.Domain.Enums.LineStatus;
import edu.utn.phones.Domain.Enums.LineType;
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
@Table(name = "phoneLines")
public class PhoneLine implements IUriInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer idLine;

    @Column
    @NotNull
    String  numberLine;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('RESIDENTIAL', 'MOVILE')")
    LineType typeLine;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('ACTIVE', 'SUSPENDED')")
    LineStatus statusLine;


    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @NotNull
    @JoinColumn(name = "idUser")
    User ownerLine;



    @Override
    @JsonIgnore
    public Integer getId() {
        return idLine;
    }
}
