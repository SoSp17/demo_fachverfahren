/*
 * InhaltTest.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.servicekonto.govgwasyncresponse.contentmodel;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class NachrichtInhaltTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testEquals_EqualsUeberschrieben_SollteEqualsKontractErfüllen() {
        EqualsVerifier.forClass(NachrichtInhalt.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();
    }
}
