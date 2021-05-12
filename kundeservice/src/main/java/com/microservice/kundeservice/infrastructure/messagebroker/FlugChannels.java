package com.microservice.kundeservice.infrastructure.messagebroker;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;


public interface FlugChannels {

    String FLUG_CREATION_CHANNEL_SINK = "flugCreationChannelSink";

    @Input(FLUG_CREATION_CHANNEL_SINK)
    MessageChannel flugCreationSink();

}
