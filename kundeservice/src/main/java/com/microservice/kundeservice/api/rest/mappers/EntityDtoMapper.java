package com.microservice.kundeservice.api.rest.mappers;

import com.microservice.kundeservice.domain.aggregates.Kunde;
import com.microservice.kundeservice.shareddomain.model.KundenResponseDTO;

public class EntityDtoMapper {

    public static KundenResponseDTO toKundenResponseDTO(Kunde kunde){
        return new KundenResponseDTO(
                kunde.getKundennummer().getKundennummer(),
                kunde.getVorname().getName(),
                kunde.getNachname().getName(),
                kunde.getPlz().getPostleitzahl(),
                kunde.getOrt().getOrt()
        );
    }


}
