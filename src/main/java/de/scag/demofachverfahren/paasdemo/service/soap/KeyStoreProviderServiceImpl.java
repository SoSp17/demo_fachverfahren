package de.scag.demofachverfahren.paasdemo.service.soap;

import org.springframework.stereotype.Service;

import java.security.KeyStore;
import java.security.KeyStoreException;


/**
 * The Class KeyStoreDelegatorImpl.
 *
 * @author mertinat
 * @since 20.07.2017
 */
@Service
public class KeyStoreProviderServiceImpl implements KeyStoreProviderService {
    private static final String PKCS12 = "PKCS12";

    /* (non-Javadoc)
     * @see de.verwalt_berlin.senbjw.isbj.servicekonto.service.KeyStoreProviderService#getPkcs12Instance(java.lang.String)
     */
    @Override
    public KeyStore getInstancePKCS12() throws KeyStoreException {
        return KeyStore.getInstance(PKCS12);
    }
}
