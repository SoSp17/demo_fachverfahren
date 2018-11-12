package de.scag.demofachverfahren.paasdemo.servicekonto;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class ServicekontoConfigurationTest {
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);


    @Test
    public void testGetNutzerdatenUrl_AlleRelevantenInformationenVorhanden_SollteUrlLiefern()
            throws Exception {
        // Preparation
        final ServicekontoConfiguration underTest = new ServicekontoConfiguration();
        final String baseUrl = "http://irgendwas:1234";
        final String path = "/somewhere";
        underTest.setBaseUrl(baseUrl)
                .setNutzerdaten(new ServicekontoConfiguration.Webservice()
                        .setPath(path));


        // Execution
        final String result = underTest.getNutzerdatenUrl();

        // Assertion
        assertThat(result, is(baseUrl + path));
    }


    @Test
    public void testGetNutzerdatenUrl_BaseUrlFehlt_SollteNurDenPfadLiefern()
            throws Exception {
        // Preparation
        final ServicekontoConfiguration underTest = new ServicekontoConfiguration();
        final String baseUrl = null;
        final String path = "/somewhere";
        underTest.setBaseUrl(baseUrl)
                .setNutzerdaten(new ServicekontoConfiguration.Webservice()
                        .setPath(path));


        // Execution
        final String result = underTest.getNutzerdatenUrl();

        // Assertion
        assertThat(result, is(path));
    }

    @Test
    public void testGetNutzerdatenUrl_PfadFehlt_SollteNurDieBaseurlLiefern()
            throws Exception {
        // Preparation
        final ServicekontoConfiguration underTest = new ServicekontoConfiguration();
        final String baseUrl = "http://irgendwas:1234";
        final String path = null;
        underTest.setBaseUrl(baseUrl)
                .setNutzerdaten(new ServicekontoConfiguration.Webservice()
                        .setPath(path));


        // Execution
        final String result = underTest.getNutzerdatenUrl();

        // Assertion
        assertThat(result, is(baseUrl));
    }

    @Test
    public void testGetNutzerdatenUrl_NutzerdatenFehlen_SollteNurDieBaseurlLiefern()
            throws Exception {
        // Preparation
        final ServicekontoConfiguration underTest = new ServicekontoConfiguration();
        final String baseUrl = "http://irgendwas:1234";
        underTest.setBaseUrl(baseUrl)
                .setNutzerdaten(null);


        // Execution
        final String result = underTest.getNutzerdatenUrl();

        // Assertion
        assertThat(result, is(baseUrl));
    }

    @Test
    public void testGetNutzerdatenUrl_BaseUndPfadSindNull_SollteNullLiefern()
            throws Exception {
        // Preparation
        final ServicekontoConfiguration underTest = new ServicekontoConfiguration();
        final String baseUrl = null;
        final String path = null;
        underTest.setBaseUrl(baseUrl)
                .setNutzerdaten(new ServicekontoConfiguration.Webservice()
                        .setPath(path));


        // Execution
        final String result = underTest.getNutzerdatenUrl();

        // Assertion
        assertThat(result, is(nullValue()));
    }


    @Test
    public void testGetNutzerdatenUrl_BaseUndNutzdatenSindNull_SollteNullLiefern()
            throws Exception {
        // Preparation
        final ServicekontoConfiguration underTest = new ServicekontoConfiguration();
        final String baseUrl = null;
        underTest.setBaseUrl(baseUrl)
                .setNutzerdaten(null);

        // Execution
        final String result = underTest.getNutzerdatenUrl();

        // Assertion
        assertThat(result, is(nullValue()));
    }

    @Test
    public void testGetNachrichtenUrl_AlleRelevantenInformationenVorhanden_SollteUrlLiefern()
            throws Exception {
        // Preparation
        final ServicekontoConfiguration underTest = new ServicekontoConfiguration();
        final String baseUrl = "http://irgendwas:1234";
        final String path = "/somewhere";
        underTest.setBaseUrl(baseUrl)
                .setNachrichten(new ServicekontoConfiguration.Webservice()
                        .setPath(path));


        // Execution
        final String result = underTest.getNachrichtenUrl();

        // Assertion
        assertThat(result, is(baseUrl + path));
    }


    @Test
    public void testGetNachrichtenUrl_BaseUrlFehlt_SollteNurDenPfadLiefern()
            throws Exception {
        // Preparation
        final ServicekontoConfiguration underTest = new ServicekontoConfiguration();
        final String baseUrl = null;
        final String path = "/somewhere";
        underTest.setBaseUrl(baseUrl)
                .setNachrichten(new ServicekontoConfiguration.Webservice()
                        .setPath(path));


        // Execution
        final String result = underTest.getNachrichtenUrl();

        // Assertion
        assertThat(result, is(path));
    }

    @Test
    public void testGetNachrichtenUrl_PfadFehlt_SollteNurDieBaseurlLiefern()
            throws Exception {
        // Preparation
        final ServicekontoConfiguration underTest = new ServicekontoConfiguration();
        final String baseUrl = "http://irgendwas:1234";
        final String path = null;
        underTest.setBaseUrl(baseUrl)
                .setNachrichten(new ServicekontoConfiguration.Webservice()
                        .setPath(path));


        // Execution
        final String result = underTest.getNachrichtenUrl();

        // Assertion
        assertThat(result, is(baseUrl));
    }

    @Test
    public void testGetNachrichtenUrl_NutzerdatenFehlen_SollteNurDieBaseurlLiefern()
            throws Exception {
        // Preparation
        final ServicekontoConfiguration underTest = new ServicekontoConfiguration();
        final String baseUrl = "http://irgendwas:1234";
        underTest.setBaseUrl(baseUrl)
                .setNachrichten(null);


        // Execution
        final String result = underTest.getNachrichtenUrl();

        // Assertion
        assertThat(result, is(baseUrl));
    }

    @Test
    public void testGetNachrichtenUrl_BaseUndPfadSindNull_SollteNullLiefern()
            throws Exception {
        // Preparation
        final ServicekontoConfiguration underTest = new ServicekontoConfiguration();
        final String baseUrl = null;
        final String path = null;
        underTest.setBaseUrl(baseUrl)
                .setNachrichten(new ServicekontoConfiguration.Webservice()
                        .setPath(path));


        // Execution
        final String result = underTest.getNachrichtenUrl();

        // Assertion
        assertThat(result, is(nullValue()));
    }


    @Test
    public void testGetNachrichtenUrl_BaseUndNutzdatenSindNull_SollteNullLiefern()
            throws Exception {
        // Preparation
        final ServicekontoConfiguration underTest = new ServicekontoConfiguration();
        final String baseUrl = null;
        underTest.setBaseUrl(baseUrl)
                .setNachrichten(null);

        // Execution
        final String result = underTest.getNachrichtenUrl();

        // Assertion
        assertThat(result, is(nullValue()));
    }
}