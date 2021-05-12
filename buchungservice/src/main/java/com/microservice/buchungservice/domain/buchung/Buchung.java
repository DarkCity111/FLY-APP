package com.microservice.buchungservice.domain.buchung;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
public class Buchung extends AbstractAggregateRoot<Buchung> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String buchungsnummer;

    private String kundennummer;

    private String flugnummer;

    private Timestamp buchungszeit;


    public Buchung(CreateBuchungCommand createBuchungCommand){
        this.buchungsnummer = createBuchungCommand.getBuchungsnummer();
        this.kundennummer = createBuchungCommand.getKundennummer();
        this.flugnummer = createBuchungCommand.getFlugnummer();
        this.buchungszeit = new Timestamp(System.currentTimeMillis());

        //addDomainEvent()



    }

    private void addDomainEvent(Object event){
        registerEvent(event);
    }






}
