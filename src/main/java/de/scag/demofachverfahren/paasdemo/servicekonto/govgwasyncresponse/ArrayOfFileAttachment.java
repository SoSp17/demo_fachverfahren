/*
 * ArrayOfFileAttachment.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.servicekonto.govgwasyncresponse;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfFileAttachment complex type.</p>
 *
 * <p>The following schema fragment specifies the expected content contained
 * within this class.</p>
 *
 * <pre>
 * &lt;complexType name="ArrayOfFileAttachment">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence>
 * &lt;element name="FileAttachment" type="{http://schemas.datacontract.org/2004/07/GovGWAsyncResponse}FileAttachment" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;/sequence>
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "ArrayOfFileAttachment",
        namespace = "http://schemas.datacontract.org/2004/07/GovGWAsyncResponse",
        propOrder = {"fileAttachment"}
)

@Getter
@Setter
@Accessors(chain = true)
@SuppressWarnings("common-java:InsufficientBranchCoverage")
public class ArrayOfFileAttachment {
    @XmlElement(name = "FileAttachment", nillable = true)
    protected List<FileAttachment> fileAttachment;

    /**
     * Gets the value of the fileAttachment property.
     *
     * <p>This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a <CODE>
     * set</CODE> method for the fileAttachment property.</p>
     *
     * <p>For example, to add a new item, do as follows:</p>
     *
     * <pre>
     * getFileAttachment().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list
     * {@link FileAttachment }</p>
     */
    public List<FileAttachment> getFileAttachment() {
        if (fileAttachment == null) {
            fileAttachment = new ArrayList<>();
        }

        return this.fileAttachment;
    }
}
