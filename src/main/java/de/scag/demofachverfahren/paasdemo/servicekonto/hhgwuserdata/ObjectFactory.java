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
package de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the
 * de.verwalt_berlin.senbjw.isbj.servicekonto.client.nutzerdaten package.
 *
 * <p>An ObjectFactory allows you to programatically construct new instances of
 * the Java representation for XML content. The Java representation of XML
 * content can consist of schema derived interfaces and classes representing the
 * binding of schema type definitions, element declarations and model groups.
 * Factory methods for each of these are provided in this class.</p>
 */
@XmlRegistry
public class ObjectFactory {
    /**
     * Create a new ObjectFactory that can be used to create new instances of
     * schema derived classes for package.
     * de.verwalt_berlin.senbjw.isbj.servicekonto.client.nutzerdaten
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetExtendedUserData }.
     *
     * @return the sets the extended user data
     */
    public SetExtendedUserData createSetExtendedUserData() {
        return new SetExtendedUserData();
    }

    /**
     * Create an instance of {@link InsertInternetUserPResponse }.
     *
     * @return the insert internet user P response
     */
    public InsertInternetUserPResponse createInsertInternetUserPResponse() {
        return new InsertInternetUserPResponse();
    }

    /**
     * Create an instance of {@link GetUserData }.
     *
     * @return the gets the user data
     */
    public GetUserData createGetUserData() {
        return new GetUserData();
    }

    /**
     * Create an instance of {@link GetUserDataResponse }.
     *
     * @return the gets the user data response
     */
    public GetUserDataResponse createGetUserDataResponse() {
        return new GetUserDataResponse();
    }

    /**
     * Create an instance of {@link InsertInternetUser }.
     *
     * @return the insert internet user
     */
    public InsertInternetUser createInsertInternetUser() {
        return new InsertInternetUser();
    }

    /**
     * Create an instance of {@link InternetUserData }.
     *
     * @return the internet user data
     */
    public InternetUserData createInternetUserData() {
        return new InternetUserData();
    }

    /**
     * Create an instance of {@link InsertInternetUserResponse }.
     *
     * @return the insert internet user response
     */
    public InsertInternetUserResponse createInsertInternetUserResponse() {
        return new InsertInternetUserResponse();
    }

    /**
     * Create an instance of {@link SetExtendedUserDataWithTokenResponse }.
     *
     * @return the sets the extended user data with token response
     */
    public SetExtendedUserDataWithTokenResponse createSetExtendedUserDataWithTokenResponse() {
        return new SetExtendedUserDataWithTokenResponse();
    }

    /**
     * Create an instance of {@link InsertInternetUserP }.
     *
     * @return the insert internet user P
     */
    public InsertInternetUserP createInsertInternetUserP() {
        return new InsertInternetUserP();
    }

    /**
     * Create an instance of {@link SetExtendedUserDataWithToken }.
     *
     * @return the sets the extended user data with token
     */
    public SetExtendedUserDataWithToken createSetExtendedUserDataWithToken() {
        return new SetExtendedUserDataWithToken();
    }

    /**
     * Create an instance of {@link SetExtendedUserDataResponse }.
     *
     * @return the sets the extended user data response
     */
    public SetExtendedUserDataResponse createSetExtendedUserDataResponse() {
        return new SetExtendedUserDataResponse();
    }
}
