package com.microservice.mitarbeiterservice.domain.aggregates;



import com.microservice.mitarbeiterservice.domain.commands.CreateMitarbeiterCommand;
import com.microservice.mitarbeiterservice.domain.valueobjects.PersonName;
import com.microservice.mitarbeiterservice.domain.valueobjects.Personalnummer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class Mitarbeiter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    @Column(unique = true)
    private Personalnummer personalnummer;

    @Embedded
    @NotNull
    @AttributeOverrides({
            @AttributeOverride(name="name", column = @Column(name = "firstname"))
    })
    private PersonName vorname;

    @Embedded
    @NotNull
    @AttributeOverrides({
            @AttributeOverride(name="name", column = @Column(name = "lastname"))
    })
    private PersonName nachname;




    public Mitarbeiter(CreateMitarbeiterCommand createMitarbeiterCommand){
        this.personalnummer = new Personalnummer(createMitarbeiterCommand.getPersonalnummer());
        this.vorname = new PersonName(createMitarbeiterCommand.getVorname());
        this.nachname = new PersonName(createMitarbeiterCommand.getNachname());
    }


    /// DOMAIN EVENT IMPLEMENTIEREN !"!!
    ///////
    ///////
    //////////////////////



}
