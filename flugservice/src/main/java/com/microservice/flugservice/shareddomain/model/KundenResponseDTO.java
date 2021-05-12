package com.microservice.flugservice.shareddomain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KundenResponseDTO {

    String kundennummer;
    String vorname;
    String nachname;
    String plz;
    String ort;

}
