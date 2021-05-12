package com.microservice.buchungservice.domain.flug;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlugForBuchungCreatedDomainEventData {

    private String flugnummer;

}
