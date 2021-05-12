package com.microservice.kundeservice.shareddomain.events;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FlugCreatedEventData {

    private String flugnummer;

    public FlugCreatedEventData(String flugnummer){
        this.flugnummer = flugnummer;
    }

}
