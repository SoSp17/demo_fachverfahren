/*
 * BenutzerTypConverterImplTest.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.converter.model.nachrichten;

import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.Benutzer;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.HHGW;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;


public class BenutzerTypConverterTest {
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @InjectMocks
    private BenutzerTypConverter classUnderTest;

    @Test
    public void testConvert_HHGWNichtGegeben_SollteNichtsZurueckliefern() throws Exception {
        // Vorbereitung

        // Ausführung
        final Benutzer.Typ benutzerTyp = classUnderTest.convert(null);

        // Prüfung
        assertThat(benutzerTyp, is(nullValue()));
    }

    @Test
    public void testConvert_NichtRelevanteIdGegeben_SollteNullZurueckliefern() throws Exception {
        // Vorbereitung
        final HHGW ggw = getGgwWithMode(4711);

        // Ausführung
        final Benutzer.Typ benutzerTyp = classUnderTest.convert(ggw);

        // Prüfung
        assertThat(benutzerTyp, is(nullValue()));
    }

    @Test
    public void testConvert_BuergerIdGegeben_SollteNullZurueckliefern() throws Exception {
        // Vorbereitung
        final HHGW ggw = getGgwWithMode(1);

        // Ausführung
        final Benutzer.Typ benutzerTyp = classUnderTest.convert(ggw);

        // Prüfung
        assertThat(benutzerTyp, is(Benutzer.Typ.BUERGER));
    }

    @Test
    public void testConvert_UnternehmenIdGegeben_SollteNullZurueckliefern() throws Exception {
        // Vorbereitung
        final HHGW ggw = getGgwWithMode(3);

        // Ausführung
        final Benutzer.Typ benutzerTyp = classUnderTest.convert(ggw);

        // Prüfung
        assertThat(benutzerTyp, is(Benutzer.Typ.UNTERNEHMEN));
    }

    private HHGW getGgwWithMode(final int modeId) {
        final HHGW ggw = new HHGW();
        ggw.setModeId(modeId);

        return ggw;
    }
}
