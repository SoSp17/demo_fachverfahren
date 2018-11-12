/*
 * AuthentifizierungConverterImpl.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.converter.model.nachrichten;

import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.Authentifizierung;
import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.Authentifizierung.Art;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.Authentication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;


/**
 * The Class AuthentifizierungConverterImpl.
 */
@Service
@RequiredArgsConstructor
public class AuthentifizierungConverter {
    private final AuthentifizierungArtConverter authentifizierungArtConverter;

    /* (non-Javadoc)
     * @see de.verwalt_berlin.senbjw.isbj.servicekonto.service.converter.model.AuthentifizierungConverter#convert(de.verwalt_berlin.senbjw.isbj.servicekonto.client.nutzerdaten.contentmodel.Authentication)
     */
    public Authentifizierung convert(final Authentication authentication) {
        if (authentication == null) {
            return null;
        }

        final Calendar gueltigBis = authentication.getInvalidAt();
        final Art art = authentifizierungArtConverter.convert(
                authentication.getAuthenticationModeID());

        return new Authentifizierung().setGueltigBis(gueltigBis).setArt(art);
    }
}
