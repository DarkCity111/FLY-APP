package com.microservice.buchungservice.infrastructure.repositories;

import com.microservice.buchungservice.domain.flug.Flug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlugRepository extends JpaRepository<Flug, Long> {

    Optional<Flug> findByFlugnummer(String flugnummer);
}
