/*
 * Inhalt.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.servicekonto.govgwasyncresponse.contentmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class Inhalt.
 */
@XmlRootElement(name = "xmlcontent")
@XmlAccessorType(XmlAccessType.FIELD)
public class NachrichtInhalt {
    @XmlElement(name = "servicename")
    private String absender;

    @XmlElement(name = "eingangstext")
    private String text;

    public String getAbsender() {
        return absender;
    }

    /**
     * Sets the fachdienst name.
     *
     * @param absender Name des Absenders
     * @return the inhalt
     */
    public NachrichtInhalt setAbsender(final String absender) {
        this.absender = absender;

        return this;
    }

    public String getText() {
        return text;
    }

    /**
     * Sets the text.
     *
     * @param text the text
     * @return the inhalt
     */
    public NachrichtInhalt setText(final String text) {
        this.text = text;

        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Inhalt [absender=" + absender + ", text=" + text + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((absender == null) ? 0 : absender.hashCode());
        result = (prime * result) + ((text == null) ? 0 : text.hashCode());

        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof NachrichtInhalt)) {
            return false;
        }

        final NachrichtInhalt other = (NachrichtInhalt) obj;

        if (absender == null) {
            if (other.absender != null) {
                return false;
            }
        } else if (!absender.equals(other.absender)) {
            return false;
        }

        if (text == null) {
            return other.text == null;
        } else {
            return text.equals(other.text);
        }

    }
}
