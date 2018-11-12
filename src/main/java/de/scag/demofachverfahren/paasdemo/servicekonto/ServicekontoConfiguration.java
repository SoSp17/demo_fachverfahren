package de.scag.demofachverfahren.paasdemo.servicekonto;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static org.apache.commons.lang3.StringUtils.defaultString;

@Getter
@Setter
@Accessors(chain = true)
@Configuration
@ConfigurationProperties("servicekonto")
@Validated
public class ServicekontoConfiguration {
    /**
     * URL zum Service-Konto-Berlin
     */
    @NotBlank
    private String baseUrl;

    /**
     * Konfiguration zum Nachrichtenversand.
     */
    @NotNull
    private Webservice nachrichten;
    /**
     * Konfiguration zum Abruf von Nutzerdaten.
     */
    @NotNull
    private Webservice nutzerdaten;

    /**
     * ID des Fachverfahrens.
     */
    @NotBlank
    private String fachverfahren;

    /**
     * Pfad zur Keystoredatei. Bsp.: /opt/servicekonto.p12.
     */
    @NotBlank
    private String keyStorePath;
    /**
     * Pfad zum Truststore. Bsp.: /opt/cacerts.jsk.
     */
    @Nullable
    private String trustStorePath;
    /**
     * Passwort zum Keystore
     */
    @NotEmpty
    private char[] keystorePassword;

    /**
     * Adresse des Servicekontos, von der aus sich eingeloggt werden kann.
     */
    @NotBlank
    private String loginUrl;

    public String getNutzerdatenUrl() {
        return getUrlFor(nutzerdaten);
    }

    public String getNachrichtenUrl() {
        return getUrlFor(nachrichten);
    }

    private String getUrlFor(final Webservice webservice) {
        final String nutzdatenPath = webservice == null ?
                null :
                webservice.path;
        return nutzdatenPath == null && baseUrl == null ?
                null :
                defaultString(baseUrl) +
                        defaultString(nutzdatenPath);
    }

    /**
     * Soap-Konfiguration.
     */
    @Data
    @Accessors(chain = true)
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Webservice {
        /**
         * Beispielsweise GovGWAsyncResponse
         */
        @NotBlank
        private String targetNamespaceUri;
        /**
         * Beispielsweise http://tempuri.org/
         */
        @NotBlank
        private String localPart;
        /**
         * Wsdl Pfad. Beispielsweise: /GovGWAsyncResponse/GovGWAsyncResponse.wsdl
         */
        @NotBlank
        private String path;
    }
}
