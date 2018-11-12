/*
 * AuthentifizierungArtConverterImplTest.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.converter.model.nachrichten;

import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.Authentifizierung.Art;
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
public class AuthentifizierungArtConverterTest {
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @Parameter(0)
    public String gueltig;
    @Parameter(1)
    public Integer artId;
    @Parameter(2)
    public Art expectedArt;
    @InjectMocks
    private AuthentifizierungArtConverter classUnderTest;

    @Parameters(name = "{index}: id ist {0} artId: {1} expectedArt: {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {"gueltigAb", 1, Art.USER_PASSWORD},
                        {"gueltigAb", 2, Art.SMART_CARD},
                        {"gueltigAb", 3, Art.WINDOWS},
                        {"gueltigAb", 4, Art.PASSWORT_INTERNAL},
                        {"gueltigAb", 5, Art.PERSONALAUSWEIS},
                        {"ungueltig", 4711, null},
                        {"ungueltig", null, null}
                });
    }

    @Test
    public void testConvert_IDFuerAuthentifizierungsartGegeben_SolltePassendeAuthentifizierungsartLiefern()
            throws Exception {
        // Vorbereitung

        // Ausführung
        final Art art = classUnderTest.convert(artId);

        // Prüfung
        assertThat(art, is(expectedArt));
    }
}
