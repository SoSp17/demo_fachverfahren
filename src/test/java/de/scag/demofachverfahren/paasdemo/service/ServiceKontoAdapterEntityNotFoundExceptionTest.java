/*
 * ServiceKontoAdapterEntityNotFoundExceptionTest.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.service;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class ServiceKontoAdapterEntityNotFoundExceptionTest {
    @Test
    public void testGetMessage_ExceptionWirdErstellt_BenutzerfreundlicheMessageSollteGesetztSein()
            throws Exception {
        // Vorbereitung
        final Class<String> type = String.class;
        final String key = "key";
        final ServiceKontoAdapterEntityNotFoundException classUnderTest =
                new ServiceKontoAdapterEntityNotFoundException(key, type);

        // Ausführung
        final String exceptionMessage = classUnderTest.getMessage();

        // Prüfung
        assertThat(exceptionMessage,
                is(equalTo(
                        "Entität mit id '" + key + "' vom typ '" + type +
                                "' konnte nicht gefunden werden.")));
    }
}
