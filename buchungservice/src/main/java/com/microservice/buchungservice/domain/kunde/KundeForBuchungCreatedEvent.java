package com.microservice.buchungservice.domain.kunde;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KundeForBuchungCreatedEvent {
    private KundeForBuchungCreatedEventData kundeForBuchungCreatedEventData;
}
