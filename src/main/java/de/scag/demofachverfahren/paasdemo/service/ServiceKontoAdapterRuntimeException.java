/*
 * ServiceKontoAdapterRuntimeException.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.service;

/**
 * Allgemeine Anwendungsspezifische Exception.
 *
 * @author mertinat
 * @since 11.04.2017
 */
public class ServiceKontoAdapterRuntimeException extends RuntimeException {
    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1;

    /**
     * Siehe {@link RuntimeException#RuntimeException(String, Throwable)}.
     *
     * @param message Siehe
     *                {@link RuntimeException#RuntimeException(String, Throwable)}
     */
    public ServiceKontoAdapterRuntimeException(final String message) {
        super(message);
    }
}
