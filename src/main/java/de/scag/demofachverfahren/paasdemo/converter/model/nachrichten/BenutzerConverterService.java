/*
 * BenutzerConverterServiceImpl.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.converter.model.nachrichten;

import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.Authentifizierung;
import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.Benutzer;
import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.BuergerDaten;
import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.UnternehmenDaten;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.HHGW;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.Userdata;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * The Class BenutzerConverterServiceImpl.
 *
 * @author mertinat
 * @since 02.06.2017
 */
@Service
@RequiredArgsConstructor
public class BenutzerConverterService {
    private final AuthentifizierungConverter authentifizierungConverter;
    private final BuergerDatenConverter buergerDatenConverter;
    private final BenutzerTypConverter benutzerTypConverter;
    private final UnternehmenDatenConverter unternehmenDatenConverter;

    /* (non-Javadoc)
     * @see de.verwalt_berlin.senbjw.isbj.servicekonto.service.converter.model.BenutzerConverterService#convert(de.verwalt_berlin.senbjw.isbj.servicekonto.client.nutzerdaten.contentmodel.Userdata)
     */
    public Benutzer convert(final Userdata servicekontoBenutzerdaten) {
        final HHGW hhgw = servicekontoBenutzerdaten.getHhgw();
        final String anrede = hhgw.getPrefix();
        final Authentifizierung authentifizierung = authentifizierungConverter.convert(
                servicekontoBenutzerdaten.getAuthentication());
        final String benutzername = hhgw.getLoginname();
        final String emailadresse = hhgw.getEmail();
        final String nachname = hhgw.getLastname();
        final String sprache = hhgw.getLanguage();
        final String titel = hhgw.getTitle();
        final Long userId = hhgw.getUserId();
        final String vorname = hhgw.getFirstname();
        final String telefonnummer = hhgw.getPhonenumber();
        final Benutzer.Typ typ = benutzerTypConverter.convert(hhgw);

        final UnternehmenDaten unternehmen = extractUnternehmen(hhgw);
        final BuergerDaten buergerDaten = extractBuergerdaten(hhgw);

        return new Benutzer().setAnrede(anrede).setAuthentifizierung(authentifizierung)
                .setBenutzername(benutzername).setBuerger(buergerDaten)
                .setEmailadresse(emailadresse).setNachname(nachname)
                .setSprache(sprache).setTitel(titel).setTyp(typ).setUserId(userId)
                .setVorname(vorname).setTelefon(telefonnummer)
                .setUnternehmen(unternehmen).setZertifikatsId(hhgw.getCertificateId())
                .setTelefon(getTelefonnummer(hhgw));
    }

    private String getTelefonnummer(final HHGW hhgw) {
        if (benutzerTypConverter.convert(hhgw) == Benutzer.Typ.UNTERNEHMEN) {
            return hhgw.getPhonenumber();
        }

        return hhgw.getUserPhoneNumber();
    }

    private BuergerDaten extractBuergerdaten(final HHGW hhgw) {
        return (benutzerTypConverter.convert(hhgw) == Benutzer.Typ.BUERGER)
                ? buergerDatenConverter.convert(hhgw) : null;
    }

    private UnternehmenDaten extractUnternehmen(final HHGW hhgw) {
        return (benutzerTypConverter.convert(hhgw) == Benutzer.Typ.UNTERNEHMEN)
                ? unternehmenDatenConverter.convert(hhgw) : null;
    }
}
