/*
 * NachrichtRepositoryImpl.java
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
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;


/**
 * The Class NachrichtRepositoryImpl.
 */
public class NachrichtRepositoryImpl implements NachrichtRepositoryCustom {
    @Autowired
    private NachrichtRepository nachrichtRepository;

    /* (non-Javadoc)
     * @see de.verwalt_berlin.senbjw.isbj.servicekonto.repositories.NachrichtRepositoryCustom#findFirstByStatusOrderBySendattemptsAscEingangAsc(de.verwalt_berlin.senbjw.isbj.servicekonto.model.Nachricht.Status)
     */
    @Override
    public Nachricht findFirstByStatusOrderBySendattemptsAscEingangAsc(final Nachricht.Status status) {
        final Pageable pagable = PageRequest.of(0, 1);
        final List<Nachricht> nachrichten =
                nachrichtRepository.findByStatusOrderBySendattemptsAscEingangAsc(status, pagable);

        return (CollectionUtils.size(nachrichten) == 0) ? null : nachrichten.get(0);
    }

    @Override
    public Nachricht findFirstByStatusAndIdNotInOrderBySendattemptsAscEingangAsc(
            final Nachricht.Status status,
            final List<Long> ids) {
        final Pageable pagable = PageRequest.of(0, 1);

        final List<Nachricht> nachrichten =
                nachrichtRepository.findByStatusAndIdNotInOrderBySendattemptsAscEingangAsc(status,
                        CollectionUtils.isEmpty(ids) ? Collections.singletonList(-1L) : ids,
                        pagable);

        return (CollectionUtils.size(nachrichten) == 0) ? null : nachrichten.get(0);
    }
}
