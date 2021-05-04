package com.microservice.mitarbeiterservice.api.rest.mappers;


import com.microservice.mitarbeiterservice.domain.aggregates.Mitarbeiter;
import com.microservice.mitarbeiterservice.shareddomain.model.MitarbeiterResponseDTO;

public class EntityDtoMapper {

    public static MitarbeiterResponseDTO toMitarbeiterResponseDTO(Mitarbeiter mitarbeiter){
        return new MitarbeiterResponseDTO(
                mitarbeiter.getPersonalnummer().getPersonalnummer(),
                mitarbeiter.getVorname().getName(),
                mitarbeiter.getNachname().getName()
        );
    }

}
