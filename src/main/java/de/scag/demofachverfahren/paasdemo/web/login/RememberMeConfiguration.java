package de.scag.demofachverfahren.paasdemo.web.login;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Accessors(chain = true)
@Configuration
@ConfigurationProperties("remember-me-token-config")
@Validated
public class RememberMeConfiguration {
    /**
     * Key zur Identifikation von Token.
     */
    private String tokenIdentificationkey = "paas-demo-remember-me-key";
    /**
     * Whether the cookie should be flagged as secure or not. Secure cookies can only be sent over an HTTPS connection and thus cannot be accidentally submitted over HTTP where they could be intercepted.
     * By default the cookie will be secure if the request is secure. If you only want to use remember-me over HTTPS (recommended) you should set this property to true.
     *
     * @see AbstractRememberMeServices#setUseSecureCookie(boolean)
     */
    private boolean useSecureCookie = true;
    /**
     * Zeit in Sekunden, ab wann der Cookie nach einer Nutzerinteraktion verfällt. Dies bestimmt auch darüber, ab wann ein Nutzer ausgeloggt ist.
     */
    private int tokenValidityInSeconds = 300;
    /**
     * Gibt an, ob sich bei einem Formlogin standardmäßig der Login in einem Cookie gemerkt werden soll.
     */
    private boolean alwaysRemember = true;
    /**
     * Name des Remember-me-Cookies
     */
    private String cookieName = "paas-demo-remember-me";

    /**
     * Gibt an, ob das Cookie von clientseitigen Scripts verborgen werden soll.
     *
     * @see javax.servlet.http.Cookie#setHttpOnly(boolean)
     */
    private boolean isHttpOnly = true;
}
