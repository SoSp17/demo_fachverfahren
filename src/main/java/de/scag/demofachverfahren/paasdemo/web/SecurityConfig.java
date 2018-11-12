package de.scag.demofachverfahren.paasdemo.web;

import de.scag.demofachverfahren.paasdemo.servicekonto.ServicekontoConfiguration;
import de.scag.demofachverfahren.paasdemo.web.login.CustomRemembermeService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    public static final int ONE_DAY_IN_SECONDS = 86400;
    private final ServicekontoConfiguration servicekontoConfiguration;
    private final CustomRemembermeService customRemembermeService;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .cors().and()

                .csrf().and()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .rememberMe().key(customRemembermeService.getKey()).rememberMeServices(customRemembermeService).and()

                .logout().deleteCookies("*").invalidateHttpSession(true).clearAuthentication(true)
                .logoutSuccessHandler(logoutSuccessHandler()).permitAll().and()

                .authorizeRequests()
                .antMatchers("/", "/login").permitAll()
                .antMatchers("/**").authenticated().and()

                .formLogin().failureForwardUrl(servicekontoConfiguration.getLoginUrl()).loginPage(servicekontoConfiguration.getLoginUrl()).and();
    }

    private LogoutSuccessHandler logoutSuccessHandler() {
        return (request, response, authentication) -> {
            customRemembermeService.loginFail(request, response);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        };
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        final String idForEncode = "bcrypt";
        final Map<String, PasswordEncoder> encoders = new HashMap<>();
        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        encoders.put(idForEncode, bCryptPasswordEncoder);
        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());

        final DelegatingPasswordEncoder delegatingPasswordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);
        delegatingPasswordEncoder.setDefaultPasswordEncoderForMatches(bCryptPasswordEncoder);
        return delegatingPasswordEncoder;
    }
}
