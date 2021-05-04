package com.microservice.mitarbeiterservice.shareddomain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MitarbeiterResponseDTO {

    private String personalnummer;
    private String vorname;
    private String nachname;


}
