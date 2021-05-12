package com.microservice.flugservice.domain.valueobjects;


import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
@Getter
@EqualsAndHashCode
public class Flugnummer {

    @NotNull
    @Size(min = 7, max = 7)
    @Column(unique = true)
    private String flugnummer = "0000000";

    protected Flugnummer(){

    }

    public Flugnummer(String flugnummer){
        this.flugnummer = flugnummer;
    }


}
