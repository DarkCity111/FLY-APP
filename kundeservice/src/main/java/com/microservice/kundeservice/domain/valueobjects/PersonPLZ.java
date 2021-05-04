package com.microservice.kundeservice.domain.valueobjects;


import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
@Getter
@EqualsAndHashCode
public class PersonPLZ {

    @NotNull
    @Size(min = 4)
    private String postleitzahl = "XXXX";

    protected PersonPLZ(){

    }

    public PersonPLZ(String postleitzahl){
        if(postleitzahl != null && postleitzahl != "" && postleitzahl.length() > 3){
            this.postleitzahl = postleitzahl;
        }else{
            throw new IllegalArgumentException("Postleitzahl ist nicht erlaubt!");
        }
    }


}
