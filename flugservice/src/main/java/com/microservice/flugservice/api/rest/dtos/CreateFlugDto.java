package com.microservice.flugservice.api.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class CreateFlugDto {

    String flugnummer;
    String flugdatum;
    String startflughafen;
    String zielflughafen;

}
