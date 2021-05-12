package com.microservice.flugservice.api.rest.mappers;

import com.microservice.flugservice.domain.aggregates.Flug;
import com.microservice.flugservice.shareddomain.model.FlugResponseDTO;

public class EntityDtoMapper {

    public static FlugResponseDTO toFlugResponseDTO(Flug flug){
        return new FlugResponseDTO(
                flug.getFlugnummer().getFlugnummer(),
                flug.getFlugdatum().getDatum(),
                flug.getStartflughafen().getName(),
                flug.getZielflughafen().getName()
        );
    }



}
