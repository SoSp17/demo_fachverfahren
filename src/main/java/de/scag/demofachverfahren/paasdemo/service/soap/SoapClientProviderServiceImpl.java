package de.scag.demofachverfahren.paasdemo.service.soap;

import de.scag.demofachverfahren.paasdemo.servicekonto.ServicekontoConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.xml.namespace.QName;


/**
 * The Class SoapClientProviderServiceImpl.
 *
 * @author mertinat
 * @since 21.07.2017
 */
@Service
public class SoapClientProviderServiceImpl implements SoapClientProviderService {
    private final KeyStoreProviderService keyStoreProviderService;
    private final SslContextProviderService sslContextProviderService;
    private final KeyManagerFactoryProviderService keyManagerFactoryProviderService;

    public SoapClientProviderServiceImpl(final KeyStoreProviderService keyStoreProviderService, final SslContextProviderService sslContextProviderService, final KeyManagerFactoryProviderService keyManagerFactoryProviderService, final ServicekontoConfiguration servicekontoConfiguration) {
        this.keyStoreProviderService = keyStoreProviderService;
        this.sslContextProviderService = sslContextProviderService;
        this.keyManagerFactoryProviderService = keyManagerFactoryProviderService;
        if (!StringUtils.isBlank(servicekontoConfiguration.getTrustStorePath())) {
            System.setProperty("javax.net.ssl.trustStore", new File(servicekontoConfiguration.getTrustStorePath()).getAbsolutePath());
        }
    }

    /* (non-Javadoc)
     * @see de.verwalt_berlin.senbjw.isbj.servicekonto.service.SoapClientProviderService#getClientFor(de.verwalt_berlin.senbjw.isbj.servicekonto.service.SoapClientProviderService.SoapConfiguration)
     */
    @Override
    public <T> T getClientFor(final SoapConfiguration<T> clienConfiguration)
            throws KeyManagementException, UnrecoverableKeyException, KeyStoreException,
            NoSuchAlgorithmException, CertificateException, IOException {
        final javax.xml.ws.Service service = getService(clienConfiguration);

        return /*configureTls(createSSLContext(clienConfiguration),*/
                service.getPort(clienConfiguration.getPortInterface())/*)*/;
    }

    private <T> SSLContext createSSLContext(final SoapConfiguration<T> clienConfiguration)
            throws KeyManagementException, UnrecoverableKeyException, KeyStoreException,
            NoSuchAlgorithmException, CertificateException, IOException {
        final SSLContext sc = sslContextProviderService.getInstanceTLS12();

        final KeyManagerFactory kmf =
                keyManagerFactoryProviderService.getInstanceWithDefaultAlgorithm();

        kmf.init(getKeyStore(clienConfiguration), clienConfiguration.getKeyStorePassword());

        sc.init(kmf.getKeyManagers(), null, null);

        return sc;
    }

//    private <T> T configureTls(final SSLContext context, final T port) {
//        final TLSClientParameters parameters = new TLSClientParameters();
//        parameters.setSSLSocketFactory(context.getSocketFactory());
//
//        final Client client = ClientProxy.getClient(port);
//        final HTTPConduit conduit = (HTTPConduit) client.getConduit();
//        conduit.setTlsClientParameters(parameters);
//
//        return port;
//    }

    private <T> javax.xml.ws.Service getService(final SoapConfiguration<T> clientConfiguration)
            throws KeyManagementException, UnrecoverableKeyException, KeyStoreException,
            NoSuchAlgorithmException, CertificateException, IOException {
//        HttpsURLConnection.setDefaultSSLSocketFactory(
//                createSSLContext(clientConfiguration).getSocketFactory());

        final QName serviceName =
                new QName(clientConfiguration.getTargetNamespace(), clientConfiguration.getLocalPart());

        return javax.xml.ws.Service.create(clientConfiguration.getUrl(), serviceName);
    }

    private <T> KeyStore getKeyStore(final SoapConfiguration<T> clienConfiguration)
            throws NoSuchAlgorithmException, CertificateException, IOException, KeyStoreException {
        final KeyStore keyStore;

        keyStore = keyStoreProviderService.getInstancePKCS12();

        final ByteArrayInputStream keystoreStream =
                new ByteArrayInputStream(clienConfiguration.getKeyStore());

        keyStore.load(keystoreStream, clienConfiguration.getKeyStorePassword());

        return keyStore;
    }
}
