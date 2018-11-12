package de.scag.demofachverfahren.paasdemo.servicekonto;

import de.scag.demofachverfahren.paasdemo.model.nachrichten.Anlage;
import de.scag.demofachverfahren.paasdemo.model.nachrichten.Fachverfahren;
import de.scag.demofachverfahren.paasdemo.model.nachrichten.Nachricht;
import de.scag.demofachverfahren.paasdemo.service.ServiceKontoAdapterNachrichtAbgelehntException;
import de.scag.demofachverfahren.paasdemo.service.ServiceKontoAdapterTransformationException;
import de.scag.demofachverfahren.paasdemo.service.soap.SoapClientProviderService;
import de.scag.demofachverfahren.paasdemo.service.soap.SoapConfiguration;
import de.scag.demofachverfahren.paasdemo.service.soap.SoapConfigurationProviderService;
import de.scag.demofachverfahren.paasdemo.service.xml.JAXBService;
import de.scag.demofachverfahren.paasdemo.servicekonto.govgwasyncresponse.ArrayOfFileAttachment;
import de.scag.demofachverfahren.paasdemo.servicekonto.govgwasyncresponse.FileAttachment;
import de.scag.demofachverfahren.paasdemo.servicekonto.govgwasyncresponse.IGovGWAsyncResponse;
import de.scag.demofachverfahren.paasdemo.servicekonto.govgwasyncresponse.contentmodel.NachrichtInhalt;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.UserDataExtendedWebSoap;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.Userdata;
import org.apache.commons.codec.binary.Base64;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.ws.Holder;

import static de.scag.demofachverfahren.paasdemo.service.ServiceKontoAdapterNutzerdatenAbfrageExceptionMatcher.isServiceKontoAdapterNutzerdatenAbfrageException;
import static de.scag.demofachverfahren.paasdemo.service.ServiceKontoAdapterSoapConnectionExceptionMatcher.isServiceKontoAdapterSoapConnectionException;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


public class ServiceKontoClientImplTest {
    private static final String DEFAULT_PREIS = "0";

    private static final QName ATTATCHMENT_QNAME =
            new QName("http://schemas.datacontract.org/2004/07/GovGWAsyncResponse", "BBinaryData");
    private static final QName FILENAME_QNAME =
            new QName("http://schemas.datacontract.org/2004/07/GovGWAsyncResponse", "StrFilename");
    private final Fachverfahren fachverfahren = new Fachverfahren().setExterneFachdienstId(1337)
            .setPrivateKeystorePasswort(
                    "keyStorePassword"
                            .toCharArray())
            .setKeystoreInBase64(
                    Base64.encodeBase64String(
                            "keyStore".getBytes()));
    private final Nachricht nachricht = new Nachricht().setExterneEmpfaengerId(42L).setId(12L)
            .setFachverfahren(fachverfahren)
            .setAbsendername("absenderName")
            .setInhalt("nachrichtInhaltUngefiltert")
            .setAnlagen(null);
    private final SoapConfiguration<IGovGWAsyncResponse> nachrichtenVersandConfiguration;
    private final SoapConfiguration<UserDataExtendedWebSoap> nutzerdatenAbfrageConfiguration;
    private final Answer<Void> successAnswerNachrichtenversand =
            invocation -> {
                final Holder<Boolean> successParam = invocation.getArgument(7);

                successParam.value = true;

                return null;
            };
    private final IGovGWAsyncResponse nachrichtClient = mock(IGovGWAsyncResponse.class);
    private final UserDataExtendedWebSoap nutzerdatenClient = mock(UserDataExtendedWebSoap.class);
    private final String gefilterterBetreff = "gefilterterBetreff";
    private final String gefilterterNachrichtInhalt = "gefilterterNachrichtInhalt";
    private final String gefilterterAbsendername = "gefilterterAbsendername";
    private final String xmlInhalt = "xmlInhalt";
    private final String token = "token";
    private final String xmlUserData = "xmlUserData";
    private final Userdata nutzerdaten = new Userdata();
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @Rule
    public ExpectedException exception = ExpectedException.none();
    @InjectMocks
    private ServiceKontoClientImpl classUnderTest;
    @Mock
    private ServiceKontoContentsPreparationService serviceKontoContentsPreparationService;
    @Mock
    private SoapClientProviderService soapClientProviderService;
    @Mock
    private SoapConfigurationProviderService soapConfigurationProviderService;
    @Captor
    private ArgumentCaptor<ArrayOfFileAttachment> arrayOfFileAttachmentCaptor;
    @Mock
    private JAXBService jaxbService;

    @Mock
    private Logger logger;

    public ServiceKontoClientImplTest() {
        try {
            nachrichtenVersandConfiguration =
                    new SoapConfiguration<>(fachverfahren.getKeystore(),
                            fachverfahren.getPrivateKeystorePasswort(),
                            IGovGWAsyncResponse.class,
                            "localPart",
                            new URL("file://url"),
                            "targetNamespace");

            nutzerdatenAbfrageConfiguration =
                    new SoapConfiguration<>(fachverfahren.getKeystore(),
                            fachverfahren.getPrivateKeystorePasswort(),
                            UserDataExtendedWebSoap.class,
                            "localPart",
                            new URL("file://url"),
                            "targetNamespace");
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetUserdata_ExistierendesFachverfahrenMitGueltigemTokenGegeben_NutzerdatenSolltenZurueckgegebenWerden()
            throws Exception {
        // Vorbereitung
        konfigurationFuerDenNutzerdatenabfrageWirdGeliefert();
        nutzerdatenWerdenErfolgreichAbgerufen();
        when(jaxbService.deserialize(xmlUserData, Userdata.class)).thenReturn(nutzerdaten);

        // Ausführung
        final Userdata returnedNutzdaten = classUnderTest.getUserdata(token);

        // Prüfung
        assertThat(returnedNutzdaten, is(sameInstance(nutzerdaten)));
    }

    @Test
    public void testGetUserdata_KeyManagerFehler_FehlerSoltleEntsprechendWeitergeleitetWerden()
            throws Exception {
        // Vorbereitung
        konfigurationFuerDenNutzerdatenabfrageWirdGeliefert();

        final Exception cause = new KeyManagementException();
        when(soapClientProviderService.getClientFor(nutzerdatenAbfrageConfiguration)).thenThrow(
                cause);

        // Prüfung
        exception.expect(
                isServiceKontoAdapterSoapConnectionException().withMessage(
                        "Fehler bei der SSL-Kontext-Initialisierung").withCause(is(sameInstance(cause))));

        // Ausführung
        classUnderTest.getUserdata(token);
    }

    @Test
    public void testGetUserdata_UnrecoverableKeyFehler_FehlerSoltleEntsprechendWeitergeleitetWerden()
            throws Exception {
        // Vorbereitung
        konfigurationFuerDenNutzerdatenabfrageWirdGeliefert();

        final Exception cause = new UnrecoverableKeyException();
        when(soapClientProviderService.getClientFor(nutzerdatenAbfrageConfiguration)).thenThrow(
                cause);

        // Prüfung
        exception.expect(
                isServiceKontoAdapterSoapConnectionException().withMessage(
                        "Fehler beim Laden des Keystores").withCause(is(sameInstance(cause))));

        // Ausführung
        classUnderTest.getUserdata(token);
    }

    @Test
    public void testGetUserdata_KeyStoreFehler_FehlerSoltleEntsprechendWeitergeleitetWerden()
            throws Exception {
        // Vorbereitung
        konfigurationFuerDenNutzerdatenabfrageWirdGeliefert();

        final Exception cause = new KeyStoreException();
        when(soapClientProviderService.getClientFor(nutzerdatenAbfrageConfiguration)).thenThrow(
                cause);

        // Prüfung
        exception.expect(
                isServiceKontoAdapterSoapConnectionException().withMessage(
                        "Fehler bei der Initialisierung des Key Stores").withCause(
                        is(sameInstance(cause))));

        // Ausführung
        classUnderTest.getUserdata(token);
    }

    @Test
    public void testGetUserdata_NoSuchAlgorithmFehler_FehlerSoltleEntsprechendWeitergeleitetWerden()
            throws Exception {
        // Vorbereitung
        konfigurationFuerDenNutzerdatenabfrageWirdGeliefert();

        final Exception cause = new NoSuchAlgorithmException();
        when(soapClientProviderService.getClientFor(nutzerdatenAbfrageConfiguration)).thenThrow(
                cause);

        // Prüfung
        exception.expect(
                isServiceKontoAdapterSoapConnectionException().withMessage(
                        "Kann nötigen Algorithmus nicht finden").withCause(is(sameInstance(cause))));

        // Ausführung
        classUnderTest.getUserdata(token);
    }

    @Test
    public void testGetUserdata_CertificateFehler_FehlerSoltleEntsprechendWeitergeleitetWerden()
            throws Exception {
        // Vorbereitung
        konfigurationFuerDenNutzerdatenabfrageWirdGeliefert();

        final Exception cause = new CertificateException();
        when(soapClientProviderService.getClientFor(nutzerdatenAbfrageConfiguration)).thenThrow(
                cause);

        // Prüfung
        exception.expect(
                isServiceKontoAdapterSoapConnectionException().withMessage("Zertifikatsfehler")
                        .withCause(is(sameInstance(cause))));

        // Ausführung
        classUnderTest.getUserdata(token);
    }

    @Test
    public void testGetUserdata_IOFehler_FehlerSoltleEntsprechendWeitergeleitetWerden()
            throws Exception {
        // Vorbereitung
        konfigurationFuerDenNutzerdatenabfrageWirdGeliefert();

        final Exception cause = new IOException();
        when(soapClientProviderService.getClientFor(nutzerdatenAbfrageConfiguration)).thenThrow(
                cause);

        // Prüfung
        exception.expect(
                isServiceKontoAdapterSoapConnectionException().withMessage(
                        "Fehler beim Zertifikatszugriff").withCause(is(sameInstance(cause))));

        // Ausführung
        classUnderTest.getUserdata(token);
    }

    private void nutzerdatenWerdenErfolgreichAbgerufen() {
        final Answer<Void> successAnswerNutzerdatenAbfrage = NutzerdatenAnswer.builder()
                .withFehlercode(
                        ServiceKontoClient.NutzerdatenabfrageFehlerart.OK).withXmlUserData(xmlUserData).build();
        doAnswer(successAnswerNutzerdatenAbfrage).when(nutzerdatenClient).getUserData(eq(token),
                any(Holder.class),
                any(Holder.class));
    }

    @Test
    public void testGetUserdata_AblehnungDerAnfrageErhalten_SollteEntsprechendeExceptionWerfen()
            throws Exception {
        // Vorbereitung
        konfigurationFuerDenNutzerdatenabfrageWirdGeliefert();

        final Answer<Void> successAnswerNutzerdatenAbfrage = NutzerdatenAnswer.builder()
                .withFehlercode(
                        ServiceKontoClient.NutzerdatenabfrageFehlerart.WS_ERROR).withXmlUserData(xmlUserData).build();
        doAnswer(successAnswerNutzerdatenAbfrage).when(nutzerdatenClient).getUserData(eq(token),
                any(Holder.class),
                any(Holder.class));

        // Prüfung
        exception.expect(
                isServiceKontoAdapterNutzerdatenAbfrageException().withFehlerart(
                        ServiceKontoClient.NutzerdatenabfrageFehlerart.WS_ERROR));

        // Ausführung
        classUnderTest.getUserdata(token);
    }


    @Test
    public void testGetUserdata_UngueltigesXmlVomServicekontoBerlinGegeben_SollteEntsprechendeExceptionWerfen()
            throws Exception {
        // Vorbereitung

        konfigurationFuerDenNutzerdatenabfrageWirdGeliefert();
        nutzerdatenWerdenErfolgreichAbgerufen();
        doThrow(ServiceKontoAdapterTransformationException.class).when(jaxbService).deserialize(
                anyString(),
                eq(Userdata.class));

        // Prüfung
        exception.expect(ServiceKontoAdapterTransformationException.class);

        // Ausführung
        classUnderTest.getUserdata(token);
    }

    private void konfigurationFuerDenNutzerdatenabfrageWirdGeliefert() throws Exception {
        configServiceLiefertKonfigurationFuerNutzerdatenabfrage();
        when(soapClientProviderService.getClientFor(nutzerdatenAbfrageConfiguration)).thenReturn(
                nutzerdatenClient);
    }

    private void configServiceLiefertKonfigurationFuerNutzerdatenabfrage() throws Exception {
        when(soapConfigurationProviderService.getNutzerdatenAbfrageConfigurationFor())
                .thenReturn(nutzerdatenAbfrageConfiguration);
    }

    @Test
    public void testSend_VersandbereiteNachrichtOhneAnhaengeGegeben_SollteNachrichtMitAllenNoetigenInformationenVerwenden()
            throws Exception {
        // Vorbereitung
        nachricht.setAnlagen(null);

        konfigurationFuerDenNachrichtenversandWirdGeliefert();
        problemzeichenWerdenGefiltert();
        nachrichtWirdSerialisiert();

        doAnswer(successAnswerNachrichtenversand).when(nachrichtClient)
                .setQueryResultWithPriceAndAttachments(
                        eq(nachricht.getExterneNachrichtenId()),
                        eq(DEFAULT_PREIS),
                        eq(nachricht.getExterneEmpfaengerId()),
                        eq(fachverfahren.getExterneFachdienstId()),
                        eq(gefilterterBetreff),
                        eq(xmlInhalt),
                        any(ArrayOfFileAttachment.class),
                        any(Holder.class),
                        any(Holder.class));

        // Ausführung
        classUnderTest.send(nachricht);

        // Prüfung
        verify(nachrichtClient).setQueryResultWithPriceAndAttachments(
                eq(nachricht.getExterneNachrichtenId()),
                eq(DEFAULT_PREIS),
                eq(nachricht.getExterneEmpfaengerId()),
                eq(fachverfahren.getExterneFachdienstId()),
                eq(gefilterterBetreff),
                eq(xmlInhalt),
                any(ArrayOfFileAttachment.class),
                any(Holder.class),
                any(Holder.class));
    }

    private void nachrichtWirdSerialisiert() throws Exception {
        final NachrichtInhalt nachrichtInhalt = new NachrichtInhalt().setAbsender(
                gefilterterAbsendername).setText(gefilterterNachrichtInhalt);
        doReturn(xmlInhalt).when(jaxbService).serialize(nachrichtInhalt);
    }

    @Test
    public void testSend_GegebeneNachrichtWirdAbgelehnt_ExceptionMitAblehnungsinformationenSollteGeworfenWerden()
            throws Exception {
        // Vorbereitung
        final String nachrichtAblehnung = "wir hatten keine Lust Ihre Nachricht zu verarbeiten";
        konfigurationFuerDenNachrichtenversandWirdGeliefert();
        problemzeichenWerdenGefiltert();
        nachrichtWirdSerialisiert();

        doAnswer((Answer<Void>) invocation -> {
            final Holder<Boolean> successParam =
                    invocation.getArgument(7);

            successParam.value = false;

            final Holder<String> ablehnungsHolder =
                    invocation.getArgument(8);
            ablehnungsHolder.value = nachrichtAblehnung;

            return null;
        }).when(nachrichtClient)
                .setQueryResultWithPriceAndAttachments(
                        eq(nachricht.getExterneNachrichtenId()),
                        eq(DEFAULT_PREIS),
                        eq(nachricht.getExterneEmpfaengerId()),
                        eq(fachverfahren.getExterneFachdienstId()),
                        eq(gefilterterBetreff),
                        eq(xmlInhalt),
                        any(ArrayOfFileAttachment.class),
                        any(Holder.class),
                        any(Holder.class));

        // Prüfung
        exception.expect(ServiceKontoAdapterNachrichtAbgelehntException.class);
        exception.expectMessage(is(equalTo(nachrichtAblehnung)));

        // Ausführung
        classUnderTest.send(nachricht);
    }

    @Test
    public void testSend_KeyManagementFehler_FehlerSollteEntsprechendWeitergeleitetWerden()
            throws Exception {
        // Vorbereitung
        problemzeichenWerdenGefiltert();
        configServiceLiefertKonfigurationFuerNachrichtenversand();

        final Exception cause = new KeyManagementException();
        when(soapClientProviderService.getClientFor(nachrichtenVersandConfiguration)).thenThrow(
                cause);

        // Prüfung
        exception.expect(
                isServiceKontoAdapterSoapConnectionException().withMessage(
                        "Fehler bei der SSL-Kontext-Initialisierung").withCause(is(sameInstance(cause))));

        // Ausführung
        classUnderTest.send(nachricht);
    }

    @Test
    public void testSend_UnrecoverableKeyFehler_FehlerSollteEntsprechendWeitergeleitetWerden()
            throws Exception {
        // Vorbereitung
        problemzeichenWerdenGefiltert();
        configServiceLiefertKonfigurationFuerNachrichtenversand();

        final Exception cause = new UnrecoverableKeyException();
        when(soapClientProviderService.getClientFor(nachrichtenVersandConfiguration)).thenThrow(
                cause);

        // Prüfung
        exception.expect(
                isServiceKontoAdapterSoapConnectionException().withMessage(
                        "Fehler beim Laden des Keystores").withCause(is(sameInstance(cause))));

        // Ausführung
        classUnderTest.send(nachricht);
    }

    @Test
    public void testSend_KeyStoreFehler_FehlerSollteEntsprechendWeitergeleitetWerden()
            throws Exception {
        // Vorbereitung
        problemzeichenWerdenGefiltert();
        configServiceLiefertKonfigurationFuerNachrichtenversand();

        final Exception cause = new KeyStoreException();
        when(soapClientProviderService.getClientFor(nachrichtenVersandConfiguration)).thenThrow(
                cause);

        // Prüfung
        exception.expect(
                isServiceKontoAdapterSoapConnectionException().withMessage(
                        "Fehler bei der Initialisierung des Key Stores").withCause(
                        is(sameInstance(cause))));

        // Ausführung
        classUnderTest.send(nachricht);
    }

    @Test
    public void testSend_NoSuchAlgorithmFehler_FehlerSollteEntsprechendWeitergeleitetWerden()
            throws Exception {
        // Vorbereitung
        problemzeichenWerdenGefiltert();
        configServiceLiefertKonfigurationFuerNachrichtenversand();

        final Exception cause = new NoSuchAlgorithmException();
        when(soapClientProviderService.getClientFor(nachrichtenVersandConfiguration)).thenThrow(
                cause);

        // Prüfung
        exception.expect(
                isServiceKontoAdapterSoapConnectionException().withMessage(
                        "Kann nötigen Algorithmus nicht finden").withCause(is(sameInstance(cause))));

        // Ausführung
        classUnderTest.send(nachricht);
    }

    @Test
    public void testSend_CertificateFehler_FehlerSollteEntsprechendWeitergeleitetWerden()
            throws Exception {
        // Vorbereitung
        problemzeichenWerdenGefiltert();
        configServiceLiefertKonfigurationFuerNachrichtenversand();

        final Exception cause = new CertificateException();
        when(soapClientProviderService.getClientFor(nachrichtenVersandConfiguration)).thenThrow(
                cause);

        // Prüfung
        exception.expect(
                isServiceKontoAdapterSoapConnectionException().withMessage("Zertifikatsfehler")
                        .withCause(is(sameInstance(cause))));

        // Ausführung
        classUnderTest.send(nachricht);
    }

    @Test
    public void testSend_IOFehler_FehlerSollteEntsprechendWeitergeleitetWerden() throws Exception {
        // Vorbereitung
        problemzeichenWerdenGefiltert();
        configServiceLiefertKonfigurationFuerNachrichtenversand();

        final Exception cause = new IOException();
        when(soapClientProviderService.getClientFor(nachrichtenVersandConfiguration)).thenThrow(
                cause);

        // Prüfung
        exception.expect(
                isServiceKontoAdapterSoapConnectionException().withMessage(
                        "Fehler beim Zertifikatszugriff").withCause(is(sameInstance(cause))));

        // Ausführung
        classUnderTest.send(nachricht);
    }

    private void problemzeichenWerdenGefiltert() {
        problemzeichenWerdenAusDemBetreffGefiltert();
        problemzeichenWerdenAusDemInhaltGefiltert();
        problemzeichenWerdenAusDemAbsendernamenGefiltert();
    }

    @Test
    public void testSend_VersandbereiteNachrichtMitAnhaengeGegeben_AnhaengeSolltenImErgebnisVorkommen()
            throws Exception {
        // Vorbereitung
        final byte[] dateiInhalt = "inhalt".getBytes();
        final String dateiname = "dateiname";
        final Anlage anlage = new Anlage().setDateiname(dateiname).setInhalt(dateiInhalt);
        final List<Anlage> anlagen = Collections.singletonList(anlage);
        nachricht.setAnlagen(anlagen);

        konfigurationFuerDenNachrichtenversandWirdGeliefert();
        problemzeichenWerdenGefiltert();
        nachrichtWirdSerialisiert();

        doAnswer(successAnswerNachrichtenversand).when(nachrichtClient)
                .setQueryResultWithPriceAndAttachments(
                        eq(nachricht.getExterneNachrichtenId()),
                        eq(DEFAULT_PREIS),
                        eq(nachricht.getExterneEmpfaengerId()),
                        eq(fachverfahren.getExterneFachdienstId()),
                        eq(gefilterterBetreff),
                        eq(xmlInhalt),
                        any(ArrayOfFileAttachment.class),
                        any(Holder.class),
                        any(Holder.class));

        // Ausführung
        classUnderTest.send(nachricht);

        // Prüfung
        verify(nachrichtClient).setQueryResultWithPriceAndAttachments(
                eq(nachricht.getExterneNachrichtenId()),
                eq(DEFAULT_PREIS),
                eq(nachricht.getExterneEmpfaengerId()),
                eq(fachverfahren.getExterneFachdienstId()),
                eq(gefilterterBetreff),
                eq(xmlInhalt),
                arrayOfFileAttachmentCaptor.capture(),
                any(Holder.class),
                any(Holder.class));

        final List<FileAttachment> fileAttachments = arrayOfFileAttachmentCaptor
                .getValue().getFileAttachment();

        assertThat(fileAttachments, hasSize(1));

        assertThat(fileAttachments.get(0).getStrFilename(),
                is(samePropertyValuesAs(
                        new JAXBElement<>(FILENAME_QNAME, String.class, dateiname))));
        assertThat(fileAttachments.get(0).getBBinaryData(),
                is(samePropertyValuesAs(
                        new JAXBElement<>(ATTATCHMENT_QNAME, byte[].class, dateiInhalt))));
    }

    private void konfigurationFuerDenNachrichtenversandWirdGeliefert() throws Exception {
        configServiceLiefertKonfigurationFuerNachrichtenversand();
        when(soapClientProviderService.getClientFor(nachrichtenVersandConfiguration)).thenReturn(
                nachrichtClient);
    }

    private void configServiceLiefertKonfigurationFuerNachrichtenversand() throws Exception {
        when(soapConfigurationProviderService.getNachrichtenVersandConfigurationFor())
                .thenReturn(nachrichtenVersandConfiguration);
    }

    private void problemzeichenWerdenAusDemAbsendernamenGefiltert() {
        doReturn(gefilterterAbsendername).when(serviceKontoContentsPreparationService)
                .prepareForNachricht(nachricht.getAbsendername());
    }

    private void problemzeichenWerdenAusDemInhaltGefiltert() {
        doReturn(gefilterterNachrichtInhalt).when(serviceKontoContentsPreparationService)
                .prepareForNachricht(nachricht.getInhalt());
    }

    private void problemzeichenWerdenAusDemBetreffGefiltert() {
        doReturn(gefilterterBetreff).when(serviceKontoContentsPreparationService)
                .prepareForNachricht(nachricht.getBetreff());
    }
}
