/*
 * AuthentifizierungConverterImplTest.java
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
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.Authentication;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;


public class AuthentifizierungConverterTest {
    private final Calendar gueltigBis = new GregorianCalendar(1985, 0, 2);
    private final Authentifizierung.Art authentifizierungsart = Authentifizierung.Art.PASSWORT_INTERNAL;
    private final Integer authenticationModeID = 42;
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @InjectMocks
    private AuthentifizierungConverter classUnderTest;
    @Mock
    private AuthentifizierungArtConverter authentifizierungArtConverter;

    @Test
    public void testConvert_AuthentifizierungsdatenGegeben_SollteModelklasseMitDatenBefuellen()
            throws Exception {
        // Vorbereitung
        final Authentication authentication = new Authentication();
        authentication.setAuthenticationModeID(authenticationModeID);
        authentication.setInvalidAt(gueltigBis);

        when(authentifizierungArtConverter.convert(authenticationModeID)).thenReturn(
                authentifizierungsart);

        // Ausführung
        final Authentifizierung authentifizierung = classUnderTest.convert(authentication);

        // Prüfung
        final Authentifizierung expectedAuthentifizierung = new Authentifizierung().setArt(
                authentifizierungsart).setGueltigBis(gueltigBis);
        assertThat(authentifizierung, samePropertyValuesAs(expectedAuthentifizierung));
    }

    @Test
    public void testConvert_AuthentifizierungsdatenNichtGegeben_SollteNichtszurueckliefern()
            throws Exception {
        // Vorbereitung
        // Ausführung
        final Authentifizierung authentifizierung = classUnderTest.convert(null);

        // Prüfung
        assertThat(authentifizierung, is(nullValue()));
    }
}
