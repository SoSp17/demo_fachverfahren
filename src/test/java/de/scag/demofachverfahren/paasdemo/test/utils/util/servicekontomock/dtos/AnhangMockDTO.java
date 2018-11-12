/*
 * AnhangMockDTO.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.test.utils.util.servicekontomock.dtos;

public class AnhangMockDTO {
    private String dateiname;
    private byte[] daten;

    public AnhangMockDTO() {
    }

    public AnhangMockDTO(final String dateiname, final byte[] daten) {
        this.dateiname = dateiname;
        this.daten = daten;
    }

    public String getDateiname() {
        return dateiname;
    }

    public void setDateiname(final String dateiname) {
        this.dateiname = dateiname;
    }

    public byte[] getDaten() {
        return daten;
    }

    public void setDaten(final byte[] daten) {
        this.daten = daten;
    }
}
