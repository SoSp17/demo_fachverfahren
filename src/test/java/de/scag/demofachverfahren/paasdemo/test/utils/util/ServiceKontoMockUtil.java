/*
 * ServiceKontoAdapterMockUtil.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.test.utils.util;


import de.scag.demofachverfahren.paasdemo.test.utils.util.servicekontomock.dtos.NachrichtenListeMockDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public final class ServiceKontoMockUtil {
    public static final int GUELTIGE_EXTERNE_FACHVERFAHREN_ID_IM_SERVICE_KONTO_MOCK = 42;
    public static final int UNGUELTIGE_EXTERNE_FACHVERFAHREN_ID_IM_SERVICE_KONTO_MOCK = 99999;
    public static final String SERVICE_KONTO_MOCK_BASE_URL =
            "http://docker-host1:9080/api/nachrichten/";

    private ServiceKontoMockUtil() {
        // util class
    }

    public static boolean isAllreadyInUse(final Long id) throws Exception {
        final List<String> ids = loadMockUsedNachrichtenIds();

        return ids.contains(id.toString());
    }

    public static List<String> loadMockUsedNachrichtenIds() throws
            Exception {
        final NachrichtenListeMockDTO nachrichtenListe = loadMockNachrichtenListe();

        final List<NachrichtenListeMockDTO.NachrichtMockDTO> nachrichten =
                nachrichtenListe.nachrichten;

        return CollectionUtils.collect(nachrichten,
                new Transformer<NachrichtenListeMockDTO.NachrichtMockDTO, String>() {
                    @Override
                    public String transform(
                            final NachrichtenListeMockDTO.NachrichtMockDTO nachricht) {
                        return nachricht.id;
                    }
                },
                new ArrayList<String>(CollectionUtils.size(nachrichten)));
    }

    public static void deleteNachricht(final String externeId) throws
            Exception {
        final CloseableHttpClient client = HttpClientBuilder.create().build();
        final HttpDelete delete = new HttpDelete(SERVICE_KONTO_MOCK_BASE_URL + externeId);
        client.execute(delete);
    }

    public static NachrichtenListeMockDTO.NachrichtMockDTO loadMockNachricht(final String externeId) throws
            Exception {
        final CloseableHttpClient client = HttpClientBuilder.create().build();
        final HttpGet get = new HttpGet(SERVICE_KONTO_MOCK_BASE_URL + externeId);
        final CloseableHttpResponse response = client.execute(get);
        final InputStream contentStream = response.getEntity().getContent();

        if (response.getStatusLine().getStatusCode() == 200) {
            final String contentString = org.apache.commons.io.IOUtils.toString(contentStream,
                    "UTF-8");

            return JSonHelper.objectOfJson(contentString, NachrichtenListeMockDTO.NachrichtMockDTO.class);
        } else {
            return null;
        }
    }

    public static NachrichtenListeMockDTO loadMockNachrichtenListe() throws
            Exception {
        final CloseableHttpClient client = HttpClientBuilder.create().build();
        final HttpGet get = new HttpGet(SERVICE_KONTO_MOCK_BASE_URL);
        final CloseableHttpResponse response = client.execute(get);
        final InputStream contentStream = response.getEntity().getContent();

        final String contentString = org.apache.commons.io.IOUtils.toString(contentStream, "UTF-8");

        if (response.getStatusLine().getStatusCode() == 200) {
            return JSonHelper.objectOfJson(contentString, NachrichtenListeMockDTO.class);
        } else {
            return null;
        }
    }

}
