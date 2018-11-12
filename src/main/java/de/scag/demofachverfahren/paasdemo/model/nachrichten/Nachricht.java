/*
 * Nachricht.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.model.nachrichten;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;


/**
 * Nachricht, welche für ein Servicekonto bestimmt ist.
 *
 * @author mertinat
 * @since 12.04.2017
 */
@Entity
@Table(name = "nachricht")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@SuppressWarnings(
        {
                "checkstyle:com.puppycrawl.tools.checkstyle.checks.coding.MagicNumberCheck",
                "common-java:DuplicatedBlocks"
        }
)
public class Nachricht {
    /**
     * Surrogate ID.
     */
    @Id
    @SequenceGenerator(
            name = "sequence_nachricht", sequenceName = "seq_nachricht", allocationSize = 1
    )
    @GeneratedValue(generator = "sequence_nachricht")
    @Column(name = "id", unique = true, nullable = false, precision = 10)
    private Long id;
    /**
     * The externe empfaenger id.
     */
    @Column(
            name = "externe_empfaenger_id", nullable = false, precision = 10
    )
    private Long externeEmpfaengerId;
    /**
     * The betreff.
     */
    @Column(name = "betreff", nullable = false, length = 256)
    private String betreff;
    /**
     * The untertitel.
     */
    @Column(name = "absendername", nullable = false, length = 256)
    private String absendername;
    /**
     * The inhalt.
     */
    @Lob
    @Column(name = "inhalt")
    private String inhalt;
    /**
     * The eingang.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "eingang", nullable = false)
    private Calendar eingang;
    /**
     * The ausgang.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ausgang")
    private Calendar ausgang;
    /**
     * The fehler text.
     */
    @Column(name = "fehlertext", length = 256)
    @Lob
    private String fehlerText;
    /**
     * The status.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;
    /**
     * The fachverfahren.
     */
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_fachverfahren")
    private Fachverfahren fachverfahren;
    /**
     * The anlagen.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "nachricht")
    private List<Anlage> anlagen = new LinkedList<>();
    /**
     * The version.
     */
    @Version
    @Column(name = "version", precision = 10)
    private Long version;
    /**
     * Bereits getätigte Versandversuche.
     */
    @Column(name = "sendattempts", nullable = false, precision = 10)
    private long sendattempts;

    /**
     * Gets the externe nachrichten id.
     *
     * @return the externe nachrichten id
     */
    public String getExterneNachrichtenId() {
        return (id == null) ? null : id.toString();
    }

    /**
     * Sets the anlagen.
     *
     * @param anlagen the new anlagen
     * @return the nachricht
     */
    public Nachricht setAnlagen(final List<Anlage> anlagen) {
        this.anlagen = anlagen;

        if (anlagen != null) {
            for (final Anlage anlage : anlagen) {
                anlage.setNachricht(this);
            }
        }

        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
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
        return HashCodeBuilder.reflectionHashCode(this, false);
    }

    /**
     * Status einer Nachricht.
     *
     * @author mertinat
     * @since 24.04.2017
     */
    public enum Status {
        /**
         * Wartend.
         */
        WARTEND,

        /**
         * Abgelehnt.
         */
        ABGELEHNT,

        /**
         * Fehler.
         */
        FEHLER,

        /**
         * Versandt.
         */
        VERSANDT
    }
}
