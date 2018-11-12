package de.scag.demofachverfahren.paasdemo.service.soap;


import de.scag.demofachverfahren.paasdemo.service.ServiceKontoConfigServiceException;
import de.scag.demofachverfahren.paasdemo.servicekonto.govgwasyncresponse.IGovGWAsyncResponse;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.UserDataExtendedWebSoap;

/**
 * Provider für Soap Konfigurationen.
 *
 * @author mertinat
 * @since 26.07.2017
 */
public interface SoapConfigurationProviderService {
    /**
     * Gets the nachrichten versand configuration.
     *
     * @return the nachrichten versand configuration for
     * @throws ServiceKontoConfigServiceException Bei Problemen mit der Konfiguration geworfen
     */
    SoapConfiguration<IGovGWAsyncResponse> getNachrichtenVersandConfigurationFor() throws ServiceKontoConfigServiceException;

    /**
     * Gets the nutzerdaten abfrage configuration.
     *
     * @return the nutzerdaten abfrage configuration for
     * @throws ServiceKontoConfigServiceException Bei Problemen mit der Konfiguration geworfen
     */
    SoapConfiguration<UserDataExtendedWebSoap> getNutzerdatenAbfrageConfigurationFor() throws ServiceKontoConfigServiceException;
}
