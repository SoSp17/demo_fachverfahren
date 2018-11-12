/*
 * ServiceKontoConfigServiceExceptionTest.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class ServiceKontoConfigServiceExceptionTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testServiceKontoConfigServiceException_MessageKeyUndCauseGegeben_SolltePassendenTextAlsMessageUndCauseHaben()
            throws Exception {
        // Vorbereitung
        final RuntimeException cause = new RuntimeException();

        final ServiceKontoConfigServiceException classUnderTest =
                new ServiceKontoConfigServiceException("Fehlermeldung", "lustiger.key", cause);

        // Prüfung
        exception.expect(ServiceKontoConfigServiceException.class);
        exception.expectCause(is(cause));
        exception.expectMessage(is(equalTo("Fehler zu key 'lustiger.key': Fehlermeldung")));

        // Ausführung
        throw classUnderTest;
    }
}
