/*
 * ServiceKontoAdapterException.java
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
public abstract class ServiceKontoAdapterException extends Exception {
    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1;

    /**
     * Siehe {@link Exception#Exception(String, Throwable)}.
     *
     * @param message Siehe {@link Exception#Exception(String)}
     */
    public ServiceKontoAdapterException(final String message) {
        super(message);
    }

    /**
     * Siehe {@link Exception#Exception(String, Throwable)}.
     *
     * @param message Siehe {@link Exception#Exception(String, Throwable)}
     * @param cause   the cause {@link Exception#Exception(String, Throwable)}
     */
    public ServiceKontoAdapterException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
