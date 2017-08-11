package com.framework.persistence.jpa.hibernate;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource({"classpath:/application.properties"})
@Order(3)
public class EntityManagerFactory {

    private static final Logger logger = LoggerFactory.getLogger(EntityManagerFactory.class);

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;

    @Value("${jpa.packagesToScan}")
    private String packagesToScan;
    @Value("${jpa.persistenceUnitName}")
    private String persistenceUnitName;
    @Value("${spring.jpa.properties.query.substitutions}")
    private String substitutions;
    @Value("${spring.jpa.properties.default_batch_fetch_size}")
    private String default_batch_fetch_size;
    @Value("${spring.jpa.properties.max_fetch_depth}")
    private String max_fetch_depth;
    @Value("${spring.jpa.properties.generate_statistics}")
    private String generate_statistics;
    @Value("${spring.jpa.properties.bytecode.use_reflection_optimizer}")
    private String use_reflection_optimizer;
    @Value("${spring.jpa.properties.cache.use_second_level_cache}")
    private String use_second_level_cache;
    @Value("${spring.jpa.properties.cache.use_query_cache}")
    private String use_query_cache;
    @Value("${spring.jpa.properties.dialect}")
    private String dialect;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
        logger.info("LocalContainerEntityManagerFactoryBean create!");
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setPackagesToScan(packagesToScan);
        entityManagerFactory.setPersistenceProvider(new HibernatePersistenceProvider());
        entityManagerFactory.setPersistenceUnitName(persistenceUnitName);
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactory.setJpaDialect(new HibernateJpaDialect());
        Map<String, String> jpaProperties = new HashMap();
        jpaProperties.put("hibernate.query.substitutions", substitutions);
        jpaProperties.put("hibernate.default_batch_fetch_size", default_batch_fetch_size);
        jpaProperties.put("hibernate.max_fetch_depth", max_fetch_depth);
        jpaProperties.put("hibernate.generate_statistics", generate_statistics);
        jpaProperties.put("hibernate.bytecode.use_reflection_optimizer", use_reflection_optimizer);
        jpaProperties.put("hibernate.cache.use_second_level_cache", use_query_cache);
        jpaProperties.put("hibernate.cache.use_query_cache", use_query_cache);
        jpaProperties.put("hibernate.dialect", dialect);
        entityManagerFactory.setJpaPropertyMap(jpaProperties);
        return entityManagerFactory;
    }
}
