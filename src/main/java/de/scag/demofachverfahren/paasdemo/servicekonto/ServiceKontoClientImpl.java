/*
 * ServiceKontoClientImpl.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.servicekonto;

import de.scag.demofachverfahren.paasdemo.model.nachrichten.Fachverfahren;
import de.scag.demofachverfahren.paasdemo.model.nachrichten.Nachricht;
import de.scag.demofachverfahren.paasdemo.service.*;
import de.scag.demofachverfahren.paasdemo.service.soap.SoapClientProviderService;
import de.scag.demofachverfahren.paasdemo.service.soap.SoapConfiguration;
import de.scag.demofachverfahren.paasdemo.service.soap.SoapConfigurationProviderService;
import de.scag.demofachverfahren.paasdemo.service.xml.JAXBService;
import de.scag.demofachverfahren.paasdemo.service.xml.ServiceKontoAdapterSerialisierungsException;
import de.scag.demofachverfahren.paasdemo.servicekonto.govgwasyncresponse.ArrayOfFileAttachment;
import de.scag.demofachverfahren.paasdemo.servicekonto.govgwasyncresponse.FileAttachment;
import de.scag.demofachverfahren.paasdemo.servicekonto.govgwasyncresponse.IGovGWAsyncResponse;
import de.scag.demofachverfahren.paasdemo.servicekonto.govgwasyncresponse.contentmodel.NachrichtInhalt;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.UserDataExtendedWebSoap;
import de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel.Userdata;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.ws.Holder;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Collection;


/**
 * The Class ServiceKontoClientImpl.
 */
@Service
@RequiredArgsConstructor
public class ServiceKontoClientImpl implements ServiceKontoClient {
    private static final QName ATTATCHMENT_QNAME =
            new QName("http://schemas.datacontract.org/2004/07/GovGWAsyncResponse", "BBinaryData");
    private static final QName FILENAME_QNAME =
            new QName("http://schemas.datacontract.org/2004/07/GovGWAsyncResponse", "StrFilename");
    private static final String PRICE = "0";

    private final JAXBService jaxbService;
    private final ServiceKontoContentsPreparationService serviceKontoContentsPreparationService;
    private final SoapClientProviderService soapClientProviderService;
    private final SoapConfigurationProviderService soapConfigurationProviderService;
    private final Logger log;
    /*
     * (non-Javadoc)
     *
     * @see de.verwalt_berlin.senbjw.isbj.servicekonto.service.ServiceKontoClient#
     * send(de.verwalt_berlin.senbjw.isbj.servicekonto.model.Nachricht)
     */
    @Override
    public synchronized void send(final Nachricht nachricht)
            throws ServiceKontoAdapterException {
        final ArrayOfFileAttachment attatchments = extractAttatchmentsFrom(nachricht);

        final String content = extractContentFrom(nachricht);

        final Holder<Boolean> success = new Holder<>();
        final Holder<String> errorMessage = new Holder<>();

        final IGovGWAsyncResponse nachrichtClient;

        final SoapConfiguration<IGovGWAsyncResponse> configuration =
                nachrichtVersandConfigurationFor();

        nachrichtClient = getClientFor(configuration);

        final Fachverfahren fachdienst = nachricht.getFachverfahren();
        nachrichtClient.setQueryResultWithPriceAndAttachments(nachricht.getExterneNachrichtenId(),
                PRICE,
                nachricht.getExterneEmpfaengerId(),
                fachdienst.getExterneFachdienstId(),
                serviceKontoContentsPreparationService.prepareForNachricht(nachricht.getBetreff()),
                content,
                attatchments,
                success,
                errorMessage);

        if (!success.value) {
            throw new ServiceKontoAdapterNachrichtAbgelehntException(errorMessage.value);
        }
    }

    private SoapConfiguration<IGovGWAsyncResponse> nachrichtVersandConfigurationFor() throws ServiceKontoConfigServiceException {
        return soapConfigurationProviderService.getNachrichtenVersandConfigurationFor(
        );
    }

    private SoapConfiguration<UserDataExtendedWebSoap> nutzerdatenAbfrageConfigurationFor() throws ServiceKontoConfigServiceException {
        return soapConfigurationProviderService.getNutzerdatenAbfrageConfigurationFor(
        );
    }

    private String extractContentFrom(final Nachricht nachricht)
            throws ServiceKontoAdapterSerialisierungsException {
        return jaxbService.serialize(
                new NachrichtInhalt().setAbsender(
                        serviceKontoContentsPreparationService.prepareForNachricht(
                                nachricht.getAbsendername())).setText(
                        serviceKontoContentsPreparationService.prepareForNachricht(
                                nachricht.getInhalt())));
    }

    private ArrayOfFileAttachment extractAttatchmentsFrom(final Nachricht nachricht) {
        final ArrayOfFileAttachment attatchments = new ArrayOfFileAttachment();

        final Collection<? extends FileAttachment> fileAttatchments = CollectionUtils.collect(
                nachricht.getAnlagen(),
                anlage -> {
                    final FileAttachment fileAttachment = new FileAttachment();

                    fileAttachment.setStrFilename(
                            new JAXBElement<>(FILENAME_QNAME,
                                    String.class,
                                    anlage.getDateiname()));

                    fileAttachment.setBBinaryData(
                            new JAXBElement<>(ATTATCHMENT_QNAME,
                                    byte[].class,
                                    anlage.getInhalt()));

                    return fileAttachment;
                });

        attatchments.getFileAttachment().addAll(fileAttatchments);

        return attatchments;
    }

    private String getUserdataXml(final String token)
            throws ServiceKontoAdapterException {
        final SoapConfiguration<UserDataExtendedWebSoap> configuration =
                nutzerdatenAbfrageConfigurationFor();

        final UserDataExtendedWebSoap nutzerdatenClient = getClientFor(configuration);

        final Holder<String> strXMLUserData = new Holder<>();
        final Holder<Integer> getUserDataResult = new Holder<>();
        nutzerdatenClient.getUserData(token, strXMLUserData, getUserDataResult);

        if (ServiceKontoClient.NutzerdatenabfrageFehlerart.getByFehlercode(
                getUserDataResult.value) != ServiceKontoClient.NutzerdatenabfrageFehlerart.OK) {
            throw new ServiceKontoAdapterNutzerdatenAbfrageException(getUserDataResult.value);
        }

        return strXMLUserData.value;
    }

    private <T> T getClientFor(final SoapConfiguration<T> configuration)
            throws ServiceKontoAdapterSoapConnectionException {
        try {
            return soapClientProviderService.getClientFor(configuration);
        } catch (final KeyManagementException e) {
            throw new ServiceKontoAdapterSoapConnectionException(
                    "Fehler bei der SSL-Kontext-Initialisierung",
                    e);
        } catch (final UnrecoverableKeyException e) {
            throw new ServiceKontoAdapterSoapConnectionException("Fehler beim Laden des Keystores",
                    e);
        } catch (final KeyStoreException e) {
            throw new ServiceKontoAdapterSoapConnectionException(
                    "Fehler bei der Initialisierung des Key Stores",
                    e);
        } catch (final NoSuchAlgorithmException e) {
            throw new ServiceKontoAdapterSoapConnectionException(
                    "Kann nötigen Algorithmus nicht finden",
                    e);
        } catch (final CertificateException e) {
            throw new ServiceKontoAdapterSoapConnectionException("Zertifikatsfehler", e);
        } catch (final IOException e) {
            throw new ServiceKontoAdapterSoapConnectionException("Fehler beim Zertifikatszugriff",
                    e);
        }
    }

    @Override
    public synchronized Userdata getUserdata(final String token)
            throws ServiceKontoAdapterException {
        final String xml = getUserdataXml(token);

        try {
            return jaxbService.deserialize(xml, Userdata.class);
        } catch (final ServiceKontoAdapterTransformationException e) {
            log.error("Fehler bei der Deserialisierung des Typs " + Userdata.class, e);
            throw new ServiceKontoAdapterTransformationException(
                    "Fehler bei der Deserialisierung des Typs " + Userdata.class,
                    e);
        }
    }
}
