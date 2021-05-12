package com.microservice.buchungservice.api.rest;


import com.microservice.buchungservice.api.rest.mapper.BuchungCommandDtoMapper;
import com.microservice.buchungservice.domain.buchung.BuchungCommandService;
import com.microservice.buchungservice.domain.buchung.BuchungQueryService;
import com.microservice.buchungservice.domain.flug.FlugCommandService;
import com.microservice.buchungservice.domain.kunde.KundeCommandService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
public class BuchungController {

    private BuchungQueryService buchungQueryService;
    private BuchungCommandService buchungCommandService;
    private KundeCommandService kundeCommandService;
    private FlugCommandService flugCommandService;

    @PostMapping("/buchung")
    public ResponseEntity<?> makeBuchung(@RequestBody CreateBuchungDTO createBuchungDTO){
        buchungCommandService.createBuchung(BuchungCommandDtoMapper.toCreateBuchungCommang(createBuchungDTO));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{buchungsnummer}")
                .buildAndExpand(createBuchungDTO.getBuchungsnummer())
                .toUri();
        return ResponseEntity.created(location).build();
    }

//    @GetMapping("/buchung/{buchungsnummer}")
//    public ResponseEntity<CreateBuchungDTO> getBuchung(@PathVariable String buchungsnummer){
//        return new ResponseEntity<> // ENTITY MAPPER
//    }

}
