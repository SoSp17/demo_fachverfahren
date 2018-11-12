/*
 * ObjectFactory.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.servicekonto.govgwasyncresponse;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the
 * de.verwalt_berlin.senbjw.isbj.servicekonto.client package.
 *
 * <p>An ObjectFactory allows you to programmatically construct new instances of
 * the Java representation for XML content. The Java representation of XML
 * content can consist of schema derived interfaces and classes representing the
 * binding of schema type definitions, element declarations and model groups.
 * Factory methods for each of these are provided in this class.</p>
 */
@XmlRegistry
public class ObjectFactory {
    private static final String NAMESPACE_URI_DATACONTRACT =
            "http://schemas.datacontract.org/2004/07/GovGWAsyncResponse";
    private static final String NAMESPACE_URI_TEMPURI = "http://tempuri.org/";
    private static final String NAMESPACE_URIMS_SERIALIZATION =
            "http://schemas.microsoft.com/2003/10/Serialization/";

    private static final QName UNSIGNED_LONG =
            new QName(NAMESPACE_URIMS_SERIALIZATION, "unsignedLong");
    private static final QName UNSIGNED_BYTE =
            new QName(NAMESPACE_URIMS_SERIALIZATION, "unsignedByte");
    private static final QName UNSIGNED_INT =
            new QName(NAMESPACE_URIMS_SERIALIZATION, "unsignedInt");
    private static final QName CHAR = new QName(NAMESPACE_URIMS_SERIALIZATION, "char");
    private static final QName SHORT = new QName(NAMESPACE_URIMS_SERIALIZATION, "short");
    private static final QName GUID = new QName(NAMESPACE_URIMS_SERIALIZATION, "guid");
    private static final QName UNSIGNED_SHORT =
            new QName(NAMESPACE_URIMS_SERIALIZATION, "unsignedShort");
    private static final QName DECIMAL = new QName(NAMESPACE_URIMS_SERIALIZATION, "decimal");
    private static final QName ARRAY_OF_FILE_ATTACHMENT =
            new QName(NAMESPACE_URI_DATACONTRACT, "ArrayOfFileAttachment");
    private static final QName BOOLEAN = new QName(NAMESPACE_URIMS_SERIALIZATION, "boolean");
    private static final QName DURATION = new QName(NAMESPACE_URIMS_SERIALIZATION, "duration");
    private static final QName FILE_ATTACHMENT =
            new QName(NAMESPACE_URI_DATACONTRACT, "FileAttachment");
    private static final QName BASE_64_BINARY =
            new QName(NAMESPACE_URIMS_SERIALIZATION, "base64Binary");
    private static final QName INT = new QName(NAMESPACE_URIMS_SERIALIZATION, "int");
    private static final QName LONG = new QName(NAMESPACE_URIMS_SERIALIZATION, "long");
    private static final QName ANY_URL = new QName(NAMESPACE_URIMS_SERIALIZATION, "anyURI");
    private static final QName FLOAT = new QName(NAMESPACE_URIMS_SERIALIZATION, "float");
    private static final QName DATE_TIME = new QName(NAMESPACE_URIMS_SERIALIZATION, "dateTime");
    private static final QName BYTE = new QName(NAMESPACE_URIMS_SERIALIZATION, "byte");
    private static final QName DOUBLE = new QName(NAMESPACE_URIMS_SERIALIZATION, "double");
    private static final QName QNAME = new QName(NAMESPACE_URIMS_SERIALIZATION, "QName");
    private static final QName ANY_TYPE = new QName(NAMESPACE_URIMS_SERIALIZATION, "anyType");
    private static final QName STRING = new QName(NAMESPACE_URIMS_SERIALIZATION, "string");
    private static final QName SET_QUERY_RESULT_WITH_PRICE_AND_ATTACHMENTS_RESPONSE_STRING_ERROR_MESSAGE =
            new QName(NAMESPACE_URI_TEMPURI, "strErrorMessage");
    private static final QName FILE_ATTACHMENT_BINARY_DATA =
            new QName(NAMESPACE_URI_DATACONTRACT, "BBinaryData");
    private static final QName FILE_ATTACHMENT_STR_FILE_NAME =
            new QName(NAMESPACE_URI_DATACONTRACT, "StrFilename");
    private static final QName SET_QUERY_RESULT_WITH_PRICE_AND_ATTACHMENTS_ATTACHMENTS =
            new QName(NAMESPACE_URI_TEMPURI, "attachments");
    private static final QName SET_QUERY_RESULT_WITH_PRICE_AND_ATTACHMENTS_STR_PRICE =
            new QName(NAMESPACE_URI_TEMPURI, "strPrice");
    private static final QName SET_QUERY_RESULT_WITH_PRICE_AND_ATTACHMENTS_STR_MESSAGE_ID =
            new QName(NAMESPACE_URI_TEMPURI, "strMessageID");
    private static final QName SET_QUERY_RESULT_WITH_PRICE_AND_ATTACHEMENTS_STR_XML_DATA =
            new QName(NAMESPACE_URI_TEMPURI, "strXMLData");
    private static final QName SET_QUERY_RESULT_WITH_PRICE_AND_ATTACHMENTS_STR_HISTORY =
            new QName(NAMESPACE_URI_TEMPURI, "strHistory");

    /**
     * Create a new ObjectFactory that can be used to create new instances of
     * schema derived classes for package
     * de.verwalt_berlin.senbjw.isbj.servicekonto.client.
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ArrayOfFileAttachment }.
     *
     * @return the array of file attachment
     */
    public ArrayOfFileAttachment createArrayOfFileAttachment() {
        return new ArrayOfFileAttachment();
    }

    /**
     * Create an instance of
     * {@link SetQueryResultWithPriceAndAttachmentsResponse }.
     *
     * @return the sets the query result with price and attachments response
     */
    public SetQueryResultWithPriceAndAttachmentsResponse createSetQueryResultWithPriceAndAttachmentsResponse() {
        return new SetQueryResultWithPriceAndAttachmentsResponse();
    }

    /**
     * Create an instance of {@link FileAttachment }.
     *
     * @return the file attachment
     */
    public FileAttachment createFileAttachment() {
        return new FileAttachment();
    }

    /**
     * Create an instance of {@link SetQueryResultWithPriceAndAttachments }.
     *
     * @return the sets the query result with price and attachments
     */
    public SetQueryResultWithPriceAndAttachments createSetQueryResultWithPriceAndAttachments() {
        return new SetQueryResultWithPriceAndAttachments();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "unsignedLong")
    public JAXBElement<BigInteger> createUnsignedLong(final BigInteger value) {
        return new JAXBElement<>(UNSIGNED_LONG, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element< short>
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "unsignedByte")
    public JAXBElement<Short> createUnsignedByte(final Short value) {
        return new JAXBElement<>(UNSIGNED_BYTE, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     * }.
     *
     * @param value the value
     * @return the JAXB element< long>
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "unsignedInt")
    public JAXBElement<Long> createUnsignedInt(final Long value) {
        return new JAXBElement<>(UNSIGNED_INT, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element< integer>
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "char")
    public JAXBElement<Integer> createChar(final Integer value) {
        return new JAXBElement<>(CHAR, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element< short>
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "short")
    public JAXBElement<Short> createShort(final Short value) {
        return new JAXBElement<>(SHORT, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element< string>
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "guid")
    public JAXBElement<String> createGuid(final String value) {
        return new JAXBElement<>(GUID, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element< integer>
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "unsignedShort")
    public JAXBElement<Integer> createUnsignedShort(final Integer value) {
        return new JAXBElement<>(UNSIGNED_SHORT, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "decimal")
    public JAXBElement<BigDecimal> createDecimal(final BigDecimal value) {
        return new JAXBElement<>(DECIMAL, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link ArrayOfFileAttachment }{@code >}}.
     *
     * @param value the value
     * @return the JAXB element< array of file attachment>
     */
    @XmlElementDecl(namespace = NAMESPACE_URI_DATACONTRACT, name = "ArrayOfFileAttachment")
    public JAXBElement<ArrayOfFileAttachment> createArrayOfFileAttachment(
            final ArrayOfFileAttachment value) {
        return new JAXBElement<>(ARRAY_OF_FILE_ATTACHMENT,
                ArrayOfFileAttachment.class,
                null,
                value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element< boolean>
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "boolean")
    public JAXBElement<Boolean> createBoolean(final Boolean value) {
        return new JAXBElement<>(BOOLEAN, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element< duration>
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "duration")
    public JAXBElement<Duration> createDuration(final Duration value) {
        return new JAXBElement<>(DURATION, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileAttachment}
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element< file attachment>
     */
    @XmlElementDecl(namespace = NAMESPACE_URI_DATACONTRACT, name = "FileAttachment")
    public JAXBElement<FileAttachment> createFileAttachment(final FileAttachment value) {
        return new JAXBElement<>(FILE_ATTACHMENT, FileAttachment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element<byte[]>
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "base64Binary")
    public JAXBElement<byte[]> createBase64Binary(final byte[] value) {
        return new JAXBElement<>(BASE_64_BINARY, byte[].class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element< integer>
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "int")
    public JAXBElement<Integer> createInt(final Integer value) {
        return new JAXBElement<>(INT, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     * }.
     *
     * @param value the value
     * @return the JAXB element< long>
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "long")
    public JAXBElement<Long> createLong(final Long value) {
        return new JAXBElement<>(LONG, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element< string>
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "anyURI")
    public JAXBElement<String> createAnyURI(final String value) {
        return new JAXBElement<>(ANY_URL, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element< float>
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "float")
    public JAXBElement<Float> createFloat(final Float value) {
        return new JAXBElement<>(FLOAT, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link XMLGregorianCalendar }{@code >}}.
     *
     * @param value the value
     * @return the JAXB element< XML gregorian calendar>
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "dateTime")
    public JAXBElement<XMLGregorianCalendar> createDateTime(final XMLGregorianCalendar value) {
        return new JAXBElement<>(DATE_TIME,
                XMLGregorianCalendar.class,
                null,
                value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}
     * }.
     *
     * @param value the value
     * @return the JAXB element< byte>
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "byte")
    public JAXBElement<Byte> createByte(final Byte value) {
        return new JAXBElement<>(BYTE, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element< double>
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "double")
    public JAXBElement<Double> createDouble(final Double value) {
        return new JAXBElement<>(DOUBLE, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "QName")
    public JAXBElement<QName> createQName(final QName value) {
        return new JAXBElement<>(QNAME, QName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "anyType")
    public JAXBElement<Object> createAnyType(final Object value) {
        return new JAXBElement<>(ANY_TYPE, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element< string>
     */
    @XmlElementDecl(namespace = NAMESPACE_URIMS_SERIALIZATION, name = "string")
    public JAXBElement<String> createString(final String value) {
        return new JAXBElement<>(STRING, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element< string>
     */
    @XmlElementDecl(
            namespace = NAMESPACE_URI_TEMPURI, name = "strErrorMessage",
            scope = SetQueryResultWithPriceAndAttachmentsResponse.class
    )
    public JAXBElement<String> createSetQueryResultWithPriceAndAttachmentsResponseStrErrorMessage(
            final String value) {
        return new JAXBElement<>(
                SET_QUERY_RESULT_WITH_PRICE_AND_ATTACHMENTS_RESPONSE_STRING_ERROR_MESSAGE,
                String.class,
                SetQueryResultWithPriceAndAttachmentsResponse.class,
                value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element<byte[]>
     */
    @XmlElementDecl(
            namespace = NAMESPACE_URI_DATACONTRACT, name = "BBinaryData", scope = FileAttachment.class
    )
    public JAXBElement<byte[]> createFileAttachmentBBinaryData(final byte[] value) {
        return new JAXBElement<>(FILE_ATTACHMENT_BINARY_DATA,
                byte[].class,
                FileAttachment.class,
                value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element< string>
     */
    @XmlElementDecl(
            namespace = NAMESPACE_URI_DATACONTRACT, name = "StrFilename", scope = FileAttachment.class
    )
    public JAXBElement<String> createFileAttachmentStrFilename(final String value) {
        return new JAXBElement<>(FILE_ATTACHMENT_STR_FILE_NAME,
                String.class,
                FileAttachment.class,
                value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link ArrayOfFileAttachment }{@code >}}.
     *
     * @param value the value
     * @return the JAXB element< array of file attachment>
     */
    @XmlElementDecl(
            namespace = NAMESPACE_URI_TEMPURI, name = "attachments",
            scope = SetQueryResultWithPriceAndAttachments.class
    )
    public JAXBElement<ArrayOfFileAttachment> createSetQueryResultWithPriceAndAttachmentsAttachments(
            final ArrayOfFileAttachment value) {
        return new JAXBElement<>(
                SET_QUERY_RESULT_WITH_PRICE_AND_ATTACHMENTS_ATTACHMENTS,
                ArrayOfFileAttachment.class,
                SetQueryResultWithPriceAndAttachments.class,
                value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element< string>
     */
    @XmlElementDecl(
            namespace = NAMESPACE_URI_TEMPURI, name = "strPrice",
            scope = SetQueryResultWithPriceAndAttachments.class
    )
    public JAXBElement<String> createSetQueryResultWithPriceAndAttachmentsStrPrice(
            final String value) {
        return new JAXBElement<>(SET_QUERY_RESULT_WITH_PRICE_AND_ATTACHMENTS_STR_PRICE,
                String.class,
                SetQueryResultWithPriceAndAttachments.class,
                value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element< string>
     */
    @XmlElementDecl(
            namespace = NAMESPACE_URI_TEMPURI, name = "strMessageID",
            scope = SetQueryResultWithPriceAndAttachments.class
    )
    public JAXBElement<String> createSetQueryResultWithPriceAndAttachmentsStrMessageID(
            final String value) {
        return new JAXBElement<>(SET_QUERY_RESULT_WITH_PRICE_AND_ATTACHMENTS_STR_MESSAGE_ID,
                String.class,
                SetQueryResultWithPriceAndAttachments.class,
                value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element< string>
     */
    @XmlElementDecl(
            namespace = NAMESPACE_URI_TEMPURI, name = "strXMLData",
            scope = SetQueryResultWithPriceAndAttachments.class
    )
    public JAXBElement<String> createSetQueryResultWithPriceAndAttachmentsStrXMLData(
            final String value) {
        return new JAXBElement<>(SET_QUERY_RESULT_WITH_PRICE_AND_ATTACHEMENTS_STR_XML_DATA,
                String.class,
                SetQueryResultWithPriceAndAttachments.class,
                value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }
     * {@code >}}.
     *
     * @param value the value
     * @return the JAXB element< string>
     */
    @XmlElementDecl(
            namespace = NAMESPACE_URI_TEMPURI, name = "strHistory",
            scope = SetQueryResultWithPriceAndAttachments.class
    )
    public JAXBElement<String> createSetQueryResultWithPriceAndAttachmentsStrHistory(
            final String value) {
        return new JAXBElement<>(SET_QUERY_RESULT_WITH_PRICE_AND_ATTACHMENTS_STR_HISTORY,
                String.class,
                SetQueryResultWithPriceAndAttachments.class,
                value);
    }
}
