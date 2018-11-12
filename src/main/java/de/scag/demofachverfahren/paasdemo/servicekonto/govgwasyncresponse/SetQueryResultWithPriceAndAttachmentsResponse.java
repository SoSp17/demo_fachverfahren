/*
 * SetQueryResultWithPriceAndAttachmentsResponse.java
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
import javax.xml.bind.annotation.*;

/**
 * <p>
 * Java class for anonymous complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SetQueryResultWithPriceAndAttachmentsResult" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="strErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"setQueryResultWithPriceAndAttachmentsResult", "strErrorMessage"})
@XmlRootElement(name = "SetQueryResultWithPriceAndAttachmentsResponse")
public class SetQueryResultWithPriceAndAttachmentsResponse {

    @XmlElement(name = "SetQueryResultWithPriceAndAttachmentsResult")
    protected Boolean setQueryResultWithPriceAndAttachmentsResult;
    @XmlElementRef(name = "strErrorMessage", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<String> strErrorMessage;

    /**
     * Gets the value of the setQueryResultWithPriceAndAttachmentsResult
     * property.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean isSetQueryResultWithPriceAndAttachmentsResult() {
        return setQueryResultWithPriceAndAttachmentsResult;
    }

    /**
     * Sets the value of the setQueryResultWithPriceAndAttachmentsResult
     * property.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setSetQueryResultWithPriceAndAttachmentsResult(final Boolean value) {
        this.setQueryResultWithPriceAndAttachmentsResult = value;
    }

    /**
     * Gets the value of the strErrorMessage property.
     *
     * @return possible object is {@link JAXBElement }{@code <}{@link String }
     * {@code >}
     */
    public JAXBElement<String> getStrErrorMessage() {
        return strErrorMessage;
    }

    /**
     * Sets the value of the strErrorMessage property.
     *
     * @param value allowed object is {@link JAXBElement }{@code <}{@link String }
     *              {@code >}
     */
    public void setStrErrorMessage(final JAXBElement<String> value) {
        this.strErrorMessage = value;
    }

}
