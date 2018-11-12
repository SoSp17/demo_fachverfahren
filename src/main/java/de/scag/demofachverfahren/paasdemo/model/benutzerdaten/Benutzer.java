/*
 * Benutzer.java
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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


/**
 * The Class Benutzer.
 *
 * @author mertinat
 * @since 29.05.2017
 */
@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Benutzer {
    /**
     * Art des Benutzers.
     */
    public enum Typ {
        /**
         * Bürger repräsentierender Benutzer.
         */
        BUERGER(1),

        /**
         * Unternehmen repräsentierender Benutzer.
         */
        UNTERNEHMEN(3);

        private final int modeId;

        private Typ(final int modeId) {
            this.modeId = modeId;
        }

        public int getModeId() {
            return modeId;
        }
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(unique = true)
    private Long userId;
    private Typ typ;
    @Column(unique = true)
    private String benutzername;
    private String titel;
    private String anrede;
    private String vorname;
    private String nachname;
    private String emailadresse;
    private String sprache;
    private String telefon;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Authentifizierung authentifizierung;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private BuergerDaten buerger;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private UnternehmenDaten unternehmen;
    private String zertifikatsId;

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
}
