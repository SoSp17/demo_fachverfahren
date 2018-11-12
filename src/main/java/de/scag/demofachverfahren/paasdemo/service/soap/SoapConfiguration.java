package de.scag.demofachverfahren.paasdemo.service.soap;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.annotation.Generated;
import java.net.URL;


/**
 * Konfiguration für einen Soap Client.
 *
 * @param <T> the generic type
 * @author mertinat
 * @since 21.07.2017
 */
public class SoapConfiguration<T> {
    private final byte[] keyStore;
    private final char[] keyStorePassword;
    private final Class<T> portInterface;
    private final String localPart;
    private final URL url;

    private final String targetNamespace;

    @Generated("SparkTools")
    @SuppressWarnings("pmd:ArrayIsStoredDirectly")
    private SoapConfiguration(final SoapConfiguration.Builder<T> builder) {
        this.keyStore = builder.keyStore;
        this.keyStorePassword = builder.keyStorePassword;
        this.portInterface = builder.portInterface;
        this.localPart = builder.localPart;
        this.url = builder.url;
        this.targetNamespace = builder.targetNamespace;
    }

    /**
     * Instantiates a new soap configuration.
     *
     * @param keyStore         the key store
     * @param keyStorePassword the key store password
     * @param portInterface    the port interface
     * @param localPart        the local part
     * @param url              the url
     * @param targetNamespace  the target namespace
     */
    @SuppressWarnings("pmd:ArrayIsStoredDirectly")
    public SoapConfiguration(final byte[] keyStore,
                             final char[] keyStorePassword,
                             final Class<T> portInterface,
                             final String localPart,
                             final URL url,
                             final String targetNamespace) {
        this.keyStore = keyStore;
        this.keyStorePassword = keyStorePassword;
        this.portInterface = portInterface;
        this.localPart = localPart;
        this.url = url;
        this.targetNamespace = targetNamespace;
    }

    /**
     * Creates builder to build {@link SoapConfiguration}.
     *
     * @param <T>           Der Konfiguration zugrunde liegendes Interface.
     * @param portInterface Der Konfiguration zugrunde liegendes Interface.
     * @return the builder
     */
    @Generated("SparkTools")
    public static <T> SoapConfiguration.Builder<T> builder(final Class<T> portInterface) {
        return new SoapConfiguration.Builder<T>().withPortInterface(portInterface);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, false);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, "keyStore", "keyStorePassword");
    }

    public String getTargetNamespace() {
        return targetNamespace;
    }

    public URL getUrl() {
        return url;
    }

    public String getLocalPart() {
        return localPart;
    }

    public Class<T> getPortInterface() {
        return portInterface;
    }

    public char[] getKeyStorePassword() {
        return keyStorePassword;
    }

    public byte[] getKeyStore() {
        return keyStore;
    }

    /**
     * Builder to build {@link SoapConfiguration}.
     *
     * @param <T> Der Konfiguration zugrunde liegendes Interface.
     */
    @Generated("SparkTools")
    public static final class Builder<T> {
        private byte[] keyStore;
        private char[] keyStorePassword;
        private Class<T> portInterface;
        private String localPart;
        private URL url;
        private String targetNamespace;

        private Builder() {
        }

        /**
         * With key store.
         *
         * @param keyStore the key store
         * @return the builder
         */
        @SuppressWarnings("pmd:ArrayIsStoredDirectly")
        public SoapConfiguration.Builder<T> withKeyStore(final byte[] keyStore) {
            this.keyStore = keyStore;

            return this;
        }

        /**
         * With key store password.
         *
         * @param keyStorePassword the key store password
         * @return the builder
         */
        @SuppressWarnings("pmd:ArrayIsStoredDirectly")
        public SoapConfiguration.Builder<T> withKeyStorePassword(final char[] keyStorePassword) {
            this.keyStorePassword = keyStorePassword;

            return this;
        }

        /**
         * With port interface.
         *
         * @param portInterface the port interface
         * @return the builder
         */
        public SoapConfiguration.Builder<T> withPortInterface(final Class<T> portInterface) {
            this.portInterface = portInterface;

            return this;
        }

        /**
         * With local part.
         *
         * @param localPart the local part
         * @return the builder
         */
        public SoapConfiguration.Builder<T> withLocalPart(final String localPart) {
            this.localPart = localPart;

            return this;
        }

        /**
         * With url.
         *
         * @param url the url
         * @return the builder
         */
        public SoapConfiguration.Builder<T> withUrl(final URL url) {
            this.url = url;

            return this;
        }

        /**
         * With target namespace.
         *
         * @param targetNamespace the target namespace
         * @return the builder
         */
        public SoapConfiguration.Builder<T> withTargetNamespace(final String targetNamespace) {
            this.targetNamespace = targetNamespace;

            return this;
        }

        /**
         * Builds the.
         *
         * @return the soap configuration
         */
        public SoapConfiguration<T> build() {
            return new SoapConfiguration<T>(this);
        }
    }
}
