/*
 * BuergerDatenConverterImpl.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.converter.model.nachrichten;

import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.Adresse;
import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.BuergerDaten;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.HHGW;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;


/**
 * The Class BuergerDatenConverterImpl.
 */
@Service
@RequiredArgsConstructor
public class BuergerDatenConverter {
    private final BuergerDatenSicherheitsstufeConverter buergerDatenSicherheitsstufeConverter;
    private final BuergerAdresseConverter buergerAdresseConverter;

    /* (non-Javadoc)
     * @see de.verwalt_berlin.senbjw.isbj.servicekonto.service.converter.model.BuergerDatenConverter#convert(de.verwalt_berlin.senbjw.isbj.servicekonto.client.nutzerdaten.contentmodel.HHGW)
     */
    public BuergerDaten convert(final HHGW hhgw) {
        final Adresse anschrift = buergerAdresseConverter.convert(hhgw);
        final BuergerDaten.Sicherheitsstufe sicherheitsstufe = buergerDatenSicherheitsstufeConverter.convert(
                hhgw);
        final Calendar geburtsdatum = hhgw.getDateOfBirth();

        return new BuergerDaten().setAnschrift(anschrift).setSicherheitsstufe(sicherheitsstufe)
                .setGeburtsdatum(geburtsdatum);
    }
}
