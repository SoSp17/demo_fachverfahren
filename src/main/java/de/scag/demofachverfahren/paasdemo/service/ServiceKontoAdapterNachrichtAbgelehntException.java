/*
 * NachrichtAbgelehntException.java
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
 * Wird geworfen, wenn das Servicekonto eine Nachricht abgelehnt hat.
 *
 * @author mertinat
 * @since 05.05.2017
 */
public class ServiceKontoAdapterNachrichtAbgelehntException extends ServiceKontoAdapterException {
    /**
     * Use serialVersionUID for interoperability.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Konstruktor.
     *
     * @param grund Grund für die Ablehnung
     */
    public ServiceKontoAdapterNachrichtAbgelehntException(final String grund) {
        super(grund);
    }
}
