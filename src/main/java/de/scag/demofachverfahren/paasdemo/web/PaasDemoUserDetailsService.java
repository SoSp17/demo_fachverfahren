package de.scag.demofachverfahren.paasdemo.web;

import de.scag.demofachverfahren.paasdemo.service.benutzerdaten.BenutzerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.singletonList;

@Service
@RequiredArgsConstructor
public class PaasDemoUserDetailsService implements UserDetailsService {
    private final BenutzerService benutzerService;
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return benutzerService.findByUsername(username)
                .map(benutzer ->
                        new User(benutzer.getBenutzername(),
                                "{noop}" + benutzer.getUserId(),
                                singletonList(new SimpleGrantedAuthority("USER"))))
                .orElseThrow(() -> new UsernameNotFoundException("Kann Nutzer nicht finen: " + username));
    }
}

