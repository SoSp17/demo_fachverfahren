/*
 * CalendarDifferenceMatcher.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.test.utils.util.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.Calendar;
import java.util.Objects;


/**
 * Matcher, der prüft, ob ein zu prüfender Zeitpunkt sich nah genug an
 * angegebenen befindet.
 *
 * @author mertinat
 * @since 17.11.2016
 */

public class CalendarDifferenceMatcher extends TypeSafeMatcher<Calendar> {
    private static final long DEFAULT_NOW_DELTA = 500;
    private final Calendar expeted;
    private final long expectedMaxDeltaInMs;

    /**
     * @param expeted Erwarteter Zeitpunkt
     * @param delta   Erlaubte Abweichung in ms
     */
    public CalendarDifferenceMatcher(final Calendar expeted, final long delta) {
        this.expeted = expeted;
        this.expectedMaxDeltaInMs = delta;
    }

    public static CalendarDifferenceMatcher closeTo(final Calendar expeted, final long delta) {
        return new CalendarDifferenceMatcher(expeted, delta);
    }

    public static CalendarDifferenceMatcher closeToNow() {
        return nowWithMaxDelta(DEFAULT_NOW_DELTA);
    }

    public static CalendarDifferenceMatcher nowWithMaxDelta(final long defaultNowDelta) {
        return closeTo(Calendar.getInstance(), defaultNowDelta);
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("Erwartetes Ergebnis ").appendValue(expeted.getTimeInMillis())
                .appendText(" mit einer Abweichung von ").appendValue(expectedMaxDeltaInMs)
                .appendText(" ms");
    }

    @Override
    protected boolean matchesSafely(final Calendar item) {
        if (Objects.equals(item, expeted)) {
            return true;
        }

        if (item == null) {
            return false;
        }

        return getDeltaInMs(item) < expectedMaxDeltaInMs;
    }

    private long getDeltaInMs(final Calendar item) {
        return Math.abs(item.getTimeInMillis() - expeted.getTimeInMillis());
    }

    @Override
    protected void describeMismatchSafely(final Calendar item,
                                          final Description mismatchDescription) {
        mismatchDescription.appendValue(item)
                .appendText(" liegt mit einer maximalen Abweichung von ")
                .appendValue(getDeltaInMs(item)).appendText(" ms insgesamt ")
                .appendValue(getDeltaInMs(item) - expectedMaxDeltaInMs).appendText(
                "ms zu weit entfernt");
    }
}
