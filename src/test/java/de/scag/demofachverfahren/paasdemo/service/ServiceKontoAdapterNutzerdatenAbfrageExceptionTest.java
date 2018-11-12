/*
 * ServiceKontoAdapterNutzerdatenAbfrageExceptionTest.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.service;

import de.scag.demofachverfahren.paasdemo.servicekonto.ServiceKontoClient.NutzerdatenabfrageFehlerart;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static de.scag.demofachverfahren.paasdemo.servicekonto.ServiceKontoClient.NutzerdatenabfrageFehlerart.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;


@RunWith(Parameterized.class)
public class ServiceKontoAdapterNutzerdatenAbfrageExceptionTest {
    @Parameter(0)
    public Integer fehlercode;
    @Parameter(1)
    public NutzerdatenabfrageFehlerart fehlerart;
    @Parameter(2)
    public String fehlerbeschreibung;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Parameters(name = "{index}: Fehlercode {0} sollte Fehlerart {1} mit Beschreibung {2} lifern")
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {1, OK, "OK"},
                        {100, GENERAL_ERROR, "Allgemeiner Fehler"},
                        {102, WS_ERROR, "Webservice Fehler"},
                        {104, DB_ERROR, "Datenbank Fehler"},
                        {106, DATA_ERROR, "DataError"},
                        {110, UNKNOWN_USER, "Unbekannter User"},
                        {
                                120, TIMEOUT,
                                "Request Timeout - User außerhalb des vorgegebenen Zeitfensters"
                        },
                        {500, NOT_IMPLEMENTED, "Nicht implementiert"},
                        {1000, UNKNOWN_ERROR, "Unbekannter Fehler"},
                        {
                                4711, UNDOKUMENTIERT, "Undokumentierter Fehler"
                        }
                });
    }

    @Test
    public void testConstructor_FehlercodeGegeben_SolltePassendenTypSetzen() throws Exception {
        // Vorbereitung

        // Prüfung
        exception.expect(ServiceKontoAdapterNutzerdatenAbfrageException.class);
        exception.expect(hasProperty("fehlerart", equalTo(fehlerart)));

        // Ausführung
        throw new ServiceKontoAdapterNutzerdatenAbfrageException(fehlercode);
    }

    @Test
    public void testConstructor_FehlercodeGegeben_SolltePassendeFehlermeldungSetzen()
            throws Exception {
        // Vorbereitung

        // Prüfung
        exception.expect(ServiceKontoAdapterNutzerdatenAbfrageException.class);
        exception.expectMessage(
                is(equalTo(
                        "Fehler '" + fehlercode +
                                "' beim Abruf von Nutzerdaten vom Service-Konto-Berlin aufgetreten: " +
                                fehlerbeschreibung)));

        // Ausführung
        throw new ServiceKontoAdapterNutzerdatenAbfrageException(fehlercode);
    }
}
