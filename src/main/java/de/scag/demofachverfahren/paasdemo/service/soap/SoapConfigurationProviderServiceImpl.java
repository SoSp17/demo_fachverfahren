package de.scag.demofachverfahren.paasdemo.service.soap;

import de.scag.demofachverfahren.paasdemo.service.ServiceKontoConfigServiceException;
import de.scag.demofachverfahren.paasdemo.servicekonto.ServicekontoConfiguration;
import de.scag.demofachverfahren.paasdemo.servicekonto.govgwasyncresponse.IGovGWAsyncResponse;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.UserDataExtendedWebSoap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * The Class SoapConfigurationProviderServiceImpl.
 *
 * @author mertinat
 * @since 26.07.2017
 */
@Service
@RequiredArgsConstructor
public class SoapConfigurationProviderServiceImpl implements SoapConfigurationProviderService {
    private final ServicekontoConfiguration servicekontoConfiguration;

    /* (non-Javadoc)
     * @see de.verwalt_berlin.senbjw.isbj.servicekonto.service.SoapConfigurationProviderService#getNachrichtenVersandConfigurationFor(de.verwalt_berlin.senbjw.isbj.servicekonto.model.nachrichten.Fachverfahren)
     */
    @Override
    public SoapConfiguration<IGovGWAsyncResponse> getNachrichtenVersandConfigurationFor() throws ServiceKontoConfigServiceException {
        try {
            return SoapConfiguration.builder(IGovGWAsyncResponse.class)
                    .withKeyStore(loadKeystore())
                    .withKeyStorePassword(servicekontoConfiguration.getKeystorePassword())
                    .withLocalPart(
                            servicekontoConfiguration.getNachrichten().getLocalPart())
                    .withTargetNamespace(
                            servicekontoConfiguration.getNachrichten().getTargetNamespaceUri())
                    .withUrl(
                            new URL(servicekontoConfiguration.getNachrichtenUrl())).build();
        } catch (final MalformedURLException e) {
            throw new ServiceKontoConfigServiceException("Fehler bei der Erzeugung der NachrichtenUrl", e);
        }
    }

    private byte[] loadKeystore() throws ServiceKontoConfigServiceException {
        try {
            return Files.readAllBytes(Paths.get(servicekontoConfiguration.getKeyStorePath()));
        } catch (final IOException e) {
            throw new ServiceKontoConfigServiceException("Keystore kann nicht geladen werden", e);
        }
    }

    /* (non-Javadoc)
     * @see de.verwalt_berlin.senbjw.isbj.servicekonto.service.SoapConfigurationProviderService#getNutzerdatenAbfrageConfigurationFor(de.verwalt_berlin.senbjw.isbj.servicekonto.model.nachrichten.Fachverfahren)
     */
    @Override
    public SoapConfiguration<UserDataExtendedWebSoap> getNutzerdatenAbfrageConfigurationFor() throws ServiceKontoConfigServiceException {
        try {
            return SoapConfiguration.builder(UserDataExtendedWebSoap.class)
                    .withKeyStore(loadKeystore())
                    .withKeyStorePassword(servicekontoConfiguration.getKeystorePassword())
                    .withLocalPart(
                            servicekontoConfiguration.getNutzerdaten().getLocalPart())
                    .withTargetNamespace(
                            servicekontoConfiguration.getNutzerdaten().getTargetNamespaceUri())
                    .withUrl(
                            new URL(servicekontoConfiguration.getNutzerdatenUrl())).build();
        } catch (final MalformedURLException e) {
            throw new ServiceKontoConfigServiceException("Fehler bei der Erzeugung der NachrichtenUrl", e);
        }
    }
}
