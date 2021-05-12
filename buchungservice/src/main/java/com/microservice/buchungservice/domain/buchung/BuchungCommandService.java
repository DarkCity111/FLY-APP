package com.microservice.buchungservice.domain.buchung;


import com.microservice.buchungservice.domain.flug.CreateFlugCommand;
import com.microservice.buchungservice.domain.flug.Flug;
import com.microservice.buchungservice.domain.flug.FlugCommandService;
import com.microservice.buchungservice.domain.flug.FlugQueryService;
import com.microservice.buchungservice.domain.kunde.CreateKundeCommand;
import com.microservice.buchungservice.domain.kunde.Kunde;
import com.microservice.buchungservice.domain.kunde.KundeCommandService;
import com.microservice.buchungservice.domain.kunde.KundeQueryService;
import com.microservice.buchungservice.infrastructure.repositories.BuchungRepository;
import com.microservice.buchungservice.infrastructure.rest.FlugserviceRest;
import com.microservice.buchungservice.infrastructure.rest.KundeserviceRest;
import com.microservice.buchungservice.shareddomain.model.FlugResponseDTO;
import com.microservice.buchungservice.shareddomain.model.KundenResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuchungCommandService {

    BuchungRepository buchungRepository;
    BuchungQueryService buchungQueryService;

    FlugQueryService flugQueryService;
    FlugCommandService flugCommandService;
    FlugserviceRest flugserviceRest;

    KundeQueryService kundeQueryService;
    KundeCommandService kundeCommandService;
    KundeserviceRest kundeserviceRest;

    public void createBuchung(CreateBuchungCommand createBuchungCommand){

        //Exception wenn Buchungsnummer schon existiert
        if(buchungQueryService.buchungsnummerIsPresent(createBuchungCommand.getBuchungsnummer())){
            throw new IllegalArgumentException("Buchungsnummer existiert bereits!");
        }

        //erstellt den Kurs in Buchung wenn er nicht bereits enthalten ist
        if(!flugQueryService.flugExists(createBuchungCommand.getFlugnummer())){
            FlugResponseDTO flugResponseDTO = flugserviceRest.getFlug(createBuchungCommand.getFlugnummer());
            flugCommandService.createFlug(new CreateFlugCommand(flugResponseDTO.getFlugnummer()));
        }

        if(!kundeQueryService.kundeExists(createBuchungCommand.getKundennummer())){
            KundenResponseDTO kundenResponseDTO = kundeserviceRest.getKunde(createBuchungCommand.getKundennummer());
            kundeCommandService.createKunde(new CreateKundeCommand(kundenResponseDTO.getKundennummer()));
        }

        Flug flug = flugQueryService.getFlugByFlugnummer(createBuchungCommand.getFlugnummer());
        Kunde kunde = kundeQueryService.getKundeByKundennummer(createBuchungCommand.getKundennummer());

        //erstellen der Buchung
        if(flugBuchungByKunden()){
            Buchung buchung = new Buchung(createBuchungCommand);
            buchungRepository.save(buchung);
        }


    }

    //Kunde hat immer geld :D langsam wir es echt viel es ist gerade 04:17 in der Nacht :D
    private boolean flugBuchungByKunden(){
        return true;
    }

}
