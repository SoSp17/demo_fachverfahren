/*
 * FileAttachment.java
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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for FileAttachment complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="FileAttachment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BBinaryData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="StrFilename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileAttachment", namespace = "http://schemas.datacontract.org/2004/07/GovGWAsyncResponse", propOrder = {
        "bBinaryData", "strFilename"})
public class FileAttachment {

    @XmlElementRef(name = "BBinaryData", namespace = "http://schemas.datacontract.org/2004/07/GovGWAsyncResponse", type = JAXBElement.class)
    protected JAXBElement<byte[]> bBinaryData;
    @XmlElementRef(name = "StrFilename", namespace = "http://schemas.datacontract.org/2004/07/GovGWAsyncResponse", type = JAXBElement.class)
    protected JAXBElement<String> strFilename;

    /**
     * Gets the value of the bBinaryData property.
     *
     * @return possible object is {@link JAXBElement }{@code <}{@link byte[]}
     * {@code >}
     */
    public JAXBElement<byte[]> getBBinaryData() {
        return bBinaryData;
    }

    /**
     * Sets the value of the bBinaryData property.
     *
     * @param value allowed object is {@link JAXBElement }{@code <}{@link byte[]}
     *              {@code >}
     */
    public void setBBinaryData(final JAXBElement<byte[]> value) {
        this.bBinaryData = value;
    }

    /**
     * Gets the value of the strFilename property.
     *
     * @return possible object is {@link JAXBElement }{@code <}{@link String }
     * {@code >}
     */
    public JAXBElement<String> getStrFilename() {
        return strFilename;
    }

    /**
     * Sets the value of the strFilename property.
     *
     * @param value allowed object is {@link JAXBElement }{@code <}{@link String }
     *              {@code >}
     */
    public void setStrFilename(final JAXBElement<String> value) {
        this.strFilename = value;
    }

}
