package com.microservice.kundeservice.shareddomain.events;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FlugCreatedEvent {

    private FlugCreatedEventData flugCreatedEventData;

    public FlugCreatedEvent(FlugCreatedEventData flugCreatedEventData){
        this.flugCreatedEventData = flugCreatedEventData;
    }



}
