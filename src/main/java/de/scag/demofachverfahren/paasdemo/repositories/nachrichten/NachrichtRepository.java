/*
 * NachrichtRepository.java
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
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Repository zum Zugriff auf {@link Nachricht}.
 *
 * @author mertinat
 * @since 10.04.2017
 */
public interface NachrichtRepository extends JpaRepository<Nachricht, Long>,
        NachrichtRepositoryCustom {
    /**
     * Find all by fachverfahren externe fachdienst id order by eingang desc.
     *
     * @param fachverfahrenId the fachverfahren id
     * @param pagable         {@link Pageable} zur Pagination
     * @return the list of {@link Nachricht}
     */
    List<Nachricht> findAllByFachverfahrenExterneFachdienstIdOrderByEingangDesc(
            Integer fachverfahrenId,
            Pageable pagable);

    /**
     * Laedt Nachrichten mit dem gegebenen Status.
     *
     * @param status  Filter
     * @param pagable {@link Pageable} zur Pagination
     * @return Gruppe von Nachrichten.
     */
    List<Nachricht> findByStatusOrderBySendattemptsAscEingangAsc(Nachricht.Status status, Pageable pagable);

    /**
     * Laedt Nachrichten mit dem gegebenen Status.
     *
     * @param status  the status
     * @param ids     the ids. Achtung, aufgrund der Einschräknungen der JPA
     *                Spezifikation darf diese Methode nicht mit einer leeren
     *                Liste aufgerufen werden.
     * @param pagable the pagable
     * @return Gruppe von Nachrichten.
     */
    List<Nachricht> findByStatusAndIdNotInOrderBySendattemptsAscEingangAsc(Nachricht.Status status,
                                                                           List<Long> ids,
                                                                           Pageable pagable);
}
