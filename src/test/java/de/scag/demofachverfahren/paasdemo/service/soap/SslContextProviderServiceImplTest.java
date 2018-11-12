package de.scag.demofachverfahren.paasdemo.service.soap;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import javax.net.ssl.SSLContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class SslContextProviderServiceImplTest {
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @InjectMocks
    private SslContextProviderServiceImpl classUnderTest;

    @Test
    public void testGetInstanceWithDefaultAlgorithm_Methodenaufruf_GibtEineInstanzImZuVerwendendenFormatZurueck()
            throws Exception {
        // Vorbereitung

        // Ausführung
        final SSLContext sslContext = classUnderTest.getInstanceTLS12();

        // Prüfung
        assertThat("SSL-Protokoll", sslContext.getProtocol(), is(equalTo("TLSv1.2")));
    }
}
