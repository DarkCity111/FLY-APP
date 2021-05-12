package com.microservice.flugservice.services;


import com.microservice.flugservice.infrastructure.messagebroker.FlugChannels;
import com.microservice.flugservice.shareddomain.events.FlugCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(FlugChannels.class)
@Slf4j
public class DomainEventAndPublisherService {

    private final FlugChannels flugChannels;


    public DomainEventAndPublisherService(FlugChannels flugChannels) {
        this.flugChannels = flugChannels;
    }

    public void handleFlugCreatedEvent(FlugCreatedEvent flugCreatedEvent){
        try{
            log.info("Listend to Domain Event -> Flug Created: " + flugCreatedEvent.getFlugCreatedEventData());
            log.info("Send Domain Event Flug Created to Message Broker Queue");
            flugChannels.flugCreationSource().send(MessageBuilder.withPayload(flugCreatedEvent).build());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
