/*
 * ServiceKontoAdapterTransformationException.java
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
 * Wird bei Transformationsproblemen geworfen.
 *
 * @author mertinat
 * @since 02.06.2017
 */
public class ServiceKontoAdapterTransformationException extends ServiceKontoAdapterException {
    /**
     * Use serialVersionUID for interoperability.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new service konto adapter transformation exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ServiceKontoAdapterTransformationException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
