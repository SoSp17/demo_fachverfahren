/*
 * ServiceKontoConfigServiceException.java
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
public class ServiceKontoConfigServiceException extends ServiceKontoAdapterException {
    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1;

    /**
     * Siehe {@link Exception#Exception(String, Throwable)}.
     *
     * @param message Siehe {@link Exception#Exception(String, Throwable)}
     * @param key     the Zugrundeliegender Problem-Key.
     * @param cause   the cause Siehe
     *                {@link Exception#Exception(String, Throwable)}
     */
    public ServiceKontoConfigServiceException(final String message,
                                              final String key,
                                              final Throwable cause) {
        super("Fehler zu key '" + key + "': " + message, cause);
    }

    /**
     * Siehe {@link Exception#Exception(String, Throwable)}.
     *
     * @param message Siehe {@link Exception#Exception(String, Throwable)}
     * @param cause   the cause Siehe
     *                {@link Exception#Exception(String, Throwable)}
     */
    public ServiceKontoConfigServiceException(final String message,
                                              final Throwable cause) {
        super(message, cause);
    }
}
