/*
 * BuergerDatenTest.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.model.benutzerdaten;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;


public class BuergerDatenTest {
    @Test
    public void testEquals_EqualsUeberschrieben_SollteEqualsKontractErfüllen() {
        EqualsVerifier.forClass(BuergerDaten.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();
    }
}
