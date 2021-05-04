package com.microservice.kundeservice.api.rest;

import com.microservice.kundeservice.api.rest.dtos.CreateKundenDto;
import com.microservice.kundeservice.api.rest.mappers.CommandDtoMapper;
import com.microservice.kundeservice.api.rest.mappers.EntityDtoMapper;
import com.microservice.kundeservice.services.CommandService;
import com.microservice.kundeservice.services.QueryService;
import com.microservice.kundeservice.shareddomain.model.KundenResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/kunden")
public class KundenController {

    private final QueryService queryService;
    private final CommandService commandService;

    public KundenController(QueryService queryService, CommandService commandService){
        this.queryService = queryService;
        this.commandService = commandService;
    }

    //gibt erstellt Kunde und gibt kundennummer zurück
    @PostMapping
    public ResponseEntity<?> createKunden(@RequestBody CreateKundenDto createKundenDto){
        String kundennummer = commandService.createKunden(CommandDtoMapper.toCreateKundenCommand(createKundenDto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{kundennummer}")
                .buildAndExpand(kundennummer)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    //gibt Kunde zurück
    @GetMapping("/{kundennummer}")
    public ResponseEntity<KundenResponseDTO> getKundenByKundennummer(@PathVariable String kundennummer){
        return new ResponseEntity<>(EntityDtoMapper.toKundenResponseDTO(queryService.getKundeByKundennummer(kundennummer)), HttpStatus.OK);
    }

}
