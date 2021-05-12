package com.microservice.buchungservice.domain.buchung;


import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class CreateBuchungCommand {

    private String buchungsnummer;
    private String kundennummer;
    private String flugnummer;




}
