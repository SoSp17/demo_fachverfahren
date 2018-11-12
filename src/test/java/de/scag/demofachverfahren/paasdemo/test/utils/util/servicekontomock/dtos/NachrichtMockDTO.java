/*
 * NachrichtMockDTO.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.test.utils.util.servicekontomock.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class NachrichtMockDTO {
    private String id;
    private String preis;
    private Long nutzerId;
    private Integer fachdienstId;
    private String betreff;
    private InhaltMockDTO inhalt;
    private List<AnhangMockDTO> anhaenge;

    public NachrichtMockDTO() {
        this.anhaenge = new ArrayList<>();
    }

    public NachrichtMockDTO(final String id,
                            final String preis,
                            final Long nutzerId,
                            final Integer fachdienstId,
                            final String untertitel,
                            final InhaltMockDTO inhalt,
                            final Collection<AnhangMockDTO> anhaenge) {
        this.id = id;
        this.preis = preis;
        this.nutzerId = nutzerId;
        this.fachdienstId = fachdienstId;
        this.betreff = untertitel;
        this.inhalt = inhalt;
        this.anhaenge = new ArrayList<>(anhaenge);
    }
}
