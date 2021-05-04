package com.microservice.kundeservice.infrastructure.repositories;

import com.microservice.kundeservice.domain.aggregates.Kunde;
import com.microservice.kundeservice.domain.valueobjects.Kundennummer;
import com.microservice.kundeservice.domain.valueobjects.PersonName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KundenRepository extends JpaRepository<Kunde, Long> {

    Optional<Kunde> findByKundennummer(Kundennummer kundennummer);

    List<Kunde> findByNachname(PersonName nachname);

    //eventuell mehr implementieren wenn Controller implementiert wird




}
