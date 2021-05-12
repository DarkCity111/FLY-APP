package com.microservice.buchungservice.domain.kunde;

import com.microservice.buchungservice.infrastructure.repositories.KundeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class KundeCommandService {

    private KundeRepository kundeRepository;

    public KundeCommandService(KundeRepository kundeRepository){
        this.kundeRepository = kundeRepository;
    }

    public String createKunde(CreateKundeCommand createKundeCommand){
        Kunde kunde = new Kunde(createKundeCommand);
        kundeRepository.findByKundennummer(createKundeCommand.getKundennummer()).orElse(kundeRepository.save(kunde));
        return kunde.getKundennummer();
    }

}
