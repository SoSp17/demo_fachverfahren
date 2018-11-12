/*
 * ServiceKontoAdapterSerialisierungsException.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.service.xml;

import de.scag.demofachverfahren.paasdemo.service.ServiceKontoAdapterException;

/**
 * Wird geworfen, wenn es Probleme bei der Serialisierung oder Deserialisierung
 * von Objekten gab.
 *
 * @author mertinat
 * @since 11.04.2017
 */
public class ServiceKontoAdapterSerialisierungsException extends ServiceKontoAdapterException {
    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1;

    /**
     * Siehe {@link Exception#Exception(String, Throwable)}.
     *
     * @param message Siehe {@link Exception#Exception(String, Throwable)}
     * @param cause   the cause {@link Exception#Exception(String, Throwable)}
     */
    public ServiceKontoAdapterSerialisierungsException(final String message,
                                                       final Throwable cause) {
        super(message, cause);
    }
}
