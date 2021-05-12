package com.microservice.buchungservice.domain.flug;

import com.microservice.buchungservice.infrastructure.repositories.FlugRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FlugCommandService {

    private FlugRepository flugRepository;

    public String createFlug(CreateFlugCommand createFlugCommand){
        Flug flug = new Flug(createFlugCommand);
        flugRepository.save(flug);
        return flug.getFlugnummer();
    }

}
