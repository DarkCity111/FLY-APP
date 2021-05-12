package com.microservice.buchungservice.api.eventlistener;


import com.microservice.buchungservice.api.eventlistener.mapper.FlugCreatedEventToCommand;
import com.microservice.buchungservice.domain.flug.FlugCommandService;
import com.microservice.buchungservice.infrastructure.messagebroker.FlugChannels;
import com.microservice.buchungservice.shareddomain.events.FlugCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(FlugChannels.class)
@Slf4j
public class FlugChannelListener {

    final FlugCommandService flugCommandService;

    public FlugChannelListener(FlugCommandService flugCommandService) {
        this.flugCommandService = flugCommandService;
    }

    @StreamListener(target = FlugChannels.FLUG_CREATION_CHANNEL_SINK)
    public void processFlugCreated(FlugCreatedEvent flugCreatedEvent){
        log.info("Listen to Message Broker -> Flug Creation: " + flugCreatedEvent.getFlugCreatedEventData());
        flugCommandService.createFlug(FlugCreatedEventToCommand.toCommand(flugCreatedEvent));
    }
}
