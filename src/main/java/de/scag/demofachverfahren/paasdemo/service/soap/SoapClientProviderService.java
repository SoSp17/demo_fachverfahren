package de.scag.demofachverfahren.paasdemo.service.soap;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;


/**
 * Provider für SoapClients.
 *
 * @author mertinat
 * @since 21.07.2017
 */
public interface SoapClientProviderService {
    /**
     * Gets the soap client for a given configuration.
     *
     * @param <T>                the generic type
     * @param clienConfiguration the clien configuration
     * @return the client for
     * @throws KeyManagementException    Fehler bei der
     *                                   SSL-Kontext-Initialisierung
     * @throws UnrecoverableKeyException Fehler beim Laden des Keystores
     * @throws KeyStoreException         Fehler bei der Initialisierung des Key
     *                                   Stores
     * @throws NoSuchAlgorithmException  Fehler beim Finden des Algorithmus
     * @throws CertificateException      Zertifikatsfehler
     * @throws IOException               Fehler beim Zertifikatszugriff
     */
    <T> T getClientFor(SoapConfiguration<T> clienConfiguration) throws KeyManagementException,
            UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException,
            CertificateException, IOException;
}
