/*
 * SetQueryResultWithPriceAndAttachments.java
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
 *         &lt;element name="strMessageID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nUserID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="nServiceID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="strHistory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strXMLData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attachments" type="{http://schemas.datacontract.org/2004/07/GovGWAsyncResponse}ArrayOfFileAttachment" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"strMessageID", "strPrice", "nUserID", "nServiceID", "strHistory", "strXMLData",
        "attachments"})
@XmlRootElement(name = "SetQueryResultWithPriceAndAttachments")
public class SetQueryResultWithPriceAndAttachments {

    @XmlElementRef(name = "strMessageID", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<String> strMessageID;
    @XmlElementRef(name = "strPrice", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<String> strPrice;
    protected Long nUserID;
    protected Integer nServiceID;
    @XmlElementRef(name = "strHistory", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<String> strHistory;
    @XmlElementRef(name = "strXMLData", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<String> strXMLData;
    @XmlElementRef(name = "attachments", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfFileAttachment> attachments;

    /**
     * Gets the value of the strMessageID property.
     *
     * @return possible object is {@link JAXBElement }{@code <}{@link String }
     * {@code >}
     */
    public JAXBElement<String> getStrMessageID() {
        return strMessageID;
    }

    /**
     * Sets the value of the strMessageID property.
     *
     * @param value allowed object is {@link JAXBElement }{@code <}{@link String }
     *              {@code >}
     */
    public void setStrMessageID(final JAXBElement<String> value) {
        this.strMessageID = value;
    }

    /**
     * Gets the value of the strPrice property.
     *
     * @return possible object is {@link JAXBElement }{@code <}{@link String }
     * {@code >}
     */
    public JAXBElement<String> getStrPrice() {
        return strPrice;
    }

    /**
     * Sets the value of the strPrice property.
     *
     * @param value allowed object is {@link JAXBElement }{@code <}{@link String }
     *              {@code >}
     */
    public void setStrPrice(final JAXBElement<String> value) {
        this.strPrice = value;
    }

    /**
     * Gets the value of the nUserID property.
     *
     * @return possible object is {@link Long }
     */
    public Long getNUserID() {
        return nUserID;
    }

    /**
     * Sets the value of the nUserID property.
     *
     * @param value allowed object is {@link Long }
     */
    public void setNUserID(final Long value) {
        this.nUserID = value;
    }

    /**
     * Gets the value of the nServiceID property.
     *
     * @return possible object is {@link Integer }
     */
    public Integer getNServiceID() {
        return nServiceID;
    }

    /**
     * Sets the value of the nServiceID property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setNServiceID(final Integer value) {
        this.nServiceID = value;
    }

    /**
     * Gets the value of the strHistory property.
     *
     * @return possible object is {@link JAXBElement }{@code <}{@link String }
     * {@code >}
     */
    public JAXBElement<String> getStrHistory() {
        return strHistory;
    }

    /**
     * Sets the value of the strHistory property.
     *
     * @param value allowed object is {@link JAXBElement }{@code <}{@link String }
     *              {@code >}
     */
    public void setStrHistory(final JAXBElement<String> value) {
        this.strHistory = value;
    }

    /**
     * Gets the value of the strXMLData property.
     *
     * @return possible object is {@link JAXBElement }{@code <}{@link String }
     * {@code >}
     */
    public JAXBElement<String> getStrXMLData() {
        return strXMLData;
    }

    /**
     * Sets the value of the strXMLData property.
     *
     * @param value allowed object is {@link JAXBElement }{@code <}{@link String }
     *              {@code >}
     */
    public void setStrXMLData(final JAXBElement<String> value) {
        this.strXMLData = value;
    }

    /**
     * Gets the value of the attachments property.
     *
     * @return possible object is {@link JAXBElement }{@code <}
     * {@link ArrayOfFileAttachment }{@code >}
     */
    public JAXBElement<ArrayOfFileAttachment> getAttachments() {
        return attachments;
    }

    /**
     * Sets the value of the attachments property.
     *
     * @param value allowed object is {@link JAXBElement }{@code <}
     *              {@link ArrayOfFileAttachment }{@code >}
     */
    public void setAttachments(final JAXBElement<ArrayOfFileAttachment> value) {
        this.attachments = value;
    }

}
