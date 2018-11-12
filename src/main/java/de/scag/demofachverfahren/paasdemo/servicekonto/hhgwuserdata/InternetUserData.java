/*
 * InternetUserData.java
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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InternetUserData complex type.</p>
 *
 * <p>The following schema fragment specifies the expected content contained
 * within this class.</p>
 *
 * <pre>
 * &lt;complexType name="InternetUserData">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence>
 * &lt;element name="strLoginName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="strPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="strCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="strCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="strDateOfBirth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="strEMail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="strPhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="fPhoneSmsCapable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 * &lt;element name="strFirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="strLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="strLanguage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="strPrefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="strStreet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="strStreetNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="strStreetExtension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="strTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="strZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="strQuestionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="strAnswer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="nLevelID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 * &lt;element name="nWebTypeID" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 * &lt;/sequence>
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "InternetUserData", propOrder =
        {
                "strLoginName", "strPassword", "strCity", "strCountry", "strDateOfBirth", "strEMail",
                "strPhoneNumber", "fPhoneSmsCapable", "strFirstName", "strLastName", "strLanguage",
                "strPrefix", "strStreet", "strStreetNumber", "strStreetExtension", "strTitle",
                "strZipCode", "strQuestionID", "strAnswer", "nLevelID", "nWebTypeID"
        }
)
@Generated(
        value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
        comments = "JAXB RI v2.2.4"
)
public class InternetUserData {
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected String strLoginName;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected String strPassword;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected String strCity;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected String strCountry;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected String strDateOfBirth;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected String strEMail;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected String strPhoneNumber;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected boolean fPhoneSmsCapable;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected String strFirstName;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected String strLastName;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected String strLanguage;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected String strPrefix;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected String strStreet;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected String strStreetNumber;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected String strStreetExtension;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected String strTitle;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected String strZipCode;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected String strQuestionID;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected String strAnswer;
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected int nLevelID;
    @XmlSchemaType(name = "unsignedByte")
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    protected short nWebTypeID;

    /**
     * Gets the value of the strLoginName property.
     *
     * @return possible object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public String getStrLoginName() {
        return strLoginName;
    }

    /**
     * Sets the value of the strLoginName property.
     *
     * @param value allowed object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setStrLoginName(final String value) {
        this.strLoginName = value;
    }

    /**
     * Gets the value of the strPassword property.
     *
     * @return possible object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public String getStrPassword() {
        return strPassword;
    }

    /**
     * Sets the value of the strPassword property.
     *
     * @param value allowed object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setStrPassword(final String value) {
        this.strPassword = value;
    }

    /**
     * Gets the value of the strCity property.
     *
     * @return possible object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public String getStrCity() {
        return strCity;
    }

    /**
     * Sets the value of the strCity property.
     *
     * @param value allowed object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setStrCity(final String value) {
        this.strCity = value;
    }

    /**
     * Gets the value of the strCountry property.
     *
     * @return possible object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public String getStrCountry() {
        return strCountry;
    }

    /**
     * Sets the value of the strCountry property.
     *
     * @param value allowed object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setStrCountry(final String value) {
        this.strCountry = value;
    }

    /**
     * Gets the value of the strDateOfBirth property.
     *
     * @return possible object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public String getStrDateOfBirth() {
        return strDateOfBirth;
    }

    /**
     * Sets the value of the strDateOfBirth property.
     *
     * @param value allowed object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setStrDateOfBirth(final String value) {
        this.strDateOfBirth = value;
    }

    /**
     * Gets the value of the strEMail property.
     *
     * @return possible object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public String getStrEMail() {
        return strEMail;
    }

    /**
     * Sets the value of the strEMail property.
     *
     * @param value allowed object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setStrEMail(final String value) {
        this.strEMail = value;
    }

    /**
     * Gets the value of the strPhoneNumber property.
     *
     * @return possible object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public String getStrPhoneNumber() {
        return strPhoneNumber;
    }

    /**
     * Sets the value of the strPhoneNumber property.
     *
     * @param value allowed object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setStrPhoneNumber(final String value) {
        this.strPhoneNumber = value;
    }

    /**
     * Gets the value of the fPhoneSmsCapable property.
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public boolean isFPhoneSmsCapable() {
        return fPhoneSmsCapable;
    }

    /**
     * Sets the value of the fPhoneSmsCapable property.
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setFPhoneSmsCapable(final boolean value) {
        this.fPhoneSmsCapable = value;
    }

    /**
     * Gets the value of the strFirstName property.
     *
     * @return possible object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public String getStrFirstName() {
        return strFirstName;
    }

    /**
     * Sets the value of the strFirstName property.
     *
     * @param value allowed object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setStrFirstName(final String value) {
        this.strFirstName = value;
    }

    /**
     * Gets the value of the strLastName property.
     *
     * @return possible object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public String getStrLastName() {
        return strLastName;
    }

    /**
     * Sets the value of the strLastName property.
     *
     * @param value allowed object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setStrLastName(final String value) {
        this.strLastName = value;
    }

    /**
     * Gets the value of the strLanguage property.
     *
     * @return possible object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public String getStrLanguage() {
        return strLanguage;
    }

    /**
     * Sets the value of the strLanguage property.
     *
     * @param value allowed object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setStrLanguage(final String value) {
        this.strLanguage = value;
    }

    /**
     * Gets the value of the strPrefix property.
     *
     * @return possible object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public String getStrPrefix() {
        return strPrefix;
    }

    /**
     * Sets the value of the strPrefix property.
     *
     * @param value allowed object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setStrPrefix(final String value) {
        this.strPrefix = value;
    }

    /**
     * Gets the value of the strStreet property.
     *
     * @return possible object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public String getStrStreet() {
        return strStreet;
    }

    /**
     * Sets the value of the strStreet property.
     *
     * @param value allowed object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setStrStreet(final String value) {
        this.strStreet = value;
    }

    /**
     * Gets the value of the strStreetNumber property.
     *
     * @return possible object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public String getStrStreetNumber() {
        return strStreetNumber;
    }

    /**
     * Sets the value of the strStreetNumber property.
     *
     * @param value allowed object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setStrStreetNumber(final String value) {
        this.strStreetNumber = value;
    }

    /**
     * Gets the value of the strStreetExtension property.
     *
     * @return possible object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public String getStrStreetExtension() {
        return strStreetExtension;
    }

    /**
     * Sets the value of the strStreetExtension property.
     *
     * @param value allowed object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setStrStreetExtension(final String value) {
        this.strStreetExtension = value;
    }

    /**
     * Gets the value of the strTitle property.
     *
     * @return possible object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public String getStrTitle() {
        return strTitle;
    }

    /**
     * Sets the value of the strTitle property.
     *
     * @param value allowed object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setStrTitle(final String value) {
        this.strTitle = value;
    }

    /**
     * Gets the value of the strZipCode property.
     *
     * @return possible object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public String getStrZipCode() {
        return strZipCode;
    }

    /**
     * Sets the value of the strZipCode property.
     *
     * @param value allowed object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setStrZipCode(final String value) {
        this.strZipCode = value;
    }

    /**
     * Gets the value of the strQuestionID property.
     *
     * @return possible object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public String getStrQuestionID() {
        return strQuestionID;
    }

    /**
     * Sets the value of the strQuestionID property.
     *
     * @param value allowed object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setStrQuestionID(final String value) {
        this.strQuestionID = value;
    }

    /**
     * Gets the value of the strAnswer property.
     *
     * @return possible object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public String getStrAnswer() {
        return strAnswer;
    }

    /**
     * Sets the value of the strAnswer property.
     *
     * @param value allowed object is {@link String }
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setStrAnswer(final String value) {
        this.strAnswer = value;
    }

    /**
     * Gets the value of the nLevelID property.
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public int getNLevelID() {
        return nLevelID;
    }

    /**
     * Sets the value of the nLevelID property.
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setNLevelID(final int value) {
        this.nLevelID = value;
    }

    /**
     * Gets the value of the nWebTypeID property.
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public short getNWebTypeID() {
        return nWebTypeID;
    }

    /**
     * Sets the value of the nWebTypeID property.
     */
    @Generated(
            value = "com.sun.tools.xjc.Driver", date = "2017-05-18T01:30:34+02:00",
            comments = "JAXB RI v2.2.4"
    )
    public void setNWebTypeID(final short value) {
        this.nWebTypeID = value;
    }
}
