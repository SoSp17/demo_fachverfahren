/*
 * RechnungsPostfachConverterImplTest.java
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
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;


public class RechnungsPostfachConverterTest {
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @InjectMocks
    private PostfachConverter classUnderTest;

    @Test
    public void testConvert_PostfachdatenGegeben_SolltePostfachdatenExtrahierenUndSetzen()
            throws Exception {
        // Vorbereitung
        final String nummer = "nummer";
        final String postleitzahl = "postleitzahl";
        final HHGW hhgw = new HHGW().setBoxZipCode(postleitzahl).setMailbox(nummer);

        // Ausführung
        final Postfach postfach = classUnderTest.convert(hhgw);

        // Prüfung
        final Postfach expectedPostfach = new Postfach().setNummer(nummer).setPostleitzahl(
                postleitzahl);
        assertThat(postfach, samePropertyValuesAs(expectedPostfach));
    }
}
