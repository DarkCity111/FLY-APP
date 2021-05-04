package com.microservice.kundeservice.domain.valueobjects;


import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
@Getter
@EqualsAndHashCode
public class Kundennummer {

    @NotNull
    @Size(min = 10,max = 10)
    @Column(unique = true)
    private String kundennummer = "0000000000";

    protected Kundennummer(){

    }

    public Kundennummer(String kundennummer){
        if(kundennummer.matches("[A-Z0-9]{10}")){
            this.kundennummer = kundennummer;
        }else{
            throw new IllegalArgumentException("Kundennummer muss 10 Zeichen beinhalten Zahlen und Großbuchstaben");
        }
    }


}
