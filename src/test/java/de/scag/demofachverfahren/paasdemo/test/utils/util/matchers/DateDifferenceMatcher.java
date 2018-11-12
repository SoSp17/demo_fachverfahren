/*
 * DateDifferenceMatcher.java
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

import java.util.Date;
import java.util.Objects;


/**
 * <p>Matcher, der prüft, ob ein zu prüfender Zeitpunkt sich nah genug an
 * angegebenen befindet.</p>
 *
 * @author mertinat
 * @since 17.11.2016
 */

public class DateDifferenceMatcher extends TypeSafeMatcher<Date> {
    private static final long DEFAULT_NOW_DELTA = 500;
    private final Date expeted;
    private final long expectedMaxDeltaInMs;

    /**
     * @param expeted Erwarteter Zeitpunkt
     * @param delta   Erlaubte Abweichung in ms
     */
    public DateDifferenceMatcher(final Date expeted, final long delta) {
        this.expeted = expeted;
        this.expectedMaxDeltaInMs = delta;
    }

    public static DateDifferenceMatcher closeTo(final Date expeted, final long delta) {
        return new DateDifferenceMatcher(expeted, delta);
    }

    public static DateDifferenceMatcher closeToNow() {
        return nowWithMaxDelta(DEFAULT_NOW_DELTA);
    }

    public static DateDifferenceMatcher nowWithMaxDelta(final long defaultNowDelta) {
        return closeTo(new Date(), defaultNowDelta);
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("Erwartetes Ergebnis ").appendValue(expeted)
                .appendText(" mit einer Abweichung von ").appendValue(expectedMaxDeltaInMs)
                .appendText(" ms");
    }

    @Override
    protected boolean matchesSafely(final Date item) {
        if (Objects.equals(item, expeted)) {
            return true;
        }

        if (item == null) {
            return false;
        }

        return getDeltaInMs(item) < expectedMaxDeltaInMs;
    }

    private long getDeltaInMs(final Date item) {
        return Math.abs(item.getTime() - expeted.getTime());
    }

    @Override
    protected void describeMismatchSafely(final Date item, final Description mismatchDescription) {
        mismatchDescription.appendValue(item)
                .appendText(" liegt mit einer maximalen Abweichung von ")
                .appendValue(getDeltaInMs(item)).appendText(" ms insgesamt ")
                .appendValue(getDeltaInMs(item) - expectedMaxDeltaInMs).appendText(
                "ms zu weit entfernt");
    }
}
