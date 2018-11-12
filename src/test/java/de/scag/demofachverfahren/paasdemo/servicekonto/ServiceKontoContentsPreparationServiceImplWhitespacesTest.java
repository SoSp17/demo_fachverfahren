package de.scag.demofachverfahren.paasdemo.servicekonto;

import org.junit.Rule;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@RunWith(Theories.class)
public class ServiceKontoContentsPreparationServiceImplWhitespacesTest {
    @DataPoints
    public static char[] whiteSpaces = {' ', '\t', '\r', '\n'};
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @InjectMocks
    private ServiceKontoContentsPreparationServiceImpl classUnderTest;

    @Theory
    public void testPrepareForNachricht_InhaltMitEinemWhitespaceGegeben_WhiteSpaceSollteInLeerzeichenUmgewandeltWerden(
            final char whiteSpaceChar) throws Exception {
        // Vorbereitung

        // Ausführung
        final String preparedString = classUnderTest.prepareForNachricht(
                "pre" + whiteSpaceChar + "mid" + whiteSpaceChar + "post");

        // Prüfung
        assertThat(preparedString, is(equalTo("pre mid post")));
    }

    @Theory
    public void testPrepareForNachricht_InhaltMitMehrerenGleichenWhitespacesGegeben_WhiteSpaceSollteInLeerzeichenUmgewandeltWerden(
            final char whiteSpaceChar) throws Exception {
        // Vorbereitung

        // Ausführung
        final String preparedString = classUnderTest.prepareForNachricht(
                "pre" + whiteSpaceChar + whiteSpaceChar + "mid" + whiteSpaceChar + whiteSpaceChar +
                        "post");

        // Prüfung
        assertThat(preparedString, is(equalTo("pre mid post")));
    }

    @Theory
    public void testPrepareForNachricht_InhaltMitMehrerenUnterschiedlichenWhitespacesGegeben_WhiteSpaceSollteInLeerzeichenUmgewandeltWerden(
            final char whiteSpaceChar1,
            final char whiteSpaceChar2) throws Exception {
        // Vorbereitung

        // Ausführung
        final String preparedString = classUnderTest.prepareForNachricht(
                "pre" + whiteSpaceChar1 + whiteSpaceChar2 + "mid" + whiteSpaceChar1 +
                        whiteSpaceChar2 + "post");

        // Prüfung
        assertThat(preparedString, is(equalTo("pre mid post")));
    }
}
