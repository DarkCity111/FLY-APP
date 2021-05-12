package com.microservice.kundeservice.domain.aggregates;

import com.microservice.kundeservice.domain.commands.CreateKundeCommand;
import com.microservice.kundeservice.domain.valueobjects.Kundennummer;
import com.microservice.kundeservice.domain.valueobjects.PersonName;
import com.microservice.kundeservice.domain.valueobjects.PersonOrt;
import com.microservice.kundeservice.domain.valueobjects.PersonPLZ;
import com.microservice.kundeservice.shareddomain.events.KundeCreatedEvent;
import com.microservice.kundeservice.shareddomain.events.KundeCreatedEventData;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class Kunde extends AbstractAggregateRoot<Kunde> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    @Column(unique = true)
    private Kundennummer kundennummer;

    @Embedded
    @NotNull
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "vorname"))
    })
    private PersonName vorname;

    @Embedded
    @NotNull
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "nachname"))
    })
    private PersonName nachname;

    @Embedded
    @NotNull
    @AttributeOverrides({
            @AttributeOverride(name = "plz", column = @Column(name = "plz"))
    })
    private PersonPLZ plz;

    @Embedded
    @NotNull
    @AttributeOverrides({
            @AttributeOverride(name = "ort", column = @Column(name = "ort"))
    })
    private PersonOrt ort;

    public Kunde(CreateKundeCommand createKundeCommand){
        this.kundennummer = new Kundennummer(createKundeCommand.getKundennummer());
        this.vorname = new PersonName(createKundeCommand.getVorname());
        this.nachname = new PersonName(createKundeCommand.getNachname());
        this.plz = new PersonPLZ(createKundeCommand.getPlz());
        this.ort = new PersonOrt(createKundeCommand.getOrt());

        addDomainEvent(new KundeCreatedEvent(
                new KundeCreatedEventData(
                        this.kundennummer.getKundennummer(),
                        this.vorname.getName(),
                        this.nachname.getName(),
                        this.plz.getPostleitzahl(),
                        this.ort.getOrt())));

    }

    private void addDomainEvent(Object event){
        registerEvent(event);
    }


}
