package de.scag.demofachverfahren.paasdemo.servicekonto;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import javax.annotation.Generated;
import javax.xml.ws.Holder;


final class NutzerdatenAnswer implements Answer<Void> {
    private final ServiceKontoClient.NutzerdatenabfrageFehlerart fehlercode;
    private final String xmlUserData;

    @Generated("SparkTools")
    private NutzerdatenAnswer(final Builder builder) {
        this.fehlercode = builder.fehlercode;
        this.xmlUserData = builder.xmlUserData;
    }

    NutzerdatenAnswer(final ServiceKontoClient.NutzerdatenabfrageFehlerart fehlercode, final String xmlUserData) {
        this.fehlercode = fehlercode;
        this.xmlUserData = xmlUserData;
    }

    /**
     * Creates builder to build {@link NutzerdatenAnswer}.
     *
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Void answer(final InvocationOnMock invocation) {
        final Holder<String> xmlUserDataHolder = invocation.getArgument(1);
        xmlUserDataHolder.value = xmlUserData;

        final Holder<Integer> resultCodeHolder = invocation.getArgument(2);

        resultCodeHolder.value = fehlercode.getFehlercode();

        return null;
    }

    /**
     * Builder to build {@link NutzerdatenAnswer}.
     */
    @Generated("SparkTools")
    public static final class Builder {
        private ServiceKontoClient.NutzerdatenabfrageFehlerart fehlercode;
        private String xmlUserData;

        private Builder() {
        }

        public Builder withFehlercode(final ServiceKontoClient.NutzerdatenabfrageFehlerart fehlercode) {
            this.fehlercode = fehlercode;

            return this;
        }

        public Builder withXmlUserData(final String xmlUserData) {
            this.xmlUserData = xmlUserData;

            return this;
        }

        public NutzerdatenAnswer build() {
            return new NutzerdatenAnswer(this);
        }
    }
}
