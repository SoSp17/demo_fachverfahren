package de.scag.demofachverfahren.paasdemo.service.benutzerdaten;

import de.scag.demofachverfahren.paasdemo.converter.model.nachrichten.BenutzerConverterService;
import de.scag.demofachverfahren.paasdemo.model.benutzerdaten.Benutzer;
import de.scag.demofachverfahren.paasdemo.repositories.benutzerdaten.BenutzerRepository;
import de.scag.demofachverfahren.paasdemo.service.ServiceKontoAdapterException;
import de.scag.demofachverfahren.paasdemo.servicekonto.ServiceKontoClient;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.Userdata;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicekontoBenutzerService implements BenutzerService {
    private final ServiceKontoClient serviceKontoClient;
    private final BenutzerConverterService benutzerConverterService;
    private final BenutzerRepository benutzerRepository;
    private final Logger log;

    @Override
    public Optional<Benutzer> getByToken(final String token) {
        try {
            final Userdata userdata = serviceKontoClient.getUserdata(token);
            final Benutzer benutzerFromSKB = benutzerConverterService.convert(userdata);
            return Optional.of(
                    findByUsername(benutzerFromSKB.getBenutzername())
                            .orElseGet(() -> benutzerRepository.save(benutzerFromSKB)));

        } catch (final ServiceKontoAdapterException e) {
            log.error("Fehler beim Laden der Nutzerdaten.", e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<Benutzer> findByUsername(final String benutzername) {
        return benutzerRepository.findByBenutzername(benutzername);
    }
}
