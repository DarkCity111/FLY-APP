package com.microservice.kundeservice.domain.commands;


import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class CreateKundeCommand {

    String kundennummer;
    String vorname;
    String nachname;
    String plz;
    String ort;

}
