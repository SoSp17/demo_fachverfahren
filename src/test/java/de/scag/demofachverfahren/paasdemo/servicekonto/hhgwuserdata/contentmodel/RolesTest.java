/*
 * RolesTest.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;


public class RolesTest {
    @Test
    public void testEquals_EqualsUeberschrieben_SollteEqualsKontractErfüllen() {
        EqualsVerifier.forClass(Roles.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();
    }
}
