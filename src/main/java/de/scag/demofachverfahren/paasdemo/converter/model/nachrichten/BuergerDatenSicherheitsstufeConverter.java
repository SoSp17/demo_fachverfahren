/*
 * BuergerDatenSicherheitsstufeConverterImpl.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.converter.model.nachrichten;

import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.BuergerDaten;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.HHGW;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * The Class BuergerDatenSicherheitsstufeConverterImpl.
 *
 * @author mertinat
 * @since 06.06.2017
 */
@Service
public class BuergerDatenSicherheitsstufeConverter {
    private static final int ID_VERIFIZIERT_MIT_ABGLEICH = 3;
    private static final int ID_VERIFIZIERT_EINFACH = 2;
    private static final int ID_REGISTRIERT = 1;
    private static final Map<Integer, BuergerDaten.Sicherheitsstufe> MAPPING =
            new HashMap<>();

    static {
        MAPPING.put(ID_REGISTRIERT, BuergerDaten.Sicherheitsstufe.REGISTRIERT);
        MAPPING.put(ID_VERIFIZIERT_EINFACH, BuergerDaten.Sicherheitsstufe.VERIFIZIERT_EINFACH);
        MAPPING.put(ID_VERIFIZIERT_MIT_ABGLEICH, BuergerDaten.Sicherheitsstufe.VERIFIZIERT_MIT_ABGLEICH);
    }

    /**
     * Convert.
     *
     * @param hhgw the hhgw
     * @return the sicherheitsstufe
     */
    public BuergerDaten.Sicherheitsstufe convert(final HHGW hhgw) {
        return MAPPING.get(hhgw.getLevelId());
    }
}
