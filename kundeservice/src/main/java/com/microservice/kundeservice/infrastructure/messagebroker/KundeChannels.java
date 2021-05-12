package com.microservice.kundeservice.infrastructure.messagebroker;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface KundeChannels {

    String KUNDE_CREATION_CHANNEL_SOURCE = "kundeCreationChannelSource";
    String KUNDE_CREATION_CHANNEL_SINK = "kundeCreationChannelSink";

    @Output(KUNDE_CREATION_CHANNEL_SOURCE)
    MessageChannel kundeCreationSource();

    @Input(KUNDE_CREATION_CHANNEL_SINK)
    MessageChannel kundeCreationSink();
}
