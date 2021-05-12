package com.microservice.buchungservice.domain.kunde;


import com.microservice.buchungservice.infrastructure.repositories.KundeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KundeQueryService {

    private final KundeRepository kundeRepository;

    public boolean kundeExists(String kundennummer){
        return kundeRepository.findByKundennummer(kundennummer).isPresent();
    }

    public Kunde getKundeByKundennummer(String kundennummer){
        return kundeRepository.findByKundennummer(kundennummer).orElseThrow(()-> new IllegalArgumentException("Kunde nicht gefunden!! "));
    }



}
