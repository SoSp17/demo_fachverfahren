/*
 * TimestampLongDifferenceMatcher.java
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
import java.util.Date;
import java.util.Objects;


/**
 * <p>Matcher, der prüft, ob ein zu prüfender Zeitpunkt sich nah genug an
 * angegebenen befindet.</p>
 *
 * @author mertinat
 * @since 17.11.2016
 */

public class TimestampLongDifferenceMatcher extends TypeSafeMatcher<Long> {
    private static final long DEFAULT_NOW_DELTA = 500;
    private final Date expeted;
    private final long expectedMaxDeltaInMs;

    /**
     * @param expeted Erwarteter Zeitpunkt
     * @param delta   Erlaubte Abweichung in ms
     */
    public TimestampLongDifferenceMatcher(final Calendar expeted, final long delta) {
        this(expeted.getTime(), delta);
    }

    /**
     * @param expeted Erwarteter Zeitpunkt
     * @param delta   Erlaubte Abweichung in ms
     */
    public TimestampLongDifferenceMatcher(final Date expeted, final long delta) {
        this.expeted = expeted;
        this.expectedMaxDeltaInMs = delta;
    }

    public static TimestampLongDifferenceMatcher closeTo(final Calendar expeted, final long delta) {
        return new TimestampLongDifferenceMatcher(expeted.getTime(), delta);
    }

    public static TimestampLongDifferenceMatcher closeTo(final Date expeted, final long delta) {
        return new TimestampLongDifferenceMatcher(expeted, delta);
    }

    public static TimestampLongDifferenceMatcher closeToNow() {
        return nowWithMaxDelta(DEFAULT_NOW_DELTA);
    }

    public static TimestampLongDifferenceMatcher nowWithMaxDelta(final long defaultNowDelta) {
        return closeTo(new Date(), defaultNowDelta);
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("Erwartetes Ergebnis ").appendValue(expeted)
                .appendText(" mit einer Abweichung von ").appendValue(expectedMaxDeltaInMs)
                .appendText(" ms");
    }

    @Override
    protected boolean matchesSafely(final Long item) {
        if (Objects.equals(item, expeted.getTime())) {
            return true;
        }

        if (item == null) {
            return false;
        }

        return getDeltaInMs(item) < expectedMaxDeltaInMs;
    }

    private long getDeltaInMs(final Long item) {
        return Math.abs(item - expeted.getTime());
    }

    @Override
    protected void describeMismatchSafely(final Long item, final Description mismatchDescription) {
        mismatchDescription.appendValue(item)
                .appendText(" liegt mit einer maximalen Abweichung von ")
                .appendValue(getDeltaInMs(item)).appendText(" ms insgesamt ")
                .appendValue(getDeltaInMs(item) - expectedMaxDeltaInMs).appendText(
                "ms zu weit entfernt");
    }
}
