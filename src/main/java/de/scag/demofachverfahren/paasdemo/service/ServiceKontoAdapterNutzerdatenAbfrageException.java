/*
 * ServiceKontoAdapterNutzerdatenAbfrageException.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.service;

import de.scag.demofachverfahren.paasdemo.servicekonto.ServiceKontoClient;


/**
 * Wird geworfen bei Fehlern in der Nutzerdaten-Abfrage mit vom
 * Service-Konto-Berlin.
 *
 * @author mertinat
 * @since 24.05.2017
 */
public class ServiceKontoAdapterNutzerdatenAbfrageException extends ServiceKontoAdapterException {
    /**
     * Use serialVersionUID for interoperability.
     */
    private static final long serialVersionUID = 1L;

    private final ServiceKontoClient.NutzerdatenabfrageFehlerart fehlerart;

    /**
     * Instantiates a new service konto adapter nutzerdaten abfrage exception.
     *
     * @param fehlerart the fehlerart
     */
    public ServiceKontoAdapterNutzerdatenAbfrageException(final int fehlerart) {
        super(
                "Fehler '" + fehlerart +
                        "' beim Abruf von Nutzerdaten vom Service-Konto-Berlin aufgetreten: " +
                        ServiceKontoClient.NutzerdatenabfrageFehlerart.getByFehlercode(fehlerart)
                                .getBezeichnung());

        this.fehlerart = ServiceKontoClient.NutzerdatenabfrageFehlerart.getByFehlercode(fehlerart);
    }

    public ServiceKontoClient.NutzerdatenabfrageFehlerart getFehlerart() {
        return fehlerart;
    }
}
