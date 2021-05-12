package com.microservice.buchungservice.domain.flug;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Flug extends AbstractAggregateRoot<Flug> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String flugnummer;

    public Flug(CreateFlugCommand createFlugCommand){
        this.flugnummer = createFlugCommand.getFlugnummer();
        addDomainEvent(new FlugForBuchungCreatedDomainEvent(new FlugForBuchungCreatedDomainEventData(createFlugCommand.getFlugnummer())));
    }



    private void addDomainEvent(Object event){
        registerEvent(event);
    }


}
