/*
 * UserdataTest.java
 *
 * Version $Revision$ $Date$
 *
 * This file is part of ISBJ.
 *
 * Copyright 2017 Senatsverwaltung fuer Bildung, Jugend und Familie, Berlin.
 * Created by Schuetze Consulting AG, Berlin.
 */
package de.scag.demofachverfahren.paasdemo.servicekonto.hhgwuserdata.contentmodel;

import de.scag.demofachverfahren.paasdemo.test.utils.util.rules.ResourceRule;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class UserdataTest {
    @Rule
    public ResourceRule resource = new ResourceRule();

    @Test
    public void testToObject_BuergerdatenXmlGegebenUndInObjektUndZurueckUmgewandelt_EntstandenesXmlSollteDemEingangsXmlEntsprechen()
            throws Exception {
        // Vorbereitung
        final String buergerUserdataSample = getBuergerUserdataSample();

        // Ausführung
        final Userdata buergerdatenObjekt = Userdata.Deserializer.INSTANCE.toObject(
                buergerUserdataSample);

        // Prüfung

        assertThat(buergerdatenObjekt, is(equalTo(getBuergerdatenObjekt())));
    }

    @Test
    public void testToObject_UnternehmendatenXmlGegebenUndInObjektUndZurueckUmgewandelt_EntstandenesXmlSollteDemEingangsXmlEntsprechen()
            throws Exception {
        // Vorbereitung
        final String unternehmenUserdataSample = getUnternehmenUserdataSample();

        // Ausführung
        final Userdata unternehmendatenObjekt = Userdata.Deserializer.INSTANCE.toObject(
                unternehmenUserdataSample);

        // Prüfung
        assertThat(unternehmendatenObjekt, is(equalTo(getUnternehmendatenObjekt())));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAddRoles_BisherigeRolesSindExistieren_SollteBeimSpaetererAbfrageNeueZusaetzlichDieNeueRoleBeinhalten()
            throws Exception {
        // Vorbereitung
        final Roles role = new Roles();
        final Userdata classUnderTest = new Userdata();
        classUnderTest.setRoles(new ArrayList<>(Collections.singletonList(role)));

        // Ausführung
        classUnderTest.addRoles(role);

        // Prüfung
        assertThat(classUnderTest.getRoles(), contains(sameInstance(role), sameInstance(role)));
    }

    @Test
    public void testEquals_EqualsUeberschrieben_SollteEqualsKontractErfüllen() {
        EqualsVerifier.forClass(Userdata.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    public void testAddRoles_BisherigeRolesSindNull_SollteBeimSpaetererAbfrageNeueRoleBeinhalten()
            throws Exception {
        // Vorbereitung
        final Roles role = new Roles();
        final Userdata classUnderTest = new Userdata();
        classUnderTest.setRoles(null);

        // Ausführung
        classUnderTest.addRoles(role);

        // Prüfung
        assertThat(classUnderTest.getRoles(), contains(sameInstance(role)));
    }

    private Userdata getUnternehmendatenObjekt() {
        final HHGW hhgw = new HHGW().setUserId(150L).setModeId(3).setUsermode("Firmenkunde")
                .setLoginname("skbref-nutzer1@schuetze-consulting.ag")
                .setTitle("Dr.").setPrefix("Herr")
                .setFirstname("Theodor der Erste").setLastname("Testnutzer")
                .setEmail("skbref-nutzer1@schuetze-consulting.ag")
                .setLanguage("de-DE").setMasteruser(0)
                .setUserOrganisation("Orga-Truppe 1")
                .setPhonenumber("+49 30 318050900").setFax("+49 30 318050901")
                .setUserStreet("Knesebeckstr.").setUserStreetnumber("1")
                .setUserCity("Berlin").setUserZipcode("10623")
                .setUserCountry("Deutschland").setCompanyId("24")
                .setCompanyName("Schütze Consulting AG")
                .setCompanyOrganisation("IT").setRegNumber("1337")
                .setCompanyStreet("Berliner Str.").setCompanyStreetnumber("2")
                .setCompanyCity("Dresden").setCompanyZipcode("10627")
                .setCompanyCountry("England").setMailbox("mad mail")
                .setBoxZipCode("11234").setBillStreet("Bill Murray Straße")
                .setBillStreetnumber("666").setBillCity("Billington")
                .setBillZipcode("56455").setBillCountry("Billonesien")
                .setBillBox("B The Box").setBillBoxZipcode("14789")
                .setCertificateId("12369")
                .setUserPhoneNumber("+49 30 123 456 789 0")
                .setCompanySubOrganisation("Entwicklung");
        final Authentication authentication = new Authentication().setAuthenticationModeID(1)
                .setInvalidAt(
                        new GregorianCalendar(2016,
                                4,
                                12,
                                13,
                                17,
                                25));
        final Roles role1 = new Roles().setRoleId(1025).setRoleName("Default-Rolle")
                .setPermission(1).setIsDefault(1);
        final Roles role2 = new Roles().setRoleId(1026).setRoleName("Personalplanungsberichte")
                .setPermission(1).setIsDefault(0);

        return new Userdata().setHhgw(hhgw).setAuthentication(authentication).addRoles(role1)
                .addRoles(role2);
    }

    private Userdata getBuergerdatenObjekt() {
        final HHGW hhgw = new HHGW().setUserId(136L).setModeId(1).setUsermode("Bürger")
                .setLoginname("A.Metzner@schuetze-consulting.ag")
                .setTitle("Dr.").setPrefix("Herr").setPrefix("Herr")
                .setFirstname("Alexander").setLastname("Metzner")
                .setEmail("A.Metzner@schuetze-consulting.ag")
                .setLanguage("de-DE").setLevelId(1).setStreet("Mopsweg")
                .setStreetNumber("5").setStreetExtension("1337")
                .setCity("Berlin").setZipcode("10317").setCountry("Deutschland")
                .setDateOfBirth(new GregorianCalendar(1970, 0, 1))
                .setCertificateId("147963").setUserPhoneNumber("0190666666");
        final Authentication authentication = new Authentication().setAuthenticationModeID(1)
                .setInvalidAt(
                        new GregorianCalendar(2017,
                                5,
                                12,
                                10,
                                27,
                                2));

        final Roles role = new Roles();
        role.setRoleId(988);
        role.setRoleName("Default-Rolle");
        role.setPermission(1);
        role.setIsDefault(1);

        return new Userdata().setHhgw(hhgw).addRoles(role).setAuthentication(authentication);
    }

    private String getUnternehmenUserdataSample() throws URISyntaxException, IOException {
        return resource.stringOf("UTF-8", "unternehmen-userdata.xml");
    }

    private String getBuergerUserdataSample() throws URISyntaxException, IOException {
        return resource.stringOf("UTF-8", "buerger-userdata.xml");
    }
}
