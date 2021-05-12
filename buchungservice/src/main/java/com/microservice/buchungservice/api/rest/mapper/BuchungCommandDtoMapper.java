package com.microservice.buchungservice.api.rest.mapper;

import com.microservice.buchungservice.api.rest.CreateBuchungDTO;
import com.microservice.buchungservice.domain.buchung.CreateBuchungCommand;

public class BuchungCommandDtoMapper {


    public static CreateBuchungDTO toCreateBuchungDTO(CreateBuchungCommand createBuchungCommand){
        return new CreateBuchungDTO(
                createBuchungCommand.getBuchungsnummer(),
                createBuchungCommand.getKundennummer(),
                createBuchungCommand.getFlugnummer()
        );
    }

    public static CreateBuchungCommand toCreateBuchungCommang(CreateBuchungDTO createBuchungDTO){
        return new CreateBuchungCommand(
                createBuchungDTO.getBuchungsnummer(),
                createBuchungDTO.getKundennummer(),
                createBuchungDTO.getFlugnummer()
        );
    }




}
