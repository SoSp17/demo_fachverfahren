/*
 * Anlage.java
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


/**
 * Anlage einer {@link Nachricht}.
 *
 * @author mertinat
 * @since 24.04.2017
 */
@Entity
@Table(name = "anlage")
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
public class Anlage {
    public static final String FIELD_NACHRICHT = "nachricht";
    public static final String FIELD_INHALT = "inhalt";
    /**
     * Surrogate ID.
     */
    @Id
    @SequenceGenerator(name = "sequence_anlage", sequenceName = "seq_anlage", allocationSize = 1)
    @GeneratedValue(generator = "sequence_anlage")
    @Column(name = "id", unique = true, nullable = false, precision = 10, scale = 0)
    private Long id;

    /**
     * Fachdienst ID, wie sie im Service-Konto hinterlegt ist.
     */
    @Column(name = "dateiname", nullable = false, length = 256)
    private String dateiname;

    /**
     * Tatsächliche Daten des Anhangs.
     */
    @Lob
    @Column(name = FIELD_INHALT, nullable = true)
    private byte[] inhalt;

    /**
     * Art des Inhalts. Beispiele: <a
     * href="https://wiki.selfhtml.org/wiki/Referenz:MIME-Typen">
     * https://wiki.selfhtml.org/wiki/Referenz:MIME-Typen</a>
     */
    @Column(name = "mime_type", nullable = true, length = 128)
    private String mimeType;

    /**
     * The version.
     */
    @Version
    @Column(name = "version", precision = 10, scale = 0)
    private Long version;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_nachricht")
    private Nachricht nachricht;

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, FIELD_INHALT, FIELD_NACHRICHT);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, FIELD_NACHRICHT);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, FIELD_NACHRICHT);
    }
}
