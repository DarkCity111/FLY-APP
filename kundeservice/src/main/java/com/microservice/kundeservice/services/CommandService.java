package com.microservice.kundeservice.services;

import com.microservice.kundeservice.domain.aggregates.Kunde;
import com.microservice.kundeservice.domain.commands.CreateKundeCommand;
import com.microservice.kundeservice.infrastructure.repositories.KundenRepository;
import org.springframework.stereotype.Service;

@Service
public class CommandService {

    private final KundenRepository kundenRepository;
    private final QueryService queryService;

    public CommandService(KundenRepository kundenRepository, QueryService queryService){
        this.kundenRepository = kundenRepository;
        this.queryService = queryService;
    }

    public String createKunden(CreateKundeCommand createKundeCommand){
        System.out.println("Create Kunden Service CreateStudentCommand");

        Kunde kunde = new Kunde(createKundeCommand);

        //Abfrage ob Kundennummer schon vorhanden
        if(queryService.kundennummerInUse(kunde.getKundennummer().getKundennummer())){
            throw new IllegalArgumentException("Kundennummer bereits vorhanden FEHLER CommandService Zeile 25");
        }else{
            kundenRepository.save(kunde);
            return kunde.getKundennummer().getKundennummer();
        }
    }



}
