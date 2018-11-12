package de.scag.demofachverfahren.paasdemo.service.soap;

import java.security.KeyStore;
import java.security.KeyStoreException;


/**
 * Provider for {@link KeyStore}s.
 *
 * @author mertinat
 * @since 20.07.2017
 */
public interface KeyStoreProviderService {
    /**
     * Gibt eine {@link KeyStore} mit einer PKCS12 Instanz zurück.
     *
     * @return the instance PKCS 12
     * @throws KeyStoreException Siehe {@link KeyStore#getInstance(String)}
     * @see KeyStore#getInstance(String)
     */
    KeyStore getInstancePKCS12() throws KeyStoreException;
}
