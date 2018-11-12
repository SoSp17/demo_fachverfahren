/*
 * AnlageRepository.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.repositories.nachrichten;

import de.scag.demofachverfahren.paasdemo.model.nachrichten.Anlage;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repository zum Zugriff auf {@link Anlage}.
 *
 * @author mertinat
 * @since 10.04.2017
 */
public interface AnlageRepository extends JpaRepository<Anlage, Long> {
}
