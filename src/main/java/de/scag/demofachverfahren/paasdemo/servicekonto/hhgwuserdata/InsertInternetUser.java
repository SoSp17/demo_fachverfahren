/*
 * InsertInternetUser.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata;

import javax.annotation.Generated;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.</p>
 *
 * <p>The following schema fragment specifies the expected content contained
 * within this class.</p>
 *
 * <pre>
 * &lt;complexType>
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence>
 * &lt;element name="oInternetUserData" type="{http://tempuri.org/}InternetUserData"/>
 * &lt;element name="lUserID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 * &lt;element name="strErrorXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;/sequence>
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"oInternetUserData", "lUserID", "strErrorXml"})
@XmlRootElement(name = "InsertInternetUser")
@Generated(
        value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
        comments = "JAXB RI v2.2.4"
)
public class InsertInternetUser {
    @XmlElement(required = true)
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected InternetUserData oInternetUserData;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected long lUserID;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected String strErrorXml;

    /**
     * Gets the value of the oInternetUserData property.
     *
     * @return possible object is {@link InternetUserData }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public InternetUserData getOInternetUserData() {
        return oInternetUserData;
    }

    /**
     * Sets the value of the oInternetUserData property.
     *
     * @param value allowed object is {@link InternetUserData }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setOInternetUserData(final InternetUserData value) {
        this.oInternetUserData = value;
    }

    /**
     * Gets the value of the lUserID property.
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public long getLUserID() {
        return lUserID;
    }

    /**
     * Sets the value of the lUserID property.
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setLUserID(final long value) {
        this.lUserID = value;
    }

    /**
     * Gets the value of the strErrorXml property.
     *
     * @return possible object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public String getStrErrorXml() {
        return strErrorXml;
    }

    /**
     * Sets the value of the strErrorXml property.
     *
     * @param value allowed object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setStrErrorXml(final String value) {
        this.strErrorXml = value;
    }
}
