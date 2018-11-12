package de.scag.demofachverfahren.paasdemo.test.acceptance.auth;

import de.scag.demofachverfahren.paasdemo.servicekonto.ServicekontoConfiguration;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginEndToEndIT {
    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();
    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ServicekontoConfiguration servicekontoConfiguration;

    @Test
    public void testLogin_AufrufBeliebigerUrlOhneEingeloggtZuSein_SollteWeiterleitungZumServicekontoMitRuecksprungUrlDurchfuehrne()
            throws Exception {
        // Preparation

        // Execution
        mockMvc.perform(get("/antraege"))
                // Assertion
                .andExpect(redirectedUrl(servicekontoConfiguration.getLoginUrl()));
    }
}
