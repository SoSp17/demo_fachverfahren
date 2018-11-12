package de.scag.demofachverfahren.paasdemo.web.login;

import de.scag.demofachverfahren.paasdemo.service.benutzerdaten.BenutzerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final CustomRemembermeService customRemembermeService;
    private final BenutzerService benutzerService;

    @GetMapping("/login")
    public ModelAndView getLogin(final HttpServletRequest request, final HttpServletResponse response, @RequestParam("Token") final String token) {
        benutzerService.getByToken(token)
                .ifPresent(benutzer -> customRemembermeService.rememberUser(benutzer.getBenutzername(), response));

        return
                new ModelAndView("redirect:/antraege");
    }
}
