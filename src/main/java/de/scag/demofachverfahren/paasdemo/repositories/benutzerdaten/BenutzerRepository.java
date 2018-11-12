package de.scag.demofachverfahren.paasdemo.repositories.benutzerdaten;

import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.Benutzer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BenutzerRepository extends JpaRepository<Benutzer, Long> {
    Optional<Benutzer> findByBenutzername(String benutzername);
}
