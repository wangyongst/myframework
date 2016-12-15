package com.framework.persistence.mybatis;

import org.apache.log4j.Logger;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
//@EnableCaching//<!-- 启用缓存注解 --> <cache:annotation-driven cache-manager="cacheManager" />
@Order(3)
public class CachingConfig {
    private static final Logger logger = Logger.getLogger(CachingConfig.class);

//    @Bean
//    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
//        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
//        //ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("properties/ehcache.xml"));
//        return ehCacheManagerFactoryBean;
//    }
//
//    @Bean
//    public CacheManager cacheManager() {
//        logger.info("EhCacheCacheManager create!");
//        EhCacheCacheManager cacheManager = new EhCacheCacheManager();
//        cacheManager.setCacheManager(ehCacheManagerFactoryBean().getObject());
//        return cacheManager;
//    }
}
