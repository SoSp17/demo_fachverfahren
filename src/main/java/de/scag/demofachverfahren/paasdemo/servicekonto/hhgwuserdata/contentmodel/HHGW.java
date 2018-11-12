/*
 * HHGW.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * The Class GGW.
 *
 * @author mertinat
 * @since 23.05.2017
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@Accessors(chain = true)
public class HHGW {
    @XmlAttribute(name = "USERID", required = true)
    private Long userId;
    @XmlAttribute(name = "MODEID", required = true)
    private Integer modeId;
    @XmlAttribute(name = "USERMODE")
    private String usermode;
    @XmlAttribute(name = "LOGINNAME")
    private String loginname;
    @XmlAttribute(name = "TITLE")
    private String title;
    @XmlAttribute(name = "PREFIX")
    private String prefix;
    @XmlAttribute(name = "FIRSTNAME")
    private String firstname;
    @XmlAttribute(name = "LASTNAME")
    private String lastname;
    @XmlAttribute(name = "EMAIL")
    private String email;
    @XmlAttribute(name = "LANGUAGE")
    private String language;
    @XmlAttribute(name = "LEVELID")
    private Integer levelId;
    @XmlAttribute(name = "STREET")
    private String street;
    @XmlAttribute(name = "STREETNUMBER")
    private String streetNumber;
    @XmlAttribute(name = "STREETEXTENSION")
    private String streetExtension;
    @XmlAttribute(name = "CITY")
    private String city;
    @XmlAttribute(name = "ZIPCODE")
    private String zipcode;
    @XmlAttribute(name = "COUNTRY")
    private String country;
    @XmlAttribute(name = "DATEOFBIRTH")
    @XmlJavaTypeAdapter(HHGW.BirthdateXmlAdapter.class)
    private Calendar dateOfBirth;
    @XmlAttribute(name = "CERTIFICATEID")
    private String certificateId;
    @XmlAttribute(name = "USERPHONENUMBER")
    private String userPhoneNumber;

    @XmlAttribute(name = "MASTERUSER")
    private int masteruser;
    @XmlAttribute(name = "USERORGANISATION")
    private String userOrganisation;
    @XmlAttribute(name = "PHONENUMBER")
    private String phonenumber;
    @XmlAttribute(name = "USERSTREET")
    private String userStreet;
    @XmlAttribute(name = "USERSTREETNUMBER")
    private String userStreetnumber;
    @XmlAttribute(name = "USERCITY")
    private String userCity;
    @XmlAttribute(name = "USERZIPCODE")
    private String userZipcode;
    @XmlAttribute(name = "USERCOUNTRY")
    private String userCountry;
    @XmlAttribute(name = "COMPANYNAME")
    private String companyName;

    @XmlAttribute(name = "COMPANYORGANISATION")
    private String companyOrganisation;
    @XmlAttribute(name = "COMPANYSTREET")
    private String companyStreet;
    @XmlAttribute(name = "COMPANYSTREETNUMBER")
    private String companyStreetnumber;
    @XmlAttribute(name = "COMPANYCITY")
    private String companyCity;
    @XmlAttribute(name = "COMPANYZIPCODE")
    private String companyZipcode;
    @XmlAttribute(name = "COMPANYCOUNTRY")
    private String companyCountry;
    @XmlAttribute(name = "MAINCUSTOMER")
    private int maincustomer;

    @XmlAttribute(name = "HHAUTHORITY")
    private int hhAuthority;
    @XmlAttribute(name = "BILLSTREET")
    private String billStreet;
    @XmlAttribute(name = "BILLSTREETNUMBER")
    private String billStreetnumber;
    @XmlAttribute(name = "BILLCITY")
    private String billCity;

    @XmlAttribute(name = "BILLZIPCODE")
    private String billZipcode;
    @XmlAttribute(name = "BILLCOUNTRY")
    private String billCountry;
    @XmlAttribute(name = "FAX")
    private String fax;
    @XmlAttribute(name = "COMPANYID")
    private String companyId;
    @XmlAttribute(name = "REGNUMBER")
    private String regNumber;
    @XmlAttribute(name = "MAILBOX")
    private String mailbox;
    @XmlAttribute(name = "BOXZIPCODE")
    private String boxZipCode;
    @XmlAttribute(name = "BILLBOX")
    private String billBox;
    @XmlAttribute(name = "BILLBOXZIPCODE")
    private String billBoxZipcode;
    @XmlAttribute(name = "COMPANYSUBORGANISATION")
    private String companySubOrganisation;


    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public boolean equals(final Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, false);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


    /**
     * The Class BirthdateXmlAdapter.
     *
     * @author mertinat
     * @since 23.05.2017
     */
    public static class BirthdateXmlAdapter extends XmlAdapter<String, Calendar> {
        private static final String DATE_OF_BIRTH_FORMAT_BUERGER = "yyyyMMdd";
        private static final String DATE_OF_BIRTH_FORMAT_UNTERNEHMEN = "yyyy-MM-dd";

        /* (non-Javadoc)
         * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
         */
        @Override
        public Calendar unmarshal(final String value) throws Exception {
            final Date parsed = parse(value);
            final Calendar calendar = Calendar.getInstance();
            calendar.setTime(parsed);

            return calendar;
        }

        private Date parse(final String value) throws ParseException {
            Date parsed;

            try {
                parsed = getDateOfBirthFormatUnternehmen().parse(value);
            } catch (final ParseException e) {
                parsed = getDateOfBirthFormatBuerger().parse(value);
            }

            return parsed;
        }

        /* (non-Javadoc)
         * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
         */
        @Override
        public String marshal(final Calendar value) throws Exception {
            return getDateOfBirthFormatBuerger().format(value.getTime());
        }

        private SimpleDateFormat getDateOfBirthFormatBuerger() {
            return new SimpleDateFormat(DATE_OF_BIRTH_FORMAT_BUERGER);
        }

        private SimpleDateFormat getDateOfBirthFormatUnternehmen() {
            return new SimpleDateFormat(DATE_OF_BIRTH_FORMAT_UNTERNEHMEN);
        }
    }
}
