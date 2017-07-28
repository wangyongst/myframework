package com.framework.spring.datasource.tomcatjdbc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.annotation.Order;

import java.beans.PropertyVetoException;

@Configuration
@PropertySource({"classpath:/properties/tomcat-jdbc.properties"})
@Order(2)
public class TomcatJdbcDataSource {
    private static final Logger logger = LogManager.getLogger(TomcatJdbcDataSource.class);

    @Value("${datasource.driverClassName}")
    private String driverClassName;
    @Value("${datasource.url}")
    private String url;
    @Value("${datasource.username}")
    private String username;
    @Value("${datasource.password}")
    private String password;
    @Value("${datasource.jmxEnabled}")
    private boolean jmxEnabled;
    @Value("${datasource.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${datasource.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${datasource.validationInterval}")
    private long validationInterval;
    @Value("${datasource.testOnReturn}")
    private boolean testOnReturn;
    @Value("${datasource.validationQuery}")
    private String validationQuery;
    @Value("${datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${datasource.maxActive}")
    private int maxActive;
    @Value("${datasource.initialSize}")
    private int initialSize;
    @Value("${datasource.maxWait}")
    private int maxWait;
    @Value("${datasource.removeAbandonedTimeout}")
    private int removeAbandonedTimeout;
    @Value("${datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;
    @Value("${datasource.minIdle}")
    private int minIdle;
    @Value("${datasource.logAbandoned}")
    private boolean logAbandoned;
    @Value("${datasource.removeAbandoned}")
    private boolean removeAbandoned;
    @Value("${datasource.jdbcInterceptors}")
    private String jdbcInterceptors;


    /**
     * 描述 : <负责解析资源文件>. <br>
     * <p>
     * <这个类必须有，而且必须声明为static，否则不能正常解析>
     * </p>
     *
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer placehodlerConfigurer() {
        logger.info("PropertySourcesPlaceholderConfigurer create!");
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "myDS")
    public DataSource dataSource() throws PropertyVetoException {
        logger.info("DataSource create!");
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setJmxEnabled(jmxEnabled);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setValidationInterval(validationInterval);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMaxActive(maxActive);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxWait(maxWait);
        dataSource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setMinIdle(minIdle);
        dataSource.setLogAbandoned(logAbandoned);
        dataSource.setRemoveAbandoned(removeAbandoned);
        dataSource.setJdbcInterceptors(jdbcInterceptors);
        return dataSource;
    }
}
