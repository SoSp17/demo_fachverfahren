/*
 * SetExtendedUserDataResponse.java
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
 * &lt;element name="SetExtendedUserDataResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 * &lt;/sequence>
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"setExtendedUserDataResult"})
@XmlRootElement(name = "SetExtendedUserDataResponse")
@Generated(
        value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
        comments = "JAXB RI v2.2.4"
)
public class SetExtendedUserDataResponse {
    @XmlElement(name = "SetExtendedUserDataResult")
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected int setExtendedUserDataResult;

    /**
     * Gets the value of the setExtendedUserDataResult property.
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public int getSetExtendedUserDataResult() {
        return setExtendedUserDataResult;
    }

    /**
     * Sets the value of the setExtendedUserDataResult property.
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setSetExtendedUserDataResult(final int value) {
        this.setExtendedUserDataResult = value;
    }
}
