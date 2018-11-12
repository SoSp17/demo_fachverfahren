/*
 * AuthentifizierungArtConverterImpl.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.converter.model.nachrichten;

import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.Authentifizierung.Art;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * The Class AuthentifizierungArtConverterImpl.
 *
 * @author mertinat
 * @since 06.06.2017
 */
@Service
public class AuthentifizierungArtConverter {
    private static final int ID_PERSONALAUSWEIS = 5;
    private static final int ID_PASSWORT_INTERNAL = 4;
    private static final int ID_WINDOWS = 3;
    private static final int ID_SMART_CARD = 2;
    private static final int ID_USER_PASSWORD = 1;
    private static final Map<Integer, Art> MAPPING = new HashMap<>();

    static {
        MAPPING.put(ID_USER_PASSWORD, Art.USER_PASSWORD);
        MAPPING.put(ID_SMART_CARD, Art.SMART_CARD);
        MAPPING.put(ID_WINDOWS, Art.WINDOWS);
        MAPPING.put(ID_PASSWORT_INTERNAL, Art.PASSWORT_INTERNAL);
        MAPPING.put(ID_PERSONALAUSWEIS, Art.PERSONALAUSWEIS);
    }

    /* (non-Javadoc)
     * @see de.verwalt_berlin.senbjw.isbj.servicekonto.service.converter.model.AuthentifizierungArtConverter#convert(java.lang.Integer)
     */
    public Art convert(final Integer authenticationModeID) {
        return MAPPING.get(authenticationModeID);
    }
}
