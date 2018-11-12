/*
 * Userdata.java
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
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * The Class Userdata.
 *
 * @author mertinat
 * @since 12.06.2017
 */
@XmlRootElement(name = "USERDATA")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@Accessors(chain = true)
public class Userdata {
    @XmlElement(name = "HHGW")
    private HHGW hhgw;
    @XmlElement(name = "AUTHENTICATION")
    private Authentication authentication;
    @XmlElement(name = "ROLES", nillable = true)
    private List<Roles> roles;

    /**
     * Wandelt das Objekt in ein XML String um.
     *
     * @return the string
     * @throws JAXBException the JAXB exception
     */
    public String toXmlString() throws JAXBException {
        final StringWriter writer = new StringWriter();
        final JAXBContext jaxbContetext = JAXBContext.newInstance(Userdata.class);
        final Marshaller marshaller = jaxbContetext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        marshaller.marshal(this, writer);

        return writer.toString();
    }


    /**
     * Adds the roles.
     *
     * @param role the role
     * @return the userdata
     */
    public Userdata addRoles(final Roles role) {
        getRoles().add(role);

        return this;
    }

    public List<Roles> getRoles() {
        if (roles == null) {
            roles = new ArrayList<>();
        }

        return roles;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
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

    /**
     * Klasse zur Deserialisierung von {@link Userdata}.
     */
    public static class Deserializer {
        /**
         * Instanz eines Deserializers.
         */
        public static final Deserializer INSTANCE = new Deserializer();

        /**
         * Instantiates a new deserializer.
         */
        private Deserializer() {
            // util class
        }

        /**
         * To object.
         *
         * @param buergerUserdataSample the buerger userdata sample
         * @return the userdata
         * @throws JAXBException the JAXB exception
         */
        public Userdata toObject(@NonNull final String buergerUserdataSample) throws JAXBException {
            final JAXBContext jaxbContetext = JAXBContext.newInstance(Userdata.class);
            final Unmarshaller unmarshaller = jaxbContetext.createUnmarshaller();

            return (Userdata) unmarshaller.unmarshal(new StringReader(buergerUserdataSample));
        }
    }
}
