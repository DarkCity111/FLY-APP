package com.microservice.kundeservice.domain.aggregates;

import com.microservice.kundeservice.domain.commands.CreateKundeCommand;
import com.microservice.kundeservice.domain.valueobjects.Kundennummer;
import com.microservice.kundeservice.domain.valueobjects.PersonName;
import com.microservice.kundeservice.domain.valueobjects.PersonOrt;
import com.microservice.kundeservice.domain.valueobjects.PersonPLZ;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class Kunde {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    @Column(unique = true)
    private Kundennummer kundennummer;

    @Embedded
    @NotNull
    private PersonName vorname;

    @Embedded
    @NotNull
    private PersonName nachname;

    @Embedded
    @NotNull
    private PersonPLZ plz;

    @Embedded
    @NotNull
    private PersonOrt ort;

    public Kunde(CreateKundeCommand createKundeCommand){
        this.kundennummer = new Kundennummer(createKundeCommand.getKundennummer());
        this.vorname = new PersonName(createKundeCommand.getVorname());
        this.nachname = new PersonName(createKundeCommand.getNachname());
        this.plz = new PersonPLZ(createKundeCommand.getPlz());
        this.ort = new PersonOrt(createKundeCommand.getOrt());


        /// DOMAIN EVENT IMPLEMENTIEREN !"!!
        ///////
        ///////
        //////////////////////
    }


}
