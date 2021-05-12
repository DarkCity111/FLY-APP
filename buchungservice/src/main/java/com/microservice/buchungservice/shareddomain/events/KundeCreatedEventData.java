package com.microservice.buchungservice.shareddomain.events;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KundeCreatedEventData {

    private String kundennummer;
    private String vorname;
    private String nachname;
    private String plz;
    private String ort;

    public KundeCreatedEventData(String kundennummer, String vorname, String nachname, String plz, String ort){
        this.kundennummer = kundennummer;
        this.vorname = vorname;
        this.nachname = nachname;
        this.plz = plz;
        this.ort = ort;
    }



}
