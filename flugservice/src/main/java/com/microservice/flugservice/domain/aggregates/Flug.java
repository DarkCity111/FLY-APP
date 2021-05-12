package com.microservice.flugservice.domain.aggregates;

import com.microservice.flugservice.domain.commands.CreateFlugCommand;
import com.microservice.flugservice.domain.valueobjects.Flugdatum;
import com.microservice.flugservice.domain.valueobjects.Flughafen;
import com.microservice.flugservice.domain.valueobjects.Flugnummer;
import com.microservice.flugservice.shareddomain.events.FlugCreatedEvent;
import com.microservice.flugservice.shareddomain.events.FlugCreatedEventData;
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
public class Flug extends AbstractAggregateRoot<Flug> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    @Column(unique = true)
    private Flugnummer flugnummer;

    @Embedded
    @NotNull
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "flugdatum"))
    })
    private Flugdatum flugdatum;

    @Embedded
    @NotNull
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "startflughafen"))
    })
    private Flughafen startflughafen;

    @Embedded
    @NotNull
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "zielflughafen"))
    })
    private Flughafen zielflughafen;

    public Flug(CreateFlugCommand createFlugCommand){
        this.flugnummer = new Flugnummer(createFlugCommand.getFlugnummer());
        this.flugdatum = new Flugdatum(createFlugCommand.getFlugdatum());
        this.startflughafen = new Flughafen(createFlugCommand.getStartflughafen());
        this.zielflughafen = new Flughafen(createFlugCommand.getZielflughafen());

        addDomainEvent(new FlugCreatedEvent(new FlugCreatedEventData(this.flugnummer.getFlugnummer())));

    }

    private void addDomainEvent (Object event){
        registerEvent(event);

    }

}
