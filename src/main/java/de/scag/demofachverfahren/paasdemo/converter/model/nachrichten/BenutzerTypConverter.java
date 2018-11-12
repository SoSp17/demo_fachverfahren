/*
 * BenutzerTypConverterImpl.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.converter.model.nachrichten;

import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.Benutzer;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.HHGW;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * The Class BenutzerTypConverterImpl.
 */
@Service
public class BenutzerTypConverter {
    private static final int ID_UNTERNEHMEN = 3;
    private static final int ID_BUERGER = 1;
    private static final Map<Integer, Benutzer.Typ> MAPPING = new HashMap<>();

    static {
        MAPPING.put(ID_BUERGER, Benutzer.Typ.BUERGER);
        MAPPING.put(ID_UNTERNEHMEN, Benutzer.Typ.UNTERNEHMEN);
    }

    /* (non-Javadoc)
     * @see de.verwalt_berlin.senbjw.isbj.servicekonto.service.converter.model.BenutzerTypConverter#convert(de.verwalt_berlin.senbjw.isbj.servicekonto.client.nutzerdaten.contentmodel.GGW)
     */
    public Benutzer.Typ convert(final HHGW hhgw) {
        if (hhgw == null) {
            return null;
        }

        return MAPPING.get(hhgw.getModeId());
    }
}
