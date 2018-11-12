/*
 * JAXBServiceImplTest.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.service.xml;

import de.scag.demofachverfahren.paasdemo.servicekonto.govgwasyncresponse.contentmodel.NachrichtInhalt;
import org.custommonkey.xmlunit.XMLAssert;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static de.scag.demofachverfahren.paasdemo.service.ServiceKontoAdapterTransformationExceptionMatcher.isServiceKontoAdapterTransformationException;
import static de.scag.demofachverfahren.paasdemo.service.xml.ServiceKontoAdapterSerialisierungsExceptionMatcher.isServiceKontoAdapterSerialisierungsException;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;


public class JAXBServiceImplTest {
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @Rule
    public ExpectedException exception = ExpectedException.none();
    @InjectMocks
    private JAXBServiceImpl classUnderTest;

    private static void initXmlUnitIgnoreStructuralDifferences() {
        XMLUnit.setIgnoreComments(true);
        XMLUnit.setIgnoreDiffBetweenTextAndCDATA(true);
        XMLUnit.setIgnoreWhitespace(true);
        XMLUnit.setIgnoreAttributeOrder(true);
    }

    @Test
    public void testDeserialize_NotMatchingType_SolltePassendeExceptionWerfen() throws Exception {
        // Vorbereitung
        final Class<String> nonJaxbType = String.class;

        // Prüfung
        exception.expect(
                isServiceKontoAdapterTransformationException().withMessage(
                        "Fehler bei der Deserialisierung des Typs " + nonJaxbType));

        // Ausführung
        classUnderTest.deserialize("<root><value>content</value></root>", nonJaxbType);
    }

    @Test
    public void testDeserialize_UngueltigesXmlGegeben_SolltePassendeExceptionWerfen()
            throws Exception {
        // Vorbereitung
        final Class<SomeJaxbType> nonJaxbType = SomeJaxbType.class;

        // Prüfung
        exception.expect(
                isServiceKontoAdapterTransformationException().withMessage(
                        "Fehler bei der Deserialisierung des Typs " + nonJaxbType));

        // Ausführung
        classUnderTest.deserialize("<root<><><><value>content</value></root>", nonJaxbType);
    }

    @Test
    public void testDeserialize_GueltigesXmlMitPassendemTypGegeben_SollteXmlErfolgreichDeserialisieren()
            throws Exception {
        // Vorbereitung

        // Ausführung
        final SomeJaxbType someType = classUnderTest.deserialize(
                "<root><value>content</value></root>",
                SomeJaxbType.class);

        // Prüfung
        assertThat(someType, hasProperty("value", equalTo("content")));
    }

    @Test
    public void testSerialize_SerialisierbareEntitaetGegeben_SolltePassendesXmlLiefern()
            throws Exception {
        // Vorbereitung
        initXmlUnitIgnoreStructuralDifferences();

        final NachrichtInhalt nachrichtInhalt = new NachrichtInhalt().setAbsender(
                "fachdienstNameWert").setText("textWert");

        // Ausführung
        final String xmlString = classUnderTest.serialize(nachrichtInhalt);

        // Prüfung
        XMLAssert.assertXMLEqual(
                "<xmlcontent><servicename>fachdienstNameWert</servicename><eingangstext>textWert</eingangstext></xmlcontent>",
                xmlString);
    }

    @Test
    public void testSerialize_NichtSerialisierbareEntitaetGegeben_SollteEntsprechendeExceptionWerfen()
            throws Exception {
        // Vorbereitung
        final JAXBServiceImplTest nichtSerialisierbareEntitaet = this;

        // Prüfung
        exception.expect(
                isServiceKontoAdapterSerialisierungsException().withMessage(
                        "Fehler bei der Deserialisierung von " + nichtSerialisierbareEntitaet).withCause(
                        is(instanceOf(JAXBException.class))));

        // Ausführung
        classUnderTest.serialize(nichtSerialisierbareEntitaet);
    }

    public static enum NonJaxbType {
    }

    @XmlRootElement(name = "root")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class SomeJaxbType {
        @XmlElement(name = "value")
        private String value;

        public String getValue() {
            return value;
        }

        public SomeJaxbType setValue(final String v) {
            this.value = v;

            return this;
        }
    }
}
