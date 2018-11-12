/*
 * Iso8601ExtendedDatetimeFormatXmlAdapter.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Calendar;


/**
 * Adapter zur Transformation zwischen {@link Calendar} in formatierte
 * {@link String}s für JaxB.
 *
 * @author mertinat
 * @since 23.05.2017
 */
public class Iso8601ExtendedDatetimeFormatXmlAdapter extends XmlAdapter<String, Calendar> {
    @Override
    public Calendar unmarshal(final String value) throws Exception {
        final Calendar cal = Calendar.getInstance();

        if (StringUtils.isBlank(value)) {
            return null;
        }

        cal.setTime(DateFormatUtils.ISO_8601_EXTENDED_DATETIME_FORMAT.parse(value));

        return cal;
    }

    @Override
    public String marshal(final Calendar value) {
        return DateFormatUtils.ISO_8601_EXTENDED_DATETIME_FORMAT.format(value);
    }
}
