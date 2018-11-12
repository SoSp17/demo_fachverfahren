/*
 * UnternehmenDaten.java
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
import javax.persistence.Id;
import javax.persistence.OneToOne;


/**
 * The Class UnternehmenDaten.
 *
 * @author mertinat
 * @since 29.05.2017
 */
@Entity
@Getter
@Setter
@Accessors(chain = true)
public class UnternehmenDaten {
    private String name;

    private String firmenAbteilung;

    private String benutzerAbteilung;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Adresse firmenadresse;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Adresse rechnungsadresse;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Adresse nutzeradresse;

    @Id
    @Column
    private String id;

    private String fax;

    private String unterabteilung;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Postfach postfach;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Postfach rechnungsPostfach;

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
}
