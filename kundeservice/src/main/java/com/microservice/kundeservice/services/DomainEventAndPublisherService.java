package com.microservice.kundeservice.services;


import com.microservice.kundeservice.infrastructure.messagebroker.KundeChannels;
import com.microservice.kundeservice.shareddomain.events.KundeCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@EnableBinding(KundeChannels.class)
@Slf4j
public class DomainEventAndPublisherService {

    private final KundeChannels kundeChannels;

    public DomainEventAndPublisherService(KundeChannels kundeChannels) {
        this.kundeChannels = kundeChannels;
    }

    @TransactionalEventListener
    public void handleKundeCreatedEvent(KundeCreatedEvent kundeCreatedEvent){
        try{
            log.info("Listen to Domain Event -> Kunde Created: " + kundeCreatedEvent.getKundeCreatedEventData());
            log.info("Send Domain Event Data to Message Broker Queue");
            kundeChannels.kundeCreationSource().send(MessageBuilder.withPayload(kundeCreatedEvent).build());
        } catch (Exception e){
            log.error("Problem mit verbindung zum Message Broker. KundeCreatedEvent konnte nicht gesendet werde : " + kundeCreatedEvent.getKundeCreatedEventData());
            e.printStackTrace();
        }
    }
}
