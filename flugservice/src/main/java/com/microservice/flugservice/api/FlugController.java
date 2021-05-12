package com.microservice.flugservice.api;


import com.microservice.flugservice.api.rest.dtos.CreateFlugDto;
import com.microservice.flugservice.api.rest.mappers.CommandDtoMapper;
import com.microservice.flugservice.api.rest.mappers.EntityDtoMapper;
import com.microservice.flugservice.services.CommandService;
import com.microservice.flugservice.services.QueryService;
import com.microservice.flugservice.shareddomain.model.FlugResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/flug")
public class FlugController {

    private final CommandService commandService;
    private final QueryService queryService;

    public FlugController(CommandService commandService, QueryService queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }


    @PostMapping
    public ResponseEntity<?> createFlug(@RequestBody CreateFlugDto createFlugDto){
        String flugnummer = commandService.createFlug(CommandDtoMapper.toCreateFlugCommand(createFlugDto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{flugnummer}")
                .buildAndExpand(flugnummer)
                .toUri();
        return ResponseEntity.created(location).build();

    }

    @GetMapping("/{flugnummer}")
    public ResponseEntity<FlugResponseDTO> getFlugByFlugnummer(@PathVariable String flugnummer){
        return new ResponseEntity<>(EntityDtoMapper.toFlugResponseDTO(queryService.getFlugByFlugnummer(flugnummer)), HttpStatus.OK);
    }





}
