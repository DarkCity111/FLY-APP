package com.microservice.mitarbeiterservice.infrastructure.repositories;

import com.microservice.mitarbeiterservice.domain.aggregates.Mitarbeiter;
import com.microservice.mitarbeiterservice.domain.valueobjects.PersonName;
import com.microservice.mitarbeiterservice.domain.valueobjects.Personalnummer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MitarbeiterRepository extends JpaRepository<Mitarbeiter, Long> {

    Optional<Mitarbeiter> findByPersonalnummer(Personalnummer personalnummer);

    List<Mitarbeiter> findByVorname(PersonName vorname);

    List<Mitarbeiter> findByNachname(PersonName nachname);

}
