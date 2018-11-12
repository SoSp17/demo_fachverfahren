package de.scag.demofachverfahren.paasdemo.web.antragsstellung.converter.dto;

import de.scag.demofachverfahren.paasdemo.model.antragsstellung.Antrag;
import de.scag.demofachverfahren.paasdemo.web.antragsstellung.AntragDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AntragDTOConverter {
    private final AntragDTOArtConverter antragDTOArtConverter;

    public AntragDTO convert(final Antrag antrag) {
        return new AntragDTO()
                .setAntragssteller(antrag.getAntragssteller())
                .setGueltigAb(antrag.getGueltig())
                .setArt(antragDTOArtConverter.convert(antrag.getArt()));
    }
}