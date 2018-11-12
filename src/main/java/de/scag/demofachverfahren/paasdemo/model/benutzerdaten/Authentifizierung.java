/*
 * Authentifizierung.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.model.benutzerdaten;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.util.Calendar;


/**
 * Daten zur Authentifizierung.
 *
 * @author mertinat
 * @since 22.05.2017
 */
@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Authentifizierung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private Calendar gueltigBis;
    @Enumerated(EnumType.STRING)
    private Art art;

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    /**
     * The Enum Art.
     */
    @Getter
    @AllArgsConstructor
    @Accessors(chain = true)
    public enum Art {
        /**
         * The user password.
         */
        USER_PASSWORD(1),

        /**
         * The smart card.
         */
        SMART_CARD(2),

        /**
         * The windows.
         */
        WINDOWS(3),

        /**
         * The passwort internal.
         */
        PASSWORT_INTERNAL(4),

        /**
         * The personalausweis.
         */
        PERSONALAUSWEIS(5);

        private final int authentifizierungsmodusId;
    }
}
