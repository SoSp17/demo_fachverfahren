/*
 * NachrichtTest.java
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

import java.util.Collections;
import java.util.List;

import static de.scag.demofachverfahren.paasdemo.model.nachrichten.NachrichtMatcher.isNachricht;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class NachrichtTest {
    @Test
    public void testEquals_EqualsUeberschrieben_SollteEqualsKontractErfüllen() {
        EqualsVerifier.forClass(Nachricht.class).suppress(Warning.STRICT_INHERITANCE).verify();
    }

    @Test
    public void testGetAnlagen_FrischeInstanz_SollteLeereListeZurueckgeben() throws Exception {
        // Vorbereitung

        // Ausführung
        final List<Anlage> anlagen = new Nachricht().getAnlagen();

        // Prüfung
        assertThat(anlagen, is(empty()));
    }

    @Test
    public void testGetExterneNachrichtenId_IdGegeben_SollteUmgewandelteIdZurueckliefern()
            throws Exception {
        // Vorbereitung
        final Long id = 42L;
        final Nachricht classUnderTest = new Nachricht();
        classUnderTest.setId(id);

        // Ausführung
        final String externeNachrichtenId = classUnderTest.getExterneNachrichtenId();

        // Prüfung
        assertThat(externeNachrichtenId, is(equalTo(id.toString())));
    }

    @Test
    public void testGetExterneNachrichtenId_IdIstNull_SollteNullLiefern() throws Exception {
        // Vorbereitung
        final Long id = null;
        final Nachricht classUnderTest = new Nachricht();
        classUnderTest.setId(id);

        // Ausführung
        final String externeNachrichtenId = classUnderTest.getExterneNachrichtenId();

        // Prüfung
        assertThat(externeNachrichtenId, is(nullValue()));
    }

    @Test
    public void testSetAnlagen_AnlageGegeben_InAnlageSollteRueckreferenzGesetztSein()
            throws Exception {
        // Vorbereitung
        final Anlage anlage = new Anlage();

        final Nachricht classUnderTest = new Nachricht();

        // Ausführung
        classUnderTest.setAnlagen(Collections.singletonList(anlage));

        // Prüfung
        assertThat(anlage.getNachricht(), is(sameInstance(classUnderTest)));
    }

    @Test
    public void testSetAnlagen_NullAlsAnlageGegeben_AnlagenSolltenNullGesetztSein()
            throws Exception {
        // Vorbereitung
        final Nachricht classUnderTest = new Nachricht();

        // Ausführung
        classUnderTest.setAnlagen(null);

        // Prüfung
        assertThat(classUnderTest, isNachricht().withAnlagen(is(nullValue())));
    }
}
