/*
 * AnlageTest.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.model.nachrichten;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class AnlageTest {
    @Test
    public void testSetInhalt_NullGegeben_FeldSollteNullSein() throws Exception {
        // Vorbereitung
        final Anlage classUnderTest = new Anlage();
        classUnderTest.setInhalt(new byte[0]);

        // Ausführung
        classUnderTest.setInhalt(null);

        // Prüfung
        assertThat(classUnderTest.getInhalt(), is(nullValue(byte[].class)));
    }

    @Test
    public void testSetInhalt_InhaltGegeben_FeldSollteInhaltEntsprechen() throws Exception {
        // Vorbereitung
        final Anlage classUnderTest = new Anlage();

        // Ausführung
        classUnderTest.setInhalt(new byte[0]);

        // Prüfung
        assertThat(classUnderTest.getInhalt(), is(equalTo(new byte[0])));
    }

    @Test
    public void testEquals_EqualsUeberschrieben_SollteEqualsKontractErfüllen() {
        EqualsVerifier.forClass(Anlage.class).suppress(Warning.STRICT_INHERITANCE).verify();
    }
}
