package com.microservice.buchungservice.api.eventlistener.mapper;

import com.microservice.buchungservice.domain.kunde.CreateKundeCommand;
import com.microservice.buchungservice.shareddomain.events.KundeCreatedEvent;
import com.microservice.buchungservice.shareddomain.events.KundeCreatedEventData;

public class KundeCreatedEventToCommand {

    public static CreateKundeCommand toCommand(KundeCreatedEvent kundeCreatedEvent){
        KundeCreatedEventData kundeCreatedEventData = kundeCreatedEvent.getKundeCreatedEventData();
        return new CreateKundeCommand(kundeCreatedEventData.getKundennummer());
    }


}
