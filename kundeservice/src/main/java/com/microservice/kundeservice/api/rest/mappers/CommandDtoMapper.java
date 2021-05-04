package com.microservice.kundeservice.api.rest.mappers;

import com.microservice.kundeservice.api.rest.dtos.CreateKundenDto;
import com.microservice.kundeservice.domain.commands.CreateKundeCommand;

public class CommandDtoMapper {

    public static CreateKundenDto toCreateKundenDto(CreateKundeCommand createKundeCommand){
        return new CreateKundenDto(createKundeCommand.getKundennummer(), createKundeCommand.getVorname(), createKundeCommand.getNachname(), createKundeCommand.getPlz(), createKundeCommand.getOrt());
    }

    public static CreateKundeCommand toCreateKundenCommand(CreateKundenDto createKundenDto){
        return new CreateKundeCommand(createKundenDto.getKundennummer(), createKundenDto.getVorname(), createKundenDto.getNachname(), createKundenDto.getPlz(), createKundenDto.getOrt());
    }


}
