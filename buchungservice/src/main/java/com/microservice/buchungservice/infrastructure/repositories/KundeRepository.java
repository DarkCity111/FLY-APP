package com.microservice.buchungservice.infrastructure.repositories;

import com.microservice.buchungservice.domain.kunde.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KundeRepository extends JpaRepository<Kunde, Long> {

    Optional<Kunde> findByKundennummer(String kundennummer);

}
