package com.microservice.buchungservice.api.eventlistener.mapper;

import com.microservice.buchungservice.domain.flug.CreateFlugCommand;
import com.microservice.buchungservice.shareddomain.events.FlugCreatedEvent;
import com.microservice.buchungservice.shareddomain.events.FlugCreatedEventData;

public class FlugCreatedEventToCommand {

    public static CreateFlugCommand toCommand(FlugCreatedEvent flugCreatedEvent){
        FlugCreatedEventData flugCreatedEventData = flugCreatedEvent.getFlugCreatedEventData();
        return new CreateFlugCommand(flugCreatedEventData.getFlugnummer());
    }



}
