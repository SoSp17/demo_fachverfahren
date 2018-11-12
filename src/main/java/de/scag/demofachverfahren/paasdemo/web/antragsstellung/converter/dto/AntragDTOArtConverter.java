package de.scag.demofachverfahren.paasdemo.web.antragsstellung.converter.dto;

import de.scag.demofachverfahren.paasdemo.model.antragsstellung.Antrag;
import de.scag.demofachverfahren.paasdemo.service.ServiceKontoAdapterRuntimeException;
import de.scag.demofachverfahren.paasdemo.web.antragsstellung.AntragDTO;
import org.springframework.stereotype.Service;

@Service
public class AntragDTOArtConverter {

    AntragDTO.Art convert(final Antrag.Art art) {
        if (art == null) {
            return null;
        }
        switch (art) {
            case KITA:
                return AntragDTO.Art.KITA;
            case EFOEB:
                return AntragDTO.Art.EFOEB;
            case SPRACHSTAND:
                return AntragDTO.Art.SPRACHSTAND;
            default:
                throw new ServiceKontoAdapterRuntimeException("Unbekannte Art: " + art);
        }
    }
}