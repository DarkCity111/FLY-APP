package com.microservice.buchungservice.domain.flug;

import com.microservice.buchungservice.infrastructure.repositories.FlugRepository;
import org.springframework.stereotype.Service;

@Service
public class FlugQueryService {

    private final FlugRepository flugRepository;

    public FlugQueryService(FlugRepository flugRepository){
        this.flugRepository = flugRepository;
    }

    public boolean flugExists(String flugnummer){
        return flugRepository.findByFlugnummer(flugnummer).isPresent();
    }

    public Flug getFlugByFlugnummer(String flugnummer){
        return flugRepository.findByFlugnummer(flugnummer).orElseThrow(()-> new IllegalArgumentException("Flug nicht gefunden!"));
    }


}
