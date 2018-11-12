/*
 * BuergerDatenSicherheitsstufeConverterImplTest.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.converter.model.nachrichten;

import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.BuergerDaten;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.HHGW;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@RunWith(Parameterized.class)
public class BuergerDatenSicherheitsstufeConverterTest {
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @Parameter(0)
    public String gueltig;
    @Parameter(1)
    public Integer sicherheitsstufeId;
    @Parameter(2)
    public BuergerDaten.Sicherheitsstufe expectedsicherheitsstufe;
    @InjectMocks
    private BuergerDatenSicherheitsstufeConverter classUnderTest;

    @Parameters(name = "{index}: id {1} ist {0} und gehört zur Sicherheitsstufe {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {"gueltigAb", 1, BuergerDaten.Sicherheitsstufe.REGISTRIERT},
                        {"gueltigAb", 2, BuergerDaten.Sicherheitsstufe.VERIFIZIERT_EINFACH},
                        {"gueltigAb", 3, BuergerDaten.Sicherheitsstufe.VERIFIZIERT_MIT_ABGLEICH},
                        {"ungueltig", 4711, null},
                        {"ungueltig", null, null}
                });
    }

    @Test
    public void testConvert_HHGWMitSicherheitsstufeIdGegeben_SolltePassendeSicherheitsstufeZurueckliefern()
            throws Exception {
        // Vorbereitung
        final HHGW hhgw = new HHGW();
        hhgw.setLevelId(sicherheitsstufeId);

        // Ausführung
        final BuergerDaten.Sicherheitsstufe sicherheitsstufe = classUnderTest.convert(hhgw);

        // Prüfung
        assertThat(sicherheitsstufe, is(expectedsicherheitsstufe));
    }
}
