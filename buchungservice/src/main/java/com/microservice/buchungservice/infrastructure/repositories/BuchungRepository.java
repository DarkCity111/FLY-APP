package com.microservice.buchungservice.infrastructure.repositories;

import com.microservice.buchungservice.domain.buchung.Buchung;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuchungRepository extends JpaRepository<Buchung, Long> {

    Optional<Buchung> getBuchungByBuchungsnummer(String buchungsnummer);


}
