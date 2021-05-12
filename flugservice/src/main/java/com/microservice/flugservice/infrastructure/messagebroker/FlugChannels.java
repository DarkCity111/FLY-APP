package com.microservice.flugservice.infrastructure.messagebroker;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface FlugChannels {

    String FLUG_CREATION_CHANNEL_SOURCE = "flugCreationChannelSource";
    String FLUG_CREATION_CHANNEL_SINK = "flugCreationChannelSink";

    @Output(FLUG_CREATION_CHANNEL_SOURCE)
    MessageChannel flugCreationSource();

    @Input(FLUG_CREATION_CHANNEL_SINK)
    MessageChannel flugCreationSink();


}
