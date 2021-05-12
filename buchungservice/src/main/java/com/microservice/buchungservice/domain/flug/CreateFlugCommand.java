package com.microservice.buchungservice.domain.flug;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class CreateFlugCommand {

    String flugnummer;

}
