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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Flugdatum {

    @NotNull
    @Size(min = 1)
    private String datum = "DATUM";

    public Flugdatum(String datum) {
        if (datum != null && datum != "" && datum.length() > 1) {
            this.datum = datum;
        } else {
            throw new IllegalArgumentException("Muss mehr als 1 Zeichen enthalten!");
        }
    }

}
