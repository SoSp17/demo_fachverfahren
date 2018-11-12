package de.scag.demofachverfahren.paasdemo.servicekonto;

/**
 * Dieser Service dient dazu, Inhalte, welche im Service-Konto-berlin für
 * Probleme sorgen würden, so aufzubereiten, dass sie problemlos vom
 * Service-Konto-berlin verarbeitet werden können.
 *
 * @author mertinat
 * @since 13.07.2017
 */
public interface ServiceKontoContentsPreparationService {
    /**
     * Bereitet Nachrichten-Teile so auf, dass sie vom Service-Konto-Berlin
     * verarbeitet werden können.
     *
     * @param inhalt the inhalt
     * @return the string
     */
    String prepareForNachricht(String inhalt);
}
