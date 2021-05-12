package com.microservice.kundeservice.api.eventlistener;


import com.microservice.kundeservice.infrastructure.messagebroker.FlugChannels;
import com.microservice.kundeservice.shareddomain.events.FlugCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(FlugChannels.class)
@Slf4j
public class FlugChannelListener {

    @StreamListener(FlugChannels.FLUG_CREATION_CHANNEL_SINK)
    public void processFlugCreated(FlugCreatedEvent flugCreatedEvent){
        log.info("Listend to Message Broker Flug Created Event: " + flugCreatedEvent.getFlugCreatedEventData());
    }


}
