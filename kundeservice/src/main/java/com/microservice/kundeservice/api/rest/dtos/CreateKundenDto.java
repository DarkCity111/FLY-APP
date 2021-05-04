package com.microservice.kundeservice.api.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class CreateKundenDto {

    String kundennummer;
    String vorname;
    String nachname;
    String plz;
    String ort;

}
