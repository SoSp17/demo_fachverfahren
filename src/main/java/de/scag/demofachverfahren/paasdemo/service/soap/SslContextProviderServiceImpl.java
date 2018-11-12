package de.scag.demofachverfahren.paasdemo.service.soap;

import org.springframework.stereotype.Service;

import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;


/**
 * The Class SslContextproviderServiceImpl.
 *
 * @author mertinat
 * @since 20.07.2017
 */
@Service
public class SslContextProviderServiceImpl implements SslContextProviderService {
    @Override
    public SSLContext getInstanceTLS12() throws NoSuchAlgorithmException {
        return SSLContext.getInstance("TLSv1.2");
    }
}
