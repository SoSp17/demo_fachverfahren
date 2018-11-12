/*
 * PostfachConverterImpl.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.converter.model.nachrichten;

import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.Postfach;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.HHGW;
import org.springframework.stereotype.Service;


/**
 * The Class PostfachConverterImpl.
 *
 * @author mertinat
 * @since 13.06.2017
 */
@Service
public class PostfachConverter {
    /* (non-Javadoc)
     * @see de.verwalt_berlin.senbjw.isbj.servicekonto.service.converter.model.PostfachConverter#convert(de.verwalt_berlin.senbjw.isbj.servicekonto.client.nutzerdaten.contentmodel.HHGW)
     */
    public Postfach convert(final HHGW hhgw) {
        final String nummer = hhgw.getMailbox();
        final String postleitzahl = hhgw.getBoxZipCode();

        return new Postfach().setNummer(nummer).setPostleitzahl(postleitzahl);
    }
}
