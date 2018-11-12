/*
 * NachrichtenListeMockDTO.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.test.utils.util.servicekontomock.dtos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class NachrichtenListeMockDTO {
    @JsonProperty("elements")
    public final List<NachrichtMockDTO> nachrichten;

    NachrichtenListeMockDTO() {
        nachrichten = Collections.emptyList();
    }

    NachrichtenListeMockDTO(final List<NachrichtMockDTO> nachrichten) {
        this.nachrichten = Collections.unmodifiableList(nachrichten);
    }

    public static class NachrichtMockDTO {
        public final String id;
        public final Long nutzerId;
        public final Integer fachdienstId;
        public final String betreff;
        public final InhaltMockDTO inhalt;
        public final Integer anzahlAnhaenge;

        NachrichtMockDTO() {
            this(null, null, null, null, null, null);
        }

        NachrichtMockDTO(final String id,
                         final Long nutzerId,
                         final Integer fachdienstId,
                         final String betreff,
                         final InhaltMockDTO inhalt,
                         final Integer anzahlAnhaenge) {
            this.id = id;
            this.nutzerId = nutzerId;
            this.fachdienstId = fachdienstId;
            this.betreff = betreff;
            this.inhalt = inhalt;
            this.anzahlAnhaenge = anzahlAnhaenge;
        }
    }
}
