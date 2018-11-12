/*
 * BuergerAdresseConverterImpl.java
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
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.HHGW;
import org.springframework.stereotype.Service;


/**
 * The Class BuergerAdresseConverterImpl.
 *
 * @author mertinat
 * @since 06.06.2017
 */
@Service
public class BuergerAdresseConverter {
    /* (non-Javadoc)
     * @see de.verwalt_berlin.senbjw.isbj.servicekonto.service.converter.model.BuergerAdresseConverter#convert(de.verwalt_berlin.senbjw.isbj.servicekonto.client.nutzerdaten.contentmodel.GGW)
     */
    public Adresse convert(final HHGW hhgw) {
        final String strasse = hhgw.getStreet();
        final String hausnummer = hhgw.getStreetNumber();
        final String land = hhgw.getCountry();
        final String hausnummerZusatz = hhgw.getStreetExtension();
        final String stadt = hhgw.getCity();
        final String postleitzahl = hhgw.getZipcode();

        return new Adresse().setStrasse(strasse).setHausnummer(hausnummer).setLand(land)
                .setPostleitzahl(postleitzahl).setStadt(stadt).setZusatz(
                        hausnummerZusatz);
    }
}
