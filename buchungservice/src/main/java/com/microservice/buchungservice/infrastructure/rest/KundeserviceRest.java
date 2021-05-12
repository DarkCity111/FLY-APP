package com.microservice.buchungservice.infrastructure.rest;

import com.microservice.buchungservice.shareddomain.model.KundenResponseDTO;

public interface KundeserviceRest {

    KundenResponseDTO getKunde(String kundennummer);

}
