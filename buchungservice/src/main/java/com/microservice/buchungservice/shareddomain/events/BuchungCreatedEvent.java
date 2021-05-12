package com.microservice.buchungservice.shareddomain.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BuchungCreatedEvent {

    BuchungCreatedEventData buchungCreatedEventData;

}
