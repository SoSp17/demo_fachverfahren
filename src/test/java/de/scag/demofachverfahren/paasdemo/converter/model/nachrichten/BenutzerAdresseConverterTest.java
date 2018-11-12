/*
 * BenutzerAdresseConverterImplTest.java
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


public class BenutzerAdresseConverterTest {
    private final String postleitzahl = "postleitzahl";
    private final String hausnummer = "hausnummer";
    private final String strasse = "strasse";
    private final String land = "land";
    private final String stadt = "stadt";
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @InjectMocks
    private BenutzerAdresseConverter classUnderTest;

    @Test
    public void testConvert_HHGWMitFirmenAdressdatenGegeben_SollteAdresseMitGegebenenFirmenadressdatenLiefern()
            throws Exception {
        // Vorbereitung
        final HHGW hhgw = new HHGW();
        hhgw.setUserCity(stadt);
        hhgw.setUserCountry(land);
        hhgw.setUserStreet(strasse);
        hhgw.setUserStreetnumber(hausnummer);
        hhgw.setUserZipcode(postleitzahl);

        // Ausführung
        final Adresse adresse = classUnderTest.convert(hhgw);

        // Prüfung
        final Adresse expectedAdresse = new Adresse();
        expectedAdresse.setStadt(stadt);
        expectedAdresse.setLand(land);
        expectedAdresse.setStrasse(strasse);
        expectedAdresse.setHausnummer(hausnummer);
        expectedAdresse.setPostleitzahl(postleitzahl);

        assertThat(adresse, samePropertyValuesAs(expectedAdresse));
    }
}
