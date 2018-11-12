package de.scag.demofachverfahren.paasdemo.service.soap;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import java.security.KeyStore;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class KeyStoreProviderServiceImplTest {
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @InjectMocks
    private KeyStoreProviderServiceImpl classUnderTest;

    @Test
    public void testGetInstancePKCS12_Methodenaufruf_GibtEineInstanzImZuVerwendendenFormatZurueck()
            throws Exception {
        // Vorbereitung

        // Ausführung
        final KeyStore keyStore = classUnderTest.getInstancePKCS12();

        // Prüfung
        assertThat("keystore Typ", keyStore.getType(), is(equalTo("PKCS12")));
    }
}
