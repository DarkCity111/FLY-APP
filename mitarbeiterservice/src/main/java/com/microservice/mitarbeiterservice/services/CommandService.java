package com.microservice.mitarbeiterservice.services;

import com.microservice.mitarbeiterservice.domain.aggregates.Mitarbeiter;
import com.microservice.mitarbeiterservice.domain.commands.CreateMitarbeiterCommand;
import com.microservice.mitarbeiterservice.infrastructure.repositories.MitarbeiterRepository;
import org.springframework.stereotype.Service;

@Service
public class CommandService {

    private final MitarbeiterRepository mitarbeiterRepository;
    private final QueryService queryService;

    public CommandService (MitarbeiterRepository mitarbeiterRepository, QueryService queryService){
        this.mitarbeiterRepository = mitarbeiterRepository;
        this.queryService = queryService;
    }

    public String createMitarbeiter(CreateMitarbeiterCommand createMitarbeiterCommand){
        System.out.println("Create Mitarbeiter Service Create MitarbeiterServiceCommand");

        Mitarbeiter mitarbeiter = new Mitarbeiter(createMitarbeiterCommand); //Triggert die Registrierung des domain-Events


        if(queryService.personalnummerInUse(mitarbeiter.getPersonalnummer().getPersonalnummer())){
            throw new IllegalArgumentException("Personalnummer bereits in verwendung FEHLER Class CommandService -> 19");
        }else{
            mitarbeiterRepository.save(mitarbeiter);
            return mitarbeiter.getPersonalnummer().getPersonalnummer();
        }



    }


}
