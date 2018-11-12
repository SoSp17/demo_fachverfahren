/*
 * JAXBServiceImpl.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.service.xml;

import de.scag.demofachverfahren.paasdemo.service.ServiceKontoAdapterTransformationException;
import de.scag.demofachverfahren.paasdemo.servicekonto.govgwasyncresponse.contentmodel.NachrichtInhalt;
import org.springframework.stereotype.Service;

import javax.xml.bind.*;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;


/**
 * The Class JAXBServiceImpl.
 *
 * @author mertinat
 * @since 02.06.2017
 */
@Service
public class JAXBServiceImpl implements JAXBService {
    private static final String FEHLERTEXT_PRAEFIX = "Fehler bei der Deserialisierung des Typs ";

    private static Marshaller marshaller;

    private static Marshaller getMarshaller() throws JAXBException {
        if (marshaller == null) {
            marshaller = JAXBContext.newInstance(NachrichtInhalt.class).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        }

        return marshaller;
    }

    /* (non-Javadoc)
     * @see de.verwalt_berlin.senbjw.isbj.servicekonto.service.JAXBService#deserialize(java.lang.String, java.lang.Class)
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T deserialize(final String xml, final Class<T> type)
            throws ServiceKontoAdapterTransformationException {
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance(type);
            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            final Reader reader = new StringReader(xml);

            return (T) unmarshaller.unmarshal(reader);
        } catch (final UnmarshalException e) {
            throw new ServiceKontoAdapterTransformationException(FEHLERTEXT_PRAEFIX + type, e);
        } catch (final JAXBException e) {
            throw new ServiceKontoAdapterTransformationException(FEHLERTEXT_PRAEFIX + type, e);
        }
    }

    @Override
    public <T> String serialize(final T serializableInstance)
            throws ServiceKontoAdapterSerialisierungsException {
        final StringWriter writer = new StringWriter();

        try {
            getMarshaller().marshal(serializableInstance, writer);
        } catch (final JAXBException e) {
            throw new ServiceKontoAdapterSerialisierungsException(
                    "Fehler bei der Deserialisierung von " + serializableInstance,
                    e);
        }

        return writer.toString();
    }
}
