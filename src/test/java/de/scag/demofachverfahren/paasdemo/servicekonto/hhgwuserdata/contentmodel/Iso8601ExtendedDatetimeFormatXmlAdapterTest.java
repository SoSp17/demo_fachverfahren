/*
 * Iso8601ExtendedDatetimeFormatXmlAdapterTest.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class Iso8601ExtendedDatetimeFormatXmlAdapterTest {
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @InjectMocks
    private Iso8601ExtendedDatetimeFormatXmlAdapter classUnderTest;

    @Test
    public void testUnmarshal_GueltigenStringGegeben_SollteInCalendarUmgewandeltWerden()
            throws Exception {
        // Vorbereitung

        // Ausführung
        final Calendar cal = classUnderTest.unmarshal("2017-05-23T16:05:25");

        // Prüfung
        assertThat(cal, is(equalTo(new GregorianCalendar(2017, 4, 23, 16, 5, 25))));
    }

    @Test
    public void testUnmarshal_LeerenStringGegeben_SollteNullZurueckgeben() throws Exception {
        // Vorbereitung

        // Ausführung
        final Calendar cal = classUnderTest.unmarshal("   ");

        // Prüfung
        assertThat(cal, is(nullValue()));
    }

    @Test(expected = Exception.class)
    public void testUnmarshal_UngueltigenStringGegeben_SollteExceptionWerfen() throws Exception {
        // Vorbereitung

        // Ausführung
        final Calendar cal = classUnderTest.unmarshal(" bla bla bla ");

        // Prüfung
        // siehe Annotation
    }

    @Test
    public void testMarshal_CalendarGegebenUndAnschliessendUnmarshalt_ErgebnisSollteEingabeEntsprechen()
            throws Exception {
        // Vorbereitung
        final Calendar eingabe = new GregorianCalendar(1985, 0, 2, 17, 30, 25);

        // Ausführung
        final String string = classUnderTest.marshal(eingabe);

        // Prüfung
        assertThat(classUnderTest.unmarshal(string), is(equalTo(eingabe)));
    }
}
