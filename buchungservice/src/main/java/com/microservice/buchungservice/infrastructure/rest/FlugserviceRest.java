package com.microservice.buchungservice.infrastructure.rest;

import com.microservice.buchungservice.shareddomain.model.FlugResponseDTO;

public interface FlugserviceRest {

    FlugResponseDTO getFlug(String flugnummer);
}
