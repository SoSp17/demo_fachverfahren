package de.scag.demofachverfahren.paasdemo.service;

/**
 * Wird bei Soap Verbindungsproblemen geworfen.
 *
 * @author mertinat
 * @since 17.07.2017
 */
public class ServiceKontoAdapterSoapConnectionException extends ServiceKontoAdapterException {
    /**
     * Use serialVersionUID for interoperability.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new service konto adapter soap connection exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ServiceKontoAdapterSoapConnectionException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
