package com.microservice.buchungservice.domain.buchung;


import com.microservice.buchungservice.infrastructure.repositories.BuchungRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuchungQueryService {

    private final BuchungRepository buchungRepository;

    public Buchung getBuchungByBuchungsnummer(String buchungsnummer){
        return buchungRepository.getBuchungByBuchungsnummer(buchungsnummer).orElseThrow(()->new IllegalArgumentException("Buchung nicht gefunden!"));
    }

    public boolean buchungsnummerIsPresent(String buchungsnummer){
        return buchungRepository.getBuchungByBuchungsnummer(buchungsnummer).isPresent();
    }

}
