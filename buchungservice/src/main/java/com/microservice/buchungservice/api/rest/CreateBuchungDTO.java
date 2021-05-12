package com.microservice.buchungservice.api.rest;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class CreateBuchungDTO {

    private String buchungsnummer;
    private String kundennummer;
    private String flugnummer;


}
