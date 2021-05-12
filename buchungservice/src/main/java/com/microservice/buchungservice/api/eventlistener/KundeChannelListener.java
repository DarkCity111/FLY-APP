package com.microservice.buchungservice.api.eventlistener;

import com.microservice.buchungservice.api.eventlistener.mapper.KundeCreatedEventToCommand;
import com.microservice.buchungservice.domain.kunde.KundeCommandService;
import com.microservice.buchungservice.infrastructure.messagebroker.KundeChannels;
import com.microservice.buchungservice.shareddomain.events.KundeCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;


@EnableBinding(KundeChannels.class)
@Slf4j
public class KundeChannelListener {

    final KundeCommandService kundeCommandService;

    public KundeChannelListener(KundeCommandService kundeCommandService) {
        this.kundeCommandService = kundeCommandService;
    }

    @StreamListener(target = KundeChannels.KUNDE_CREATION_CHANNEL_SINK)
    public void processKundeCreated(KundeCreatedEvent kundeCreatedEvent){
        log.info("Listend to Message Broker -> Kunde Created: " + kundeCreatedEvent.getKundeCreatedEventData());
        kundeCommandService.createKunde(KundeCreatedEventToCommand.toCommand(kundeCreatedEvent));
    }
}
