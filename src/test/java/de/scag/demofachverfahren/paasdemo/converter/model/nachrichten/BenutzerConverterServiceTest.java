/*
 * BenutzerConverterServiceImplTest.java
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
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.Authentication;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.HHGW;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.Userdata;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;


public class BenutzerConverterServiceTest {
    private final String zertifikatsId = "zertifikatsId";
    private final String unternehmensTelefonnummer = "unternehmensTelefonnummer";
    private final String benutzerTelefonnummer = "benutzerTelefonnummer";
    private final String vorname = "vorname";
    private final String titel = "titel";
    private final String sprache = "sprache";
    private final String nachname = "nachname";
    private final String emailadresse = "emailadresse";
    private final String benutzername = "benutzername";
    private final String anrede = "anrede";
    private final Authentifizierung authentifizierung = new Authentifizierung();
    private final BuergerDaten buergerDaten = new BuergerDaten();
    private final Calendar geburtsdatum = new GregorianCalendar(1985, 0, 2);
    private final Long userId = 42L;
    private final Integer modeId = 1337;
    private final UnternehmenDaten unternehmenDaten = new UnternehmenDaten();
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @InjectMocks
    private BenutzerConverterService classUnderTest;
    @Mock
    private BuergerDatenConverter buergerDatenConverter;
    @Mock
    private AuthentifizierungConverter authentifizierungConverter;
    @Mock
    private BenutzerTypConverter benutzerTypConverter;
    @Mock
    private UnternehmenDatenConverter unternehmenDatenConverter;

    @Test
    public void testConvert_BuergerdatenGegeben_ZurueckgeliefertesModellSollteKonvertierteDatenEnthalten()
            throws Exception {
        // Vorbereitung
        final Userdata servicekontoBenutzerdaten = new Userdata();
        final HHGW hhgw = new HHGW();
        hhgw.setUserId(userId);
        hhgw.setModeId(modeId);
        hhgw.setLoginname(benutzername);
        hhgw.setTitle(titel);
        hhgw.setPrefix(anrede);
        hhgw.setFirstname(vorname);
        hhgw.setLastname(nachname);
        hhgw.setEmail(emailadresse);
        hhgw.setLanguage(sprache);
        hhgw.setDateOfBirth(geburtsdatum);
        hhgw.setCertificateId(zertifikatsId);
        hhgw.setUserPhoneNumber(benutzerTelefonnummer);
        hhgw.setPhonenumber(unternehmensTelefonnummer);

        final Authentication authentication = new Authentication();
        servicekontoBenutzerdaten.setAuthentication(authentication);
        servicekontoBenutzerdaten.setHhgw(hhgw);
        when(buergerDatenConverter.convert(hhgw)).thenReturn(buergerDaten);
        when(benutzerTypConverter.convert(hhgw)).thenReturn(Benutzer.Typ.BUERGER);
        when(authentifizierungConverter.convert(authentication)).thenReturn(authentifizierung);

        // Ausführung
        final Benutzer benutzer = classUnderTest.convert(servicekontoBenutzerdaten);

        // Prüfung
        final Benutzer expectedBenutzer = new Benutzer();
        expectedBenutzer.setAnrede(anrede);
        expectedBenutzer.setAuthentifizierung(authentifizierung);
        expectedBenutzer.setBenutzername(benutzername);
        expectedBenutzer.setBuerger(buergerDaten);
        expectedBenutzer.setEmailadresse(emailadresse);
        expectedBenutzer.setNachname(nachname);
        expectedBenutzer.setSprache(sprache);
        expectedBenutzer.setTitel(titel);
        expectedBenutzer.setTyp(Benutzer.Typ.BUERGER);
        expectedBenutzer.setUserId(userId);
        expectedBenutzer.setVorname(vorname);
        expectedBenutzer.setUnternehmen(null);
        expectedBenutzer.setTelefon(benutzerTelefonnummer);
        expectedBenutzer.setZertifikatsId(zertifikatsId);

        assertThat(benutzer, samePropertyValuesAs(expectedBenutzer));
        verifyZeroInteractions(unternehmenDatenConverter);
    }

    @Test
    public void testConvert_UnternehmendatenGegeben_ZurueckgeliefertesModellSollteKonvertierteDatenEnthalten()
            throws Exception {
        // Vorbereitung
        final Userdata servicekontoBenutzerdaten = new Userdata();
        final HHGW hhgw = new HHGW();
        hhgw.setUserId(userId);
        hhgw.setModeId(modeId);
        hhgw.setLoginname(benutzername);
        hhgw.setTitle(titel);
        hhgw.setPrefix(anrede);
        hhgw.setFirstname(vorname);
        hhgw.setLastname(nachname);
        hhgw.setEmail(emailadresse);
        hhgw.setLanguage(sprache);
        hhgw.setDateOfBirth(geburtsdatum);
        hhgw.setPhonenumber(unternehmensTelefonnummer);
        hhgw.setUserPhoneNumber(benutzerTelefonnummer);
        hhgw.setCertificateId(zertifikatsId);

        final Authentication authentication = new Authentication();
        servicekontoBenutzerdaten.setAuthentication(authentication);
        servicekontoBenutzerdaten.setHhgw(hhgw);
        when(benutzerTypConverter.convert(hhgw)).thenReturn(Benutzer.Typ.UNTERNEHMEN);
        when(authentifizierungConverter.convert(authentication)).thenReturn(authentifizierung);
        when(unternehmenDatenConverter.convert(hhgw)).thenReturn(unternehmenDaten);

        // Ausführung
        final Benutzer benutzer = classUnderTest.convert(servicekontoBenutzerdaten);

        // Prüfung
        final Benutzer expectedBenutzer = new Benutzer();
        expectedBenutzer.setAnrede(anrede);
        expectedBenutzer.setAuthentifizierung(authentifizierung);
        expectedBenutzer.setBenutzername(benutzername);
        expectedBenutzer.setBuerger(null);
        expectedBenutzer.setEmailadresse(emailadresse);
        expectedBenutzer.setNachname(nachname);
        expectedBenutzer.setSprache(sprache);
        expectedBenutzer.setTitel(titel);
        expectedBenutzer.setTyp(Benutzer.Typ.UNTERNEHMEN);
        expectedBenutzer.setUserId(userId);
        expectedBenutzer.setVorname(vorname);
        expectedBenutzer.setUnternehmen(unternehmenDaten);
        expectedBenutzer.setTelefon(unternehmensTelefonnummer);
        expectedBenutzer.setZertifikatsId(zertifikatsId);

        assertThat(benutzer, samePropertyValuesAs(expectedBenutzer));
        verifyZeroInteractions(buergerDatenConverter);
    }
}
