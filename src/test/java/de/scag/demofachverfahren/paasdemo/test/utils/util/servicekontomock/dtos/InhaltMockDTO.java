/*
 * InhaltMockDTO.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.test.utils.util.servicekontomock.dtos;

public class InhaltMockDTO {
    private String absender;

    private String text;

    public String getAbsender() {
        return absender;
    }

    public void setAbsender(final String absender) {
        this.absender = absender;
    }

    public String getFachdienstName() {
        return absender;
    }

    public void setFachdienstName(final String fachdienstName) {
        this.absender = fachdienstName;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }
}
