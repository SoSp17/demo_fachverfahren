/*
 * FachverfahrenTest.java
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

import org.apache.commons.codec.binary.Base64;

import static org.hamcrest.CoreMatchers.not;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import static org.junit.matchers.JUnitMatchers.containsString;


public class FachverfahrenTest {
    @Test
    public void testEquals_EqualsUeberschrieben_SollteEqualsKontractErfüllen() {
        EqualsVerifier.forClass(Fachverfahren.class).suppress(Warning.STRICT_INHERITANCE).verify();
    }

    @Test
    public void testToString_DasPasswortFürDenZertifikatscontainerIstGesetzt_EsSollteNichtMitToStringAusgegebenWerden()
        throws Exception {
        // Vorbereitung
        final String passwort = "SomeTopS3ecretFancyUncredibleSafePasswordNobodyWouldEverGuess1234";
        final Fachverfahren classUnderTest =
            new Fachverfahren().setPrivateKeystorePasswort(passwort.toCharArray());

        // Ausführung
        final String toStringResult = classUnderTest.toString();

        // Prüfung
        assertThat(toStringResult,
            is(allOf(not(containsString(passwort)),
                    not(containsString("passwort")),
                    not(containsString("privateKeystorePasswort")))));
    }

    @Test
    public void testGetKeystore_KeystoreKorrektInBase64Gesetzt_SolltePassendesBytearrayZurueckliefern()
        throws Exception {
        // Vorbereitung
        final String encoded = "RHUgc2llaHN0IG1pY2ggbmljaHQh";
        final Fachverfahren classUnderTest = new Fachverfahren().setKeystoreInBase64(encoded);

        // Ausführung
        final byte[] decoded = classUnderTest.getKeystore();

        // Prüfung
        final byte[] decode = Base64.decodeBase64(encoded);
        assertThat("Decoded", decoded, is(equalTo(decode)));
    }
}
