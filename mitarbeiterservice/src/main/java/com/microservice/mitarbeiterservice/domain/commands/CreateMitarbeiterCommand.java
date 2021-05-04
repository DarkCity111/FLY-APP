package com.microservice.mitarbeiterservice.domain.commands;


import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class CreateMitarbeiterCommand {

    String personalnummer;
    String vorname;
    String nachname;

}
