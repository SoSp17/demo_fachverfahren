package de.scag.demofachverfahren.paasdemo.web.antragsstellung.converter.model;

import de.scag.demofachverfahren.paasdemo.model.antragsstellung.Antrag;
import de.scag.demofachverfahren.paasdemo.service.ServiceKontoAdapterRuntimeException;
import de.scag.demofachverfahren.paasdemo.web.antragsstellung.AntragDTO;
import org.springframework.stereotype.Service;

@Service
public class AntragArtConverter {

    public Antrag.Art convert(final AntragDTO.Art art) {
        if (art == null) {
            return null;
        }
        switch (art) {
            case SPRACHSTAND:
                return Antrag.Art.SPRACHSTAND;
            case EFOEB:
                return Antrag.Art.EFOEB;
            case KITA:
                return Antrag.Art.KITA;
            default:
                throw new ServiceKontoAdapterRuntimeException("Unbekannte Art: " + art);
        }
    }
}