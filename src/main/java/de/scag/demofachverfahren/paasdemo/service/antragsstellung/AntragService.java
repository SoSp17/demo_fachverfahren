package de.scag.demofachverfahren.paasdemo.service.antragsstellung;

import de.scag.demofachverfahren.paasdemo.model.antragsstellung.Antrag;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

public interface AntragService {
    List<Antrag> getAllAntraege();

    Optional<Antrag> getAntragById(long id);

    void stelleAntrag(Antrag antrag, Principal principal);
}
