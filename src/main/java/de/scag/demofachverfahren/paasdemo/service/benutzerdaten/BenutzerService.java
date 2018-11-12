package de.scag.demofachverfahren.paasdemo.service.benutzerdaten;

import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.Benutzer;

import java.util.Optional;

/**
 * Service im Kontext von von Benutzern.
 */
public interface BenutzerService {
    /**
     * Erstellt oder aktualisiert einen Nutzer anhand eines Tokens.
     *
     * @param token Token anhand dessen der Benutzer aktualisiert werden soll.
     * @return Benutzer, sofern vorhanden.
     */
    Optional<Benutzer> getByToken(String token);

    Optional<Benutzer> findByUsername(String benutzername);
}
