package de.scag.demofachverfahren.paasdemo.service.soap;

import javax.net.ssl.KeyManagerFactory;
import java.security.NoSuchAlgorithmException;


/**
 * Provider for {@link KeyManagerFactory}s.
 *
 * @author mertinat
 * @since 20.07.2017
 */
public interface KeyManagerFactoryProviderService {
    /**
     * Gibt eine Instanz von {@link KeyManagerFactory} mit dem default
     * Algorithmus des Systems zurück.
     *
     * @return the instance mit dem default Algorithmus des Systems
     * @throws NoSuchAlgorithmException siehe {@link KeyManagerFactory#getInstance(String)}
     * @see {@link KeyManagerFactory#getInstance(String)}
     */
    KeyManagerFactory getInstanceWithDefaultAlgorithm() throws NoSuchAlgorithmException;
}
