/*
 * ResourceRule.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.test.utils.util.rules;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.rules.ExternalResource;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;


/**
 * Allows easy access to resources contained under the same package as the
 * accessing testclass.
 *
 * @author mertinat
 * @since 21.09.2016
 */
public class ResourceRule extends ExternalResource {
    private static final String PATH_DELIMITER = "/";
    private Description description;
    private List<InputStream> openedInputStreams;

    /**
     * The passed resource path relative to the current testclass as Path. (If
     * you start your resource Path with '/' it's not relative to the current
     * testclass anymore).
     *
     * <p>If the Class is "foo.bar.Testclassname" the rigen resourcename is
     * expected to be in a resourcefolder caled "foo/bar/"</p>
     *
     * @param resourcePathRelativeToTestclass Resourcepath-String.
     * @return A Path Object to the Test-Resource.
     * @throws URISyntaxException Thrown if the resource does not exist.
     */
    public File fileOf(final String... resourcePathRelativeToTestclass) throws URISyntaxException {
        return new File(
                description.getTestClass().getResource(
                        toPathString(resourcePathRelativeToTestclass)).toURI());
    }

    /**
     * Reads a resource as String.
     *
     * @see #fileOf(String...)
     */
    public String stringOf(final String encoding, final String... resourcePathRelativeToTestclass)
            throws URISyntaxException, IOException {
        return FileUtils.readFileToString(
                new File(
                        description.getTestClass().getResource(
                                toPathString(resourcePathRelativeToTestclass)).toURI()),
                encoding);
    }

    private String toPathString(final String... resourcePathRelativeToTestclass) {
        return StringUtils.join(resourcePathRelativeToTestclass, PATH_DELIMITER);
    }

    /**
     * Like {@link #fileOf(String...)} but relative to a subfolder with the same
     * name as the Testclass.
     *
     * <p>If the Class is "foo.bar.Testclassname" the rigen resourcename is
     * expected to be in a resourcefolder caled "foo/bar/Testclassname/"</p>
     */
    public File fileUnderTestclassFolderOf(final String... resourcePathRelativeToTestclass)
            throws URISyntaxException {
        return fileOf(relativeToTestclassName(resourcePathRelativeToTestclass));
    }

    private String relativeToTestclassName(final String... resourcePathRelativeToTestclass) {
        return description.getTestClass().getSimpleName() + PATH_DELIMITER +
                toPathString(resourcePathRelativeToTestclass);
    }

    /**
     * The passed resource path relative to the current testclass as opened
     * {@link InputStream}. (If you start your resource Path with '/' it's not
     * relative to the current testclass anymore).
     *
     * <p>If the Class is "foo.bar.Testclassname" the rigen resourcename is
     * expected to be in a resourcefolder caled "foo/bar/"</p>
     *
     * <p>You don't have to worry about closing the Stream. It happens
     * automatically after the testexecution.</p>
     *
     * @param resourcePathRelativeToTestclass Resourcepath-String.
     * @return An opened {@link InputStream} to the Resource if it exists.
     */
    public InputStream streamOf(final String... resourcePathRelativeToTestclass) {
        return description.getTestClass().getResourceAsStream(
                toPathString(resourcePathRelativeToTestclass));
    }

    /**
     * Like {@link #streamOf(String...)} but relative to a subfolder with the
     * same name as the Testclass.
     *
     * <p>If the Class is "foo.bar.Testclassname" the rigen resourcename is
     * expected to be in a resourcefolder caled "foo/bar/Testclassname/"</p>
     */
    public InputStream streamUnderTestclassFolderOf(
            final String... resourcePathRelativeToTestclass) {
        return streamOf(relativeToTestclassName(resourcePathRelativeToTestclass));
    }

    @Override
    public Statement apply(final Statement base, final Description description) {
        this.description = description;
        openedInputStreams = new LinkedList<>();

        return super.apply(base, description);
    }

    @Override
    protected void after() {
        openedInputStreams.forEach(IOUtils::closeQuietly);
    }
}
