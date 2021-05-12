package com.microservice.buchungservice.shareddomain.events;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KundeCreatedEvent {

    private KundeCreatedEventData kundeCreatedEventData;

    public KundeCreatedEvent(KundeCreatedEventData kundeCreatedEventData){
        this.kundeCreatedEventData = kundeCreatedEventData;
    }


}
