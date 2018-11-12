/*
 * UnternehmenDatenConverterImplTest.java
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
import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.Postfach;
import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.UnternehmenDaten;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.HHGW;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;


public class UnternehmenDatenConverterTest {
    private static final String id = "id";
    private static final String fax = "fax";
    private static final String unterabteilung = "unterabteilung";
    private static final Postfach postfach = new Postfach();
    private static final Postfach rechnungsPostfach = new Postfach();
    private final String name = "name";
    private final String firmenAbteilung = "firmenAbteilung";
    private final String benutzerAbteilung = "benutzerAbteilung";
    private final Adresse benutzerAdresse = new Adresse();
    private final Adresse firmenAdresse = new Adresse();
    private final Adresse rechnungAdresse = new Adresse();
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @InjectMocks
    private UnternehmenDatenConverter classUnderTest;
    @Mock
    private BenutzerAdresseConverter benutzerAdresseConverter;
    @Mock
    private FirmenAdresseConverter firmenAdresseConverter;
    @Mock
    private RechnungAdresseConverter rechnungAdresseConverter;
    @Mock
    private PostfachConverter postfachConverter;
    @Mock
    private RechnungsPostfachConverter rechnungsPostfachConverter;

    @Test
    public void testConvert_HHGWMitUnternehmensspezifischenDatenGegeben_SollteUnternehmensspezifischeDatenUebernommenHaben()
            throws Exception {
        // Vorbereitung
        final HHGW hhgw = new HHGW();
        hhgw.setCompanyName(name);
        hhgw.setCompanyOrganisation(firmenAbteilung);
        hhgw.setUserOrganisation(benutzerAbteilung);
        hhgw.setFax(fax);
        hhgw.setCompanyId(id);
        hhgw.setCompanySubOrganisation(unterabteilung);
        when(benutzerAdresseConverter.convert(hhgw)).thenReturn(benutzerAdresse);
        when(firmenAdresseConverter.convert(hhgw)).thenReturn(firmenAdresse);
        when(rechnungAdresseConverter.convert(hhgw)).thenReturn(rechnungAdresse);
        when(postfachConverter.convert(hhgw)).thenReturn(postfach);
        when(rechnungsPostfachConverter.convert(hhgw)).thenReturn(postfach);

        final UnternehmenDaten unternehmen = classUnderTest.convert(hhgw);
        // Ausführung

        // Prüfung
        final UnternehmenDaten expectedUnternehmen = new UnternehmenDaten();
        expectedUnternehmen.setBenutzerAbteilung(benutzerAbteilung);
        expectedUnternehmen.setFirmenAbteilung(firmenAbteilung).setName(name);
        expectedUnternehmen.setFirmenadresse(firmenAdresse).setNutzeradresse(benutzerAdresse);
        expectedUnternehmen.setRechnungsadresse(rechnungAdresse);
        expectedUnternehmen.setId(id);
        expectedUnternehmen.setFax(fax);
        expectedUnternehmen.setUnterabteilung(unterabteilung);
        expectedUnternehmen.setPostfach(postfach);
        expectedUnternehmen.setRechnungsPostfach(rechnungsPostfach);

        assertThat(unternehmen, samePropertyValuesAs(expectedUnternehmen));
    }
}
