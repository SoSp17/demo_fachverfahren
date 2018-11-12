package de.scag.demofachverfahren.paasdemo.web.antragsstellung.converter.model;

import de.scag.demofachverfahren.paasdemo.model.antragsstellung.Antrag;
import de.scag.demofachverfahren.paasdemo.web.antragsstellung.AntragDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AntragConverter {

    private final AntragArtConverter antragArtConverter;

    public Antrag convert(final AntragDTO antragDTO) {
        return new Antrag()
                .setAntragssteller(antragDTO.getAntragssteller())
                .setArt(antragArtConverter.convert(antragDTO.getArt()))
                .setGueltig(antragDTO.getGueltigAb());

    }

}