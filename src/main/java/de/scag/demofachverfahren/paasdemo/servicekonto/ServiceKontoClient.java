/*
 * ServiceKontoClient.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.servicekonto;

import de.scag.demofachverfahren.paasdemo.model.nachrichten.Nachricht;
import de.scag.demofachverfahren.paasdemo.service.ServiceKontoAdapterException;
import de.scag.demofachverfahren.paasdemo.service.ServiceKontoAdapterNachrichtAbgelehntException;
import de.scag.demofachverfahren.paasdemo.service.ServiceKontoAdapterNutzerdatenAbfrageException;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.Userdata;
import org.apache.commons.lang3.ObjectUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * Client für die Kommunikation mit dem Service Konto Berlin.
 *
 * @author mertinat
 * @since 05.05.2017
 */
public interface ServiceKontoClient {
    /**
     * Verschicht eine {@link Nachricht} an das Service Konto Be n.
     *
     * @param nachricht the nachricht
     * @throws ServiceKontoAdapterNachrichtAbgelehntException Wird geworfen,
     *                                                        wenn die Nachricht
     *                                                        vom
     *                                                        ServiceKontoBerlin
     *                                                        abgelehnt wurde.
     * @throws ServiceKontoAdapterException                   Wird bei
     *                                                        technischen
     *                                                        Fehlern geworfen.
     */
    void send(Nachricht nachricht) throws ServiceKontoAdapterException;

    /**
     * Lädt Nutzerdaten anhand eines Tokens vom Servicekonto Berlin.
     *
     * @param anyToken      the any token
     * @return the userdata
     * @throws ServiceKontoAdapterNutzerdatenAbfrageException Wird geworfen,
     *                                                        wenn das
     *                                                        Servicekonto
     *                                                        Berlin dieAnfrage
     *                                                        ablehnt oder ein
     *                                                        Fehler bei der
     *                                                        Abfrage im
     *                                                        Service-Konto-Berlin
     *                                                        auftritt.
     * @throws ServiceKontoAdapterException                   Wird bei internen
     *                                                        Fehlern geworfen.
     */
    Userdata getUserdata(String anyToken) throws ServiceKontoAdapterException;

    /**
     * Mögliche Arten des aufgetretenen Fehlers.
     *
     * @author mertinat
     * @since 24.05.2017
     */
    enum NutzerdatenabfrageFehlerart {
        /**
         * The ok.
         */
        OK(1, "OK"),

        /**
         * The general error.
         */
        GENERAL_ERROR(100, "Allgemeiner Fehler"),

        /**
         * The ws error.
         */
        WS_ERROR(102, "Webservice Fehler"),

        /**
         * The db error.
         */
        DB_ERROR(104, "Datenbank Fehler"),

        /**
         * The data error.
         */
        DATA_ERROR(106, "DataError"),

        /**
         * The unknown user.
         */
        UNKNOWN_USER(110, "Unbekannter User"),

        /**
         * The timeout.
         */
        TIMEOUT(120, "Request Timeout - User außerhalb des vorgegebenen Zeitfensters"),

        /**
         * The not implemented.
         */
        NOT_IMPLEMENTED(500, "Nicht implementiert"),

        /**
         * The unknown error.
         */
        UNKNOWN_ERROR(1000, "Unbekannter Fehler"),

        /**
         * The undokumentiert.
         */
        UNDOKUMENTIERT(null, "Undokumentierter Fehler");

        private static final Map<Integer, NutzerdatenabfrageFehlerart> FEHLERCODE_MAP;

        static {
            FEHLERCODE_MAP = new HashMap<>();

            for (final NutzerdatenabfrageFehlerart fehlarart : NutzerdatenabfrageFehlerart.values()) {
                FEHLERCODE_MAP.put(fehlarart.getFehlercode(), fehlarart);
            }
        }

        private final Integer fehlercode;
        private final String bezeichnung;

        NutzerdatenabfrageFehlerart(final Integer fehlercode, final String bezeichnung) {
            this.fehlercode = fehlercode;
            this.bezeichnung = bezeichnung;
        }

        /**
         * Gets the by fehlercode.
         *
         * @param fehlercode the fehlercode
         * @return the by fehlercode
         */
        public static NutzerdatenabfrageFehlerart getByFehlercode(final Integer fehlercode) {
            return ObjectUtils.defaultIfNull(FEHLERCODE_MAP.get(fehlercode), UNDOKUMENTIERT);
        }

        public String getBezeichnung() {
            return bezeichnung;
        }

        public Integer getFehlercode() {
            return fehlercode;
        }
    }
}
