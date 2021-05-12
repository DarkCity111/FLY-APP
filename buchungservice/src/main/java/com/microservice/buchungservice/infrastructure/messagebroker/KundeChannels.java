package com.microservice.buchungservice.infrastructure.messagebroker;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface KundeChannels {

    String KUNDE_CREATION_CHANNEL_SINK = "kundeCreationChannelSink";

    @Input(KUNDE_CREATION_CHANNEL_SINK)
    MessageChannel kundeCreation();


}
