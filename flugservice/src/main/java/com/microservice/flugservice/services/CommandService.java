package com.microservice.flugservice.services;

import com.microservice.flugservice.domain.aggregates.Flug;
import com.microservice.flugservice.domain.commands.CreateFlugCommand;
import com.microservice.flugservice.infrastructure.repositories.FlugRepository;
import org.springframework.stereotype.Service;

@Service
public class CommandService {

    private final FlugRepository flugRepository;
    private final QueryService queryService;


    public CommandService(FlugRepository flugRepository, QueryService queryService) {
        this.flugRepository = flugRepository;
        this.queryService = queryService;
    }

    public String createFlug(CreateFlugCommand createFlugCommand){

        Flug flug = new Flug(createFlugCommand);

        if(queryService.flugnummerIsPresent(flug.getFlugnummer().getFlugnummer())){
            throw new IllegalArgumentException("Flugnummer gibt es schon!");
        }else{
            flugRepository.save(flug);
            return flug.getFlugnummer().getFlugnummer();
        }


    }
}
