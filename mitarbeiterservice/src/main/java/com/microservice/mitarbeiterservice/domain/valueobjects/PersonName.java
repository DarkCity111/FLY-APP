package com.microservice.mitarbeiterservice.domain.valueobjects;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
@Getter
@EqualsAndHashCode
public class PersonName {

    @NotNull
    @Size(min = 2)
    private String name = "DEFAULT";

    protected PersonName(){

    }

    public PersonName(String name){
        if(name != null && name != "" && name.length() > 1){
            this.name = name;
        }
    }

}
