package com.microservice.buchungservice.domain.kunde;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KundeForBuchungCreatedEventData {

    private String kundennummer;

    public KundeForBuchungCreatedEventData(String kundennummer){
        this.kundennummer = kundennummer;
    }

}
