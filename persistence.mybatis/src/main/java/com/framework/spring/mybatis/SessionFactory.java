package com.framework.spring.mybatis;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

@Configuration
@PropertySource({ "classpath:/properties/mybatis.properties" })
@Order(3)
public class SessionFactory {

	private static final Logger logger = Logger.getLogger(SessionFactory.class);

	@Autowired
	@Qualifier("myDS")
	private DataSource dataSource;

	@Value("${mybatis.mapperLocations}")
	private String mapperLocations;

	@Value("${mybatis.configLocation}")
	private String configLocation;

	@Bean
	public static PropertySourcesPlaceholderConfigurer placehodlerConfigurer() {
		logger.info("PropertySourcesPlaceholderConfigurer create!");
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean(name = "mySF")
	public SqlSessionFactoryBean SqlSessionFactoryBean() throws Exception {
		logger.info("SessionFactory create!");
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
		sessionFactory.setConfigLocation(new DefaultResourceLoader().getResource(configLocation));
		return sessionFactory;

	}
}
