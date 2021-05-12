package com.microservice.flugservice.infrastructure.repositories;

import com.microservice.flugservice.domain.aggregates.Flug;
import com.microservice.flugservice.domain.valueobjects.Flughafen;
import com.microservice.flugservice.domain.valueobjects.Flugnummer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlugRepository extends JpaRepository<Flug, Long> {

    Optional<Flug> findByFlugnummer(Flugnummer flugnummer);

    List<Flug> getAllByStartflughafen(Flughafen startflughafen);



}
