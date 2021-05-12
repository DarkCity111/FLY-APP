package com.microservice.kundeservice.api.eventlistener;


import com.microservice.kundeservice.infrastructure.messagebroker.KundeChannels;
import com.microservice.kundeservice.shareddomain.events.KundeCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(KundeChannels.class)
@Slf4j
public class KundeChannelListener {

    @StreamListener(target = KundeChannels.KUNDE_CREATION_CHANNEL_SINK)
    public void processKundeCreated(KundeCreatedEvent kundeCreatedEvent){
        log.info("Listened to Message Broker Kunde Created Event: " + kundeCreatedEvent.getKundeCreatedEventData());
    }


}
