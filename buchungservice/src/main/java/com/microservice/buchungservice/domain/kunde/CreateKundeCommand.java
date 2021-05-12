package com.microservice.buchungservice.domain.kunde;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class CreateKundeCommand {

    String kundennummer;

}
