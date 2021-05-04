package com.microservice.kundeservice.domain.valueobjects;


import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
@Getter
@EqualsAndHashCode
public class PersonOrt {

    @NotNull
    @Size(min = 2)
    private String ort = "DEFAULT";

    protected PersonOrt(){

    }

    public PersonOrt(String ort){
        if(ort != null && ort != "" && ort.length() > 1){
            this.ort = ort;
        }else{
            throw new IllegalArgumentException("Ort darf nicht leer sein und muss mehr als 1 Zeichen enthalten!");
        }
    }


}
