package de.scag.demofachverfahren.paasdemo.web.antragsstellung;

import de.scag.demofachverfahren.paasdemo.model.antragsstellung.Antrag;
import de.scag.demofachverfahren.paasdemo.service.antragsstellung.AntragService;
import de.scag.demofachverfahren.paasdemo.web.antragsstellung.converter.dto.AntragDTOConverter;
import de.scag.demofachverfahren.paasdemo.web.antragsstellung.converter.model.AntragConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author marmer
 * @since 14.09.2018
 */
@Controller
@RequestMapping("/antraege")
@RequiredArgsConstructor
public class AntragController {
    public static final String VIEW_ANTRAG = "antrag";
    public static final String MODEL_ANTRAG = "antrag";
    private final AntragService antragService;
    private final AntragDTOConverter antragDTOConverter;
    private final AntragConverter antragConverter;

    @GetMapping()
    public ModelAndView getAntraege(final HttpServletRequest request) {
        final List<AntragDTO> antraegeDTOs = antragService.getAllAntraege().stream().map(antragDTOConverter::convert).collect(Collectors.toList());
        return new ModelAndView("antraege", "antraegeDTOs", antraegeDTOs);
    }

    @GetMapping("/{id:[0-9]+}")
    public ModelAndView getAntraege(@PathVariable final long id, final HttpServletRequest request) {
        return antragService.getAntragById(id)
                .map(antragDTOConverter::convert)
                .map(antragDTO -> new ModelAndView(VIEW_ANTRAG, MODEL_ANTRAG, antragDTO))
                .orElse(getAntrag(request));
    }

    @GetMapping("/:neu")
    public ModelAndView getAntrag(final HttpServletRequest request) {

        return new ModelAndView(VIEW_ANTRAG, MODEL_ANTRAG, new AntragDTO());
    }

    @PostMapping
    public ModelAndView createAntrag(@ModelAttribute(MODEL_ANTRAG) final AntragDTO antrag, final HttpServletRequest request, final Principal principal) {
        final Antrag antragModel = antragConverter.convert(antrag);

        antragService.stelleAntrag(antragModel, principal);

        return getAntraege(request);
    }

}
