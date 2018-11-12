/*
 * UnternehmenDatenConverterImpl.java
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
import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.Postfach;
import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.UnternehmenDaten;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.HHGW;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * The Class UnternehmenDatenConverterImpl.
 *
 * @author mertinat
 * @since 06.06.2017
 */
@Service
@RequiredArgsConstructor
public class UnternehmenDatenConverter {
    private final BenutzerAdresseConverter benutzerAdresseConverter;
    private final FirmenAdresseConverter firmenAdresseConverter;
    private final RechnungAdresseConverter rechnungAdresseConverter;
    private final PostfachConverter postfachConverter;
    private final RechnungsPostfachConverter rechnungsPostfachConverter;

    /* (non-Javadoc)
     * @see de.verwalt_berlin.senbjw.isbj.servicekonto.service.converter.model.UnternehmenDatenConverter#convert(de.verwalt_berlin.senbjw.isbj.servicekonto.client.nutzerdaten.contentmodel.HHGW)
     */
    public UnternehmenDaten convert(final HHGW hhgw) {
        final String benutzerAbteilung = hhgw.getUserOrganisation();
        final String firmenAbteilung = hhgw.getCompanyOrganisation();
        final String name = hhgw.getCompanyName();
        final Adresse firmenadresse = firmenAdresseConverter.convert(hhgw);
        final Adresse nutzeradresse = benutzerAdresseConverter.convert(hhgw);
        final Adresse rechnungsadresse = rechnungAdresseConverter.convert(hhgw);

        final String id = hhgw.getCompanyId();
        final String fax = hhgw.getFax();
        final String unterabteilung = hhgw.getCompanySubOrganisation();
        final Postfach postfach = postfachConverter.convert(hhgw);
        final Postfach rechnungsPostfach = rechnungsPostfachConverter.convert(hhgw);

        return new UnternehmenDaten().setBenutzerAbteilung(benutzerAbteilung)
                .setFirmenAbteilung(firmenAbteilung)
                .setFirmenadresse(firmenadresse).setName(name)
                .setNutzeradresse(nutzeradresse)
                .setRechnungsadresse(rechnungsadresse).setId(id).setFax(fax)
                .setUnterabteilung(unterabteilung).setPostfach(postfach)
                .setRechnungsPostfach(rechnungsPostfach);
    }
}
