package de.scag.demofachverfahren.paasdemo.servicekonto;

import org.junit.Rule;
import org.junit.Test;
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
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;


@RunWith(Theories.class)
public class ServiceKontoContentsPreparationServiceImplProblemCharsTest {
    @DataPoints
    public static char[] problemChars = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 11, 12, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
            27, 28, 29, 30, 31, 37, 38, 60, 62
    };
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @InjectMocks
    private ServiceKontoContentsPreparationServiceImpl classUnderTest;

    @Theory
    public void testPrepareForNachricht_InhaltMitSonderzeichenGegeben_SonnderzeichenSollteEntferntWerden(
            final char problemChar) throws Exception {
        // Vorbereitung

        // Ausführung
        final String preparedString = classUnderTest.prepareForNachricht(
                "pre" + problemChar + "post");

        // Prüfung
        assertThat(preparedString, is(equalTo("prepost")));
    }

    @Test
    public void testPrepareForNachricht_NullGegeben_SollteNullZurueckliefern() throws Exception {
        // Vorbereitung

        // Ausführung
        final String preparedString = classUnderTest.prepareForNachricht(null);

        // Prüfung
        assertThat(preparedString, is(nullValue()));
    }
}
