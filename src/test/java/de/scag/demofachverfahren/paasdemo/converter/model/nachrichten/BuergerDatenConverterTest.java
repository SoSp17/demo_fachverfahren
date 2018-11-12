/*
 * BuergerDatenConverterImplTest.java
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
import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.BuergerDaten;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.HHGW;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import java.util.GregorianCalendar;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;


public class BuergerDatenConverterTest {
    private final Adresse anschrift = new Adresse();
    private final BuergerDaten.Sicherheitsstufe sicherheitsstufe = BuergerDaten.Sicherheitsstufe.REGISTRIERT;
    private final HHGW hhgw = new HHGW();
    private final Adresse buergerAdresse = new Adresse();
    private final GregorianCalendar geburtsdatum = new GregorianCalendar(1985, 0, 2);
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @InjectMocks
    private BuergerDatenConverter classUnderTest;
    @Mock
    private BuergerDatenSicherheitsstufeConverter buergerDatenSicherheitsstufeConverter;
    @Mock
    private BuergerAdresseConverter buergerAdresseConverter;

    @Test
    public void testConvert_GGWGegeben_SollteBuergerdatenanteileExtrahieren() throws Exception {
        // Vorbereitung
        when(buergerDatenSicherheitsstufeConverter.convert(hhgw)).thenReturn(sicherheitsstufe);
        when(buergerAdresseConverter.convert(hhgw)).thenReturn(buergerAdresse);
        hhgw.setDateOfBirth(geburtsdatum);

        // Ausführung
        final BuergerDaten buergerDaten = classUnderTest.convert(hhgw);

        // Prüfung
        final BuergerDaten expectedBuergerDaten = new BuergerDaten().setAnschrift(anschrift)
                .setSicherheitsstufe(
                        sicherheitsstufe).setGeburtsdatum(geburtsdatum);

        assertThat(buergerDaten, samePropertyValuesAs(expectedBuergerDaten));
    }
}
