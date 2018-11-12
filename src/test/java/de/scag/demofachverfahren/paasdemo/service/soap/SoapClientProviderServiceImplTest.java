package de.scag.demofachverfahren.paasdemo.service.soap;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

import java.io.Serializable;
import java.net.URL;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class SoapClientProviderServiceImplTest {
    @Test
    public void testEquals_EqualsUeberschrieben_SollteEqualsKontractErfuellen() throws Exception {
        EqualsVerifier.forClass(SoapConfiguration.class)
                .withPrefabValues(URL.class, new URL("file://a"), new URL("file://b"))
                .suppress(Warning.STRICT_INHERITANCE).verify();
    }

    @Test
    public void testToString_Methodenaufruf_PasswortUndZertifikatSolltenNichtInToStringVorkommen()
            throws Exception {
        // Vorbereitung
        final byte[] keyStore = "keyStore".getBytes();
        final char[] keyStorePassword = "keyStorePassword".toCharArray();
        final Class<Serializable> portInterface = Serializable.class;
        final String localPart = "localPart";
        final URL url = new URL("file://a");
        final String targetNamespace = "targetNamespace";

        final SoapConfiguration<Serializable> classUnderTest = SoapConfiguration.builder(
                portInterface)
                .withKeyStore(
                        keyStore)
                .withKeyStorePassword(
                        keyStorePassword)
                .withLocalPart(
                        localPart)
                .withPortInterface(
                        portInterface).withTargetNamespace(targetNamespace).withUrl(url).build();

        // Ausführung

        // Prüfung
        assertThat(classUnderTest,
                hasToString(
                        is(allOf(not(containsString(keyStore.toString())),
                                not(containsString("keyStore")),
                                not(containsString(keyStorePassword.toString())),
                                not(containsString("keyStorePassword"))))));
    }

    @Test
    public void testBuilder_InitialisierungAllerWerteMitBuilder_SollteGleichDerKonstruktorInitialisierungSein()
            throws Exception {
        // Vorbereitung
        final byte[] keyStore = "keyStore".getBytes();
        final char[] keyStorePassword = "keyStorePassword".toCharArray();
        final Class<Serializable> portInterface = Serializable.class;
        final String localPart = "localPart";
        final URL url = new URL("file://a");
        final String targetNamespace = "targetNamespace";

        final SoapConfiguration<Serializable> classUnderTestInitializedWithConstructor =
                new SoapConfiguration<Serializable>(keyStore,
                        keyStorePassword,
                        portInterface,
                        localPart,
                        url,
                        targetNamespace);
        final SoapConfiguration<Serializable> classUnderTestInitializedWithBuilder =
                SoapConfiguration.builder(portInterface).withKeyStore(keyStore)
                        .withKeyStorePassword(keyStorePassword).withLocalPart(localPart)
                        .withTargetNamespace(targetNamespace).withPortInterface(portInterface)
                        .withUrl(url).build();

        // Ausführung

        // Prüfung
        assertThat(classUnderTestInitializedWithBuilder,
                is(equalTo(classUnderTestInitializedWithConstructor)));
    }
}
