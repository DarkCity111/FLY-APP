package com.microservice.buchungservice.domain.kunde;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Kunde extends AbstractAggregateRoot<Kunde> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String kundennummer;

    public Kunde(CreateKundeCommand createKundeCommand){
        this.kundennummer = createKundeCommand.getKundennummer();
        addDomainEvent(new KundeForBuchungCreatedEvent(new KundeForBuchungCreatedEventData(this.kundennummer)));
    }

    private void addDomainEvent(Object event){
        registerEvent(event);
    }


}
