package com.microservice.flugservice.api.rest.mappers;

import com.microservice.flugservice.api.rest.dtos.CreateFlugDto;
import com.microservice.flugservice.domain.commands.CreateFlugCommand;

public class CommandDtoMapper {

    public static CreateFlugDto toCreateFlugDto(CreateFlugCommand createFlugCommand) {
        return new CreateFlugDto(createFlugCommand.getFlugnummer(), createFlugCommand.getFlugdatum(), createFlugCommand.getStartflughafen(), createFlugCommand.getZielflughafen());
    }

    public static CreateFlugCommand toCreateFlugCommand(CreateFlugDto createFlugDto) {
        return new CreateFlugCommand(createFlugDto.getFlugnummer(), createFlugDto.getFlugdatum(), createFlugDto.getStartflughafen(), createFlugDto.getZielflughafen());
    }

}
