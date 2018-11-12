package de.scag.demofachverfahren.paasdemo.service.soap;

import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;


/**
 * Provider for {@link SSLContext}s.
 *
 * @author mertinat
 * @since 20.07.2017
 */
public interface SslContextProviderService {
    /**
     * Gibt eine Instanz von {@link SSLContext} mit TLS12 Algorithmus zurück.
     *
     * @return the instance TLS 12
     * @throws NoSuchAlgorithmException siehe
     *                                  {@link SSLContext#getInstance(String)}
     * @see {@link SSLContext#getInstance(String)}
     */
    SSLContext getInstanceTLS12() throws NoSuchAlgorithmException;
}
