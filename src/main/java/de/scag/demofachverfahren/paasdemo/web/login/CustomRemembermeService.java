package de.scag.demofachverfahren.paasdemo.web.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationException;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class CustomRemembermeService extends AbstractRememberMeServices {
    private final RememberMeConfiguration rememberMeConfiguration;
    protected CustomRemembermeService(final RememberMeConfiguration rememberMeConfiguration, final UserDetailsService userDetailsService) {
        super(rememberMeConfiguration.getTokenIdentificationkey(), userDetailsService);
        this.rememberMeConfiguration = rememberMeConfiguration;
        this.setAlwaysRemember(rememberMeConfiguration.isAlwaysRemember());
        this.setTokenValiditySeconds(rememberMeConfiguration.getTokenValidityInSeconds());
        this.setUseSecureCookie(rememberMeConfiguration.isUseSecureCookie());
        this.setCookieName(rememberMeConfiguration.getCookieName());
    }

    @Override
    protected void onLoginSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication successfulAuthentication) {
        rememberUser(successfulAuthentication.getName(), response);
    }

    @Override
    protected UserDetails processAutoLoginCookie(final String[] cookieTokens, final HttpServletRequest request, final HttpServletResponse response) throws RememberMeAuthenticationException, UsernameNotFoundException {
        // Hier könnten noch Validierungen des Tokens stattfinen (wenn z.B. JWT Token verwenet wird)
        final UserDetails userDetails;
        try {
            userDetails = userByUsername(cookieTokens[0]);
        } catch (final UsernameNotFoundException e) {
            removeRememberMeCookie(request, response);
            throw e;
        }

        rememberUser(userDetails.getUsername(), response);

        return userDetails;
    }

    private UserDetails userByUsername(final String username) {
        return getUserDetailsService().loadUserByUsername(username);
    }

    @Override
    protected void onLoginFail(final HttpServletRequest request, final HttpServletResponse response) {
        removeRememberMeCookie(request, response);
    }

    private void removeRememberMeCookie(final HttpServletRequest request, final HttpServletResponse response) {
        cancelCookie(request, response);
    }

    public void rememberUser(final String username, final HttpServletResponse response) {
        final Cookie cookie = new Cookie(getCookieName(), encodeCookie(new String[]{username}));
        cookie.setMaxAge(getTokenValiditySeconds());
        cookie.setSecure(rememberMeConfiguration.isUseSecureCookie());
        cookie.setHttpOnly(rememberMeConfiguration.isHttpOnly());
        response.addCookie(cookie);
    }
}
