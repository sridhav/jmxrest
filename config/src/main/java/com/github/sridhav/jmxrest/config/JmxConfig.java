package com.github.sridhav.jmxrest.config;

public class JmxConfig {

    public static final String MYBATIS_JDBC_DRIVER_CLASS = "mybatis.jdbc.driver.class";

    public static final String MYBATIS_JDBC_URL = "mybatis.jdbc.url";

    public static final String MYBATIS_JDBC_USERNAME = "mybatis.jdbc.username";

    public static final String MYBATIS_JDBC_PASSWORD = "mybatis.jdbc.password";

    public static final String NAMESPACE_LIST = "namespace.client.list";

    public static final String CLIENT_HOSTNAME = "client.hostname";

    public static final String CLIENT_PORT = "client.port";

    public static final String POOL_MAX_IDLE = "pool.max.idle";

    public static final String POOL_MIN_IDLE = "pool.min.idle";

    public static final String POOL_MAX_TOTAL = "pool.max.total";

    public static final String POOL_JMX_ENABLED = "pool.jmx.enabled";

    public static final String POOL_TEST_ON_BORROW = "pool.test.on.borrow";

    public static final String POOL_TEST_ON_RETURN = "pool.test.on.return";

    public static final String POOL_TEST_ON_CREATE = "pool.test.on.create";

    public static final String SSL_ENABLED = "ssl.enabled";

    public static final String SSL_KEY_PASSWORD = "ssl.key.password";

    public static final String SSL_KEYSTORE_PASSWORD = "ssl.keystore.password";

    public static final String SSL_TRUSTSTORE_PASSWORD = "ssl.truststore.password";

    public static final String SSL_KEYSTORE_LOCATION = "ssl.keystore.location";

    public static final String SSL_TRUSTSTORE_LOCATION = "ssl.truststore.location";

    public static final String SSL_ENABLED_PROTOCOLS = "ssl.enabled.protocols";

    public static final String SSL_KEYSTORE_TYPE = "ssl.keystore.type";

    public static final String SSL_PROTOCOL = "ssl.protocol";

    public static final String SSL_PROVIDER = "ssl.provider";

    public static final String SSL_TRUSTSTORE_TYPE = "ssl.truststore.type";

    public static final String SSL_CIPHER_SUITES = "ssl.cipher.suites";

    public static final String SSL_ENDPOINT_IDENTIFICATION_ALGORITHM = "ssl.endpoint.identification.algorithm";

    public static final String SSL_SECURE_RANDOM_IMPLEMENTATION = "ssl.secure.random.implementation";

    public static final String SSL_KEYMANAGER_ALGORITHM = "ssl.keymanager.algorithm";

    public static final String SSL_TRUSTMANAGER_ALGORITHM = "ssl.trustmanager.algorithm";






//
//    public static final ConfigDef MYBATIS_JDBC_DRIVER_CLASS = ConfigDef.define(
//            "mybatis.jdbc.driver.class",
//            "com.mysql.jdbc.Driver",
//            "JDBC Driver class name."
//    );
//
//    public static final ConfigDef MYBATIS_JDBC_URL = ConfigDef.define(
//            "mybatis.jdbc.url",
//            "jdbc:mysql://localhost:3306/test",
//            "JDBC JNDI name/url"
//    );
//
//    public static final ConfigDef MYBATIS_JDBC_USERNAME = ConfigDef.define(
//            "mybatis.jdbc.username",
//            "root",
//            "JDBC user name"
//    );
//
//    public static final ConfigDef MYBATIS_JDBC_PASSWORD = ConfigDef.define(
//            "mybatis.jdbc.password",
//            "",
//            "JDBC password"
//    );
//
//
//    public static final ConfigDef CLIENT_NAMESPACE_LIST= ConfigDef.define(
//            "client.namespace.list",
//            "",
//            "Comma Separated namespaces list"
//    );
//
//    public static final ConfigDef CLIENT_NAMESPACE_HOSTNAME = ConfigDef.define(
//            "client.hostname",
//            "",
//            "Jmx client host name"
//    );
//
//    public static final ConfigDef CLIENT_NAMESPACE_PORT = ConfigDef.define(
//            "client.port",
//            "",
//            "Jmx client port"
//    );
//
//
//    /**
//     * POOL Configuration
//     */
//
//    public static final ConfigDef POOL_MAX_IDLE = ConfigDef.define(
//            "pool.max.idle",
//            "",
//            "Max idle connections in pool"
//    );
//
//    public static final ConfigDef POOL_MIN_IDLE = ConfigDef.define(
//            "pool.min.idle",
//            "",
//            "Min idle connections in pool"
//    );
//
//    public static final ConfigDef POOL_MAX_TOTAL = ConfigDef.define(
//            "pool.max.total",
//            "",
//            "Min idle connections in pool"
//    );
//
//    public static final ConfigDef POOL_JMX_ENABLED = ConfigDef.define(
//            "pool.jmx.enabled",
//            "true",
//            "Pool jmx enabled. defaults to true"
//    );
//
//    public static final ConfigDef POOL_TEST_ON_BORROW = ConfigDef.define(
//            "pool.teston.borrow",
//            "true",
//            "enable test on borrowing. defaults to true "
//    );
//
//    public static final ConfigDef POOL_TEST_ON_RETURN = ConfigDef.define(
//            "pool.teston.return",
//            "true",
//            "enable test on returning. defaults to true"
//    );
//
//    public static final ConfigDef POOL_TEST_ON_CREATE = ConfigDef.define(
//            "pool.teston.create",
//            "true",
//            "enable test on creation. defaults to true"
//    );
//
//


//
//    /**
//     * ####################################################################################################
//     * SSL Configuration
//     */
//    public static final ConfigDef CLIENT_SSL_KEY_PASSWORD = ConfigDef.define(
//            "ssl.key.password",
//            "",
//            "The password of the private key in the key store file. This is optional for client"
//    );
//
//    public static final ConfigDef CLIENT_SSL_KEYSTORE_PASSWORD = ConfigDef.define(
//            "ssl.keystore.password",
//            "",
//            "The password for the key store file"
//    );
//
//    public static final ConfigDef CLIENT_SSL_TRUSTSTORE_PASSWORD = ConfigDef.define(
//            "ssl.truststore.password",
//            "",
//            "The password for the trust store file"
//    );
//
//    public static final ConfigDef CLIENT_SSL_KEYSTORE_LOCATION = ConfigDef.define(
//            "ssl.keystore.location",
//            "",
//            "The location of the key store file"
//    );
//
//    public static final ConfigDef CLIENT_SSL_TRUSTSTORE_LOCATION = ConfigDef.define(
//            "ssl.truststore.location",
//            "",
//            "The location of the trust store file"
//    );
//
//    public static final ConfigDef CLIENT_SSL_ENABLED_PROTOCOLS = ConfigDef.define(
//            "ssl.enabled.protocols",
//            "TLSv1.2,TLSv1.1,TLSv1",
//            "The list of protocols enabled for SSL connections"
//    );
//
//    public static final ConfigDef CLIENT_SSL_KEYSTORE_TYPE = ConfigDef.define(
//            "ssl.keystore.type",
//            "JKS",
//            "The file format of the key store file. This is optional for client"
//    );
//
//    public static final ConfigDef CLIENT_SSL_PROTOCOL = ConfigDef.define(
//            "ssl.protocol",
//            "TLS",
//            "The SSL protocol used to generate the SSLContext. Default setting is TLS, which is fine for most cases. Allowed values in recent JVMs are TLS, TLSv1.1 and TLSv1.2. SSL, SSLv2 and SSLv3 may be supported in older JVMs, but their usage is discouraged due to known security vulnerabilities."
//    );
//
//    public static final ConfigDef CLIENT_SSL_PROVIDER = ConfigDef.define(
//            "ssl.provider",
//            "",
//            "The name of the security provider used for SSL connections. Default value is the default security provider of the JVM."
//    );
//
//
//    public static final ConfigDef CLIENT_SSL_TRUSTSTORE_TYPE = ConfigDef.define(
//            "ssl.truststore.type",
//            "JKS",
//            "The file format of the trust store file. "
//    );
//
//    public static final ConfigDef CLIENT_SSL_CIPHER_SUITES = ConfigDef.define(
//            "ssl.cipher.suites",
//            "",
//            "A list of cipher suites. This is a named combination of authentication, encryption, MAC and key exchange algorithm used to negotiate the security settings for a network connection using TLS or SSL network protocol. By default all the available cipher suites are supported."
//    );
//
//    public static final ConfigDef CLIENT_SSL_ENDPOINT_IDENTIFICATION_ALGORITHM = ConfigDef.define(
//            "ssl.endpoint.identification.algorithm",
//            "",
//            "The endpoint identification algorithm to validate server hostname using server certificate."
//    );
//
//    public static final ConfigDef CLIENT_SSL_SECURE_RANDOM_IMPLEMENTATION = ConfigDef.define(
//            "ssl.secure.random.implementation",
//            "",
//            "The SecureRandom PRNG implementation to use for SSL cryptography operations."
//    );
//
//    public static final ConfigDef CLIENT_SSL_KEYMANAGER_ALGORITHM = ConfigDef.define(
//            "ssl.keymanager.algorithm",
//            "",
//            "The algorithm used by key manager factory for SSL connections. Default value is the key manager factory algorithm configured for the Java Virtual Machine."
//    );
//
//    public static final ConfigDef CLIENT_SSL_TRUSTMANAGER_ALGORITHM = ConfigDef.define(
//            "ssl.trustmanager.algorithm",
//            "",
//            "The algorithm used by trust manager factory for SSL connections. Default value is the trust manager factory algorithm configured for the Java Virtual Machine."
//    );
//
//
//    public static final ConfigDef REST_SSL_KEY_PASSWORD = ConfigDef.define(
//            "ssl.key.password",
//            "",
//            "The password of the private key in the key store file. This is optional for client"
//    );
//
//    public static final ConfigDef REST_SSL_KEYSTORE_PASSWORD = ConfigDef.define(
//            "ssl.keystore.password",
//            "",
//            "The password for the key store file"
//    );
//
//    public static final ConfigDef REST_SSL_TRUSTSTORE_PASSWORD = ConfigDef.define(
//            "ssl.truststore.password",
//            "",
//            "The password for the trust store file"
//    );
//
//    public static final ConfigDef REST_SSL_KEYSTORE_LOCATION = ConfigDef.define(
//            "ssl.keystore.location",
//            "",
//            "The location of the key store file"
//    );
//
//    public static final ConfigDef REST_SSL_TRUSTSTORE_LOCATION = ConfigDef.define(
//            "ssl.truststore.location",
//            "",
//            "The location of the trust store file"
//    );
//
//
//
//    public static final ConfigDef REST_SSL_ENABLED_PROTOCOLS = ConfigDef.define(
//            "ssl.enabled.protocols",
//            "TLSv1.2,TLSv1.1,TLSv1",
//            "The list of protocols enabled for SSL connections"
//    );
//
//    public static final ConfigDef REST_SSL_KEYSTORE_TYPE = ConfigDef.define(
//            "ssl.keystore.type",
//            "JKS",
//            "The file format of the key store file. This is optional for client"
//    );
//
//    public static final ConfigDef REST_SSL_PROTOCOL = ConfigDef.define(
//            "ssl.protocol",
//            "TLS",
//            "The SSL protocol used to generate the SSLContext. Default setting is TLS, which is fine for most cases. Allowed values in recent JVMs are TLS, TLSv1.1 and TLSv1.2. SSL, SSLv2 and SSLv3 may be supported in older JVMs, but their usage is discouraged due to known security vulnerabilities."
//    );
//
//    public static final ConfigDef REST_SSL_PROVIDER = ConfigDef.define(
//            "ssl.provider",
//            "",
//            "The name of the security provider used for SSL connections. Default value is the default security provider of the JVM."
//    );
//
//
//    public static final ConfigDef REST_SSL_TRUSTSTORE_TYPE = ConfigDef.define(
//            "ssl.truststore.type",
//            "JKS",
//            "The file format of the trust store file. "
//    );
//
//    public static final ConfigDef REST_SSL_CIPHER_SUITES = ConfigDef.define(
//            "ssl.cipher.suites",
//            "",
//            "A list of cipher suites. This is a named combination of authentication, encryption, MAC and key exchange algorithm used to negotiate the security settings for a network connection using TLS or SSL network protocol. By default all the available cipher suites are supported."
//    );
//
//    public static final ConfigDef REST_SSL_ENDPOINT_IDENTIFICATION_ALGORITHM = ConfigDef.define(
//            "ssl.endpoint.identification.algorithm",
//            "",
//            "The endpoint identification algorithm to validate server hostname using server certificate."
//    );
//
//    public static final ConfigDef REST_SSL_SECURE_RANDOM_IMPLEMENTATION = ConfigDef.define(
//            "ssl.secure.random.implementation",
//            "",
//            "The SecureRandom PRNG implementation to use for SSL cryptography operations."
//    );
//
//    public static final ConfigDef REST_SSL_KEYMANAGER_ALGORITHM = ConfigDef.define(
//            "ssl.keymanager.algorithm",
//            "",
//            "The algorithm used by key manager factory for SSL connections. Default value is the key manager factory algorithm configured for the Java Virtual Machine."
//    );
//
//    public static final ConfigDef REST_SSL_TRUSTMANAGER_ALGORITHM = ConfigDef.define(
//            "ssl.trustmanager.algorithm",
//            "",
//            "The algorithm used by trust manager factory for SSL connections. Default value is the trust manager factory algorithm configured for the Java Virtual Machine."
//    );
//
//    /**
//     * ####################################################################################################
//     * END SSL Configuration
//     */
}
