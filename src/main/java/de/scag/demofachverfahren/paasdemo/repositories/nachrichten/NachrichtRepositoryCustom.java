/*
 * NachrichtRepositoryCustom.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.repositories.nachrichten;

import de.scag.demofachverfahren.paasdemo.model.nachrichten.Nachricht;

import java.util.List;


/**
 * Benutzerdefinitierte Repository-Erweiterungen von {@link NachrichtRepository}.
 */
public interface NachrichtRepositoryCustom {
    /**
     * Lädt die älteste Nachricht mit den wenigesten Versandversuchen, welche
     * den gegebenen Status hat.
     *
     * @param status the status
     * @return Gruppe von Nachrichten.
     */
    Nachricht findFirstByStatusOrderBySendattemptsAscEingangAsc(Nachricht.Status status);

    /**
     * Lädt die älteste Nachricht mit den wenigesten Versandversuchen, welche
     * den gegebenen Status hat.
     *
     * @param status the status
     * @param ids    zu ignorierende Nachrichtenids. Achtung, die Liste sollte
     *               aufgrund von JPA einschränkungen nicht leer sein. Falls
     *               sie es doch ist, wird sie mit vor der Abfrage mit dem Wert
     *               "-1" befüllt.
     * @return Gruppe von Nachrichten.
     */
    Nachricht findFirstByStatusAndIdNotInOrderBySendattemptsAscEingangAsc(Nachricht.Status status,
                                                                          List<Long> ids);
}
