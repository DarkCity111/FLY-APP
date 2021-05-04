package com.microservice.kundeservice.services;

import com.microservice.kundeservice.infrastructure.repositories.KundenRepository;

public class CommandService {

    private final KundenRepository kundenRepository;
    private final QueryService queryService;

    public CommandService(KundenRepository kundenRepository, QueryService queryService){
        this.kundenRepository = kundenRepository;
        this.queryService = queryService;
    }





}
