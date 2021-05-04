package com.microservice.mitarbeiterservice.services;


import com.microservice.mitarbeiterservice.domain.aggregates.Mitarbeiter;
import com.microservice.mitarbeiterservice.domain.valueobjects.Personalnummer;
import com.microservice.mitarbeiterservice.infrastructure.repositories.MitarbeiterRepository;
import org.springframework.stereotype.Service;

@Service
public class QueryService {

    private final MitarbeiterRepository mitarbeiterRepository;

    public QueryService(MitarbeiterRepository mitarbeiterRepository){
        this.mitarbeiterRepository = mitarbeiterRepository;
    }

    public boolean personalnummerInUse(String personalnummer){
        return mitarbeiterRepository.findByPersonalnummer(new Personalnummer(personalnummer)).isPresent();
    }

    public Mitarbeiter getMitarbeiterByPersonalnummer(String personalnummer){
        return mitarbeiterRepository.findByPersonalnummer(new Personalnummer(personalnummer)).orElseThrow(IllegalArgumentException::new);
    }

}
