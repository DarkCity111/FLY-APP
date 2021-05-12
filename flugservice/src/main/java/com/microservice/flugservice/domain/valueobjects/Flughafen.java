package com.microservice.flugservice.domain.valueobjects;


import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Flughafen {


    @NotNull
    @Size(min = 2)
    private String name = "DEFAULT";

    public Flughafen(String name){
        if(name != null && name != "" && name.length() > 1){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Darf nicht leer sein und muss mehr als 1 Zeichen enthalten!");
        }
    }



}
