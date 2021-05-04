package com.microservice.mitarbeiterservice.domain.valueobjects;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
@Getter
@EqualsAndHashCode
public class Personalnummer {

    @NotNull
    @Size(min = 6, max = 6)
    @Column(unique = true)
    private String personalnummer = "000000";

    protected Personalnummer(){
    }

    public Personalnummer(String personalnummer){
        if(personalnummer.matches("[A-Z0-9]{6}")){
            this.personalnummer = personalnummer;
        }
    }

}
