/*
 * ServiceKontoAdapterEntityNotFoundException.java
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
 * Wird geworfen, wenn Entitäten nicht gefunden werden konnten.
 *
 * @author mertinat
 * @since 11.04.2017
 */
public class ServiceKontoAdapterEntityNotFoundException extends ServiceKontoAdapterException {
    /**
     * Use serialVersionUID for interoperability.
     */
    private static final long serialVersionUID = 1L;
    private final transient Object key;
    private final Class<?> type;

    /**
     * Konstruktor.
     *
     * @param key  Wert des keys der betroffenen Entität.
     * @param type Typ der nicht gefundenen Entität.
     */
    public ServiceKontoAdapterEntityNotFoundException(final Object key, final Class<?> type) {
        super("Entität mit id '" + key + "' vom typ '" + type + "' konnte nicht gefunden werden.");
        this.key = key;
        this.type = type;
    }

    public Class<?> getType() {
        return type;
    }

    public Object getKey() {
        return key;
    }
}
