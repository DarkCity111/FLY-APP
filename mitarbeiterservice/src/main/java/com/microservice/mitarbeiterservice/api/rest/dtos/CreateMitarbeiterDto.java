package com.microservice.mitarbeiterservice.api.rest.dtos;


import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class CreateMitarbeiterDto {

    String personalnummer;
    String vorname;
    String nachname;

}
