package com.microservice.flugservice.infrastructure.messagebroker;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface KundenChannels {

    String FLUG_CREATION_CHANNEL_SINK = "flugCreationChannelSink";

    @Input(FLUG_CREATION_CHANNEL_SINK)
    MessageChannel flugCreationSink();
}
