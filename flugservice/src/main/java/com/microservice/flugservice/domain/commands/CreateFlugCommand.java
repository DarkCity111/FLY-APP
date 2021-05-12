package com.microservice.flugservice.domain.commands;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class CreateFlugCommand {

    String flugnummer;
    String flugdatum;
    String startflughafen;
    String zielflughafen;


}
