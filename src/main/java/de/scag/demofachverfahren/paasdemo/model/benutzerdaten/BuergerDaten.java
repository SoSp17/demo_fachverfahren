/*
 * BuergerDaten.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.model.benutzerdaten;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


/**
 * The Class BuergerDaten.
 *
 * @author mertinat
 * @since 29.05.2017
 */
@Entity
@Getter
@Setter
@Accessors(chain = true)
public class BuergerDaten {

    /**
     * Gibt an, wie zuverlässig die Daten erhoben wurden.
     *
     * @author mertinat
     * @since 30.05.2017
     */
    public enum Sicherheitsstufe {
        /**
         * Buerger hat sich selbst registriert, ohne Verifizierung.
         */
        REGISTRIERT,

        /**
         * Bürger hat sich mit nPA oder auf andere Art und Weise verifiziert.
         */
        VERIFIZIERT_EINFACH,

        /**
         * Verifizierte Daten wurden mit Daten vom Einwohner Meldeamt
         * abgeglichen.
         */
        VERIFIZIERT_MIT_ABGLEICH
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Enumerated(EnumType.STRING)
    private Sicherheitsstufe sicherheitsstufe;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Adresse anschrift;
    private Calendar geburtsdatum;

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

    public Calendar getGeburtsdatum() {
        return this.geburtsdatum;
    }

    public BuergerDaten setGeburtsdatum(final Calendar geburtsdatum) {
        this.geburtsdatum = geburtsdatum;

        return this;
    }
}
