/*
 * FirmenAdresseConverterImpl.java
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
 * The Class FirmenAdresseConverterImpl.
 *
 * @author mertinat
 * @since 06.06.2017
 */
@Service
public class FirmenAdresseConverter {
    /* (non-Javadoc)
     * @see de.verwalt_berlin.senbjw.isbj.servicekonto.service.converter.model.FirmenAdresseConverter#convert(de.verwalt_berlin.senbjw.isbj.servicekonto.client.nutzerdaten.contentmodel.HHGW)
     */
    public Adresse convert(final HHGW hhgw) {
        final String hausnummer = hhgw.getCompanyStreetnumber();
        final String land = hhgw.getCompanyCountry();
        final String postleitzahl = hhgw.getCompanyZipcode();
        final String stadt = hhgw.getCompanyCity();
        final String strasse = hhgw.getCompanyStreet();

        return new Adresse().setHausnummer(hausnummer).setLand(land).setPostleitzahl(postleitzahl)
                .setStadt(stadt).setStrasse(strasse);
    }
}
