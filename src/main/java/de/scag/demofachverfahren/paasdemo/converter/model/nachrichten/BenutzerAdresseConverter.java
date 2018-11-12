/*
 * BenutzerAdresseConverterImpl.java
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
 * The Class BenutzerAdresseConverterImpl.
 *
 * @author mertinat
 * @since 06.06.2017
 */
@Service
public class BenutzerAdresseConverter {
    /* (non-Javadoc)
     * @see de.verwalt_berlin.senbjw.isbj.servicekonto.service.converter.model.BenutzerAdresseConverter#convert(de.verwalt_berlin.senbjw.isbj.servicekonto.client.nutzerdaten.contentmodel.HHGW)
     */
    public Adresse convert(final HHGW hhgw) {
        final String hausnummer = hhgw.getUserStreetnumber();
        final String land = hhgw.getUserCountry();
        final String postleitzahl = hhgw.getUserZipcode();
        final String stadt = hhgw.getUserCity();
        final String strasse = hhgw.getUserStreet();

        return new Adresse().setHausnummer(hausnummer).setLand(land).setPostleitzahl(postleitzahl)
                .setStadt(stadt).setStrasse(strasse);
    }
}
