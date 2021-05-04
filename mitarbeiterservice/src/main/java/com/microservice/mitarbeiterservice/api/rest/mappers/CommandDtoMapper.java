package com.microservice.mitarbeiterservice.api.rest.mappers;


import com.microservice.mitarbeiterservice.api.rest.dtos.CreateMitarbeiterDto;
import com.microservice.mitarbeiterservice.domain.commands.CreateMitarbeiterCommand;

public class CommandDtoMapper {

    public static CreateMitarbeiterDto toCreateMitarbeiterDto(CreateMitarbeiterCommand createMitarbeiterCommand){
        return new CreateMitarbeiterDto(createMitarbeiterCommand.getPersonalnummer(), createMitarbeiterCommand.getVorname(), createMitarbeiterCommand.getNachname());
    }

    public static CreateMitarbeiterCommand toCreateMitarbeiterCommand(CreateMitarbeiterDto createMitarbeiterDto){
        return new CreateMitarbeiterCommand(createMitarbeiterDto.getPersonalnummer(), createMitarbeiterDto.getVorname(), createMitarbeiterDto.getNachname());
    }

}
