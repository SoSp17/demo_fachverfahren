/*
 * JSonHelper.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.test.utils.util;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


/**
 * Hilfsklasse für JSon.
 *
 * @author mertinat
 * @since 26.04.2017
 */
public final class JSonHelper {
    private JSonHelper() {
        // Helper
    }

    /**
     * Serialisiert ein Objekt ins Format JSon.
     *
     * @param obj
     * @return
     * @throws IOException
     * @throws JsonGenerationException
     * @throws JsonMappingException
     */
    public static String jsonOf(final Object obj) throws IOException, JsonGenerationException,
            JsonMappingException {
        final ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(obj);
    }

    /**
     * Deserialisiert ein JSon String zum Java Objekt.
     *
     * @param json the json
     * @return the string
     * @throws IOException             Signals that an I/O exception has
     *                                 occurred.
     * @throws JsonGenerationException the json generation exception
     * @throws JsonMappingException    the json mapping exception
     */
    public static <T> T objectOfJson(final String json, final Class<T> type) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(json, type);
    }

    /**
     * Serialisiert ein Objekt ins Format JSon in Form eines UTF-8 codierten
     * Bytearrays.
     *
     * @param obj
     * @return
     * @throws UnsupportedEncodingException
     * @throws IOException
     * @throws JsonGenerationException
     * @throws JsonMappingException
     */
    public static byte[] jsonUtf8Bytes(final Object obj) throws Exception {
        return jsonOf(obj).getBytes("UTF-8");
    }

    public static <T> List<T> objectListOfJson(final String contentString, final Class<T> type)
            throws Exception {
        final ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(contentString,
                TypeFactory.defaultInstance().constructCollectionType(List.class, type));
    }
}
