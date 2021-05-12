package com.microservice.buchungservice.infrastructure.rest;


import com.microservice.buchungservice.shareddomain.model.KundenResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class KundeserviceRestImpl implements KundeserviceRest {


    @Override
    public KundenResponseDTO getKunde(String kundennummer) {
        try{
            RestTemplate restTemplate = new RestTemplate();
            String resourceUrl = "http://localhost:8081/kunden/" + kundennummer;
            return restTemplate.getForObject(resourceUrl, KundenResponseDTO.class);
        }catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
            System.out.println("StudentServiceRestImpl Fehler");
            System.out.println(httpClientOrServerExc.getMessage());
            if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode())) {
                throw new IllegalArgumentException("Kunde wurde nicht gefunden!");
            } else {
                throw new IllegalArgumentException("Fehler in KundeserviceRestImpl!°");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
