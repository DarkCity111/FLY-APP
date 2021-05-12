package com.microservice.buchungservice.infrastructure.rest;

import com.microservice.buchungservice.shareddomain.model.FlugResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class FlugserviceRestImpl implements FlugserviceRest {
    @Override
    public FlugResponseDTO getFlug(String flugnummer) {
        try{
            RestTemplate restTemplate = new RestTemplate();
            String resourceUrl = "http://localhost:8083/flug/" + flugnummer;
            // System.out.println("Coursenumber URL " + resourceUrl);
            return restTemplate.getForObject(resourceUrl, FlugResponseDTO.class);
        }catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {

            System.out.println("CourseServiceRestImpl Fehler");
            System.out.println(httpClientOrServerExc.getMessage());
            System.out.println();
            if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode())) {
                throw new IllegalArgumentException("Flug nicht gefunden!");
            } else {
                throw new IllegalArgumentException("Fehler in FlugserbiceRestImpl!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
