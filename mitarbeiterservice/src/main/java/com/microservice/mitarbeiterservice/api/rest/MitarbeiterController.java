package com.microservice.mitarbeiterservice.api.rest;



import com.microservice.mitarbeiterservice.api.rest.dtos.CreateMitarbeiterDto;
import com.microservice.mitarbeiterservice.api.rest.mappers.CommandDtoMapper;
import com.microservice.mitarbeiterservice.api.rest.mappers.EntityDtoMapper;
import com.microservice.mitarbeiterservice.services.CommandService;
import com.microservice.mitarbeiterservice.services.QueryService;
import com.microservice.mitarbeiterservice.shareddomain.model.MitarbeiterResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/mitarbeiter")
public class MitarbeiterController {

    private final CommandService commandService;
    private final QueryService queryService;

    public MitarbeiterController(CommandService commandService, QueryService queryService){
        this.commandService = commandService;
        this.queryService = queryService;
    }


    //Anlegen eines Mitarbeiters
    @PostMapping
    public ResponseEntity<?> createMitarbeiter(@RequestBody CreateMitarbeiterDto createMitarbeiterDto){
        String personalnummer = commandService.createMitarbeiter(CommandDtoMapper.toCreateMitarbeiterCommand(createMitarbeiterDto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{personalnummer}")
                .buildAndExpand(personalnummer)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    //Mitarbeiter per personalnummer zurückgeben
    @GetMapping("/{personalnummer}")
    public ResponseEntity<MitarbeiterResponseDTO> getMitarbeiterByPersonalnummer(@PathVariable String personalnummer){
        return new ResponseEntity<>(EntityDtoMapper.toMitarbeiterResponseDTO(queryService.getMitarbeiterByPersonalnummer(personalnummer)), HttpStatus.OK);
    }

}
