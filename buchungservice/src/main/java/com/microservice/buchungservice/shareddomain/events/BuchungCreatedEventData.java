package com.microservice.buchungservice.shareddomain.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BuchungCreatedEventData {

    private String buchungsnummer;
    private String kundennummer;
    private String flugnummer;
    private String buchungszeit;

}
