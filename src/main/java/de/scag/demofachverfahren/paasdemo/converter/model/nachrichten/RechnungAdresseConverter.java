/*
 * RechnungAdresseConverterImpl.java
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
 * The Class RechnungAdresseConverterImpl.
 */
@Service
public class RechnungAdresseConverter {
    /* (non-Javadoc)
     * @see de.verwalt_berlin.senbjw.isbj.servicekonto.service.converter.model.RechnungAdresseConverter#convert(de.verwalt_berlin.senbjw.isbj.servicekonto.client.nutzerdaten.contentmodel.HHGW)
     */
    public Adresse convert(final HHGW hhgw) {
        final String hausnummer = hhgw.getBillStreetnumber();
        final String land = hhgw.getBillCountry();
        final String postleitzahl = hhgw.getBillZipcode();
        final String stadt = hhgw.getBillCity();
        final String strasse = hhgw.getBillStreet();

        return new Adresse().setHausnummer(hausnummer).setLand(land).setPostleitzahl(postleitzahl)
                .setStadt(stadt).setStrasse(strasse);
    }
}
