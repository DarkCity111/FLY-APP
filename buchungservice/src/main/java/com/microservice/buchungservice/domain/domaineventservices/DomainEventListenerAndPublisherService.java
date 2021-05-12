package com.microservice.buchungservice.domain.domaineventservices;

import com.microservice.buchungservice.domain.flug.FlugForBuchungCreatedDomainEvent;
import com.microservice.buchungservice.domain.kunde.KundeForBuchungCreatedEvent;
import com.microservice.buchungservice.shareddomain.events.BuchungCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@Slf4j
public class DomainEventListenerAndPublisherService {

    @TransactionalEventListener
    public void handleKundeForBuchungCreatedEvent(KundeForBuchungCreatedEvent kundeForBuchungCreatedEvent){
        try{
            log.info("Listened to Domain Event -> Kunde created Event in Buchung service: " + kundeForBuchungCreatedEvent.getKundeForBuchungCreatedEventData());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @TransactionalEventListener
    public void handleFlugForBuchungCreatedEvent(FlugForBuchungCreatedDomainEvent flugForBuchungCreatedDomainEvent){
        try{
            log.info("Listened to Domain Event -> Flug created Event in Buchung service: " + flugForBuchungCreatedDomainEvent.getFlugForBuchungCreatedDomainEventData());
        }catch ( Exception e ){
            e.printStackTrace();
        }
    }

    @TransactionalEventListener
    public void handleBuchungCreatedEvent(BuchungCreatedEvent buchungCreatedEvent){
        log.info("Listend to Domain Event -> Buchung created: " + buchungCreatedEvent.getBuchungCreatedEventData());
    }


}
