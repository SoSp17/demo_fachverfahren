package de.scag.demofachverfahren.paasdemo.service.antragsstellung;

import de.scag.demofachverfahren.paasdemo.model.antragsstellung.Antrag;
import de.scag.demofachverfahren.paasdemo.model.nachrichten.Fachverfahren;
import de.scag.demofachverfahren.paasdemo.model.nachrichten.Nachricht;
import de.scag.demofachverfahren.paasdemo.repositories.AntragRepository;
import de.scag.demofachverfahren.paasdemo.service.ServiceKontoAdapterException;
import de.scag.demofachverfahren.paasdemo.service.benutzerdaten.BenutzerService;
import de.scag.demofachverfahren.paasdemo.servicekonto.ServiceKontoClient;
import de.scag.demofachverfahren.paasdemo.servicekonto.ServicekontoConfiguration;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class PersistentAntragService implements AntragService {
    private final AntragRepository antragRepository;
    private final ServiceKontoClient serviceKontoClient;
    private final ServicekontoConfiguration servicekontoConfiguration;
    private final BenutzerService benutzerService;
    private final Logger log;
    @Override
    public List<Antrag> getAllAntraege() {
        return antragRepository.findAll();
    }

    @Override
    public Optional<Antrag> getAntragById(final long id) {
        return antragRepository.findById(id);
    }

    @Override
    public void stelleAntrag(final Antrag antrag, final Principal principal) {
        antrag.setGueltig(LocalDate.now());
        antragRepository.save(antrag);
        benachrichtige(antrag, principal);
    }

    private void benachrichtige(final Antrag antrag, final Principal principal) {
        if (principal != null) {
            benutzerService.findByUsername(principal.getName())
                    .ifPresent(benutzer -> {
                        final Nachricht nachricht = new Nachricht()
                                .setId(antrag.getId())
                                .setBetreff(antrag.getArt() + " Antrag")
                                .setInhalt(antrag.getArt() + "Antrag wurde eingereicht")
                                .setAbsendername("demo-fachverfahren")
                                .setExterneEmpfaengerId(benutzer.getUserId())
                                .setFachverfahren(new Fachverfahren()
                                        .setExterneFachdienstId(Integer.valueOf(servicekontoConfiguration.getFachverfahren())));
                        try {
                            serviceKontoClient.send(nachricht);
                        } catch (final ServiceKontoAdapterException e) {
                            log.error("Fehler bei der Benachrichtigung");
                        }
                    });
        }
    }
}
