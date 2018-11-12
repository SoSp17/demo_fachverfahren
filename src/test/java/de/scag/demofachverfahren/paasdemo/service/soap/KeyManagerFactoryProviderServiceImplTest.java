package de.scag.demofachverfahren.paasdemo.service.soap;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import javax.net.ssl.KeyManagerFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class KeyManagerFactoryProviderServiceImplTest {
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @InjectMocks
    private KeyManagerFactoryProviderServiceImpl classUnderTest;

    @Test
    public void testGetInstanceWithDefaultAlgorithm_Methodenaufruf_GibtEineInstanzImZuVerwendendenFormatZurueck()
            throws Exception {
        // Vorbereitung

        // Ausführung
        final KeyManagerFactory keyManagerFactory =
                classUnderTest.getInstanceWithDefaultAlgorithm();

        // Prüfung
        assertThat("Key Manager Algorithmus",
                keyManagerFactory.getAlgorithm(),
                is(equalTo(KeyManagerFactory.getDefaultAlgorithm())));
    }
}
