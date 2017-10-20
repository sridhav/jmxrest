package com.github.sridhav.jmxrest.config;

public class JmxConfig {

    public static final ConfigDef JDBC_DRIVER_CLASS = ConfigDef.define(
            "jdbc.driver.class",
            "com.mysql.jdbc.Driver",
            "JDBC Driver class name."
    );

    public static final ConfigDef JDBC_URL = ConfigDef.define(
            "jdbc.url",
            "jdbc:mysql://localhost:3306/test",
            "JDBC JNDI name/url"
    );

    public static final ConfigDef JDBC_USERNAME = ConfigDef.define(
            "jdbc.username",
            "root",
            "JDBC user name"
    );

    public static final ConfigDef JDBC_PASSWORD = ConfigDef.define(
            "jdbc.password",
            "",
            "JDBC password"
    );



    /**
     * ####################################################################################################
     * SSL Configuration
     */
    public static final ConfigDef CLIENT_SSL_KEY_PASSWORD = ConfigDef.define(
            "client.ssl.key.password",
            "",
            "The password of the private key in the key store file. This is optional for client"
    );

    public static final ConfigDef CLIENT_SSL_KEYSTORE_PASSWORD = ConfigDef.define(
            "client.ssl.keystore.password",
            "",
            "The password for the key store file"
    );

    public static final ConfigDef CLIENT_SSL_TRUSTSTORE_PASSWORD = ConfigDef.define(
            "client.ssl.truststore.password",
            "",
            "The password for the trust store file"
    );

    public static final ConfigDef CLIENT_SSL_KEYSTORE_LOCATION = ConfigDef.define(
            "client.ssl.keystore.location",
            "",
            "The location of the key store file"
    );

    public static final ConfigDef CLIENT_SSL_TRUSTSTORE_LOCATION = ConfigDef.define(
            "client.ssl.truststore.location",
            "",
            "The location of the trust store file"
    );

    public static final ConfigDef CLIENT_SSL_ENABLED_PROTOCOLS = ConfigDef.define(
            "client.ssl.enabled.protocols",
            "TLSv1.2,TLSv1.1,TLSv1",
            "The list of protocols enabled for SSL connections"
    );

    public static final ConfigDef CLIENT_SSL_KEYSTORE_TYPE = ConfigDef.define(
            "client.ssl.keystore.type",
            "JKS",
            "The file format of the key store file. This is optional for client"
    );

    public static final ConfigDef CLIENT_SSL_PROTOCOL = ConfigDef.define(
            "client.ssl.protocol",
            "TLS",
            "The SSL protocol used to generate the SSLContext. Default setting is TLS, which is fine for most cases. Allowed values in recent JVMs are TLS, TLSv1.1 and TLSv1.2. SSL, SSLv2 and SSLv3 may be supported in older JVMs, but their usage is discouraged due to known security vulnerabilities."
    );

    public static final ConfigDef CLIENT_SSL_PROVIDER = ConfigDef.define(
            "client.ssl.provider",
            "",
            "The name of the security provider used for SSL connections. Default value is the default security provider of the JVM."
    );


    public static final ConfigDef CLIENT_SSL_TRUSTSTORE_TYPE = ConfigDef.define(
            "client.ssl.truststore.type",
            "JKS",
            "The file format of the trust store file. "
    );

    public static final ConfigDef CLIENT_SSL_CIPHER_SUITES = ConfigDef.define(
            "client.ssl.cipher.suites",
            "",
            "A list of cipher suites. This is a named combination of authentication, encryption, MAC and key exchange algorithm used to negotiate the security settings for a network connection using TLS or SSL network protocol. By default all the available cipher suites are supported."
    );

    public static final ConfigDef CLIENT_SSL_ENDPOINT_IDENTIFICATION_ALGORITHM = ConfigDef.define(
            "client.ssl.endpoint.identification.algorithm",
            "",
            "The endpoint identification algorithm to validate server hostname using server certificate."
    );

    public static final ConfigDef CLIENT_SSL_SECURE_RANDOM_IMPLEMENTATION = ConfigDef.define(
            "client.ssl.secure.random.implementation",
            "",
            "The SecureRandom PRNG implementation to use for SSL cryptography operations."
    );

    public static final ConfigDef CLIENT_SSL_KEYMANAGER_ALGORITHM = ConfigDef.define(
            "client.ssl.keymanager.algorithm",
            "",
            "The algorithm used by key manager factory for SSL connections. Default value is the key manager factory algorithm configured for the Java Virtual Machine."
    );

    public static final ConfigDef CLIENT_SSL_TRUSTMANAGER_ALGORITHM = ConfigDef.define(
            "client.ssl.trustmanager.algorithm",
            "",
            "The algorithm used by trust manager factory for SSL connections. Default value is the trust manager factory algorithm configured for the Java Virtual Machine."
    );


    public static final ConfigDef REST_SSL_KEY_PASSWORD = ConfigDef.define(
            "ssl.key.password",
            "",
            "The password of the private key in the key store file. This is optional for client"
    );

    public static final ConfigDef REST_SSL_KEYSTORE_PASSWORD = ConfigDef.define(
            "ssl.keystore.password",
            "",
            "The password for the key store file"
    );

    public static final ConfigDef REST_SSL_TRUSTSTORE_PASSWORD = ConfigDef.define(
            "ssl.truststore.password",
            "",
            "The password for the trust store file"
    );

    public static final ConfigDef REST_SSL_KEYSTORE_LOCATION = ConfigDef.define(
            "ssl.keystore.location",
            "",
            "The location of the key store file"
    );

    public static final ConfigDef REST_SSL_TRUSTSTORE_LOCATION = ConfigDef.define(
            "ssl.truststore.location",
            "",
            "The location of the trust store file"
    );



    public static final ConfigDef REST_SSL_ENABLED_PROTOCOLS = ConfigDef.define(
            "ssl.enabled.protocols",
            "TLSv1.2,TLSv1.1,TLSv1",
            "The list of protocols enabled for SSL connections"
    );

    public static final ConfigDef REST_SSL_KEYSTORE_TYPE = ConfigDef.define(
            "ssl.keystore.type",
            "JKS",
            "The file format of the key store file. This is optional for client"
    );

    public static final ConfigDef REST_SSL_PROTOCOL = ConfigDef.define(
            "ssl.protocol",
            "TLS",
            "The SSL protocol used to generate the SSLContext. Default setting is TLS, which is fine for most cases. Allowed values in recent JVMs are TLS, TLSv1.1 and TLSv1.2. SSL, SSLv2 and SSLv3 may be supported in older JVMs, but their usage is discouraged due to known security vulnerabilities."
    );

    public static final ConfigDef REST_SSL_PROVIDER = ConfigDef.define(
            "ssl.provider",
            "",
            "The name of the security provider used for SSL connections. Default value is the default security provider of the JVM."
    );


    public static final ConfigDef REST_SSL_TRUSTSTORE_TYPE = ConfigDef.define(
            "ssl.truststore.type",
            "JKS",
            "The file format of the trust store file. "
    );

    public static final ConfigDef REST_SSL_CIPHER_SUITES = ConfigDef.define(
            "ssl.cipher.suites",
            "",
            "A list of cipher suites. This is a named combination of authentication, encryption, MAC and key exchange algorithm used to negotiate the security settings for a network connection using TLS or SSL network protocol. By default all the available cipher suites are supported."
    );

    public static final ConfigDef REST_SSL_ENDPOINT_IDENTIFICATION_ALGORITHM = ConfigDef.define(
            "ssl.endpoint.identification.algorithm",
            "",
            "The endpoint identification algorithm to validate server hostname using server certificate."
    );

    public static final ConfigDef REST_SSL_SECURE_RANDOM_IMPLEMENTATION = ConfigDef.define(
            "ssl.secure.random.implementation",
            "",
            "The SecureRandom PRNG implementation to use for SSL cryptography operations."
    );

    public static final ConfigDef REST_SSL_KEYMANAGER_ALGORITHM = ConfigDef.define(
            "ssl.keymanager.algorithm",
            "",
            "The algorithm used by key manager factory for SSL connections. Default value is the key manager factory algorithm configured for the Java Virtual Machine."
    );

    public static final ConfigDef REST_SSL_TRUSTMANAGER_ALGORITHM = ConfigDef.define(
            "ssl.trustmanager.algorithm",
            "",
            "The algorithm used by trust manager factory for SSL connections. Default value is the trust manager factory algorithm configured for the Java Virtual Machine."
    );

    /**
     * ####################################################################################################
     * END SSL Configuration
     */
}
