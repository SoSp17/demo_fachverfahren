/*
 * Fachverfahren.java
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
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;


/**
 * Fachverfahren.
 *
 * @author mertinat
 * @since 12.04.2017
 */
@Entity
@Table(name = "fachverfahren")
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
public class Fachverfahren {
    /**
     * Surrogate ID.
     */
    @Id
    @SequenceGenerator(
            name = "sequence_fachverfahren", sequenceName = "seq_fachverfahren", allocationSize = 1
    )
    @GeneratedValue(generator = "sequence_fachverfahren")
    @Column(name = "id", unique = true, nullable = false, precision = 10, scale = 0)
    private Long id;

    /**
     * Fachdienst ID, wie sie im Service-Konto hinterlegt ist.
     */
    @Column(
            name = "externe_fachdienst_id", unique = true, nullable = false, precision = 10, scale = 0
    )
    private Integer externeFachdienstId;

    /**
     * Name des Fachdienstes, wie er im Servicekonto hinterlegt ist.
     */
    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Lob
    @Column(name = "keystore_in_base_64", nullable = false)
    private String keystoreInBase64;

    @Column(name = "private_keystore_passwort", nullable = false, length = 128)
    private char[] privateKeystorePasswort;

    /**
     * The version.
     */
    @Version
    @Column(name = "version", precision = 10, scale = 0)
    private Long version;

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, "privateKeystorePasswort");
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

    public char[] getPrivateKeystorePasswort() {
        return privateKeystorePasswort;
    }

    @SuppressWarnings("pmd:ArrayIsStoredDirectly")
    public Fachverfahren setPrivateKeystorePasswort(final char[] passwort) {
        this.privateKeystorePasswort = passwort;

        return this;
    }

    public byte[] getKeystore() {
        return Base64.decodeBase64(keystoreInBase64);
    }
}
