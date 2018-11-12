package de.scag.demofachverfahren.paasdemo.service.soap;

import org.springframework.stereotype.Service;

import javax.net.ssl.KeyManagerFactory;
import java.security.NoSuchAlgorithmException;


/**
 * The Class KeyManagerFactoryProviderServiceImpl.
 *
 * @author mertinat
 * @since 20.07.2017
 */
@Service
public class KeyManagerFactoryProviderServiceImpl implements KeyManagerFactoryProviderService {
    @Override
    public KeyManagerFactory getInstanceWithDefaultAlgorithm() throws NoSuchAlgorithmException {
        return KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    }
}
