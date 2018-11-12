/*
 * BuergerAdresseConverterImplTest.java
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
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.HHGW;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;


public class BuergerAdresseConverterTest {
    private final String land = "country";
    private final String postleitzahl = "zipcode";
    private final String stadt = "city";
    private final String hausnummerZusatz = "streetExtension";
    private final String hausnummer = "streetNumber";
    private final String strasse = "street";
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @InjectMocks
    private BuergerAdresseConverter classUnderTest;

    @Test
    public void testConvert_HHGWMitAddressdatenGegeben_SollteAdresseMitAddressdatenZurueckliefern()
            throws Exception {
        // Vorbereitung
        final HHGW hhgw = new HHGW();
        hhgw.setStreet(strasse);
        hhgw.setStreetNumber(hausnummer);
        hhgw.setStreetExtension(hausnummerZusatz);
        hhgw.setCity(stadt);
        hhgw.setZipcode(postleitzahl);
        hhgw.setCountry(land);

        // Ausführung
        final Adresse buergerAdresse = classUnderTest.convert(hhgw);

        // Prüfung
        final Adresse expectedBuergerAdresse = new Adresse().setStrasse(strasse)
                .setHausnummer(hausnummer).setLand(land)
                .setPostleitzahl(postleitzahl)
                .setStadt(stadt).setZusatz(
                        hausnummerZusatz);
        assertThat(buergerAdresse, samePropertyValuesAs(expectedBuergerAdresse));
    }
}
