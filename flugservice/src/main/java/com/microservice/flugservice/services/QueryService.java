package com.microservice.flugservice.services;


import com.microservice.flugservice.domain.aggregates.Flug;
import com.microservice.flugservice.domain.valueobjects.Flugnummer;
import com.microservice.flugservice.infrastructure.repositories.FlugRepository;
import org.springframework.stereotype.Service;

@Service
public class QueryService {

    private final FlugRepository flugRepository;

    public QueryService(FlugRepository flugRepository){
        this.flugRepository = flugRepository;
    }

    public Flug getFlugByFlugnummer(String flugnummer){
        return flugRepository.findByFlugnummer(new Flugnummer(flugnummer)).orElseThrow(()->new IllegalArgumentException("Flugnummer nicht gefunden!"));
    }

    public boolean flugnummerIsPresent(String flugnummer){
        return flugRepository.findByFlugnummer(new Flugnummer(flugnummer)).isPresent();
    }



}
