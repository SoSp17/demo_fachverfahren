/*
 * JAXBService.java
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


/**
 * Service zum Umgang mit JaxB.
 *
 * @author mertinat
 * @since 02.06.2017
 */
public interface JAXBService {
    /**
     * Deserialisiert ein XMLString zum angegebenen Typen.
     *
     * @param <T>  the generic type
     * @param xml  the xml
     * @param type the type
     * @return the t
     */
    <T> T deserialize(final String xml, final Class<T> type)
            throws ServiceKontoAdapterTransformationException;

    /**
     * Serialisiert ein mit JaxB Serialisierbares Objekt.
     *
     * @param <T>                  the generic type
     * @param serializableInstance the serializable instance
     * @return the string
     */
    <T> String serialize(T serializableInstance) throws ServiceKontoAdapterSerialisierungsException;
}
