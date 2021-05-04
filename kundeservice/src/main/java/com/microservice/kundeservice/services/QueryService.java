package com.microservice.kundeservice.services;

import com.microservice.kundeservice.domain.aggregates.Kunde;
import com.microservice.kundeservice.domain.valueobjects.Kundennummer;
import com.microservice.kundeservice.infrastructure.repositories.KundenRepository;
import org.springframework.stereotype.Service;

@Service
public class QueryService {

    private final KundenRepository kundenRepository;

    public QueryService(KundenRepository kundenRepository){
        this.kundenRepository = kundenRepository;
    }

    public boolean kundennummerInUse(String kundennummer){
        return kundenRepository.findByKundennummer(new Kundennummer(kundennummer)).isPresent();
    }

    public Kunde getKundeByKundennummer(String kundennummer){
        return kundenRepository.findByKundennummer(new Kundennummer(kundennummer)).orElseThrow((()-> new IllegalArgumentException("Kein Kunde gefunden")));
    }

}
